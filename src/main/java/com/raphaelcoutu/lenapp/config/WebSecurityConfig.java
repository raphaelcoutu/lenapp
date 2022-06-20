package com.raphaelcoutu.lenapp.config;

import com.raphaelcoutu.lenapp.support.access.AccessController;
import com.raphaelcoutu.lenapp.support.keycloak.KeycloakJwtAuthenticationConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                        .antMatchers("/").permitAll()
                        .antMatchers("/api/**").authenticated();

        // H2-Console
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                        .and()
                .csrf().ignoringAntMatchers("/h2-console/**")
                        .and()
                .headers().frameOptions().sameOrigin();

//        http.authorizeRequests().mvcMatchers("/api/**").access("@accessController.checkAccess()");
        http.oauth2ResourceServer(arcs -> arcs.jwt().jwtAuthenticationConverter(keycloakJwtAuthenticationConverter));

        return http.build();
    }

    @Bean
    protected AccessController accessController() {
        return new AccessController();
    }
}
