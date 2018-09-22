package org.ecolab.client.vaadin.server.ui.view.content.lab_1.experiment;

import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringView;
import org.ecolab.client.vaadin.server.service.impl.I18N;
import org.ecolab.client.vaadin.server.ui.VaadinUI;
import org.ecolab.client.vaadin.server.ui.common.LabExperimentView;
import org.ecolab.client.vaadin.server.ui.common.LabWizardStep;
import org.ecolab.client.vaadin.server.ui.windows.ConfirmWindow;
import org.ecolab.client.vaadin.server.ui.windows.InitialDataWindow;
import org.ecolab.client.vaadin.server.ui.windows.LabFinishedWindow;
import org.ecolab.server.common.Profiles;
import org.ecolab.server.model.content.lab1.Lab1Data;
import org.ecolab.server.model.content.lab1.experiment.Lab1ExperimentLog;
import org.ecolab.server.service.api.content.lab1.experiment.Lab1ExperimentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import java.util.List;

/**
 * Created by Андрей on 02.04.2017.
 */
@SpringView(name = Lab1ExperimentView.NAME)
@Profile(Profiles.MODE.PROD)
public class Lab1ExperimentView extends LabExperimentView<Lab1Data<Lab1ExperimentLog>, Lab1ExperimentLog, Lab1ExperimentService> {
    public static final String NAME = "lab1experiment";

    public Lab1ExperimentView(I18N i18N,
                              InitialDataWindow<Lab1Data<Lab1ExperimentLog>,
                                                                    Lab1ExperimentLog> initialDataWindow,
                              Lab1ExperimentService labService,
                              Binder<Lab1Data<Lab1ExperimentLog>> binder,
                              LabFinishedWindow<Lab1Data<Lab1ExperimentLog>,
                                      Lab1ExperimentLog> labFinishedWindow,
                              List<LabWizardStep<Lab1Data<Lab1ExperimentLog>, Lab1ExperimentLog>> labSteps,
                              ConfirmWindow confirmWindow,
                              VaadinUI ui,
                              Binder<Lab1ExperimentLog> variantBinder,
                              @Value("${ecolab.lab.autoSaveRate:#{60000}}") long autoSaveRate) {
        super(i18N, initialDataWindow, labService, binder, labFinishedWindow,
                labSteps, confirmWindow, ui, variantBinder, autoSaveRate);
    }
}
