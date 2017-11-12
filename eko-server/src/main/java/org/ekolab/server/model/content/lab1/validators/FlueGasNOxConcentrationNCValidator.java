package org.ekolab.server.model.content.lab1.validators;

import org.ekolab.server.common.MathUtils;
import org.ekolab.server.model.content.FieldValidationResult;
import org.ekolab.server.model.content.FieldValidator;
import org.ekolab.server.model.content.lab1.Lab1Data;
import org.ekolab.server.model.content.lab1.Lab1Variant;
import org.springframework.stereotype.Service;

@Service
public class FlueGasNOxConcentrationNCValidator implements FieldValidator<Double, Lab1Data<Lab1Variant>> {
    @Override
    public FieldValidationResult validate(Double value,  Lab1Data<Lab1Variant> labData) {
        return FieldValidationResult.of(labData.getFlueGasNOxConcentration() == null ||
                labData.getExcessAirRatio() == null ||
                MathUtils.checkEquals(value,
                        labData.getFlueGasNOxConcentration() * labData.getExcessAirRatio() / 1.4));
    }
}
