package org.ekolab.server.model.content.lab2;

import org.ekolab.server.model.content.LabVariant;
import org.ekolab.server.model.content.ValidatedBy;
import org.ekolab.server.model.content.lab2.validators.AverageSoundPressureControlPointValidator;
import org.ekolab.server.model.content.lab2.validators.QuantityOfSingleTypeEquipmentValidator;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
 * Created by Андрей on 24.06.2017.
 */
public abstract class Lab2Variant extends LabVariant {
    /**
     * Название объекта
     */
    private ObjectType name;

    /**
     * Барометрическое давление
     */
    private Integer barometricPressure;

    /**
     * Температура воздуха в помещении
     */

    private Integer indoorsTemperature;

    /**
     * Объем помещения с исследуемым объектом
     */

    private Integer roomSize;

    /**
     * Количество однотипного оборудования
     */
    @ValidatedBy(QuantityOfSingleTypeEquipmentValidator.class)
    private Integer quantityOfSingleTypeEquipment;

    /**
     * Средний уровень звукового давления
     */
    @Size(min = 9, max = 9)
    @ValidatedBy(AverageSoundPressureControlPointValidator.class)
    private List<Double> averageSoundPressure;

    public ObjectType getName() {
        return name;
    }

    public void setName(ObjectType name) {
        this.name = name;
    }

    public Integer getBarometricPressure() {
        return barometricPressure;
    }

    public void setBarometricPressure(Integer barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    public Integer getIndoorsTemperature() {
        return indoorsTemperature;
    }

    public void setIndoorsTemperature(Integer indoorsTemperature) {
        this.indoorsTemperature = indoorsTemperature;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public Integer getQuantityOfSingleTypeEquipment() {
        return quantityOfSingleTypeEquipment;
    }

    public void setQuantityOfSingleTypeEquipment(Integer quantityOfSingleTypeEquipment) {
        this.quantityOfSingleTypeEquipment = quantityOfSingleTypeEquipment;
    }
    public List<Double> getAverageSoundPressure() {
        return averageSoundPressure;
    }

    public void setAverageSoundPressure(List<Double> averageSoundPressure) {
        this.averageSoundPressure = averageSoundPressure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lab2Variant)) return false;
        Lab2Variant that = (Lab2Variant) o;
        return name == that.name &&
                Objects.equals(barometricPressure, that.barometricPressure) &&
                Objects.equals(indoorsTemperature, that.indoorsTemperature) &&
                Objects.equals(roomSize, that.roomSize) &&
                Objects.equals(quantityOfSingleTypeEquipment, that.quantityOfSingleTypeEquipment) &&
                Objects.equals(averageSoundPressure, that.averageSoundPressure);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, barometricPressure, indoorsTemperature, roomSize, quantityOfSingleTypeEquipment, averageSoundPressure);
    }
}
