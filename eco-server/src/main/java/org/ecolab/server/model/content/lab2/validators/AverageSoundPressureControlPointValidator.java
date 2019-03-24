package org.ecolab.server.model.content.lab2.validators;

import java.util.List;
import java.util.Objects;
import org.ecolab.server.model.DomainModel;
import org.ecolab.server.model.content.FieldValidationResult;
import org.ecolab.server.model.content.FieldValidator;
import org.springframework.stereotype.Service;

@Service
public class AverageSoundPressureControlPointValidator implements FieldValidator<List<Double>, DomainModel> {
    @Override
    public FieldValidationResult validate(List<Double> value, DomainModel data) {
        // Валидатор отключён
        // "на производстве всякое бывает, могут и не совсем точно снять показания, а потом из-за этого лабу не сделают"
        /*for (int i = 1; i < value.size(); i++) {
            if (value.get(i) > value.get(i - 1)) {
                return FieldValidationResult.error("lab2.error.soundPressureControlPointValidator");
            }
        }*/
        // Проверяем что все значения непусты
        return FieldValidationResult.of(value.stream().anyMatch(Objects::isNull));
    }
}
