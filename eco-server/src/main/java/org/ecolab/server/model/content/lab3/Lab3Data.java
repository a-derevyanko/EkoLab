package org.ecolab.server.model.content.lab3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ecolab.server.model.content.Calculated;
import org.ecolab.server.model.content.LabData;
import org.ecolab.server.model.content.ValidatedBy;
import org.ecolab.server.model.content.lab3.validators.StacksDiameterValidator;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by 777Al on 06.04.2017.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Lab3Data extends LabData<Lab3Variant> {
    /**
     * Мощность ГРЭС
     */
    @Max(3200L)
    @Min(1200L)
    private Integer tppOutput;

    /**
     * Число блоков
     */
    private NumberOfUnits numberOfUnits;

    /**
     * Район расположения ГРЭС (город)
     */
    @Valid
    private City city;

    /**
     * Номинальная паропроизводительность одного котла
     */
    @Max(2450L)
    @Min(580L)
    private Integer steamProductionCapacity;

    /**
     * Число дымовых труб
     */
    private NumberOfStacks numberOfStacks;

    /**
     * Высота дымовой трубы
     */
    @Max(240L)
    @Min(120L)
    private Integer stacksHeight;

    /**
     * Диаметр устья дымовой трубы
     */
    @ValidatedBy(StacksDiameterValidator.class)
    private Double stacksDiameter;

    /**
     * Господствующее направление ветра
     */
    private WindDirection windDirection;

    /**
     * Расчетная скорость ветра
     */
    private Double windSpeed;

    /**
     * Низшая теплота сгорания топлива
     */
    /*@Max(40)
    @Min(28)*/
    @Digits(integer = 2, fraction = 2)
    private Double lowHeatValue;

    /**
     * Расход топлива на 1 блок
     */
    private Double fuelConsumer;

    /**
     * Потери тепла от механической неполноты сгорания топлива
     */
    /*@Max(1.5)
    @Min(0)*/
    @Digits(integer = 1, fraction = 1)
    private Double carbonInFlyAsh;

    /**
     * Содержание серы в топливе
     */
    private Double sulphurContent;

    /**
     * Зольность топлива
     */
    /*@Max(99)
    @Min(0)*/
    @Digits(integer = 2, fraction = 1)
    private Double ashContent;

    /**
     * Влажность топлива
     */
    private Double waterContent;

    /**
     * Степень улавливания золы
     */
    private Double ashRecyclingFactor;

    /**
     * Концентрация оксидов азота в сухих газах
     */
    @Max(400L)
    @Min(200L)
    private Integer flueGasNOxConcentration;

    /**
     * Температура газов на выходе из дымовой трубы
     */
    @Max(200L)
    @Min(100L)
    private Integer stackExitTemperature;

    /**
     * Температура наружного воздуха
     */
    @Max(100L)
    @Min(-100L)
    private Integer outsideAirTemperature;

    /**
     * Коэффициент избытка воздуха в уходящих газах
     */
    // Всегда == 1,4
    private Double excessAirRatio;

    /**
     * Теоретический объем продуктов сгорания
     */
    private Double combustionProductsVolume;

    /**
     * Теоретический объем паров воды
     */
    private Double waterVaporVolume;

    /**
     * Теоретический объем воздуха
     */
    private Double airVolume;

    /**
     * Фоновая концентрация NO2
     */
    private Double no2BackgroundConcentration;

    /**
     * Фоновая концентрация NO
     */
    private Double noBackgroundConcentration;

    /**
     * Фоновая концентрация SO2
     */
    private Double so2BackgroundConcentration;

    /**
     * Фоновая концентрация золы
     */
    private Double ashBackgroundConcentration;

    /**
     *  Доля оксидов серы, связываемых летучей золой в котле
     */
    private Double sulphurOxidesFractionAssociatedByFlyAsh;

    /**
     * Доля оксидов серы, улавливаемых в мокром золоуловителе попутно с твердыми частицами
     */
    private Double sulphurOxidesFractionAssociatedInWetDustCollector;

    /**
     * Доля оксидов серы, улавливаемых в сероулавливающей установке
     */
    private Double sulphurOxidesFractionAssociatedInDesulphurizationSystem;

    /**
     * Длительность работы сероулавливающей установки
     */
    private Double desulphurizationSystemRunningTime;

    /**
     * Длительность работы котла
     */
    private Double boilerRunningTime;

    /**
     * Доля золы, уносимой газами из котла
     */
    private Double ashProportionEntrainedGases;

    /**
     * Средняя скорость газов на выходе из дымовой трубы
     */
    @Min(10)
    @Max(25)
    @Calculated
    private Double stackAverageGasesSpeed;

    /**
     * Суммарное количество NOx поступающего в атмосферу с дымовыми газами
     */
    @Calculated
    private Double noxMassiveInjection;

    /**
     * Суммарное количество NO2, поступающего в атмосферу с дымовыми газами
     */
    @Calculated
    private Double no2MassiveInjection;

    /**
     * Суммарное количество NO, поступающего в атмосферу с дымовыми газами
     */
    @Calculated
    private Double noMassiveInjection;

    /**
     * Суммарное количество SO2, поступающего в атмосферу с дымовыми газами
     */
    @Calculated
    private Double so2MassiveInjection;

    /**
     * Суммарное количество золы, поступающей в атмосферу с дымовыми газами
     */
    @Calculated
    private Double ashMassiveInjection;

    /**
     * Коэффициент, характеризующий температурную стратификацию атмосферы
     */
    //todo ставить ограничение относительно города
    @Max(250L)
    @Min(140L)
    private Double temperatureCoefficient;

    /**
     * Коэффициент, учитывающий влияние рельефа местности
     */
    private Double terrainCoefficient;

    /**
     * Безразмерный коэффициент, учитывающий скорость оседания вредных веществ в атмосферном воздухе
     */
    private Double harmfulSubstancesDepositionCoefficient;

    /**
     * ПДК NO2
     */
    /*@DecimalMax("0.085")
    @DecimalMin("0.085")*/
    @Min(0L)
    @Max(1L)
    private Double no2MAC;

    /**
     * ПДК NO
     */
    /*@DecimalMax("0.4")
    @DecimalMin("0.4")*/
    @Min(0L)
    @Max(1L)
    private Double noMAC;

    /**
     * ПДК SO2
     */
    /*@DecimalMax("0.5")
    @DecimalMin("0.5")*/
    @Min(0L)
    @Max(1L)
    private Double so2MAC;

    /**
     * ПДК золы
     */
    /*@DecimalMax("0.05")
    @DecimalMin("0.05")*/
    @Min(0L)
    @Max(1L)
    private Double ashMAC;

    /**
     * Опасная скорость ветра
     */
    @Calculated
    private Double breakdownWindSpeed;

    /**
     * Максимальное значение приземной концентрации NO2 при опасной скорости ветра
     */
    @Calculated
    private Double bwdNo2GroundLevelConcentration;

    /**
     * Максимальное значение приземной концентрации NOx при опасной скорости ветра
     */
    @Calculated
    private Double bwdNoxGroundLevelConcentration;

    /**
     * Максимальное значение приземной концентрации NO при опасной скорости ветра
     */
    @Calculated
    private Double bwdNoGroundLevelConcentration;

    /**
     * Максимальное значение приземной концентрации SO2 при опасной скорости ветра
     */
    @Calculated
    private Double bwdSo2GroundLevelConcentration;

    /**
     * Максимальное значение приземной концентрации золы при опасной скорости ветра
     */
    @Calculated
    private Double bwdAshGroundLevelConcentration;

    /**
     * Безразмерная концентрация веществ, обладающих суммацией вредного действия (NO2 и SO2)
     */
    @Calculated
    private Double no2AndSo2SummationGroup;

    /**
     * Безразмерная концентрация веществ, обладающих суммацией вредного действия (NO и SO2)
     */
    @Calculated
    private Double noAndSo2SummationGroup;

    /**
     * Расстояние от источника выбросов, на котором приземные концентрации загрязняющих веществ достигают максимального значения при опасной скорости ветра
     */
    @Calculated
    private Double bwdMaxGroundLevelConcentrationDistance;

    /**
     * Максимальное значение приземной концентрации NO2 при расчетной скорости ветра
     */
    @Calculated
    private Double windSpeedMaxNo2GroundLevelConcentration;

    /**
     * Максимальное значение приземной концентрации NO при расчетной скорости ветра
     */
    @Calculated
    private Double windSpeedMaxNoGroundLevelConcentration;

    /**
     * Максимальное значение приземной концентрации SO2 при расчетной скорости ветра
     */
    @Calculated
    private Double windSpeedMaxSo2GroundLevelConcentration;

    /**
     * Максимальное значение приземной концентрации золы при расчетной скорости ветра
     */
    @Calculated
    private Double windSpeedMaxAshGroundLevelConcentration;

    /**
     * Расстояние от источника выброса, на котором при скорости ветра u приземная концентрация вредных веществ достигает максимального значения
     */
    @Calculated
    private Double windSpeedMaxGroundLevelConcentrationDistance;

    /**
     * Параметр f
     */
    @Calculated
    private Double f;

    /**
     * Коэффициент m, учитывающий условия выхода газов из дымовой трубы
     */
    @Calculated
    private Double m;

    /**
     * Безразмерный коэффициент d
     */
    @Calculated
    private Double d;

    /**
     * Параметр υ_м
     */
    @Calculated
    private Double VM;

    /**
     * Коэффициент n,учитывающий условия выхода газов из дымовой трубы
     */
    @Calculated
    private Double n;

    /**
     * Расход дымовых газов от одного котла
     */
    @Calculated
    private Double oneBoilerFuelConsumption;

    public Integer getTppOutput() {
        return tppOutput;
    }

    public void setTppOutput(Integer tppOutput) {
        this.tppOutput = tppOutput;
    }

    public NumberOfUnits getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(NumberOfUnits numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getSteamProductionCapacity() {
        return steamProductionCapacity;
    }

    public void setSteamProductionCapacity(Integer steamProductionCapacity) {
        this.steamProductionCapacity = steamProductionCapacity;
    }

    public NumberOfStacks getNumberOfStacks() {
        return numberOfStacks;
    }

    public void setNumberOfStacks(NumberOfStacks numberOfStacks) {
        this.numberOfStacks = numberOfStacks;
    }

    public Integer getStacksHeight() {
        return stacksHeight;
    }

    public void setStacksHeight(Integer stacksHeight) {
        this.stacksHeight = stacksHeight;
    }

    public Double getStacksDiameter() {
        return stacksDiameter;
    }

    public void setStacksDiameter(Double stacksDiameter) {
        this.stacksDiameter = stacksDiameter;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getLowHeatValue() {
        return lowHeatValue;
    }

    public void setLowHeatValue(Double lowHeatValue) {
        this.lowHeatValue = lowHeatValue;
    }

    public Double getFuelConsumer() {
        return fuelConsumer;
    }

    public void setFuelConsumer(Double fuelConsumer) {
        this.fuelConsumer = fuelConsumer;
    }

    public Double getCarbonInFlyAsh() {
        return carbonInFlyAsh;
    }

    public void setCarbonInFlyAsh(Double carbonInFlyAsh) {
        this.carbonInFlyAsh = carbonInFlyAsh;
    }

    public Double getSulphurContent() {
        return sulphurContent;
    }

    public void setSulphurContent(Double sulphurContent) {
        this.sulphurContent = sulphurContent;
    }

    public Double getAshContent() {
        return ashContent;
    }

    public void setAshContent(Double ashContent) {
        this.ashContent = ashContent;
    }

    public Double getWaterContent() {
        return waterContent;
    }

    public void setWaterContent(Double waterContent) {
        this.waterContent = waterContent;
    }

    public Double getAshRecyclingFactor() {
        return ashRecyclingFactor;
    }

    public void setAshRecyclingFactor(Double ashRecyclingFactor) {
        this.ashRecyclingFactor = ashRecyclingFactor;
    }

    public Integer getFlueGasNOxConcentration() {
        return flueGasNOxConcentration;
    }

    public void setFlueGasNOxConcentration(Integer flueGasNOxConcentration) {
        this.flueGasNOxConcentration = flueGasNOxConcentration;
    }

    public Integer getStackExitTemperature() {
        return stackExitTemperature;
    }

    public void setStackExitTemperature(Integer stackExitTemperature) {
        this.stackExitTemperature = stackExitTemperature;
    }

    public Integer getOutsideAirTemperature() {
        return outsideAirTemperature;
    }

    public void setOutsideAirTemperature(Integer outsideAirTemperature) {
        this.outsideAirTemperature = outsideAirTemperature;
    }

    public Double getExcessAirRatio() {
        return excessAirRatio;
    }

    public void setExcessAirRatio(Double excessAirRatio) {
        this.excessAirRatio = excessAirRatio;
    }

    public Double getCombustionProductsVolume() {
        return combustionProductsVolume;
    }

    public void setCombustionProductsVolume(Double combustionProductsVolume) {
        this.combustionProductsVolume = combustionProductsVolume;
    }

    public Double getWaterVaporVolume() {
        return waterVaporVolume;
    }

    public void setWaterVaporVolume(Double waterVaporVolume) {
        this.waterVaporVolume = waterVaporVolume;
    }

    public Double getAirVolume() {
        return airVolume;
    }

    public void setAirVolume(Double airVolume) {
        this.airVolume = airVolume;
    }

    public Double getNo2BackgroundConcentration() {
        return no2BackgroundConcentration;
    }

    public void setNo2BackgroundConcentration(Double no2BackgroundConcentration) {
        this.no2BackgroundConcentration = no2BackgroundConcentration;
    }

    public Double getNoBackgroundConcentration() {
        return noBackgroundConcentration;
    }

    public void setNoBackgroundConcentration(Double noBackgroundConcentration) {
        this.noBackgroundConcentration = noBackgroundConcentration;
    }

    public Double getSo2BackgroundConcentration() {
        return so2BackgroundConcentration;
    }

    public void setSo2BackgroundConcentration(Double so2BackgroundConcentration) {
        this.so2BackgroundConcentration = so2BackgroundConcentration;
    }

    public Double getAshBackgroundConcentration() {
        return ashBackgroundConcentration;
    }

    public void setAshBackgroundConcentration(Double ashBackgroundConcentration) {
        this.ashBackgroundConcentration = ashBackgroundConcentration;
    }

    public Double getSulphurOxidesFractionAssociatedByFlyAsh() {
        return sulphurOxidesFractionAssociatedByFlyAsh;
    }

    public void setSulphurOxidesFractionAssociatedByFlyAsh(Double sulphurOxidesFractionAssociatedByFlyAsh) {
        this.sulphurOxidesFractionAssociatedByFlyAsh = sulphurOxidesFractionAssociatedByFlyAsh;
    }

    public Double getSulphurOxidesFractionAssociatedInWetDustCollector() {
        return sulphurOxidesFractionAssociatedInWetDustCollector;
    }

    public void setSulphurOxidesFractionAssociatedInWetDustCollector(Double sulphurOxidesFractionAssociatedInWetDustCollector) {
        this.sulphurOxidesFractionAssociatedInWetDustCollector = sulphurOxidesFractionAssociatedInWetDustCollector;
    }

    public Double getSulphurOxidesFractionAssociatedInDesulphurizationSystem() {
        return sulphurOxidesFractionAssociatedInDesulphurizationSystem;
    }

    public void setSulphurOxidesFractionAssociatedInDesulphurizationSystem(Double sulphurOxidesFractionAssociatedInDesulphurizationSystem) {
        this.sulphurOxidesFractionAssociatedInDesulphurizationSystem = sulphurOxidesFractionAssociatedInDesulphurizationSystem;
    }

    public Double getDesulphurizationSystemRunningTime() {
        return desulphurizationSystemRunningTime;
    }

    public void setDesulphurizationSystemRunningTime(Double desulphurizationSystemRunningTime) {
        this.desulphurizationSystemRunningTime = desulphurizationSystemRunningTime;
    }

    public Double getBoilerRunningTime() {
        return boilerRunningTime;
    }

    public void setBoilerRunningTime(Double boilerRunningTime) {
        this.boilerRunningTime = boilerRunningTime;
    }

    public Double getAshProportionEntrainedGases() {
        return ashProportionEntrainedGases;
    }

    public void setAshProportionEntrainedGases(Double ashProportionEntrainedGases) {
        this.ashProportionEntrainedGases = ashProportionEntrainedGases;
    }

    public Double getStackAverageGasesSpeed() {
        return stackAverageGasesSpeed;
    }

    public void setStackAverageGasesSpeed(Double stackAverageGasesSpeed) {
        this.stackAverageGasesSpeed = stackAverageGasesSpeed;
    }

    public Double getNoxMassiveInjection() {
        return noxMassiveInjection;
    }

    public void setNoxMassiveInjection(Double noxMassiveInjection) {
        this.noxMassiveInjection = noxMassiveInjection;
    }

    public Double getNo2MassiveInjection() {
        return no2MassiveInjection;
    }

    public void setNo2MassiveInjection(Double no2MassiveInjection) {
        this.no2MassiveInjection = no2MassiveInjection;
    }

    public Double getNoMassiveInjection() {
        return noMassiveInjection;
    }

    public void setNoMassiveInjection(Double noMassiveInjection) {
        this.noMassiveInjection = noMassiveInjection;
    }

    public Double getSo2MassiveInjection() {
        return so2MassiveInjection;
    }

    public void setSo2MassiveInjection(Double so2MassiveInjection) {
        this.so2MassiveInjection = so2MassiveInjection;
    }

    public Double getAshMassiveInjection() {
        return ashMassiveInjection;
    }

    public void setAshMassiveInjection(Double ashMassiveInjection) {
        this.ashMassiveInjection = ashMassiveInjection;
    }

    public Double getTemperatureCoefficient() {
        return temperatureCoefficient;
    }

    public void setTemperatureCoefficient(Double temperatureCoefficient) {
        this.temperatureCoefficient = temperatureCoefficient;
    }

    public Double getTerrainCoefficient() {
        return terrainCoefficient;
    }

    public void setTerrainCoefficient(Double terrainCoefficient) {
        this.terrainCoefficient = terrainCoefficient;
    }

    public Double getHarmfulSubstancesDepositionCoefficient() {
        return harmfulSubstancesDepositionCoefficient;
    }

    public void setHarmfulSubstancesDepositionCoefficient(Double harmfulSubstancesDepositionCoefficient) {
        this.harmfulSubstancesDepositionCoefficient = harmfulSubstancesDepositionCoefficient;
    }

    public Double getNo2MAC() {
        return no2MAC;
    }

    public void setNo2MAC(Double no2MAC) {
        this.no2MAC = no2MAC;
    }

    public Double getNoMAC() {
        return noMAC;
    }

    public void setNoMAC(Double noMAC) {
        this.noMAC = noMAC;
    }

    public Double getSo2MAC() {
        return so2MAC;
    }

    public void setSo2MAC(Double so2MAC) {
        this.so2MAC = so2MAC;
    }

    public Double getAshMAC() {
        return ashMAC;
    }

    public void setAshMAC(Double ashMAC) {
        this.ashMAC = ashMAC;
    }

    public Double getBreakdownWindSpeed() {
        return breakdownWindSpeed;
    }

    public void setBreakdownWindSpeed(Double breakdownWindSpeed) {
        this.breakdownWindSpeed = breakdownWindSpeed;
    }

    public Double getBwdNo2GroundLevelConcentration() {
        return bwdNo2GroundLevelConcentration;
    }

    public void setBwdNo2GroundLevelConcentration(Double bwdNo2GroundLevelConcentration) {
        this.bwdNo2GroundLevelConcentration = bwdNo2GroundLevelConcentration;
    }

    public Double getBwdNoxGroundLevelConcentration() {
        return bwdNoxGroundLevelConcentration;
    }

    public void setBwdNoxGroundLevelConcentration(Double bwdNoxGroundLevelConcentration) {
        this.bwdNoxGroundLevelConcentration = bwdNoxGroundLevelConcentration;
    }

    public Double getBwdNoGroundLevelConcentration() {
        return bwdNoGroundLevelConcentration;
    }

    public void setBwdNoGroundLevelConcentration(Double bwdNoGroundLevelConcentration) {
        this.bwdNoGroundLevelConcentration = bwdNoGroundLevelConcentration;
    }

    public Double getBwdSo2GroundLevelConcentration() {
        return bwdSo2GroundLevelConcentration;
    }

    public void setBwdSo2GroundLevelConcentration(Double bwdSo2GroundLevelConcentration) {
        this.bwdSo2GroundLevelConcentration = bwdSo2GroundLevelConcentration;
    }

    public Double getBwdAshGroundLevelConcentration() {
        return bwdAshGroundLevelConcentration;
    }

    public void setBwdAshGroundLevelConcentration(Double bwdAshGroundLevelConcentration) {
        this.bwdAshGroundLevelConcentration = bwdAshGroundLevelConcentration;
    }

    public Double getNo2AndSo2SummationGroup() {
        return no2AndSo2SummationGroup;
    }

    public void setNo2AndSo2SummationGroup(Double no2AndSo2SummationGroup) {
        this.no2AndSo2SummationGroup = no2AndSo2SummationGroup;
    }

    public Double getNoAndSo2SummationGroup() {
        return noAndSo2SummationGroup;
    }

    public void setNoAndSo2SummationGroup(Double noAndSo2SummationGroup) {
        this.noAndSo2SummationGroup = noAndSo2SummationGroup;
    }

    public Double getBwdMaxGroundLevelConcentrationDistance() {
        return bwdMaxGroundLevelConcentrationDistance;
    }

    public void setBwdMaxGroundLevelConcentrationDistance(Double bwdMaxGroundLevelConcentrationDistance) {
        this.bwdMaxGroundLevelConcentrationDistance = bwdMaxGroundLevelConcentrationDistance;
    }

    public Double getWindSpeedMaxNo2GroundLevelConcentration() {
        return windSpeedMaxNo2GroundLevelConcentration;
    }

    public void setWindSpeedMaxNo2GroundLevelConcentration(Double windSpeedMaxNo2GroundLevelConcentration) {
        this.windSpeedMaxNo2GroundLevelConcentration = windSpeedMaxNo2GroundLevelConcentration;
    }

    public Double getWindSpeedMaxNoGroundLevelConcentration() {
        return windSpeedMaxNoGroundLevelConcentration;
    }

    public void setWindSpeedMaxNoGroundLevelConcentration(Double windSpeedMaxNoGroundLevelConcentration) {
        this.windSpeedMaxNoGroundLevelConcentration = windSpeedMaxNoGroundLevelConcentration;
    }

    public Double getWindSpeedMaxSo2GroundLevelConcentration() {
        return windSpeedMaxSo2GroundLevelConcentration;
    }

    public void setWindSpeedMaxSo2GroundLevelConcentration(Double windSpeedMaxSo2GroundLevelConcentration) {
        this.windSpeedMaxSo2GroundLevelConcentration = windSpeedMaxSo2GroundLevelConcentration;
    }

    public Double getWindSpeedMaxAshGroundLevelConcentration() {
        return windSpeedMaxAshGroundLevelConcentration;
    }

    public void setWindSpeedMaxAshGroundLevelConcentration(Double windSpeedMaxAshGroundLevelConcentration) {
        this.windSpeedMaxAshGroundLevelConcentration = windSpeedMaxAshGroundLevelConcentration;
    }

    public Double getWindSpeedMaxGroundLevelConcentrationDistance() {
        return windSpeedMaxGroundLevelConcentrationDistance;
    }

    public void setWindSpeedMaxGroundLevelConcentrationDistance(Double windSpeedMaxGroundLevelConcentrationDistance) {
        this.windSpeedMaxGroundLevelConcentrationDistance = windSpeedMaxGroundLevelConcentrationDistance;
    }

    public Double getM() {
        return m;
    }

    public void setM(Double m) {
        this.m = m;
    }

    public Double getF() {
        return f;
    }

    public void setF(Double f) {
        this.f = f;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getVM() {
        return VM;
    }

    public void setVM(Double VM) {
        this.VM = VM;
    }

    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }

    public Double getOneBoilerFuelConsumption() {
        return oneBoilerFuelConsumption;
    }

    public void setOneBoilerFuelConsumption(Double oneBoilerFuelConsumption) {
        this.oneBoilerFuelConsumption = oneBoilerFuelConsumption;
    }
}
