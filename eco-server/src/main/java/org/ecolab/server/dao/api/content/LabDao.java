package org.ecolab.server.dao.api.content;

import org.ecolab.server.model.content.LabData;
import org.ecolab.server.model.content.LabTestQuestion;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by 777Al on 19.04.2017.
 */
public interface LabDao<T extends LabData> {
    T getLastLabByUser(String userName, boolean completed);

    void saveLab(T labData);

    int updateLab(T labData);

    int removeLabsByUser(String userName);

    int removeOldLabs(LocalDateTime lastSaveDate);

    Collection<LabTestQuestion> getTestQuestions(Locale locale);

    /**
     * Устанавливает признак пройденной лабораторной
     * @param data данные лабораторной
     */
    void setLabCompleted(T data);
}
