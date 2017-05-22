CREATE TABLE lab3data (
  /**
  *Блок системных свойств
  */
  id BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 0) PRIMARY KEY,
  user_id BIGINT NOT NULL REFERENCES users (id) ON DELETE CASCADE,
  start_date TIMESTAMP NOT NULL ,
  save_date TIMESTAMP NOT NULL ,
  version INT,
  /**
  *Блок свойств лабы
  */
  tpp_output INT,
  number_of_units INT,
  city VARCHAR(32),
  steam_production_capacity INT,
  number_of_stacks INT,
  stacks_height INT,
  stacks_diameter INT,
  wind_direction VARCHAR(32),
  wind_speed DOUBLE,
  low_heat_value DOUBLE,
  fuel_consumer DOUBLE,
  carbon_in_fly_ash DOUBLE,
  sulphur_content DOUBLE,
  ash_content DOUBLE,
  water_content DOUBLE,
  ash_recycling_factor DOUBLE,
  flue_gas_nox_concentration DOUBLE,
  stack_exit_temperature INT,
  outside_air_temperature INT,
  excess_air_ratio DOUBLE,
  combustion_product_volume DOUBLE,
  water_vapor_volume DOUBLE,
  air_volume DOUBLE,
  no2_background_concentration DOUBLE,
  no_background_concentration DOUBLE,
  so2_background_concentration DOUBLE,
  ash_background_concentration DOUBLE,
  sulphur_oxides_fraction_associated_by_fly_ash DOUBLE,
  sulphur_oxides_fraction_associated_in_wet_dust_collector DOUBLE,
  sulphur_oxides_fraction_associated_in_desulphurization_system DOUBLE,
  desulphurization_system_running_time DOUBLE,
  boiler_running_time DOUBLE,
  ash_proportion_entrained_gases DOUBLE,
  solid_particles_propotion_collected_in_ash DOUBLE,
  temperature_coefficient DOUBLE,
  terrain_coefficient DOUBLE,
  harmful_substances_deposition_coefficient DOUBLE,
  no2_mac DOUBLE,
  no_mac DOUBLE,
  so2_mac DOUBLE,
  ash_mac DOUBLE,
  breakdown_wind_speed DOUBLE,
  completed BOOLEAN NOT NULL DEFAULT FALSE,
  /**
  *Блок ключей
  */
  CONSTRAINT fk_lab3data_user FOREIGN KEY (user_id) REFERENCES users (id)
);

/*
* Создадим индексы
*/
CREATE UNIQUE INDEX ix_lab3data_id
  ON lab3data (id);
CREATE INDEX ix_lab3data_user_id
  ON lab3data (user_id);
CREATE INDEX ix_lab3data_user_id_start_date
  ON lab3data (USER_ID, START_DATE);

/*
* Добавим комментарии
*/
COMMENT ON TABLE LAB3DATA IS 'Данные лабораторной №3';
COMMENT ON COLUMN lab3data.id IS 'Уникальный идентификатор выполненного варианта';
COMMENT ON COLUMN lab3data.user_id IS 'ID пользователя, выполнившего задание';
COMMENT ON COLUMN lab3data.start_date IS 'Дата и время начала выполнения лабораторной';
COMMENT ON COLUMN lab3data.save_date IS 'Дата и время последнего сохранения результатов';
COMMENT ON COLUMN lab3data.version IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN lab3data.tpp_output IS 'Мощность ГРЭС';
COMMENT ON COLUMN lab3data.number_of_units IS 'Число блоков';
COMMENT ON COLUMN lab3data.city IS 'Район расположения ГРЭС (город)';
COMMENT ON COLUMN lab3data.steam_production_capacity IS 'Номинальная паропроизводительность одного котла';
COMMENT ON COLUMN lab3data.number_of_stacks IS 'Число дымовых труб';
COMMENT ON COLUMN lab3data.stacks_height IS 'Высота дымовой трубы';
COMMENT ON COLUMN lab3data.stacks_diameter IS 'Диаметр устья дымовой трубы';
COMMENT ON COLUMN lab3data.wind_direction IS 'Расчетное направление ветра';
COMMENT ON COLUMN lab3data.wind_speed IS 'Расчетная скорость ветра';
COMMENT ON COLUMN lab3data.low_heat_value IS 'Низшая теплота сгорания топлива';
COMMENT ON COLUMN lab3data.fuel_consumer IS 'Расход топлива на 1 блок';
COMMENT ON COLUMN lab3data.carbon_in_fly_ash IS 'Потери тепла от механической неполноты сгорания топлива';
COMMENT ON COLUMN lab3data.sulphur_content IS 'Содержание серы в топливе';
COMMENT ON COLUMN lab3data.ash_content IS 'Зольность топлива';
COMMENT ON COLUMN lab3data.water_content IS 'Влажность топлива';
COMMENT ON COLUMN lab3data.ash_recycling_factor IS 'Степень улавливания золы';
COMMENT ON COLUMN lab3data.flue_gas_nox_concentration IS 'Концентрация оксидов азота в сухих газах';
COMMENT ON COLUMN lab3data.stack_exit_temperature IS 'Температура газов на выходе из дымовой трубы';
COMMENT ON COLUMN lab3data.outside_air_temperature IS 'Температура наружного воздуха';
COMMENT ON COLUMN lab3data.excess_air_ratio IS 'Коэффициент избытка воздуха в уходящих газах';
COMMENT ON COLUMN lab3data.combustion_product_volume IS 'Теоретический объем продуктов сгорания';
COMMENT ON COLUMN lab3data.water_vapor_volume IS 'Теоретический объем паров воды';
COMMENT ON COLUMN lab3data.air_volume IS 'Теоретический объем воздуха';
COMMENT ON COLUMN lab3data.no2_background_concentration IS 'Фоновая концентрация NO2';
COMMENT ON COLUMN lab3data.no_background_concentration IS 'Фоновая концентрация NO';
COMMENT ON COLUMN lab3data.so2_background_concentration IS 'Фоновая концентрация SO2';
COMMENT ON COLUMN lab3data.ash_background_concentration IS 'Фоновая концентрация золы';
COMMENT ON COLUMN lab3data.sulphur_oxides_fraction_associated_by_fly_ash IS 'Доля оксидов серы, связываемых летучей золой в котле';
COMMENT ON COLUMN lab3data.sulphur_oxides_fraction_associated_in_wet_dust_collector IS 'Доля оксидов серы, улавливаемых в мокром золоуловителе попутно с твердыми частицами';
COMMENT ON COLUMN lab3data.sulphur_oxides_fraction_associated_in_desulphurization_system IS 'Доля оксидов серы, улавливаемых в сероулавливающей установке';
COMMENT ON COLUMN lab3data.desulphurization_system_running_time IS 'Длительность работы сероулавливающей установки';
COMMENT ON COLUMN lab3data.boiler_running_time IS 'Длительность работы котла';
COMMENT ON COLUMN lab3data.ash_proportion_entrained_gases IS 'Доля золы, уносимой газами из котла';
COMMENT ON COLUMN lab3data.solid_particles_propotion_collected_in_ash IS 'Доля твердых частиц, улавливаемых в золоуловителях';
COMMENT ON COLUMN lab3data.temperature_coefficient IS 'Коэффициент, характеризующий температурную стратификацию атмосферы';
COMMENT ON COLUMN lab3data.terrain_coefficient IS 'Коэффициент, учитывающий влияние рельефа местности';
COMMENT ON COLUMN lab3data.harmful_substances_deposition_coefficient IS 'Безразмерный коэффициент, учитывающий скорость оседания вредных веществ в атмосферном воздухе';
COMMENT ON COLUMN lab3data.no2_mac IS 'ПДК NO2';
COMMENT ON COLUMN lab3data.no_mac IS 'ПДК NO';
COMMENT ON COLUMN lab3data.so2_mac IS 'ПДК SO2';
COMMENT ON COLUMN lab3data.ash_mac IS 'ПДК золы';
COMMENT ON COLUMN lab3data.completed IS 'Признак завершенности лабораторной работы';

CREATE TABLE lab3variant (
  id BIGINT IDENTITY PRIMARY KEY REFERENCES lab3data(id) ON DELETE CASCADE,
  version INT,
  /**
  *Блок свойств лабы
  */
  tpp_output INT,
  number_of_units INT,
  fuel_type VARCHAR(32),
  city VARCHAR(32),
  steam_production_capacity INT,
  number_of_stacks INT,
  stacks_height INT,
  wind_direction VARCHAR(32),
  wind_speed DOUBLE,
  low_heat_value DOUBLE,
  fuel_consumer DOUBLE,
  carbon_in_fly_ash DOUBLE,
  sulphur_content DOUBLE,
  ash_content DOUBLE,
  water_content DOUBLE,
  ash_recycling_factor DOUBLE,
  flue_gas_nox_concentration DOUBLE,
  stack_exit_temperature INT,
  outside_air_temperature INT,
  excess_air_ratio DOUBLE,
  combustion_product_volume DOUBLE,
  water_vapor_volume DOUBLE,
  air_volume DOUBLE,
  no2_background_concentration DOUBLE,
  no_background_concentration DOUBLE,
  so2_background_concentration DOUBLE,
  ash_background_concentration DOUBLE
);

/*
* Создадим индексы
*/
CREATE UNIQUE INDEX ix_lab3variant_id
  ON lab3variant (id);

/*
* Добавим комментарии
*/
COMMENT ON TABLE LAB3VARIANT IS 'Вариант лабораторной №3';
COMMENT ON COLUMN lab3variant.id IS 'Уникальный идентификатор выполненного варианта';
COMMENT ON COLUMN lab3variant.version IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN lab3variant.tpp_output IS 'Мощность ГРЭС';
COMMENT ON COLUMN lab3variant.number_of_units IS 'Число блоков';
COMMENT ON COLUMN lab3variant.fuel_type IS 'Тип топлива';
COMMENT ON COLUMN lab3variant.city IS 'Район расположения ГРЭС (город)';
COMMENT ON COLUMN lab3variant.steam_production_capacity IS 'Номинальная паропроизводительность одного котла';
COMMENT ON COLUMN lab3variant.number_of_stacks IS 'Число дымовых труб';
COMMENT ON COLUMN lab3variant.stacks_height IS 'Высота дымовой трубы';
COMMENT ON COLUMN lab3variant.wind_direction IS 'Расчетное направление ветра';
COMMENT ON COLUMN lab3variant.wind_speed IS 'Расчетная скорость ветра';
COMMENT ON COLUMN lab3variant.low_heat_value IS 'Низшая теплота сгорания топлива';
COMMENT ON COLUMN lab3variant.fuel_consumer IS 'Расход топлива на 1 блок';
COMMENT ON COLUMN lab3variant.carbon_in_fly_ash IS 'Потери тепла от механической неполноты сгорания топлива';
COMMENT ON COLUMN lab3variant.sulphur_content IS 'Содержание серы в топливе';
COMMENT ON COLUMN lab3variant.ash_content IS 'Зольность топлива';
COMMENT ON COLUMN lab3variant.water_content IS 'Влажность топлива';
COMMENT ON COLUMN lab3variant.ash_recycling_factor IS 'Степень улавливания золы';
COMMENT ON COLUMN lab3variant.flue_gas_nox_concentration IS 'Концентрация оксидов азота в сухих газах';
COMMENT ON COLUMN lab3variant.stack_exit_temperature IS 'Температура газов на выходе из дымовой трубы';
COMMENT ON COLUMN lab3variant.outside_air_temperature IS 'Температура наружного воздуха';
COMMENT ON COLUMN lab3variant.excess_air_ratio IS 'Коэффициент избытка воздуха в уходящих газах';
COMMENT ON COLUMN lab3variant.combustion_product_volume IS 'Теоретический объем продуктов сгорания';
COMMENT ON COLUMN lab3variant.water_vapor_volume IS 'Теоретический объем паров воды';
COMMENT ON COLUMN lab3variant.air_volume IS 'Теоретический объем воздуха';
COMMENT ON COLUMN lab3variant.no2_background_concentration IS 'Фоновая концентрация NO2';
COMMENT ON COLUMN lab3variant.no_background_concentration IS 'Фоновая концентрация NO';
COMMENT ON COLUMN lab3variant.so2_background_concentration IS 'Фоновая концентрация SO2';
COMMENT ON COLUMN lab3variant.ash_background_concentration IS 'Фоновая концентрация золы';