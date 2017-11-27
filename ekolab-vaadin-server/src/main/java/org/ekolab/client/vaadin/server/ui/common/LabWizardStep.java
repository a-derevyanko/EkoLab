package org.ekolab.client.vaadin.server.ui.common;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import org.ekolab.client.vaadin.server.ui.styles.EkoLabTheme;
import org.ekolab.client.vaadin.server.ui.view.api.UIComponent;
import org.ekolab.server.dev.LogExecutionTime;
import org.ekolab.server.model.content.LabData;
import org.ekolab.server.model.content.LabVariant;
import org.vaadin.teemu.wizards.WizardStep;

import javax.annotation.PostConstruct;

/**
 * Created by 777Al on 05.04.2017.
 */
public interface LabWizardStep<T extends LabData<V>, V extends LabVariant> extends Component, UIComponent, WizardStep {
    @Override
    @PostConstruct
    @LogExecutionTime
    default void init() {
        setSizeUndefined();
        setStyleName(EkoLabTheme.PANEL_WIZARD_STEP);
    }

    @Override
    default Component getContent() {
        beforeEnter();
        return this;
    }

    @Override
    default boolean onAdvance() {
        return true;
    }

    @Override
    default boolean onBack() {
        return true;
    }

    default void placeAdditionalComponents(HorizontalLayout buttonsLayout) {}

    default void beforeEnter() {}
}
