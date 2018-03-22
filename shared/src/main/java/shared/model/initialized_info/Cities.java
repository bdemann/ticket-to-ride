package shared.model.initialized_info;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import shared.model.City;
import shared.model.CityPoint;

import static shared.model.initialized_info.DestCardId.*;

/**
 *
 * Created by paulinecausse on 3/3/18.
 */

public class Cities implements Serializable {
    private static Cities _instance;
    private Map<String, City> citiesMap;

    private City vanc = new City(new CityPoint(132,18), VANCOUVER);
    private City winn = new City(new CityPoint(524, 62), WINNIPEG);
    private City cal = new City(new CityPoint(275, 18), CALGARY);
    private City mont = new City(new CityPoint(956, 83), MONTREAL);
    private City seat = new City(new CityPoint(131, 68), SEATTLE);
    private City port = new City(new CityPoint(96, 113), PORTLAND);
    private City hel = new City(new CityPoint(338, 161), HELENA);
    private City dul = new City(new CityPoint(604, 197), DULUTH);
    private City stm = new City(new CityPoint(737, 144), SAUL_ST_MARIE);
    private City tor = new City(new CityPoint(841, 171), TORONTO);
    private City bost = new City(new CityPoint(976, 171), BOSTON);
    private City nyc = new City(new CityPoint(935, 240), NEW_YORK);
    private City pitt = new City(new CityPoint(839, 269), PITTSBURGH);
    private City wash = new City(new CityPoint(892, 329), WASHINGTON);
    private City chic = new City(new CityPoint(715, 269), CHICAGO);
    private City omhC = new City(new CityPoint(521, 395), OKLAHOMA_CITY);
    private City omh = new City(new CityPoint(554, 264), OMAHA);
    private City dvr = new City(new CityPoint(384, 311), DENVER);
    private City kanC = new City(new CityPoint(560, 327), KANSAS_CITY);
    private City stL = new City(new CityPoint(644, 336), ST_LOUIS);
    private City nash = new City(new CityPoint(740, 387), NASHVILLE);
    private City ral = new City(new CityPoint(841, 381), RALEIGH);
    private City atl = new City(new CityPoint(776, 431), ATLANTA);
    private City charl = new City(new CityPoint(862, 450), CHARLESTON);
    private City miami = new City(new CityPoint(880, 617), MIAMI);
    private City newO = new City(new CityPoint(667, 543), NEW_ORLEANS);
    private City lRock = new City(new CityPoint(614, 417), LITTLE_ROCK);
    private City hou = new City(new CityPoint(580, 540), HOUSTON);
    private City dal = new City(new CityPoint(560, 503), DALLAS);
    private City elP = new City(new CityPoint(345, 480), EL_PASO);
    private City sanFe = new City(new CityPoint(357, 399), SANTA_FE);
    private City phx = new City(new CityPoint(236, 429), PHOENIX);
    private City lasV = new City(new CityPoint(197, 369), LAS_VEGAS);
    private City lax = new City(new CityPoint(131, 416), LOS_ANGELES);
    private City sanFr = new City(new CityPoint(65, 306), SAN_FRANCISCO);
    private City slc = new City(new CityPoint(261, 264), SALT_LAKE_CITY);

    public static Cities instance() {

        if (_instance == null)
            _instance = new Cities();
        return _instance;
    }

    private Cities(){
        citiesMap = new HashMap<>();
        citiesMap.put(VANCOUVER, vanc);
        citiesMap.put(WINNIPEG, winn);
        citiesMap.put(CALGARY, cal);
        citiesMap.put(MONTREAL, mont);
        citiesMap.put(SEATTLE, seat);
        citiesMap.put(PORTLAND, port);
        citiesMap.put(HELENA, hel);
        citiesMap.put(DULUTH, dul);
        citiesMap.put(SAUL_ST_MARIE, stm);
        citiesMap.put(TORONTO, tor);
        citiesMap.put(BOSTON, bost);
        citiesMap.put(NEW_YORK, nyc);
        citiesMap.put(PITTSBURGH, pitt);
        citiesMap.put(WASHINGTON, wash);
        citiesMap.put(CHICAGO, chic);
        citiesMap.put(OKLAHOMA_CITY, omhC);
        citiesMap.put(OMAHA, omh);
        citiesMap.put(DENVER, dvr);
        citiesMap.put(KANSAS_CITY, kanC);
        citiesMap.put(ST_LOUIS, stL);
        citiesMap.put(NASHVILLE, nash);
        citiesMap.put(RALEIGH, ral);
        citiesMap.put(ATLANTA, atl);
        citiesMap.put(CHARLESTON, charl);
        citiesMap.put(MIAMI, miami);
        citiesMap.put(NEW_ORLEANS, newO);
        citiesMap.put(LITTLE_ROCK, lRock);
        citiesMap.put(HOUSTON, hou);
        citiesMap.put(DALLAS, dal);
        citiesMap.put(EL_PASO, elP);
        citiesMap.put(SANTA_FE, sanFe);
        citiesMap.put(PHOENIX, phx);
        citiesMap.put(LAS_VEGAS, lasV);
        citiesMap.put(LOS_ANGELES, lax);
        citiesMap.put(SAN_FRANCISCO, sanFr);
        citiesMap.put(SALT_LAKE_CITY, slc);
    }



    public City getVanc() {
        return vanc;
    }

    public City getWinn() {
        return winn;
    }

    public City getCal() {
        return cal;
    }

    public City getMont() {
        return mont;
    }

    public City getSeat() {
        return seat;
    }

    public City getPort() { return port; }

    public City getHel() {
        return hel;
    }

    public City getDul() {
        return dul;
    }

    public City getStm() {
        return stm;
    }

    public City getTor() {
        return tor;
    }

    public City getBost() {
        return bost;
    }

    public City getNyc() {
        return nyc;
    }

    public City getPitt() {
        return pitt;
    }

    public City getWash() {
        return wash;
    }

    public City getChic() {
        return chic;
    }

    public City getOmhC() {
        return omhC;
    }

    public City getOmh() {
        return omh;
    }

    public City getDvr() {
        return dvr;
    }

    public City getKanC() {
        return kanC;
    }

    public City getStL() {
        return stL;
    }

    public City getNash() {
        return nash;
    }

    public City getRal() {
        return ral;
    }

    public City getAtl() {
        return atl;
    }

    public City getCharl() {
        return charl;
    }

    public City getMiami() {
        return miami;
    }

    public City getNewO() {
        return newO;
    }

    public City getlRock() {
        return lRock;
    }

    public City getHou() {
        return hou;
    }

    public City getDal() {
        return dal;
    }

    public City getElP() {
        return elP;
    }

    public City getSanFe() {
        return sanFe;
    }

    public City getPhx() {
        return phx;
    }

    public City getLasV() {
        return lasV;
    }

    public City getLax() {
        return lax;
    }

    public City getSanFr() {
        return sanFr;
    }

    public City getSlc() {
        return slc;
    }

    public City getCity(String cityName) {

        if(citiesMap.containsKey(cityName)){
            return citiesMap.get(cityName);
        }
        else {
            return null;
        }

    }
}
