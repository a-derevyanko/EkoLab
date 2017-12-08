package org.ekolab.client.vaadin.server.ui.view.content.lab_2.random;

import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.ekolab.client.vaadin.server.service.impl.I18N;
import org.ekolab.client.vaadin.server.ui.common.LabWizardStep;
import org.ekolab.client.vaadin.server.ui.customcomponents.ParameterWithFormulaeLayout;
import org.ekolab.client.vaadin.server.ui.styles.EkoLabTheme;
import org.ekolab.server.model.content.lab2.Lab2Data;
import org.ekolab.server.model.content.lab2.random.Lab2RandomVariant;
import org.springframework.security.util.FieldUtils;

/**
 * Created by 777Al on 06.04.2017.
 */
@SpringComponent
@ViewScope
public class Lab2RandomStep1 extends HorizontalLayout implements LabWizardStep<Lab2Data<Lab2RandomVariant>, Lab2RandomVariant> {
    private final I18N i18N;

    private final Binder<Lab2Data<Lab2RandomVariant>> binder;

    private final ParameterWithFormulaeLayout<Lab2Data<Lab2RandomVariant>, Lab2RandomVariant> firstFormLayout;

    public Lab2RandomStep1(I18N i18N,
                           Binder<Lab2Data<Lab2RandomVariant>> binder,
                           ParameterWithFormulaeLayout<Lab2Data<Lab2RandomVariant>, Lab2RandomVariant> firstFormLayout) {
        this.i18N = i18N;
        this.binder = binder;
        this.firstFormLayout = firstFormLayout;
    }

    // ----------------------------- Графические компоненты --------------------------------
    private final Label nameLabel = new Label();

    @Override
    public void init() {
        LabWizardStep.super.init();
        setSizeFull();
        setMargin(true);
        addComponent(firstFormLayout);
        setCaption(i18N.get("lab2.step1.general-data"));

        nameLabel.addStyleName(EkoLabTheme.LABEL_BOLD_ITALIC);

        firstFormLayout.addCaption("name", 0);
        firstFormLayout.addComponent(nameLabel, 1, 0, 2, 0);
        firstFormLayout.addInfoButton("name", 0);
        firstFormLayout.insertRow(firstFormLayout.getRows());

        firstFormLayout.addField(FieldUtils.getField(Lab2Data.class, "barometricPressure"));
        firstFormLayout.addField(FieldUtils.getField(Lab2Data.class, "indoorsTemperature"));
        firstFormLayout.addField(FieldUtils.getField(Lab2Data.class, "roomSize"));
        firstFormLayout.addField(FieldUtils.getField(Lab2Data.class, "quantityOfSingleTypeEquipment"));
        firstFormLayout.addField(FieldUtils.getField(Lab2Data.class, "hemisphereRadius"));
        firstFormLayout.addField(FieldUtils.getField(Lab2Data.class, "averageSoundPressure"));
    }

    @Override
    public void beforeEnter() {
        nameLabel.setValue(i18N.get(binder.getBean().getVariant().getName()));
    }
}