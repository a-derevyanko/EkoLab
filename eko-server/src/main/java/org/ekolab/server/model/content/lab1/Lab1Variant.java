package org.ekolab.server.model.content.lab1;

import org.ekolab.server.model.content.LabVariant;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Андрей on 24.06.2017.
 */
public class Lab1Variant extends LabVariant {
    /**
     * Название объекта
     */
    @Nullable
    private String name;

    /**
     * Температура наружного воздуха
     */

    private Double outsideAirTemperature;

    /**
     * Высота дымовой трубы
     */
    private Double stacksHeight;

    /**
     * Диаметр дымовой трубы
     */
    private Double stacksDiameter;

    /**
     * Время проведения измерений
     */
    private LocalDateTime time;

    /**
     * Паровая нагрузка котла
     */
    private Double steamProductionCapacity;

    /**
     * Содержание кислорода в сечении газохода, где проводились измерения
     */
    private Double oxygenConcentrationPoint;


    /**
     * Расход природного газа на котел, приведенный к нормальным условиям
     */
    private Double fuelConsumerNormalized;

    /**
     * Температура уходящих дымовых газов
     */
    private Double stackExitTemperature;

    /**
     * Концентрация оксидов азота в дымовых газах по результатам измерений
     */
    private Integer flueGasNOxConcentration;

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public Double getOutsideAirTemperature() {
        return outsideAirTemperature;
    }

    public void setOutsideAirTemperature(Double outsideAirTemperature) {
        this.outsideAirTemperature = outsideAirTemperature;
    }

    public Double getStacksHeight() {
        return stacksHeight;
    }

    public void setStacksHeight(Double stacksHeight) {
        this.stacksHeight = stacksHeight;
    }

    public Double getStacksDiameter() {
        return stacksDiameter;
    }

    public void setStacksDiameter(Double stacksDiameter) {
        this.stacksDiameter = stacksDiameter;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Double getSteamProductionCapacity() {
        return steamProductionCapacity;
    }

    public void setSteamProductionCapacity(Double steamProductionCapacity) {
        this.steamProductionCapacity = steamProductionCapacity;
    }

    public Double getOxygenConcentrationPoint() {
        return oxygenConcentrationPoint;
    }

    public void setOxygenConcentrationPoint(Double oxygenConcentrationPoint) {
        this.oxygenConcentrationPoint = oxygenConcentrationPoint;
    }

    public Double getFuelConsumerNormalized() {
        return fuelConsumerNormalized;
    }

    public void setFuelConsumerNormalized(Double fuelConsumerNormalized) {
        this.fuelConsumerNormalized = fuelConsumerNormalized;
    }

    public Double getStackExitTemperature() {
        return stackExitTemperature;
    }

    public void setStackExitTemperature(Double stackExitTemperature) {
        this.stackExitTemperature = stackExitTemperature;
    }

    public Integer getFlueGasNOxConcentration() {
        return flueGasNOxConcentration;
    }

    public void setFlueGasNOxConcentration(Integer flueGasNOxConcentration) {
        this.flueGasNOxConcentration = flueGasNOxConcentration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lab1Variant)) return false;
        Lab1Variant that = (Lab1Variant) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(outsideAirTemperature, that.outsideAirTemperature) &&
                Objects.equals(stacksHeight, that.stacksHeight) &&
                Objects.equals(stacksDiameter, that.stacksDiameter) &&
                Objects.equals(time, that.time) &&
                Objects.equals(steamProductionCapacity, that.steamProductionCapacity) &&
                Objects.equals(oxygenConcentrationPoint, that.oxygenConcentrationPoint) &&
                Objects.equals(fuelConsumerNormalized, that.fuelConsumerNormalized) &&
                Objects.equals(stackExitTemperature, that.stackExitTemperature) &&
                Objects.equals(flueGasNOxConcentration, that.flueGasNOxConcentration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, outsideAirTemperature, stacksHeight, stacksDiameter, time, steamProductionCapacity, oxygenConcentrationPoint, fuelConsumerNormalized, stackExitTemperature, flueGasNOxConcentration);
    }
}
