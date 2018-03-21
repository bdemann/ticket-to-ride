package shared.model.initialized_info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import shared.model.Color;
import shared.model.Route;

/**
 *
 * Created by paulinecausse on 3/2/18.
 */

public class Routes implements Serializable {
    private static Routes _instance;

    public static Routes instance() {

        if (_instance == null)
            _instance = new Routes();
        return _instance;
    }

    private Routes(){
        this._allRoutes = new ArrayList<Route>();
        set_edges();
    }

    private List<Route> _allRoutes;

    private void set_edges(){

        Cities cities = Cities.instance();

        Route _1 = new Route(1, cities.getVanc(), cities.getSeat(), Color.GRAY, false);
        Route _1b = new Route(1, cities.getVanc(), cities.getSeat(), Color.GRAY, false);

        Route _2 = new Route(1, cities.getSeat(), cities.getPort(), Color.GRAY,false);
        Route _2b = new Route(1, cities.getSeat(), cities.getPort(), Color.GRAY,false);

        Route _3 = new Route(4, cities.getSeat(), cities.getCal(), Color.GRAY, false);

        Route _4 = new Route(3, cities.getVanc(), cities.getCal(), Color.GRAY, false);

        Route _5 = new Route(6, cities.getCal(), cities.getWinn(), Color.WHITE, false);

        Route _6 = new Route(4, cities.getCal(), cities.getHel(), Color.GRAY, false);

        Route _7 = new Route(6, cities.getSeat(), cities.getHel(), Color.YELLOW, false);

        Route _8 = new Route(4, cities.getWinn(), cities.getHel(), Color.BLUE, false);

        Route _9 = new Route(6, cities.getPort(), cities.getSlc(), Color.BLUE, false);

        Route _10 = new Route(5, cities.getPort(), cities.getSanFr(), Color.GREEN, false);
        Route _10b = new Route(5, cities.getPort(), cities.getSanFr(), Color.PINK, false);

        Route _11 = new Route(5, cities.getSanFr(), cities.getSlc(), Color.ORANGE, false);
        Route _11b = new Route(5, cities.getSanFr(), cities.getSlc(), Color.WHITE, false);

        Route _12 = new Route(3, cities.getSanFr(), cities.getLax(), Color.PINK, false);
        Route _12b = new Route(3, cities.getSanFr(), cities.getLax(), Color.YELLOW, false);

        Route _13 = new Route(2, cities.getLax(), cities.getLasV(), Color.GRAY, false);

        Route _14 = new Route(3, cities.getLax(), cities.getPhx(), Color.GRAY, false);

        Route _15 = new Route(6, cities.getLax(), cities.getElP(), Color.BLACK, false);

        Route _16 = new Route(3, cities.getLasV(), cities.getSlc(), Color.ORANGE, false);

        Route _17 = new Route(3, cities.getSlc(), cities.getDvr(), Color.RED, false);
        Route _17b = new Route(3, cities.getSlc(), cities.getDvr(), Color.YELLOW, false);

        Route _18 = new Route(5, cities.getPhx(), cities.getDvr(), Color.WHITE, false);

        Route _19 = new Route(3, cities.getPhx(), cities.getSanFe(), Color.GRAY, false);

        Route _20 = new Route(3, cities.getPhx(), cities.getElP(), Color.GRAY, false);

        Route _21 = new Route(6, cities.getElP(), cities.getHou(), Color.GREEN, false);

        Route _22 = new Route(2, cities.getElP(), cities.getSanFe(), Color.GRAY, false);
        Route _23 = new Route(5, cities.getElP(), cities.getOmhC(), Color.YELLOW, false);
        Route _24 = new Route(4, cities.getElP(), cities.getDal(), Color.RED, false);
        Route _25 = new Route(2, cities.getHou(), cities.getNewO(), Color.GRAY, false);
        Route _26 = new Route(1, cities.getHou(), cities.getDal(), Color.GRAY, false);
        Route _26b = new Route(1, cities.getHou(), cities.getDal(), Color.GRAY, false);
        Route _27 = new Route(3, cities.getNewO(), cities.getlRock(), Color.GREEN, false);
        Route _28 = new Route(4, cities.getNewO(), cities.getAtl(), Color.ORANGE, false);
        Route _28b = new Route(4, cities.getNewO(), cities.getAtl(), Color.YELLOW, false);
        Route _29 = new Route(6, cities.getNewO(), cities.getMiami(), Color.RED, false);
        Route _30 = new Route(5, cities.getMiami(), cities.getAtl(), Color.BLUE, false);
        Route _31 = new Route(4, cities.getMiami(), cities.getCharl(), Color.PINK, false);
        Route _32 = new Route(2, cities.getCharl(), cities.getAtl(), Color.GRAY, false);
        Route _33 = new Route(2, cities.getCharl(), cities.getRal(), Color.GRAY, false);
        Route _34 = new Route(2, cities.getAtl(), cities.getRal(), Color.GRAY, false);
        Route _34b = new Route(2, cities.getAtl(), cities.getRal(), Color.GRAY, false);
        Route _35 = new Route(1, cities.getAtl(), cities.getNash(), Color.GRAY, false);
        Route _36 = new Route(2, cities.getRal(), cities.getWash(), Color.GRAY, false);
        Route _36b = new Route(2, cities.getRal(), cities.getWash(), Color.GRAY, false);
        Route _37 = new Route(3, cities.getRal(), cities.getNash(), Color.BLACK, false);
        Route _38 = new Route(2, cities.getRal(), cities.getPitt(), Color.GRAY, false);
        Route _39 = new Route(2, cities.getWash(), cities.getNyc(), Color.ORANGE, false);
        Route _39b = new Route(2, cities.getWash(), cities.getNyc(), Color.BLACK, false);
        Route _40 = new Route(2, cities.getWash(), cities.getPitt(), Color.GRAY, false);
        Route _41 = new Route(2, cities.getNyc(), cities.getBost(), Color.RED, false);
        Route _41b = new Route(2, cities.getNyc(), cities.getBost(), Color.YELLOW, false);
        Route _42 = new Route(3, cities.getNyc(), cities.getMont(), Color.BLUE, false);
        Route _43 = new Route(2, cities.getNyc(), cities.getPitt(), Color.WHITE, false);
        Route _43b = new Route(2, cities.getNyc(), cities.getPitt(), Color.GREEN, false);
        Route _44 = new Route(2, cities.getBost(), cities.getMont(), Color.GRAY, false);
        Route _44b = new Route(2, cities.getBost(), cities.getMont(), Color.GRAY, false);
        Route _45 = new Route(5, cities.getMont(), cities.getStm(), Color.BLACK, false);
        Route _46 = new Route(3, cities.getMont(), cities.getTor(), Color.GRAY, false);
        Route _47 = new Route(2, cities.getTor(), cities.getPitt(), Color.GRAY, false);
        Route _48 = new Route(2, cities.getTor(), cities.getStm(), Color.GRAY, false);
        Route _49 = new Route(4, cities.getTor(), cities.getChic(), Color.WHITE, false);
        Route _50 = new Route(6, cities.getTor(), cities.getDvr(), Color.PINK, false);
        Route _51 = new Route(4, cities.getPitt(), cities.getNash(), Color.YELLOW, false);
        Route _52 = new Route(3, cities.getPitt(), cities.getChic(), Color.ORANGE, false);
        Route _52b = new Route(3, cities.getPitt(), cities.getChic(), Color.BLACK, false);
        Route _53 = new Route(3, cities.getNash(), cities.getlRock(), Color.WHITE, false);
        Route _54 = new Route(2, cities.getNash(), cities.getStL(), Color.GRAY, false);
        Route _55 = new Route(2, cities.getlRock(), cities.getDal(), Color.GRAY, false);
        Route _56 = new Route(2, cities.getlRock(), cities.getOmhC(), Color.GRAY, false);
        Route _57 = new Route(2, cities.getlRock(), cities.getStL(), Color.GRAY, false);
        Route _58 = new Route(2, cities.getStL(), cities.getChic(), Color.WHITE, false);
        Route _58b = new Route(2, cities.getStL(), cities.getChic(), Color.GREEN, false);
        Route _59 = new Route(2, cities.getStL(), cities.getKanC(), Color.PINK, false);
        Route _59b = new Route(2, cities.getStL(), cities.getKanC(), Color.BLUE, false);
        Route _60 = new Route(4, cities.getChic(), cities.getOmh(), Color.BLUE, false);
        Route _61 = new Route(3, cities.getChic(), cities.getDul(), Color.RED, false);
        Route _62 = new Route(2, cities.getDal(), cities.getOmhC(), Color.GRAY, false);
        Route _62b = new Route(2, cities.getDal(), cities.getOmhC(), Color.GRAY, false);
        Route _63 = new Route(2, cities.getOmhC(), cities.getKanC(), Color.GRAY, false);
        Route _63b = new Route(2, cities.getOmhC(), cities.getKanC(), Color.GRAY, false);
        Route _64 = new Route(1, cities.getKanC(), cities.getOmh(), Color.GRAY, false);
        Route _64b = new Route(1, cities.getKanC(), cities.getOmh(), Color.GRAY, false);
        Route _65 = new Route(2, cities.getOmh(), cities.getDul(), Color.GRAY, false);
        Route _65b = new Route(2, cities.getOmh(), cities.getDul(), Color.GRAY, false);
        Route _66 = new Route(3, cities.getDul(), cities.getStm(), Color.GRAY, false);
        Route _67 = new Route(6, cities.getWinn(), cities.getStm(), Color.GRAY, false);
        Route _68 = new Route(4, cities.getDul(), cities.getWinn(), Color.BLACK, false);
        Route _69 = new Route(6, cities.getDul(), cities.getHel(), Color.ORANGE, false);
        Route _70 = new Route(5, cities.getOmh(), cities.getHel(), Color.RED, false);
        Route _71 = new Route(4, cities.getOmh(), cities.getDvr(), Color.PINK, false);
        Route _72 = new Route(4, cities.getKanC(), cities.getDvr(), Color.ORANGE, false);
        Route _72b = new Route(4, cities.getKanC(), cities.getDvr(), Color.BLACK, false);
        Route _73 = new Route(4, cities.getDvr(), cities.getOmhC(), Color.RED, false);
        Route _74 = new Route(3, cities.getOmhC(), cities.getSanFe(), Color.BLUE, false);
        Route _75 = new Route(2, cities.getSanFe(), cities.getDvr(), Color.GRAY, false);
        Route _76 = new Route(4, cities.getDvr(), cities.getHel(), Color.GREEN, false);
        Route _77 = new Route(3, cities.getSlc(), cities.getHel(), Color.PINK, false);

        _allRoutes.add(_1);
        _allRoutes.add(_1b);
        _allRoutes.add(_2);
        _allRoutes.add(_2b);
        _allRoutes.add(_3);
        _allRoutes.add(_4);
        _allRoutes.add(_5);
        _allRoutes.add(_6);
        _allRoutes.add(_7);
        _allRoutes.add(_8);
        _allRoutes.add(_9);
        _allRoutes.add(_10);
        _allRoutes.add(_10b);
        _allRoutes.add(_11);
        _allRoutes.add(_11b);
        _allRoutes.add(_12);
        _allRoutes.add(_12b);
        _allRoutes.add(_13);
        _allRoutes.add(_14);
        _allRoutes.add(_15);
        _allRoutes.add(_16);
        _allRoutes.add(_17);
        _allRoutes.add(_17b);
        _allRoutes.add(_18);
        _allRoutes.add(_19);
        _allRoutes.add(_20);
        _allRoutes.add(_21);
        _allRoutes.add(_22);
        _allRoutes.add(_23);
        _allRoutes.add(_24);
        _allRoutes.add(_25);
        _allRoutes.add(_26);
        _allRoutes.add(_26b);
        _allRoutes.add(_27);
        _allRoutes.add(_28);
        _allRoutes.add(_28b);
        _allRoutes.add(_29);
        _allRoutes.add(_30);
        _allRoutes.add(_31);
        _allRoutes.add(_32);
        _allRoutes.add(_33);
        _allRoutes.add(_34);
        _allRoutes.add(_34b);
        _allRoutes.add(_34);
        _allRoutes.add(_35);
        _allRoutes.add(_36);
        _allRoutes.add(_36b);
        _allRoutes.add(_37);
        _allRoutes.add(_38);
        _allRoutes.add(_39);
        _allRoutes.add(_39b);
        _allRoutes.add(_40);
        _allRoutes.add(_41);
        _allRoutes.add(_41b);
        _allRoutes.add(_42);
        _allRoutes.add(_43);
        _allRoutes.add(_43b);
        _allRoutes.add(_44);
        _allRoutes.add(_44b);
        _allRoutes.add(_45);
        _allRoutes.add(_46);
        _allRoutes.add(_47);
        _allRoutes.add(_48);
        _allRoutes.add(_49);
        _allRoutes.add(_50);
        _allRoutes.add(_51);
        _allRoutes.add(_52);
        _allRoutes.add(_52b);
        _allRoutes.add(_53);
        _allRoutes.add(_54);
        _allRoutes.add(_55);
        _allRoutes.add(_56);
        _allRoutes.add(_57);
        _allRoutes.add(_58);
        _allRoutes.add(_58b);
        _allRoutes.add(_59);
        _allRoutes.add(_59b);
        _allRoutes.add(_60);
        _allRoutes.add(_61);
        _allRoutes.add(_62);
        _allRoutes.add(_62b);
        _allRoutes.add(_63);
        _allRoutes.add(_63b);
        _allRoutes.add(_64);
        _allRoutes.add(_64b);
        _allRoutes.add(_65);
        _allRoutes.add(_65b);
        _allRoutes.add(_66);
        _allRoutes.add(_67);
        _allRoutes.add(_68);
        _allRoutes.add(_69);
        _allRoutes.add(_70);
        _allRoutes.add(_71);
        _allRoutes.add(_72);
        _allRoutes.add(_72b);
        _allRoutes.add(_73);
        _allRoutes.add(_74);
        _allRoutes.add(_75);
        _allRoutes.add(_76);
        _allRoutes.add(_77);

    }

    public List<Route> getEdges(){
        return _allRoutes;
    }
}
