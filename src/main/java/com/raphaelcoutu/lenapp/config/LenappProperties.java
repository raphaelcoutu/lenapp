package com.raphaelcoutu.lenapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "lenapp")
public class LenappProperties {

    private KeycloakJwtProperties jwt = new KeycloakJwtProperties();

    @Getter
    @Setter
    public static class KeycloakJwtProperties {
        private String clientId;
        private String issuerUri;
        private List<String> allowedAudiences;
    }
}
