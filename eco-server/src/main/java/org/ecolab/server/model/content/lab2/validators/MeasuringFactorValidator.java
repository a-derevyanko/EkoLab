package org.ecolab.server.model.content.lab2.validators;

import org.ecolab.server.common.MathUtils;
import org.ecolab.server.model.content.FieldValidationResult;
import org.ecolab.server.model.content.FieldValidator;
import org.ecolab.server.model.content.lab2.Lab2Data;
import org.ecolab.server.model.content.lab2.Lab2Variant;
import org.springframework.stereotype.Service;

@Service
public class MeasuringFactorValidator implements FieldValidator<Double, Lab2Data<Lab2Variant>> {
    @Override
    public FieldValidationResult validate(Double value, Lab2Data<Lab2Variant> data) {
        return FieldValidationResult.of(data.getHemisphereSurface() == null || MathUtils.roundedCheckEquals(value,
                10 * Math.log10(data.getHemisphereSurface()), 1));
    }
}
