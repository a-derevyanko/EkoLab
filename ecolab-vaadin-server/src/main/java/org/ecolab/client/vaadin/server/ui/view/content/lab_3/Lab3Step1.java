package org.ecolab.client.vaadin.server.ui.view.content.lab_3;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.HorizontalLayout;
import org.ecolab.client.vaadin.server.service.impl.I18N;
import org.ecolab.client.vaadin.server.ui.common.LabWizardStep;
import org.ecolab.client.vaadin.server.ui.customcomponents.ParameterLayout;
import org.ecolab.server.model.content.lab3.Lab3Data;
import org.ecolab.server.model.content.lab3.Lab3Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.util.FieldUtils;

/**
 * Created by 777Al on 06.04.2017.
 */
@SpringComponent
@ViewScope
public class Lab3Step1 extends HorizontalLayout implements LabWizardStep<Lab3Data, Lab3Variant> {
    private final I18N i18N;

    private final ParameterLayout<Lab3Data, Lab3Variant> firstFormLayout;

    private final ParameterLayout<Lab3Data, Lab3Variant> secondFormLayout;

    @Autowired
    public Lab3Step1(I18N i18N, ParameterLayout<Lab3Data, Lab3Variant> firstFormLayout, ParameterLayout<Lab3Data, Lab3Variant> secondFormLayout) {
        this.i18N = i18N;
        this.firstFormLayout = firstFormLayout;
        this.secondFormLayout = secondFormLayout;
    }

    // ----------------------------- Графические компоненты --------------------------------

    @Override
    public void init() {
        LabWizardStep.super.init();
        setSizeFull();
        setMargin(true);
        addComponent(firstFormLayout);
        addComponent(secondFormLayout);
        firstFormLayout.setCaption(i18N.get("lab3.step1.power-station-characteristics"));
        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "tppOutput"));
        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "numberOfUnits"));
        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "city"));
        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "steamProductionCapacity"));
        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "numberOfStacks"));
        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "stacksHeight"));
        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "stacksDiameter"));

        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "windSpeed"));
        firstFormLayout.addField(FieldUtils.getField(Lab3Data.class, "windDirection"));

        secondFormLayout.setCaption(i18N.get("lab3.step1.fuel-characteristics"));
        secondFormLayout.addField(FieldUtils.getField(Lab3Data.class, "lowHeatValue"));
        secondFormLayout.addField(FieldUtils.getField(Lab3Data.class, "fuelConsumer"));
        secondFormLayout.addField(FieldUtils.getField(Lab3Data.class, "carbonInFlyAsh"));
        secondFormLayout.addField(FieldUtils.getField(Lab3Data.class, "sulphurContent"));
        secondFormLayout.addField(FieldUtils.getField(Lab3Data.class, "ashContent"));
        secondFormLayout.addField(FieldUtils.getField(Lab3Data.class, "waterContent"));
        secondFormLayout.addField(FieldUtils.getField(Lab3Data.class, "ashRecyclingFactor"));
    }
}
