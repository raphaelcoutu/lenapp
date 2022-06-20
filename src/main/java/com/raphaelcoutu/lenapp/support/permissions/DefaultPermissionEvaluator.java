package com.raphaelcoutu.lenapp.support.permissions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        log.info("check permission user={} target={} permission={}", auth.getName(), targetDomainObject, permission);

        // TODO

        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        DomainObjectReference dor = new DomainObjectReference(targetType, targetType.toString());
        return hasPermission(authentication, dor, permission);
    }
}
