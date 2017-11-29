package org.ekolab.server.dao.impl.content.lab2.random;

import org.ekolab.server.common.Profiles;
import org.ekolab.server.dao.api.content.lab2.random.Lab2RandomDao;
import org.ekolab.server.dao.impl.DaoUtils;
import org.ekolab.server.dao.impl.content.lab2.Lab2DaoImpl;
import org.ekolab.server.model.content.lab2.Lab2Data;
import org.ekolab.server.model.content.lab2.random.Lab2RandomVariant;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.ekolab.server.db.h2.public_.Tables.LAB1DATA;
import static org.ekolab.server.db.h2.public_.Tables.LAB1_RANDOM_VARIANT;

/**
 * Created by 777Al on 19.04.2017.
 */
@Service
@Profile({Profiles.DB.H2, Profiles.DB.POSTGRES})
public class Lab2RandomDaoImpl extends Lab2DaoImpl<Lab2RandomVariant> implements Lab2RandomDao {
    private static final Lab2DataMapper<Lab2RandomVariant> RECORD_MAPPER = new Lab2DataMapper<Lab2RandomVariant>() {

        @Override
        public Lab2Data<Lab2RandomVariant> map(Record record) {
            Lab2Data<Lab2RandomVariant> data = super.map(record);
            data.getVariant().setId(record.get(LAB1_RANDOM_VARIANT.ID));
            /*data.getVariant().setCity(record.get(LAB1_RANDOM_VARIANT.CITY) == null ? null : City.valueOf(record.get(LAB1_RANDOM_VARIANT.CITY)));
            data.getVariant().setOutsideAirTemperature(record.get(LAB1_RANDOM_VARIANT.OUTSIDE_AIR_TEMPERATURE));
            data.getVariant().setSteamProductionCapacity(record.get(LAB1_RANDOM_VARIANT.STEAM_PRODUCTION_CAPACITY));
            data.getVariant().setOxygenConcentrationPoint(record.get(LAB1_RANDOM_VARIANT.OXYGEN_CONCENTRATION_POINT));
            data.getVariant().setFuelConsumerNormalized(record.get(LAB1_RANDOM_VARIANT.FUEL_CONSUMER));
            data.getVariant().setStackExitTemperature(record.get(LAB1_RANDOM_VARIANT.STACK_EXIT_TEMPERATURE));
            data.getVariant().setFlueGasNOxConcentration(record.get(LAB1_RANDOM_VARIANT.FLUE_GAS_NOX_CONCENTRATION));*/
            return data;
        }

        @Override
        protected Lab2RandomVariant createVariant() {
            return new Lab2RandomVariant();
        }
    };

    public Lab2RandomDaoImpl(DSLContext dsl) {
        super(dsl);
    }

    @Override
    public Lab2Data<Lab2RandomVariant> getLastLabByUser(String userName, boolean completed) {
        return dsl.select().from(LAB1DATA).join(LAB1_RANDOM_VARIANT).on(LAB1_RANDOM_VARIANT.ID.eq(LAB1DATA.ID)).
                where(LAB1DATA.USER_ID.eq(DaoUtils.getFindUserIdSelect(dsl, userName))).and(LAB1DATA.COMPLETED.eq(completed)).
                orderBy(LAB1DATA.SAVE_DATE.desc()).limit(1).fetchOne(getLabMapper());
    }

    @Override
    public List<Lab2Data<Lab2RandomVariant>> getAllLabsByUser(String userName) {
        return dsl.select().from(LAB1DATA).join(LAB1_RANDOM_VARIANT).on(LAB1_RANDOM_VARIANT.ID.eq(LAB1DATA.ID))
                .where(LAB1DATA.USER_ID.eq(DaoUtils.getFindUserIdSelect(dsl, userName))).fetch(getLabMapper());
    }

    @Override
    protected Lab2DataMapper<Lab2RandomVariant> getLabMapper() {
        return RECORD_MAPPER;
    }

    @Override
    protected void saveVariant(Lab2RandomVariant variant) {
       /* dsl.insertInto(LAB1_RANDOM_VARIANT,
                LAB1_RANDOM_VARIANT.ID,
                LAB1_RANDOM_VARIANT.CITY,
                LAB1_RANDOM_VARIANT.OUTSIDE_AIR_TEMPERATURE,
                LAB1_RANDOM_VARIANT.STEAM_PRODUCTION_CAPACITY,
                LAB1_RANDOM_VARIANT.OXYGEN_CONCENTRATION_POINT,
                LAB1_RANDOM_VARIANT.FUEL_CONSUMER,
                LAB1_RANDOM_VARIANT.STACK_EXIT_TEMPERATURE,
                LAB1_RANDOM_VARIANT.FLUE_GAS_NOX_CONCENTRATION).
                values(
                        variant.getId(),
                        variant.getCity().name(),
                        variant.getOutsideAirTemperature(),
                        variant.getSteamProductionCapacity(),
                        variant.getOxygenConcentrationPoint(),
                        variant.getFuelConsumerNormalized(),
                        variant.getStackExitTemperature(),
                        variant.getFlueGasNOxConcentration()
                ).execute();*/
    }
}
