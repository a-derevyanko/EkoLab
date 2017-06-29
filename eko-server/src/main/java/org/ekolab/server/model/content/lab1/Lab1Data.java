package org.ekolab.server.model.content.lab1;

import org.ekolab.server.model.content.LabData;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Created by Андрей on 24.06.2017.
 */
public class Lab1Data extends LabData<Lab1Variant> {
    /**
     * Название объекта
     */
    @Nullable
    private String name;

    /**
     * Барометрическое давление
     */
    private Double barometricPressure;

    /**
     * Температура наружного воздуха
     */

    private Double outsideTemperature;

    /**
     * Высота дымовой трубы
     */
    private Double stacksHeight;

    /**
     * Паровая нагрузка котла
     */
    private Double steamProductionCapacity;

    /**
     * Содержание кислорода за пароперегревателем
     */
    private Double oxigenConcentration;

    /**
     * Содержание кислорода в сечении газохода, где проводились измерения
     */
    private Double oxigenConcentrationPoint;

    /**
     * Расход природного газа на паровой котел по расходомеру
     */
    private Double fuelConsumer;

    /**
     * Избыточное давление природного газа в магистрали
     */
    private Double excessPressure;

    /**
     * Температура природного газа в магистрали
     */
    private Double gasTemperature;

    /**
     * Температура уходящих дымовых газов
     */
    private Double stackExitTemperature;

    /**
     * Концентрация оксидов азота в дымовых газах по результатам измерений
     */
    private Double flueGasNOxConcentration;

    /**
     * Коэффициент избытка воздуха в точке измерения
     */
    private Double excessAirRatio;

    /**
     * Концентрация оксидов азота, приведенная к стандартному коэффициенту избытка воздуха α=1,4
     */
    private Double flueGasNOxConcentrationNC;

    /**
     * Превышение допустимых норм
     */
    private Boolean excessOfNorms;

    /**
     * Действительное барометрическое давление
     */
    private Double validBarometricPressure;

    /**
     * Действительное абсолютное давление топлива в газопроводе
     */
    private Double validAbsolutePressure;

    /**
     * Поправочный  коэффициент на давление, температуру и плотность природного газа
     */
    private Double correctionFactor;

    /**
     * Расход природного газа на котел с учетом поправок
     */
    private Double fuelConsumerCorrection;

    /**
     * Расход природного газа на котел, приведенный к нормальным условиям
     */
    private Double fuelConsumerNC;

    /**
     * Расход дымовых газов, выбрасываемых в атмосферу
     */
    private Double flueGasesRate;

    /**
     * Объемный расход сухих газов
     */
    private Double dryGasesFlowRate;

    /**
     * Массовые выбросы оксидов азота
     */
    private Double massEmissions;

    /**
     * Скорость дымовых газов на выходе из дымовой трубы
     */
    private Double flueGasesSpeed;

    /**
     * Параметр f
     */
    private Double f;

    /**
     * Коэффициент m учитывающий условия выхода газов из дымовой трубы
     */
    private Double m;

    /**
     * Параметр υ_м
     */
    private Double u;

    /**
     * Коэффициент n учитывающий условия выхода газов из дымовой трубы
     */
    private Double n;

    /**
     * Безразмерный коэффициент d
     */
    private Double d;

    /**
     * Безразмерный коэффициент, учитывающий скорость оседания вредных веществ в атмосферном воздухе
     */
    private Double harmfulSubstancesDepositionCoefficient;

    /**
     * Коэффициент, учитывающий влияние рельефа местности
     */
    private Double terrainCoefficient;

    /**
     * Коэффициент, характеризующий температурную стратификацию атмосферы
     */
    private Double temperatureCoefficient;

    /**
     * Расстояние от источника выбросов, на котором приземные концентрации загрязняющих веществ достигают максимального значения
     */
    private Double distanceFromEmissionSource;

    /**
     * Максимальная приземная концентрация оксидов азота
     */
    private Double maximumSurfaceConcentration;

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public Double getBarometricPressure() {
        return barometricPressure;
    }

    public void setBarometricPressure(Double barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    public Double getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(Double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

    public Double getStacksHeight() {
        return stacksHeight;
    }

    public void setStacksHeight(Double stacksHeight) {
        this.stacksHeight = stacksHeight;
    }

    public Double getSteamProductionCapacity() {
        return steamProductionCapacity;
    }

    public void setSteamProductionCapacity(Double steamProductionCapacity) {
        this.steamProductionCapacity = steamProductionCapacity;
    }

    public Double getOxigenConcentration() {
        return oxigenConcentration;
    }

    public void setOxigenConcentration(Double oxigenConcentration) {
        this.oxigenConcentration = oxigenConcentration;
    }

    public Double getOxigenConcentrationPoint() {
        return oxigenConcentrationPoint;
    }

    public void setOxigenConcentrationPoint(Double oxigenConcentrationPoint) {
        this.oxigenConcentrationPoint = oxigenConcentrationPoint;
    }

    public Double getFuelConsumer() {
        return fuelConsumer;
    }

    public void setFuelConsumer(Double fuelConsumer) {
        this.fuelConsumer = fuelConsumer;
    }

    public Double getExcessPressure() {
        return excessPressure;
    }

    public void setExcessPressure(Double excessPressure) {
        this.excessPressure = excessPressure;
    }

    public Double getGasTemperature() {
        return gasTemperature;
    }

    public void setGasTemperature(Double gasTemperature) {
        this.gasTemperature = gasTemperature;
    }

    public Double getStackExitTemperature() {
        return stackExitTemperature;
    }

    public void setStackExitTemperature(Double stackExitTemperature) {
        this.stackExitTemperature = stackExitTemperature;
    }

    public Double getFlueGasNOxConcentration() {
        return flueGasNOxConcentration;
    }

    public void setFlueGasNOxConcentration(Double flueGasNOxConcentration) {
        this.flueGasNOxConcentration = flueGasNOxConcentration;
    }

    public Double getExcessAirRatio() {
        return excessAirRatio;
    }

    public void setExcessAirRatio(Double excessAirRatio) {
        this.excessAirRatio = excessAirRatio;
    }

    public Double getFlueGasNOxConcentrationNC() {
        return flueGasNOxConcentrationNC;
    }

    public void setFlueGasNOxConcentrationNC(Double flueGasNOxConcentrationNC) {
        this.flueGasNOxConcentrationNC = flueGasNOxConcentrationNC;
    }

    public Boolean getExcessOfNorms() {
        return excessOfNorms;
    }

    public void setExcessOfNorms(Boolean excessOfNorms) {
        this.excessOfNorms = excessOfNorms;
    }

    public Double getValidBarometricPressure() {
        return validBarometricPressure;
    }

    public void setValidBarometricPressure(Double validBarometricPressure) {
        this.validBarometricPressure = validBarometricPressure;
    }

    public Double getValidAbsolutePressure() {
        return validAbsolutePressure;
    }

    public void setValidAbsolutePressure(Double validAbsolutePressure) {
        this.validAbsolutePressure = validAbsolutePressure;
    }

    public Double getCorrectionFactor() {
        return correctionFactor;
    }

    public void setCorrectionFactor(Double correctionFactor) {
        this.correctionFactor = correctionFactor;
    }

    public Double getFuelConsumerCorrection() {
        return fuelConsumerCorrection;
    }

    public void setFuelConsumerCorrection(Double fuelConsumerCorrection) {
        this.fuelConsumerCorrection = fuelConsumerCorrection;
    }

    public Double getFuelConsumerNC() {
        return fuelConsumerNC;
    }

    public void setFuelConsumerNC(Double fuelConsumerNC) {
        this.fuelConsumerNC = fuelConsumerNC;
    }

    public Double getFlueGasesRate() {
        return flueGasesRate;
    }

    public void setFlueGasesRate(Double flueGasesRate) {
        this.flueGasesRate = flueGasesRate;
    }

    public Double getDryGasesFlowRate() {
        return dryGasesFlowRate;
    }

    public void setDryGasesFlowRate(Double dryGasesFlowRate) {
        this.dryGasesFlowRate = dryGasesFlowRate;
    }

    public Double getMassEmissions() {
        return massEmissions;
    }

    public void setMassEmissions(Double massEmissions) {
        this.massEmissions = massEmissions;
    }

    public Double getFlueGasesSpeed() {
        return flueGasesSpeed;
    }

    public void setFlueGasesSpeed(Double flueGasesSpeed) {
        this.flueGasesSpeed = flueGasesSpeed;
    }

    public Double getF() {
        return f;
    }

    public void setF(Double f) {
        this.f = f;
    }

    public Double getM() {
        return m;
    }

    public void setM(Double m) {
        this.m = m;
    }

    public Double getU() {
        return u;
    }

    public void setU(Double u) {
        this.u = u;
    }

    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getHarmfulSubstancesDepositionCoefficient() {
        return harmfulSubstancesDepositionCoefficient;
    }

    public void setHarmfulSubstancesDepositionCoefficient(Double harmfulSubstancesDepositionCoefficient) {
        this.harmfulSubstancesDepositionCoefficient = harmfulSubstancesDepositionCoefficient;
    }

    public Double getTerrainCoefficient() {
        return terrainCoefficient;
    }

    public void setTerrainCoefficient(Double terrainCoefficient) {
        this.terrainCoefficient = terrainCoefficient;
    }

    public Double getTemperatureCoefficient() {
        return temperatureCoefficient;
    }

    public void setTemperatureCoefficient(Double temperatureCoefficient) {
        this.temperatureCoefficient = temperatureCoefficient;
    }

    public Double getDistanceFromEmissionSource() {
        return distanceFromEmissionSource;
    }

    public void setDistanceFromEmissionSource(Double distanceFromEmissionSource) {
        this.distanceFromEmissionSource = distanceFromEmissionSource;
    }

    public Double getMaximumSurfaceConcentration() {
        return maximumSurfaceConcentration;
    }

    public void setMaximumSurfaceConcentration(Double maximumSurfaceConcentration) {
        this.maximumSurfaceConcentration = maximumSurfaceConcentration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lab1Data)) return false;
        if (!super.equals(o)) return false;
        Lab1Data lab1Data = (Lab1Data) o;
        return Objects.equals(name, lab1Data.name) &&
                Objects.equals(barometricPressure, lab1Data.barometricPressure) &&
                Objects.equals(outsideTemperature, lab1Data.outsideTemperature) &&
                Objects.equals(stacksHeight, lab1Data.stacksHeight) &&
                Objects.equals(steamProductionCapacity, lab1Data.steamProductionCapacity) &&
                Objects.equals(oxigenConcentration, lab1Data.oxigenConcentration) &&
                Objects.equals(oxigenConcentrationPoint, lab1Data.oxigenConcentrationPoint) &&
                Objects.equals(fuelConsumer, lab1Data.fuelConsumer) &&
                Objects.equals(excessPressure, lab1Data.excessPressure) &&
                Objects.equals(gasTemperature, lab1Data.gasTemperature) &&
                Objects.equals(stackExitTemperature, lab1Data.stackExitTemperature) &&
                Objects.equals(flueGasNOxConcentration, lab1Data.flueGasNOxConcentration) &&
                Objects.equals(excessAirRatio, lab1Data.excessAirRatio) &&
                Objects.equals(flueGasNOxConcentrationNC, lab1Data.flueGasNOxConcentrationNC) &&
                Objects.equals(excessOfNorms, lab1Data.excessOfNorms) &&
                Objects.equals(validBarometricPressure, lab1Data.validBarometricPressure) &&
                Objects.equals(validAbsolutePressure, lab1Data.validAbsolutePressure) &&
                Objects.equals(correctionFactor, lab1Data.correctionFactor) &&
                Objects.equals(fuelConsumerCorrection, lab1Data.fuelConsumerCorrection) &&
                Objects.equals(fuelConsumerNC, lab1Data.fuelConsumerNC) &&
                Objects.equals(flueGasesRate, lab1Data.flueGasesRate) &&
                Objects.equals(dryGasesFlowRate, lab1Data.dryGasesFlowRate) &&
                Objects.equals(massEmissions, lab1Data.massEmissions) &&
                Objects.equals(flueGasesSpeed, lab1Data.flueGasesSpeed) &&
                Objects.equals(f, lab1Data.f) &&
                Objects.equals(m, lab1Data.m) &&
                Objects.equals(u, lab1Data.u) &&
                Objects.equals(n, lab1Data.n) &&
                Objects.equals(d, lab1Data.d) &&
                Objects.equals(harmfulSubstancesDepositionCoefficient, lab1Data.harmfulSubstancesDepositionCoefficient) &&
                Objects.equals(terrainCoefficient, lab1Data.terrainCoefficient) &&
                Objects.equals(temperatureCoefficient, lab1Data.temperatureCoefficient) &&
                Objects.equals(distanceFromEmissionSource, lab1Data.distanceFromEmissionSource) &&
                Objects.equals(maximumSurfaceConcentration, lab1Data.maximumSurfaceConcentration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, barometricPressure, outsideTemperature, stacksHeight, steamProductionCapacity, oxigenConcentration, oxigenConcentrationPoint, fuelConsumer, excessPressure, gasTemperature, stackExitTemperature, flueGasNOxConcentration, excessAirRatio, flueGasNOxConcentrationNC, excessOfNorms, validBarometricPressure, validAbsolutePressure, correctionFactor, fuelConsumerCorrection, fuelConsumerNC, flueGasesRate, dryGasesFlowRate, massEmissions, flueGasesSpeed, f, m, u, n, d, harmfulSubstancesDepositionCoefficient, terrainCoefficient, temperatureCoefficient, distanceFromEmissionSource, maximumSurfaceConcentration);
    }
}
