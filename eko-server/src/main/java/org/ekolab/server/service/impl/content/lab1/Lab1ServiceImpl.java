package org.ekolab.server.service.impl.content.lab1;

import org.ekolab.server.dao.api.content.lab1.Lab1Dao;
import org.ekolab.server.model.content.lab1.Lab1Data;
import org.ekolab.server.model.content.lab1.Lab1Variant;
import org.ekolab.server.service.api.ReportService;
import org.ekolab.server.service.api.StudentInfoService;
import org.ekolab.server.service.api.UserInfoService;
import org.ekolab.server.service.api.content.lab1.Lab1Service;
import org.ekolab.server.service.impl.content.LabServiceImpl;
import org.springframework.context.MessageSource;

/**
 * Created by 777Al on 26.04.2017.
 */
public abstract class Lab1ServiceImpl<V extends Lab1Variant, D extends Lab1Dao<Lab1Data<V>>> extends LabServiceImpl<Lab1Data<V>, V, D> implements Lab1Service<V> {

    protected Lab1ServiceImpl(D labDao, UserInfoService userInfoService, ReportService reportService, MessageSource messageSource, StudentInfoService studentInfoService) {
        super(labDao, userInfoService, reportService, messageSource, studentInfoService);
    }

    @Override
    protected Lab1Data<V> createNewLabData() {
        return new Lab1Data<>();
    }

    @Override
    public void updateCalculatedFields(Lab1Data labData) {
        //todo correctionFactor!!!!
    }


    @Override
    public int getLabNumber() {
        return 1;
    }
}
