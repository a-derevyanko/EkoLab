package org.ekolab.server.dao.api.content.lab1.experiment;

import org.ekolab.server.dao.api.content.LabExperimentDao;
import org.ekolab.server.dao.api.content.lab1.Lab1Dao;
import org.ekolab.server.model.content.lab1.Lab1Data;
import org.ekolab.server.model.content.lab1.experiment.Lab1ExperimentLog;

public interface Lab1ExperimentDao extends Lab1Dao<Lab1Data<Lab1ExperimentLog>>,
        LabExperimentDao<Lab1Data<Lab1ExperimentLog>, Lab1ExperimentLog> {
}
