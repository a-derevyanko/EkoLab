package org.ecolab.server.dao.api.content.lab1;

import org.ecolab.server.dao.api.content.LabDao;
import org.ecolab.server.model.content.lab1.Lab1Data;
import org.ecolab.server.model.content.lab1.Lab1Variant;

/**
 * Created by 777Al on 19.04.2017.
 */
public interface Lab1Dao<T extends Lab1Variant> extends LabDao<Lab1Data<T>> {
}
