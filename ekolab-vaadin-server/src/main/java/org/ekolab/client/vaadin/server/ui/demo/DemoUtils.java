package org.ekolab.client.vaadin.server.ui.demo;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.vaadin.spring.security.VaadinSecurity;

/**
 * Утилиты для демо-версии.
 */
public class DemoUtils {
    /**
     * Если есть анонимная сессия, производится попытка входа в систему
     * @param vaadinSecurity сервис аутентификации
     */
    public static void authenticateAsAdmin(VaadinSecurity vaadinSecurity) {
        if (vaadinSecurity.isAuthenticatedAnonymously()) {
            try {
                vaadinSecurity.login("admin", "admin");
            } catch (Exception e) {
                throw new InternalAuthenticationServiceException(e.getMessage(), e);
            }
        }
    }
}