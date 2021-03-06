package org.ecolab.client.vaadin.server.ui.common;

import com.vaadin.data.Binder;
import com.vaadin.data.BinderValidationStatus;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import org.ecolab.client.vaadin.server.service.impl.I18N;
import org.ecolab.client.vaadin.server.ui.VaadinUI;
import org.ecolab.client.vaadin.server.ui.customcomponents.ComponentErrorNotification;
import org.ecolab.client.vaadin.server.ui.development.DevUtils;
import org.ecolab.client.vaadin.server.ui.styles.EcoLabTheme;
import org.ecolab.client.vaadin.server.ui.view.api.AutoSavableView;
import org.ecolab.client.vaadin.server.ui.windows.ConfirmWindow;
import org.ecolab.client.vaadin.server.ui.windows.InitialDataWindow;
import org.ecolab.client.vaadin.server.ui.windows.LabFinishedWindow;
import org.ecolab.server.common.Role;
import org.ecolab.server.model.content.LabData;
import org.ecolab.server.model.content.LabVariant;
import org.ecolab.server.service.api.content.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by Андрей on 19.03.2017.
 */
@RolesAllowed({Role.ADMIN, Role.TEACHER, Role.STUDENT})
public abstract class LabWizard<T extends LabData<V>, V extends LabVariant, S extends LabService<T, V>> extends Wizard implements AutoSavableView {
    // ---------------------------- Графические компоненты --------------------
    protected final GridLayout buttons = new GridLayout(3, 1);
    protected final Button saveButton = new Button("Save", VaadinIcons.CLOUD_DOWNLOAD_O);
    protected final Button initialDataButton = new Button("Initial data", VaadinIcons.CLIPBOARD_TEXT);
    protected final HorizontalLayout leftButtonsLayout = new HorizontalLayout();
    protected final HorizontalLayout firstColumnLayout = new HorizontalLayout();
    protected final HorizontalLayout secondColumnLayout = new HorizontalLayout();
    protected final HorizontalLayout thirdComponentsLayout = new HorizontalLayout();

    protected final List<LabWizardStep<T, V>> labSteps;

    protected final Authentication currentUser;

    protected final InitialDataWindow<T, V> initialDataWindow;

    protected final S labService;

    protected final Binder<T> binder;

    protected final LabFinishedWindow<T, V> labFinishedWindow;

    protected final ConfirmWindow confirmWindow;

    protected final VaadinUI ui;

    @Autowired
    public LabWizard(I18N i18N,
                     Authentication currentUser,
                     InitialDataWindow<T, V> initialDataWindow,
                     S labService, Binder<T> binder,
                     LabFinishedWindow<T, V> labFinishedWindow,
                     List<LabWizardStep<T, V>> labSteps,
                     ConfirmWindow confirmWindow, VaadinUI ui) {
        super(i18N);
        this.currentUser = currentUser;
        this.initialDataWindow = initialDataWindow;
        this.labService = labService;
        this.binder = binder;
        this.labFinishedWindow = labFinishedWindow;
        this.labSteps = labSteps;
        this.confirmWindow = confirmWindow;
        this.ui = ui;
    }

    @Override
    public void init() throws Exception {
        super.init();
        getHeader().setVisible(false);
        buttons.setSizeFull();
        buttons.setHeightUndefined();
        buttons.setSpacing(true);
        saveButton.setVisible(false);

        saveButton.addStyleName(EcoLabTheme.BUTTON_PRIMARY);
        saveButton.addStyleName(EcoLabTheme.BUTTON_TINY);
        initialDataButton.addStyleName(EcoLabTheme.BUTTON_PRIMARY);
        initialDataButton.addStyleName(EcoLabTheme.BUTTON_TINY);

        saveButton.setCaption(i18N.get("savable.save"));
        initialDataButton.setCaption(i18N.get("labwizard.initial-data"));

        mainLayout.removeComponent(footer);

        footer.addComponent(initialDataButton, 0);
        mainLayout.addComponent(buttons);

        thirdComponentsLayout.addComponent(footer);

        leftButtonsLayout.addComponent(getBackButton());
        leftButtonsLayout.addComponent(saveButton);
        firstColumnLayout.addComponent(leftButtonsLayout);
        buttons.addComponent(firstColumnLayout, 0, 0);
        buttons.addComponent(secondColumnLayout, 1, 0);
        buttons.addComponent(thirdComponentsLayout, 2, 0);

        firstColumnLayout.setSizeFull();
        secondColumnLayout.setSizeFull();
        thirdComponentsLayout.setSizeFull();

        buttons.setComponentAlignment(firstColumnLayout, Alignment.MIDDLE_LEFT);
        buttons.setComponentAlignment(secondColumnLayout, Alignment.MIDDLE_CENTER);
        buttons.setComponentAlignment(thirdComponentsLayout, Alignment.MIDDLE_RIGHT);

        thirdComponentsLayout.setComponentAlignment(footer, Alignment.MIDDLE_RIGHT);

        firstColumnLayout.setComponentAlignment(leftButtonsLayout, Alignment.MIDDLE_LEFT);

        binder.addValueChangeListener(event -> {
            labService.updateCalculatedFields(binder.getBean());
            saveButton.setVisible(true);
        });

        saveButton.addClickListener(event -> saveData(true));
        initialDataButton.addClickListener(event -> showInitialData());

        labSteps.forEach(this::addStep);
    }

    @Override
    @Scheduled(fixedRateString = "${ecolab.lab.autoSaveRate:#{60000}}", initialDelayString = "${ecolab.lab.autoSaveRate:#{60000}}")
    public void autoSave() {
        saveData(false);
    }

    @Override
    public boolean saveData(boolean showErrors) {
        if (hasUnsavedData()) {
            var validationStatus = binder.validate();
            if (validationStatus.isOk()) {
                ui.access(() -> {
                    binder.readBean(labService.updateLab(binder.getBean()));
                    saveButton.setVisible(false);
                });
            } else {
                if (showErrors && Page.getCurrent() != null) {
                    ComponentErrorNotification.show(i18N.get("savable.save-exception-caption"), i18N.get("savable.save-exception"));
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasUnsavedData() {
        return currentStep instanceof LabExperimentJournalStep;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        var uncompletedLabData = labService.getLastUncompletedLabByUser(currentUser.getName());
        if (uncompletedLabData == null) {
            if (!DevUtils.isProductionVersion()) {
                labService.removeLabsByUser(currentUser.getName());
            }
            var newLabData = labService.startNewLab(currentUser.getName());
            binder.setBean(newLabData);
        } else {
            binder.setBean(uncompletedLabData);
        }
    }

    @Override
    public void activeStepChanged(WizardStepActivationEvent event) {
        super.activeStepChanged(event);
        secondColumnLayout.removeAllComponents();
        ((LabWizardStep) event.getActivatedStep()).placeAdditionalComponents(secondColumnLayout);
    }

    @Override
    public void wizardCompleted(WizardCompletedEvent event) {
        if (UIUtils.isModelFull(binder.getBean())) {
            binder.getBean().setCompleted(true);
            if (saveData(true) || binder.validate().isOk()) {
                removeAllWindows();
                labService.setLabCompleted(binder.getBean());
                confirmWindow.show(new ConfirmWindow.ConfirmWindowSettings("labwizard.lab-finished.confirm", () -> {
                    labFinishedWindow.show(new LabFinishedWindow.LabFinishedWindowSettings<>(binder.getBean(), labService));
                }));
            }
        } else {
            ComponentErrorNotification.show(i18N.get("labwizard.finish.cant-save"), i18N.get("labwizard.finish.not-all-fields-filled"));
        }
    }

    @Override
    public void next() {
        saveData(false);
        removeAllWindows();
        super.next();
    }

    @Override
    public void back() {
        saveData(false);
        removeAllWindows();
        super.back();
    }

    private void showInitialData() {
        initialDataWindow.show(new InitialDataWindow.InitialDataWindowSettings<T, V>(binder.getBean().getVariant(), labService));
    }
}
