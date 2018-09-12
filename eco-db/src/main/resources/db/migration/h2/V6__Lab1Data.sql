CREATE TABLE lab1data (
  /**
  *Блок системных свойств
  */
  id                                        BIGINT             GENERATED BY DEFAULT AS IDENTITY ( START WITH 0) PRIMARY KEY,
  start_date                                TIMESTAMP NOT NULL,
  save_date                                 TIMESTAMP NOT NULL,
  version                                   INT,
  completed                                 BOOLEAN   NOT NULL DEFAULT FALSE,

  /**
  *Блок свойств лабы
  */
  stacks_Height                             DOUBLE,
  stacks_Diameter                           DOUBLE,
  outside_Air_Temperature                   INT,
  steam_Production_Capacity                 INT,
  oxygen_Concentration_Point                DOUBLE,
  fuel_Consumer_Normalized                  INT,
  stack_Exit_Temperature                    INT,
  flue_Gas_NOx_Concentration                INT,
  excess_Air_Ratio                          DOUBLE,
  flue_Gas_NOx_Concentration_NC             DOUBLE,
  excess_Of_Norms                           BOOLEAN,
  flue_Gases_Rate                           DOUBLE,
  dry_Gases_Flow_Rate                       DOUBLE,
  mass_Emissions                            DOUBLE,
  flue_Gases_Speed                          DOUBLE,
  f                                         DOUBLE,
  m                                         DOUBLE,
  u                                         DOUBLE,
  n                                         DOUBLE,
  d                                         DOUBLE,
  harmful_Substances_Deposition_Coefficient DOUBLE,
  terrain_Coefficient                       DOUBLE,
  temperature_Coefficient                   DOUBLE,
  distance_From_Emission_Source             DOUBLE,
  maximum_Surface_Concentration             DOUBLE
);

/*
* Создадим индексы
*/
CREATE UNIQUE INDEX ix_lab1data_id
  ON lab1data (id);
CREATE INDEX ix_LAB1DATA_start_date
  ON lab1data (id, START_DATE);
/*
* Добавим комментарии
*/
COMMENT ON TABLE LAB1DATA IS 'Данные лабораторной №1';
COMMENT ON COLUMN LAB1DATA.id IS 'Уникальный идентификатор выполненного варианта';
COMMENT ON COLUMN LAB1DATA.start_date IS 'Дата и время начала выполнения лабораторной';
COMMENT ON COLUMN LAB1DATA.save_date IS 'Дата и время последнего сохранения результатов';
COMMENT ON COLUMN LAB1DATA.version IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN LAB1DATA.completed IS 'Признак завершенности лабораторной работы';

COMMENT ON COLUMN LAB1DATA.excess_air_ratio IS 'Коэффициент избытка воздуха в уходящих газах';
COMMENT ON COLUMN LAB1DATA.temperature_coefficient IS 'Коэффициент, характеризующий температурную стратификацию атмосферы';
COMMENT ON COLUMN LAB1DATA.terrain_coefficient IS 'Коэффициент, учитывающий влияние рельефа местности';
COMMENT ON COLUMN LAB1DATA.harmful_substances_deposition_coefficient IS 'Безразмерный коэффициент, учитывающий скорость оседания вредных веществ в атмосферном воздухе';
COMMENT ON COLUMN LAB1DATA.stacks_height IS 'Высота дымовой трубы';
COMMENT ON COLUMN LAB1DATA.stacks_diameter IS 'Диаметр устья дымовой трубы';
COMMENT ON COLUMN LAB1DATA.flue_gas_nox_concentration IS 'Концентрация оксидов азота в сухих газах';
COMMENT ON COLUMN LAB1DATA.stack_exit_temperature IS 'Температура газов на выходе из дымовой трубы';
COMMENT ON COLUMN LAB1DATA.outside_air_temperature IS 'Температура наружного воздуха';
COMMENT ON COLUMN LAB1DATA.steam_Production_Capacity IS 'Паровая нагрузка котла';
COMMENT ON COLUMN LAB1DATA.oxygen_Concentration_Point IS 'Содержание кислорода в сечении газохода, где проводились измерения';
COMMENT ON COLUMN LAB1DATA.fuel_Consumer_Normalized IS 'Расход природного газа на котел, приведенный к нормальным условиям';
COMMENT ON COLUMN LAB1DATA.flue_Gas_NOx_Concentration_NC IS 'Концентрация оксидов азота, приведенная к стандартному коэффициенту избытка воздуха α=1,4';
COMMENT ON COLUMN LAB1DATA.excess_Of_Norms IS 'Превышение допустимых норм';
COMMENT ON COLUMN LAB1DATA.flue_Gases_Rate IS 'Расход дымовых газов, выбрасываемых в атмосферу';
COMMENT ON COLUMN LAB1DATA.dry_Gases_Flow_Rate IS 'Объемный расход сухих газов';
COMMENT ON COLUMN LAB1DATA.mass_Emissions IS 'Массовые выбросы оксидов азота';
COMMENT ON COLUMN LAB1DATA.flue_Gases_Speed IS 'Скорость дымовых газов на выходе из дымовой трубы';
COMMENT ON COLUMN LAB1DATA.f IS 'Параметр f';
COMMENT ON COLUMN LAB1DATA.m IS 'Коэффициент m учитывающий условия выхода газов из дымовой трубы';
COMMENT ON COLUMN LAB1DATA.u IS 'Параметр υ_м';
COMMENT ON COLUMN LAB1DATA.n IS 'Коэффициент n учитывающий условия выхода газов из дымовой трубы';
COMMENT ON COLUMN LAB1DATA.d IS 'Безразмерный коэффициент d';
COMMENT ON COLUMN LAB1DATA.distance_From_Emission_Source IS 'Расстояние от источника выбросов, на котором приземные концентрации загрязняющих веществ достигают максимального значения';
COMMENT ON COLUMN LAB1DATA.maximum_Surface_Concentration IS 'Максимальная приземная концентрация оксидов азота';

CREATE TABLE LAB1_RANDOM_VARIANT (
  id                           BIGINT IDENTITY PRIMARY KEY REFERENCES LAB1DATA (id) ON DELETE CASCADE,
  version                      INT,
  /**
  *Блок свойств лабы
  */
  CITY                                      VARCHAR(256),
  outside_Air_Temperature                   INT,
  steam_Production_Capacity                 INT,
  oxygen_Concentration_Point                DOUBLE,
  fuel_Consumer                             INT,
  stack_Exit_Temperature                    INT,
  flue_Gas_NOx_Concentration                INT,
);

/*
* Создадим индексы
*/
CREATE UNIQUE INDEX ix_LAB1_RANDOM_VARIANT_id
  ON LAB1_RANDOM_VARIANT (id);

/*
* Добавим комментарии
*/
COMMENT ON TABLE LAB1_RANDOM_VARIANT IS 'Вариант лабораторной №1';
COMMENT ON COLUMN LAB1_RANDOM_VARIANT.flue_gas_nox_concentration IS 'Концентрация оксидов азота в сухих газах';
COMMENT ON COLUMN LAB1_RANDOM_VARIANT.stack_exit_temperature IS 'Температура газов на выходе из дымовой трубы';
COMMENT ON COLUMN LAB1_RANDOM_VARIANT.outside_air_temperature IS 'Температура наружного воздуха';
COMMENT ON COLUMN LAB1_RANDOM_VARIANT.steam_Production_Capacity IS 'Паровая нагрузка котла';
COMMENT ON COLUMN LAB1_RANDOM_VARIANT.oxygen_Concentration_Point IS 'Содержание кислорода в сечении газохода, где проводились измерения';
COMMENT ON COLUMN LAB1_RANDOM_VARIANT.fuel_Consumer IS 'Расход природного газа на котел';
COMMENT ON COLUMN LAB1_RANDOM_VARIANT.city IS 'Город';

CREATE TABLE lab1_experiment_log (
  id                           BIGINT IDENTITY PRIMARY KEY REFERENCES LAB1DATA (id) ON DELETE CASCADE,
  version                      INT,
  /**
  *Блок свойств лабы
  */
  name                                      VARCHAR(256),
  outside_Air_Temperature                   INT,
  stacks_Height                             DOUBLE,
  stacks_Diameter                           DOUBLE,
  time                                      TIMESTAMP,
  steam_Production_Capacity                 INT,
  oxygen_Concentration_Point                DOUBLE,
  fuel_Consumer                             INT,
  stack_Exit_Temperature                    INT,
  flue_Gas_NOx_Concentration                INT,
);

/*
* Создадим индексы
*/
CREATE UNIQUE INDEX ix_lab1_experiment_log_id
  ON lab1_experiment_log (id);

/*
* Добавим комментарии
*/
COMMENT ON TABLE lab1_experiment_log IS 'Вариант лабораторной №1';
COMMENT ON COLUMN lab1_experiment_log.stacks_height IS 'Высота дымовой трубы';
COMMENT ON COLUMN lab1_experiment_log.stacks_diameter IS 'Диаметр устья дымовой трубы';
COMMENT ON COLUMN lab1_experiment_log.flue_gas_nox_concentration IS 'Концентрация оксидов азота в сухих газах';
COMMENT ON COLUMN lab1_experiment_log.stack_exit_temperature IS 'Температура газов на выходе из дымовой трубы';
COMMENT ON COLUMN lab1_experiment_log.outside_air_temperature IS 'Температура наружного воздуха';
COMMENT ON COLUMN lab1_experiment_log.name IS 'Название объекта';
COMMENT ON COLUMN lab1_experiment_log.steam_Production_Capacity IS 'Паровая нагрузка котла';
COMMENT ON COLUMN lab1_experiment_log.oxygen_Concentration_Point IS 'Содержание кислорода в сечении газохода, где проводились измерения';

create table lab1team (
  id        BIGINT       NOT NULL REFERENCES lab1data (id) ON DELETE CASCADE,
  version      INT,
  user_id   BIGINT      NOT NULL REFERENCES users (id) ON DELETE CASCADE,
);

CREATE INDEX ix_lab1team
  ON lab1team (user_id);

alter table lab1team add constraint uk_lab1team unique (id, user_id);


COMMENT ON TABLE lab1team IS 'Бригада, выполняющая лабораторную работу №1';
COMMENT ON COLUMN lab1team.id IS 'Идентификатор лабораторной';
COMMENT ON COLUMN lab1team.VERSION IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN lab1team.user_id IS 'Пользователь';