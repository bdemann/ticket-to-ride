package shared.model.initialized_info;

import java.awt.Point;
import java.util.ArrayList;

import shared.model.City;
import shared.model.Edge;

/**
 * Created by paulinecausse on 3/3/18.
 */

public class Cities {
    private static Cities _instance;

    public static Cities instance() {

        if (_instance == null)
            _instance = new Cities();
        return _instance;
    }

    private Cities() {}

    private City vanc = new City(new Point(350,222), "Vancouver");
    private City winn = new City(new Point(1225, 320), "Winnipeg");
    private City cal = new City(new Point(663, 218), "Calgary");
    private City mont = new City(new Point(2186, 365), "Montréal");
    private City seat = new City(new Point(335, 335), "Seatle");
    private City port = new City(new Point(260, 429), "Portland");
    private City hel = new City(new Point(803, 542), "Helena");
    private City dul = new City(new Point(1398, 625), "Duluth");
    private City stm = new City(new Point(1696, 497), "Saul St. Marie");
    private City tor = new City(new Point(1930, 565), "Toronto");
    private City bost = new City(new Point(2235, 565), "Boston");
    private City nyc = new City(new Point(2149, 719), "New York");
    private City pitt = new City(new Point(1926, 783), "Pittsburg");
    private City wash = new City(new Point(2047, 915), "Washington");
    private City chic = new City(new Point(1647, 915), "Chicago");
    private City omhC = new City(new Point(1210, 1059), "Omklahoma City");
    private City omh = new City(new Point(1285, 772), "Omaha");
    private City dvr = new City(new Point(908, 874), "Denver");
    private City kanC = new City(new Point(1300, 908), "Kansas City");
    private City stL = new City(new Point(1489, 930), "St. Louis");
    private City nash = new City(new Point(1700, 1043), "Nashville");
    private City ral = new City(new Point(1930, 1032), "Raleigh");
    private City atl = new City(new Point(1787, 1141), "Atlanta");
    private City charl = new City(new Point(1975, 1190), "Charleston");
    private City miami = new City(new Point(2017, 1556), "Miami");
    private City newO = new City(new Point(1539, 1402), "New Orleans");
    private City lRock = new City(new Point(1421, 1115), "Little Rock");
    private City hou = new City(new Point(1345, 1387), "Houston");
    private City dal = new City(new Point(1304, 1304), "Dallas");
    private City elP = new City(new Point(818, 1258), "El Paso");
    private City sanFe = new City(new Point(844, 1074), "Santa Fe");
    private City phx = new City(new Point(576, 1145), "Phoenix");
    private City lasV = new City(new Point(482, 1006), "Las, Vegas");
    private City lax = new City(new Point(339, 1108), "Los Angeles");
    private City sanFr = new City(new Point(192, 866), "San Fransisco");
    private City slc = new City(new Point(633, 768), "Salt Lake City");

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

    public City getPort() {
        return port;
    }

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
}
