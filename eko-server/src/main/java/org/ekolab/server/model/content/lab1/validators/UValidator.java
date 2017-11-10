package org.ekolab.server.model.content.lab1.validators;

import org.ekolab.server.common.MathUtils;
import org.ekolab.server.model.content.FieldValidationResult;
import org.ekolab.server.model.content.FieldValidator;
import org.ekolab.server.model.content.lab1.Lab1Data;
import org.ekolab.server.model.content.lab1.Lab1Variant;
import org.springframework.stereotype.Service;

@Service
public class UValidator implements FieldValidator<Double, Lab1Variant, Lab1Data<Lab1Variant>> {
    @Override
    public FieldValidationResult validate(Double value, Lab1Data<Lab1Variant> labData) {
        if (labData.getStackExitTemperature() == null || labData.getOutsideAirTemperature() == null ||
                labData.getFlueGasesRate() == null || labData.getStacksHeight() == null) {
            return FieldValidationResult.ok();
        }
        double dT = labData.getStackExitTemperature() - labData.getOutsideAirTemperature();
        return FieldValidationResult.of(MathUtils.checkEquals(value, 0.65 *
                Math.cbrt(labData.getFlueGasesRate() * dT / labData.getStacksHeight())));
    }
}
