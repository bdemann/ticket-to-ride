package shared.model.initialized_info;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import shared.model.City;
import shared.model.Edge;

/**
 * Created by paulinecausse on 3/3/18.
 */

public class Cities implements Serializable {
    private static Cities _instance;

    public static Cities instance() {

        if (_instance == null)
            _instance = new Cities();
        return _instance;
    }

    private Cities() {}

    private City vanc = new City(new Point(132,18), "Vancouver");
    private City winn = new City(new Point(524, 62), "Winnipeg");
    private City cal = new City(new Point(275, 18), "Calgary");
    private City mont = new City(new Point(956, 83), "Montréal");
    private City seat = new City(new Point(131, 68), "Seatle");
    private City port = new City(new Point(96, 113), "Portland");
    private City hel = new City(new Point(338, 161), "Helena");
    private City dul = new City(new Point(604, 197), "Duluth");
    private City stm = new City(new Point(737, 144), "Saul St. Marie");
    private City tor = new City(new Point(841, 171), "Toronto");
    private City bost = new City(new Point(976, 171), "Boston");
    private City nyc = new City(new Point(935, 240), "New York");
    private City pitt = new City(new Point(839, 269), "Pittsburg");
    private City wash = new City(new Point(892, 329), "Washington");
    private City chic = new City(new Point(715, 269), "Chicago");
    private City omhC = new City(new Point(521, 395), "Omklahoma City");
    private City omh = new City(new Point(554, 264), "Omaha");
    private City dvr = new City(new Point(384, 311), "Denver");
    private City kanC = new City(new Point(560, 327), "Kansas City");
    private City stL = new City(new Point(644, 336), "St. Louis");
    private City nash = new City(new Point(740, 387), "Nashville");
    private City ral = new City(new Point(841, 381), "Raleigh");
    private City atl = new City(new Point(776, 431), "Atlanta");
    private City charl = new City(new Point(862, 450), "Charleston");
    private City miami = new City(new Point(880, 617), "Miami");
    private City newO = new City(new Point(667, 543), "New Orleans");
    private City lRock = new City(new Point(614, 417), "Little Rock");
    private City hou = new City(new Point(580, 540), "Houston");
    private City dal = new City(new Point(560, 503), "Dallas");
    private City elP = new City(new Point(345, 480), "El Paso");
    private City sanFe = new City(new Point(357, 399), "Santa Fe");
    private City phx = new City(new Point(236, 429), "Phoenix");
    private City lasV = new City(new Point(197, 369), "Las, Vegas");
    private City lax = new City(new Point(131, 416), "Los Angeles");
    private City sanFr = new City(new Point(65, 306), "San Fransisco");
    private City slc = new City(new Point(261, 264), "Salt Lake City");

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
}
