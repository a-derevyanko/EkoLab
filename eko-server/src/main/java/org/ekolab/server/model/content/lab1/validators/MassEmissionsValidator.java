package org.ekolab.server.model.content.lab1.validators;

import org.ekolab.server.common.MathUtils;
import org.ekolab.server.model.content.FieldValidator;
import org.ekolab.server.model.content.lab1.Lab1Data;
import org.ekolab.server.model.content.lab1.Lab1Variant;

public class MassEmissionsValidator implements FieldValidator<Double, Lab1Variant, Lab1Data> {
    @Override
    public boolean validate(Double value, Lab1Data labData) {
        return labData.getVariant().getFlueGasNOxConcentration() == null || labData.getDryGasesFlowRate() == null ||
                MathUtils.checkEquals(value,
                        labData.getVariant().getFlueGasNOxConcentration() * labData.getDryGasesFlowRate());
    }
}
