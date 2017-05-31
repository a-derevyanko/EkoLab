package org.ekolab.client.vaadin.server.service;

/**
 * Created by 777Al on 30.05.2017.
 */
public interface ParameterCustomizer {
    /**
     * Возвращает префикс параметру, добавляемому на форму.
     * @return префикс параметра
     */
    String getParameterPrefix();
}
