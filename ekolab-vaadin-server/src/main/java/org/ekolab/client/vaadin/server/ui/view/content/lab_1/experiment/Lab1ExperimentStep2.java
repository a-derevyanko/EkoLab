package org.ekolab.client.vaadin.server.ui.view.content.lab_1.experiment;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import org.ekolab.client.vaadin.server.service.I18N;
import org.ekolab.client.vaadin.server.ui.common.LabWizardStep;
import org.ekolab.client.vaadin.server.ui.customcomponents.ParameterWithFormulaeLayout;
import org.ekolab.server.model.content.lab1.Lab1Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.util.FieldUtils;

import java.io.IOException;

/**
 * Created by 777Al on 06.04.2017.
 */
@SpringComponent
@ViewScope
public class Lab1ExperimentStep2 extends HorizontalLayout implements LabWizardStep {
    // ----------------------------- Графические компоненты --------------------------------
    @Autowired
    private I18N i18N;

    @Autowired
    private ParameterWithFormulaeLayout<Lab1Data> firstFormLayout;

    @Override
    public void init() throws IOException {
        LabWizardStep.super.init();
        setSizeFull();
        setMargin(true);
        addComponent(firstFormLayout);
        setComponentAlignment(firstFormLayout, Alignment.MIDDLE_CENTER);
        firstFormLayout.setCaption(i18N.get("lab1.step2.processing-experiment-results"));
        firstFormLayout.addField(FieldUtils.getField(Lab1Data.class, "excessAirRatio"));
        firstFormLayout.addField(FieldUtils.getField(Lab1Data.class, "flueGasNOxConcentrationNC"));
        firstFormLayout.addField(FieldUtils.getField(Lab1Data.class, "excessOfNorms"));
        firstFormLayout.addField(FieldUtils.getField(Lab1Data.class, "validBarometricPressure"));
        firstFormLayout.addField(FieldUtils.getField(Lab1Data.class, "validAbsolutePressure"));
        firstFormLayout.addField(FieldUtils.getField(Lab1Data.class, "correctionFactor"));
        firstFormLayout.addField(FieldUtils.getField(Lab1Data.class, "fuelConsumerCorrection"));
        firstFormLayout.addField(FieldUtils.getField(Lab1Data.class, "fuelConsumerNC"));
    }
}