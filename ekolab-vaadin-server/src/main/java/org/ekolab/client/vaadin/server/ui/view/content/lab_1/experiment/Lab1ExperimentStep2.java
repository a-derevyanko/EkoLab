package org.ekolab.client.vaadin.server.ui.view.content.lab_1.experiment;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.ekolab.client.vaadin.server.service.api.ResourceService;
import org.ekolab.client.vaadin.server.service.impl.I18N;
import org.ekolab.client.vaadin.server.ui.customcomponents.ParameterWithFormulaeLayout;
import org.ekolab.client.vaadin.server.ui.view.content.lab_1.Lab1Step2;
import org.ekolab.client.vaadin.server.ui.windows.ResourceWindow;
import org.ekolab.server.model.content.lab1.Lab1Data;
import org.ekolab.server.model.content.lab1.Lab1ExperimentLog;

/**
 * Created by 777Al on 06.04.2017.
 */
@SpringComponent
@ViewScope
public class Lab1ExperimentStep2 extends Lab1Step2<Lab1ExperimentLog> {
    public Lab1ExperimentStep2(I18N i18N, ResourceWindow resourceWindow,
                               ResourceService resourceService,
                               ParameterWithFormulaeLayout<Lab1Data<Lab1ExperimentLog>, Lab1ExperimentLog> firstFormLayout) {
        super(i18N, resourceWindow, resourceService, firstFormLayout);
    }
}
