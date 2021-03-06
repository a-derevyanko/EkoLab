package org.ecolab.client.vaadin.server.ui.windows;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.ecolab.client.vaadin.server.service.api.ResourceService;
import org.ecolab.client.vaadin.server.service.impl.I18N;
import org.ecolab.client.vaadin.server.ui.EcoLabNavigator;
import org.ecolab.client.vaadin.server.ui.styles.EcoLabTheme;
import org.ecolab.client.vaadin.server.ui.view.LabChooserView;
import org.ecolab.server.model.content.LabTestQuestionVariant;
import org.ecolab.server.model.content.LabTestQuestionVariantWithAnswers;
import org.ecolab.server.model.content.LabTestResult;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by 777Al on 20.04.2017.
 */
@SpringComponent
@UIScope
public class LabTestFinishedWindow extends BaseEcoLabWindow<LabTestFinishedWindow.LabFinishedWindowSettings> {

    // ---------------------------- Графические компоненты --------------------
    private final Accordion testResultAccordion = new Accordion();
    private final Image testCompleted = new Image();
    private final Image testNotCompleted = new Image();
    private final Button toMainMenuButton = new Button("Exit to main menu", VaadinIcons.EXIT);
    private final Label result = new Label("Result: {}, {}");
    private final VerticalLayout bottomRightPane = new VerticalLayout(result, toMainMenuButton);
    private final VerticalLayout rightPane = new VerticalLayout(testCompleted, testNotCompleted, bottomRightPane);
    private final HorizontalLayout content = new HorizontalLayout(testResultAccordion, rightPane);

    private final I18N i18N;

    private final EcoLabNavigator navigator;

    private final ResourceService resourceService;

    @Autowired
    public LabTestFinishedWindow(I18N i18N, EcoLabNavigator navigator, ResourceService resourceService) {
        this.i18N = i18N;
        this.navigator = navigator;
        this.resourceService = resourceService;
    }

    @PostConstruct
    public void init() {
        setCaption(i18N.get("labwizard.lab-finished"));
        setContent(content);
        setHeight(80.0F, Unit.PERCENTAGE);
        setWidth(80.0F, Unit.PERCENTAGE);
        setModal(true);
        testCompleted.setSource(resourceService.getImage("content/", EcoLabTheme.TEST_COMPLETED));
        testNotCompleted.setSource(resourceService.getImage("content/", EcoLabTheme.TEST_NOT_COMPLETED));

        rightPane.setSizeFull();

        rightPane.setComponentAlignment(testCompleted, Alignment.TOP_CENTER);
        rightPane.setComponentAlignment(testNotCompleted, Alignment.TOP_CENTER);
        rightPane.setComponentAlignment(bottomRightPane, Alignment.BOTTOM_CENTER);
        bottomRightPane.setComponentAlignment(result, Alignment.MIDDLE_CENTER);
        bottomRightPane.setComponentAlignment(toMainMenuButton, Alignment.BOTTOM_CENTER);
        testResultAccordion.setSizeFull();
        content.setSizeFull();
        content.setStyleName(EcoLabTheme.PANEL_TEST_FINISHED);
        content.setMargin(true);

        result.setStyleName(EcoLabTheme.LABEL_BOLD_ITALIC);

        toMainMenuButton.setCaption(i18N.get("labwizard.lab-finished.go-to-main-menu"));

        toMainMenuButton.addStyleName(EcoLabTheme.BUTTON_PRIMARY);
        toMainMenuButton.addStyleName(EcoLabTheme.BUTTON_TINY);

        toMainMenuButton.addClickListener(event -> close());
        center();
    }

    @Override
    public void close() {
        super.close();
        navigator.redirectToView(LabChooserView.NAME);
    }

    @Override
    protected void beforeShow() {
        super.beforeShow();
        if (settings.result.getCompleted()) {
            testCompleted.setVisible(true);
            result.setVisible(true);
            result.setValue(i18N.get("test.result", settings.result.getPointCount(), settings.result.getMark()));
        } else {
            testNotCompleted.setVisible(true);
            result.setVisible(false);
        }

        settings.questions.stream().
                sorted(Comparator.comparingInt(LabTestQuestionVariant::getNumber)).
                forEach(questionVariant -> {
                    var question = new StringBuilder(questionVariant.getQuestion());

                    if (questionVariant instanceof LabTestQuestionVariantWithAnswers) {
                        var answers = ((LabTestQuestionVariantWithAnswers) questionVariant).getAnswers();
                        IntStream.rangeClosed(0, answers.size() - 1).forEachOrdered(i -> question.append("<br>").append(i + 1).append(") ").append(answers.get(i)));
                    }

                    var label = new Label(question.toString(), ContentMode.HTML);
                    label.setWidth(500.0F, Unit.PIXELS);

                    Layout content = new VerticalLayout(label);
                    if (questionVariant.getImage() != null) {
                        content.addComponent(new Image(null, new ThemeResource(questionVariant.getImage())));
                    }

                    testResultAccordion.addTab(content,
                            i18N.get("test.question", questionVariant.getNumber())).setIcon(resourceService.getImage("ok.svg"));
                });

        settings.result.getErrors().forEach(tabIndex -> testResultAccordion.getTab(tabIndex - 1).setIcon(resourceService.getImage("error.svg")));
    }

    @Override
    protected void clear() {
        super.clear();
        testCompleted.setVisible(false);
        testNotCompleted.setVisible(false);
        testResultAccordion.removeAllComponents();
    }

    public static class LabFinishedWindowSettings implements WindowSettings {
        private final LabTestResult result;
        private final Collection<LabTestQuestionVariant> questions;

        public LabFinishedWindowSettings(LabTestResult result, Collection<LabTestQuestionVariant> questions) {
            this.result = result;
            this.questions = questions;
        }
    }
}
