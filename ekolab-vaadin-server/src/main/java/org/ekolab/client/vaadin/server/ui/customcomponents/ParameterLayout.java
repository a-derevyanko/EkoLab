package org.ekolab.client.vaadin.server.ui.customcomponents;

import com.vaadin.data.Binder;
import com.vaadin.data.Converter;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.util.ReflectTools;
import org.ekolab.client.vaadin.server.service.I18N;
import org.ekolab.client.vaadin.server.service.ParameterCustomizer;
import org.ekolab.client.vaadin.server.service.ResourceService;
import org.ekolab.client.vaadin.server.ui.styles.EkoLabTheme;
import org.ekolab.client.vaadin.server.ui.view.api.UIComponent;
import org.ekolab.server.model.content.LabData;
import org.ekolab.server.service.api.content.LabService;
import org.springframework.boot.autoconfigure.mustache.MustacheProperties;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.ekolab.client.vaadin.server.ui.common.ResourceWindow.show;

/**
 * Created by 777Al on 08.04.2017.
 */
public class ParameterLayout<BEAN extends LabData> extends GridLayout implements UIComponent {
    private final String parametersPath;

    private final Binder<BEAN> dataBinder;

    private final LabService labService;

    private final I18N i18N;

    private final ResourceService res;

    private final ParameterCustomizer parameterCustomizer;

    public ParameterLayout(String parametersPath, Binder<BEAN> dataBinder, LabService labService, I18N i18N,
                           ResourceService res, ParameterCustomizer parameterCustomizer) {
        this.parametersPath = parametersPath;
        this.dataBinder = dataBinder;
        this.labService = labService;
        this.i18N = i18N;
        this.res = res;
        this.parameterCustomizer = parameterCustomizer;
    }

    // ---------------------------- Графические компоненты --------------------
    @Override
    public void init() throws Exception {
        UIComponent.super.init();
        setColumns(4);
        setMargin(true);
        setSpacing(false);
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setStyleName(EkoLabTheme.LAYOUT_LAB);
    }

    public void addField(Field propertyField) {
        int lastRow = getRows() - 1;

        addCaption(propertyField.getName(), lastRow);
        addComponent(propertyField, lastRow);
        addSign(propertyField.getName(), lastRow);
        addInfoButton(propertyField.getName(), lastRow);
        insertRow(getRows());
    }

    @Override
    public void addComponent(Component c) {
        throw new UnsupportedOperationException();
    }

    private void addCaption(String fieldName, int row) {
        String fieldCaption = parameterCustomizer.getParameterPrefix() + i18N.get(fieldName);
        String fieldDimension = i18N.get(fieldName + "-dimension");
        Label captionLabel = new Label(fieldDimension.isEmpty() ? fieldCaption : fieldCaption + " (" + fieldDimension + ')', ContentMode.HTML);
        captionLabel.addStyleName(EkoLabTheme.LABEL_TINY);
        super.addComponent(captionLabel, 0, row);
        setComponentAlignment(captionLabel, Alignment.MIDDLE_LEFT);
    }

    private void addSign(String fieldName, int row) {
        Label signLabel = new Label(i18N.get(fieldName + "-sign"), ContentMode.HTML);
        signLabel.addStyleName(EkoLabTheme.LABEL_SIGN);
        signLabel.addStyleName(EkoLabTheme.LABEL_TINY);
        super.addComponent(signLabel, 2, row);
    }

    private void addComponent(Field propertyField, int row) {
        Class<?> propClass = ReflectTools.convertPrimitiveType(propertyField.getType());
        boolean readOnly = labService.isFieldCalculated(propertyField);
        AbstractComponent component;
        if (propClass.isEnum()) {
            ComboBox<Enum<?>> comboBox = new ComboBox<>(null, Arrays.asList((Enum<?>[]) propClass.getEnumConstants()));
            comboBox.setItemCaptionGenerator((elem) -> i18N.get(elem.getDeclaringClass().getSimpleName() + '.' + elem.name()));
            comboBox.setTextInputAllowed(false);
            comboBox.setPageLength(15);
            comboBox.setEmptySelectionAllowed(false);
            dataBinder.forField(comboBox).bind(propertyField.getName());
            comboBox.setReadOnly(readOnly);
            comboBox.addStyleName(EkoLabTheme.COMBOBOX_TINY);
            component = comboBox;
        } else {
            TextField field = new TextField();
            String validatorPrefix = i18N.get("validator.value-of-field") + " '"
                    + i18N.get(propertyField.getName()) + "' ";
            Converter<String, ?> converter;
            if (propClass == Integer.class) {
                converter = new StringToIntegerConverter(validatorPrefix + i18N.get("validator.must-be-number"));
            } else if (propClass == Double.class) {
                converter = new StringToDoubleConverter(validatorPrefix + i18N.get("validator.must-be-double"));
            } else {
                throw new IllegalArgumentException("Unknown field type");
            }

            dataBinder.forField(field).withNullRepresentation(readOnly ? i18N.get("labwizard.unknown-value") : "")
                    .withConverter(converter).bind(propertyField.getName());
            field.setReadOnly(readOnly);
            field.addStyleName(EkoLabTheme.TEXTFIELD_TINY);
            component = field;
        }
        super.addComponent(component, 1, row);
        component.setWidth(130, Unit.PIXELS);
    }

    private void addInfoButton(String fieldName, int row) {
        if (res.isResourceExists(parametersPath, fieldName + MustacheProperties.DEFAULT_SUFFIX)) {
            Button infoButton = new Button(VaadinIcons.QUESTION);
            infoButton.addClickListener(event -> show(i18N.get(fieldName), res.getHtmlData(parametersPath, fieldName + MustacheProperties.DEFAULT_SUFFIX)));
            infoButton.addStyleName(EkoLabTheme.BUTTON_TINY);
            super.addComponent(infoButton, 3, row);
        }
    }
}
