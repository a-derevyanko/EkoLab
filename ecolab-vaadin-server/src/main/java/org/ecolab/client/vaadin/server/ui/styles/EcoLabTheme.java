package org.ecolab.client.vaadin.server.ui.styles;

import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Андрей on 02.04.2017.
 */
public class EcoLabTheme extends ValoTheme {
    public static final String THEME_NAME = "EcoLab";

    // ---------------------- Представления -------------------------
    public static final String VIEW_LOGIN = "loginview";

    public static final String VIEW_LABCHOOSER = "labchooserview";

    // ---------------------- Панели -------------------------
    public static final String PANEL_CAPTION = "v-panel-caption";

    public static final String PANEL_LOGIN = "login-panel";

    public static final String PANEL_LABCHOOSER = "content-panel";

    public static final String PANEL_WIZARD = "wizard-panel";

    public static final String PANEL_WIZARD_STEP = "wizard-step-panel";

    public static final String PANEL_WIZARD_PRESENTATION = "wizard-presentation-panel";

    public static final String PANEL_WIZARD_EXPERIMENT_PRESENTATION = "wizard-experiment-presentation-panel";

    public static final String PANEL_LAB_FINISHED = "wizard-lab-finished";

    public static final String PANEL_TEST_FINISHED = "test-finished";

    public static final String PANEL_TEST_PRESENTATION = "test-presentation-panel";

    // ---------------------- Окна -------------------------

    // ---------------------- Компоновщики  -------------------------
    public static final String LAYOUT_LAB = "lab-form-layout";

    // ---------------------- Надписи -------------------------
    public static final String LABEL_SIGN = "lab-form-layout-sign";

    public static final String LABEL_BOLD_ITALIC = "label-bold-italic";

    // ---------------------- Кнопки -------------------------
    public static final String BUTTON_MULTILINE = "multiline";

    public static final String BUTTON_VARIANT_CHOOSER = "variant-chooser";

    public static final String BUTTON_TEST_VARIANT_CHOOSER = "test-variant-chooser";

    public static final String BUTTON_CHOOSER = "chooser";

    public static final String BUTTON_DISABLED = "disabled";

    //public static final String BUTTON_LABWIZARD_BACK = "labwizard-button-back";


    // ---------------------- Изображения -------------------------
    public static final String IMAGE_TEXT_LOGO = "textLogo.svg";

    public static final String IMAGE_LOGO = "logo.svg";

    public static final String TEST_COMPLETED = "testCompleted.svg";

    public static final String TEST_NOT_COMPLETED = "testNotCompleted.svg";

    public static final String EXPERIMENT_TYPE = "experimentType.svg";

    public static final String RANDOM_DATA_TYPE = "randomDataType.svg";

    public static final String IMAGE_LOGO_CROP = "logoCrop.svg";

    // --------------------- Расположение --------------------------
    public static final String V_ALIGN_CENTER = "v-align-center";
    public static String toCssPosition(int left, int top) {
        return String.format("left: %spx; top: %spx;", left, top);
    }
}
