package org.ekolab.client.vaadin.server.ui.view.content.lab_1;

import com.vaadin.spring.annotation.SpringView;
import org.ekolab.client.vaadin.server.service.impl.I18N;
import org.ekolab.client.vaadin.server.ui.common.LabTestWizard;
import org.ekolab.server.service.api.content.UserLabService;
import org.ekolab.server.service.api.content.lab1.Lab1Service;

/**
 * Created by 777Al on 03.04.2017.
 */
@SpringView(name = Lab1TestView.NAME)
public class Lab1TestView extends LabTestWizard {
    public static final String NAME = "lab1test";

    // ---------------------------- Графические компоненты --------------------

    protected Lab1TestView(I18N i18N, UserLabService userLabService, Lab1Service labService) {
        super(i18N, userLabService, labService);
    }
}
