package org.ekolab.server.model.content.lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 777Al on 11.04.2017.
 */
public enum City {
    MOSCOW{
        public List<FuelType> getFuelTypesForTheCity() {
            return Arrays.asList(FuelType.DONETSK_COAL, FuelType.SULFUR_OIL);
        }
    },
    SAINT_PETERSBURG{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.SULFUR_OIL);
            FuelTypesForTheCity.add(FuelType.LENINGRAD_SHALE);
            FuelTypesForTheCity.add(FuelType.ESTONIAN_SHALE);
            return FuelTypesForTheCity;
        }
    },
    NOVOSIBIRSK{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.EKIBASTUZ_COAL);
            FuelTypesForTheCity.add(FuelType.BEREZOVSKY_COAL_TSU);
            FuelTypesForTheCity.add(FuelType.BEREZOVSKY_COAL_ZHSHU);
            FuelTypesForTheCity.add(FuelType.KUZNETSK_COAL);
            return FuelTypesForTheCity;
        }
    },
    EKATERINBURG{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.EKIBASTUZ_COAL);
            FuelTypesForTheCity.add(FuelType.SULFUR_OIL);
            FuelTypesForTheCity.add(FuelType.KUZNETSK_COAL);
            return FuelTypesForTheCity;
        }
    },
    NIZHNIY_NOVGOROD{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.DONETSK_COAL);
            FuelTypesForTheCity.add(FuelType.SULFUR_OIL);
            return FuelTypesForTheCity;
        }
    },
    KRASNOYARSK{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.EKIBASTUZ_COAL);
            FuelTypesForTheCity.add(FuelType.BEREZOVSKY_COAL_TSU);
            FuelTypesForTheCity.add(FuelType.BEREZOVSKY_COAL_ZHSHU);
            FuelTypesForTheCity.add(FuelType.KUZNETSK_COAL);
            return FuelTypesForTheCity;
        }
    },
    ROSTOV_NA_DONU{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.DONETSK_COAL);
            FuelTypesForTheCity.add(FuelType.SULFUR_OIL);
            return FuelTypesForTheCity;
        }
    },
    KALININGRAD{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.DONETSK_COAL);
            FuelTypesForTheCity.add(FuelType.SULFUR_OIL);
            return FuelTypesForTheCity;
        }
    },
    VLADIVOSTOK{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.EKIBASTUZ_COAL);
            FuelTypesForTheCity.add(FuelType.BEREZOVSKY_COAL_TSU);
            FuelTypesForTheCity.add(FuelType.BEREZOVSKY_COAL_ZHSHU);
            FuelTypesForTheCity.add(FuelType.KUZNETSK_COAL);
            return FuelTypesForTheCity;
        }
    },
    SURGUT{
        public List<FuelType> getFuelTypesForTheCity(){
            ArrayList<FuelType> FuelTypesForTheCity = new ArrayList<>();
            FuelTypesForTheCity.add(FuelType.SULFUR_OIL);
            FuelTypesForTheCity.add(FuelType.STABILIZED_OIL);
            return FuelTypesForTheCity;
        }
    };

    public abstract List<FuelType> getFuelTypesForTheCity();
}
