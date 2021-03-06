package org.ecolab.server.model.content.lab1.validators;

import org.ecolab.server.common.MathUtils;
import org.ecolab.server.model.content.FieldValidationResult;
import org.ecolab.server.model.content.FieldValidator;
import org.ecolab.server.model.content.lab1.Lab1Data;
import org.ecolab.server.model.content.lab1.Lab1Variant;
import org.springframework.stereotype.Service;

@Service
public class MassEmissionsValidator implements FieldValidator<Double, Lab1Data<Lab1Variant>> {
    @Override
    public FieldValidationResult validate(Double value, Lab1Data<Lab1Variant> labData) {
        return value < 0.1 ? FieldValidationResult.error("lab1.error.massEmissions") :
                FieldValidationResult.of(labData.getFlueGasNOxConcentration() == null || labData.getDryGasesFlowRate() == null ||
                MathUtils.roundedCheckEquals(value,
                        labData.getFlueGasNOxConcentration() / 1000.0 * labData.getDryGasesFlowRate(), 1));
    }
}
