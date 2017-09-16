package org.ekolab.server.service.api.content;

import org.ekolab.server.model.DomainModel;
import org.ekolab.server.model.content.*;
import org.jfree.chart.JFreeChart;
import org.springframework.mail.MailException;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by 777Al on 26.04.2017.
 */
public interface LabService<T extends LabData> {
    /**
     * Возвращает признак того, что значение поля может быть проверено программой
     * @param field поле
     * @return признак того, что значение поля может быть проверено программой
     */
    boolean isFieldValidated(Field field);

    boolean isFieldCalculated(Field field);

    T getLastUncompletedLabByUser(String userName);

    T getCompletedLabByUser(String userName);

    List<T> getAllLabsByUser(String userName);

    T startNewLab(String userName);

    T updateLab(T labData);

    int removeLabsByUser(String userName);

    int removeOldLabs(LocalDateTime lastSaveDate);

    /**
     * Возвращает печатный вариант отчёта в PDF формате
     * @param labData данные лабораторной работы
     * @param locale язык
     * @return печатный вариант данных в PDF формате
     */
    byte[] createReport(T labData, Locale locale);

    /**
     * Заполняет в модели значения вычисляемых полей
     * @param labData модель
     * @return модель, в которой заполнены вычисляемые поля
     */
    T updateCalculatedFields(T labData);

    /**
     * Проверяет правильность значения поля
     * @param field поле
     * @param value значение
     * @param labData данные лабораторной
     * @return признак того, что значение верно
     */
    boolean validateFieldValue(Field field, Object value, T labData);

    /**
     * Возвращает печатный вариант исходных данных в PDF формате
     * @param variant вариант лабораторной работы
     * @param locale язык
     * @return печатный вариант исходных данных в PDF формате
     */
    byte[] printInitialData(LabVariant variant, Locale locale);

    /**
     * Отправляет печатный вариант исходных данных в PDF формате на почту
     * @param variant вариант лабораторной работы
     * @param locale язык
     * @param email адрес
     */
    void sentInitialDataToEmail(LabVariant variant, Locale locale, String email) throws MailException;


    /**
     * Отправляет печатный вариант отчёта в PDF формате на почту
     * @param labData данные лабораторной работы
     * @param locale язык
     * @param email адрес
     */
    void sendReportToEmail(T labData, Locale locale, String email);

    JFreeChart createChart(T labData, Locale locale, LabChartType chartType);

    LabTest getLabTest(Locale locale);

    /**
     * Проверяет результаты теста.
     * @param data данные лабораторной
     * @param answers ответы
     * @return количество ошибок
     */
    int checkLabTest(LabData<?> data, Map<LabTestQuestionVariant, Object> answers);

    /**
     * Проверяет, что тест пройден пользователем
     * @param userName имя пользователя
     * @return тест пройден пользователем
     */
    boolean isTestCompleted(String userName);

    /**
     * Устанавливает признак пройденного теста для лабораторной
     * @param userName имя пользователя, прошедшего тест
     */
    void setTestCompleted(String userName);

    Map<String, String> getPrintData(DomainModel data, Locale locale);

    int getLabNumber();
}
