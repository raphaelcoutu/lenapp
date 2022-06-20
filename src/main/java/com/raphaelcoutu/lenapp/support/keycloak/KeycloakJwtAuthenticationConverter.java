package com.raphaelcoutu.lenapp.support.keycloak;

import com.raphaelcoutu.lenapp.entity.User;
import com.raphaelcoutu.lenapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private UserService userService;
    private Converter<Jwt, Collection<GrantedAuthority>> grantedAuthoritiesConverter;

    public KeycloakJwtAuthenticationConverter(UserService userService, Converter<Jwt, Collection<GrantedAuthority>> grantedAuthoritiesConverter) {
        this.userService = userService;
        this.grantedAuthoritiesConverter = grantedAuthoritiesConverter;
    }

    @Override
    public JwtAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = grantedAuthoritiesConverter.convert(jwt);
        String username = getUsernameFrom(jwt);

        log.info("### Convert token");

        UUID subject = UUID.fromString(jwt.getSubject());
        if (userService.getBySubject(subject) == null) {
            log.info("### Creating  user={} subject={}", username, jwt.getSubject());
            User user = new User(subject, username);
            userService.createUser(user);
        }

        return new JwtAuthenticationToken(jwt, authorities, username);
    }

    protected String getUsernameFrom(Jwt jwt) {
        if (jwt.hasClaim("preferred_username")) {
            return jwt.getClaimAsString("preferred_username");
        }

        return jwt.getSubject();
    }
}
