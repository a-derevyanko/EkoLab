package org.ecolab.client.vaadin.server.ui.view.content.lab_1.random;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.ecolab.client.vaadin.server.service.api.ResourceService;
import org.ecolab.client.vaadin.server.service.impl.I18N;
import org.ecolab.client.vaadin.server.ui.customcomponents.ParameterWithFormulaeLayout;
import org.ecolab.client.vaadin.server.ui.view.content.lab_1.Lab1Step2;
import org.ecolab.client.vaadin.server.ui.windows.ResourceWindow;
import org.ecolab.server.model.content.lab1.Lab1Data;
import org.ecolab.server.model.content.lab1.random.Lab1RandomVariant;

/**
 * Created by 777Al on 06.04.2017.
 */
@SpringComponent
@ViewScope
public class Lab1RandomStep2 extends Lab1Step2<Lab1RandomVariant> {
    public Lab1RandomStep2(I18N i18N, ResourceWindow resourceWindow,
                           ResourceService resourceService,
                           ParameterWithFormulaeLayout<Lab1Data<Lab1RandomVariant>, Lab1RandomVariant> firstFormLayout) {
        super(i18N, resourceWindow, resourceService, firstFormLayout);
    }
}
