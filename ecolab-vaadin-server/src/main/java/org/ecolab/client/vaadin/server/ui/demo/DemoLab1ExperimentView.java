package org.ecolab.client.vaadin.server.ui.demo;

import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringView;
import org.ecolab.client.vaadin.server.service.impl.I18N;
import org.ecolab.client.vaadin.server.ui.VaadinUI;
import org.ecolab.client.vaadin.server.ui.common.LabWizardStep;
import org.ecolab.client.vaadin.server.ui.view.content.lab_1.experiment.Lab1ExperimentView;
import org.ecolab.client.vaadin.server.ui.windows.ConfirmWindow;
import org.ecolab.client.vaadin.server.ui.windows.InitialDataWindow;
import org.ecolab.client.vaadin.server.ui.windows.LabFinishedWindow;
import org.ecolab.server.common.Profiles;
import org.ecolab.server.model.content.lab1.Lab1Data;
import org.ecolab.server.model.content.lab1.experiment.Lab1ExperimentLog;
import org.ecolab.server.service.api.content.lab1.experiment.Lab1ExperimentService;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * Created by Андрей on 02.04.2017.
 */
@SpringView(name = DemoLab1ExperimentView.NAME)
@Profile(value = {Profiles.MODE.DEMO, Profiles.MODE.DEV})
public class DemoLab1ExperimentView extends Lab1ExperimentView {

    public DemoLab1ExperimentView(I18N i18N, Authentication currentUser, InitialDataWindow<Lab1Data<Lab1ExperimentLog>,
                Lab1ExperimentLog> initialDataWindow, Lab1ExperimentService labService,
                                  Binder<Lab1Data<Lab1ExperimentLog>> binder,
                                  LabFinishedWindow<Lab1Data<Lab1ExperimentLog>, Lab1ExperimentLog> labFinishedWindow,
                                  List<LabWizardStep<Lab1Data<Lab1ExperimentLog>, Lab1ExperimentLog>> labSteps,
                                  ConfirmWindow confirmWindow,
                                  VaadinUI ui, Binder<Lab1ExperimentLog> variantBinder) {
        super(i18N, currentUser, initialDataWindow, labService, binder, labFinishedWindow, labSteps, confirmWindow, ui, variantBinder);
    }
}
