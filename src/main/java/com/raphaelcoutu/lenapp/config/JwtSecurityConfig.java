package com.raphaelcoutu.lenapp.config;

import com.raphaelcoutu.lenapp.service.UserService;
import com.raphaelcoutu.lenapp.support.keycloak.KeycloakGrantedAuthoritiesConverter;
import com.raphaelcoutu.lenapp.support.keycloak.KeycloakJwtAuthenticationConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;

@Configuration
public class JwtSecurityConfig {

    private final UserService userService;

    public JwtSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter(Converter<Jwt, Collection<GrantedAuthority>> authoritiesConverter) {
        return new KeycloakJwtAuthenticationConverter(userService, authoritiesConverter);
    }

    @Bean
    Converter<Jwt, Collection<GrantedAuthority>> keycloakGrantedAuthoritiesConverter(GrantedAuthoritiesMapper authoritiesMapper, LenappProperties lenappProperties) {
        String clientId = lenappProperties.getJwt().getClientId();
        return new KeycloakGrantedAuthoritiesConverter(clientId, authoritiesMapper);
    }
}
