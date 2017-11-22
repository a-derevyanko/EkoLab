package org.ekolab.server.model.content.lab1.validators;

import org.ekolab.server.common.MathUtils;
import org.ekolab.server.model.content.FieldValidationResult;
import org.ekolab.server.model.content.FieldValidator;
import org.ekolab.server.model.content.lab1.Lab1Data;
import org.ekolab.server.model.content.lab1.Lab1Variant;
import org.springframework.stereotype.Service;

@Service
public class DistanceFromEmissionSourceValidator implements FieldValidator<Double, Lab1Data<Lab1Variant>> {
    @Override
    public FieldValidationResult validate(Double value, Lab1Data<Lab1Variant> labData) {
        return FieldValidationResult.of(labData.getStacksHeight() == null || labData.getD() == null || labData.getF() == null ||
                MathUtils.roundedCheckEquals(value,
                        (5 - labData.getHarmfulSubstancesDepositionCoefficient()) / 4.0 * labData.getStacksHeight() * labData.getD(), 2));
    }
}
