package org.ekolab.server.dao.api;

import org.ekolab.server.model.LabData;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by 777Al on 19.04.2017.
 */
public interface LabDao<T extends LabData> {
    T getLastLabByUser(String userName);

    List<T> getAllLabsByUser(String userName);

    T saveLab(T labData);

    T updateLab(T labData);

    int removeLabsByUser(String userName);

    int removeOldLabs(LocalDateTime lastSaveDate);
}
