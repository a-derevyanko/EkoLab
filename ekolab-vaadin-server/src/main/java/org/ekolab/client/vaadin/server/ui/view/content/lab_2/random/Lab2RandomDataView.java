package org.ekolab.client.vaadin.server.ui.view.content.lab_2.random;

import com.vaadin.spring.annotation.SpringView;
import org.ekolab.client.vaadin.server.ui.common.LabWizardStep;
import org.ekolab.client.vaadin.server.ui.view.content.lab_2.Lab2View;

import java.util.Collection;

/**
 * Created by Андрей on 02.04.2017.
 */
@SpringView(name = Lab2RandomDataView.NAME)
public class Lab2RandomDataView extends Lab2View {
    public static final String NAME = "lab2randomdata";

    // ----------------------------- Графические компоненты --------------------------------
    @Override
    protected Collection<LabWizardStep> getLabSteps() {
        return null;
    }
}