package shared.model.initialized_info;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import shared.model.City;
import shared.model.Color;
import shared.model.Edge;

/**
 * Created by paulinecausse on 3/2/18.
 */

public class Edges implements Serializable {
    private static Edges _instance;

    public static Edges instance() {

        if (_instance == null)
            _instance = new Edges();
        return _instance;
    }

    private Edges(){
        this._allEdges = new ArrayList<Edge>();
        set_edges();
    }

    private List<Edge> _allEdges;

    private void set_edges(){

        Cities cities = Cities.instance();

        Edge _1 = new Edge(1, cities.getVanc(), cities.getSeat(), Color.GRAY, false);
        Edge _1b = new Edge(1, cities.getVanc(), cities.getSeat(), Color.GRAY, false);
        Edge _2 = new Edge(1, cities.getSeat(), cities.getPort(), Color.GRAY,false);
        Edge _2b = new Edge(1, cities.getSeat(), cities.getPort(), Color.GRAY,false);
        Edge _3 = new Edge(4, cities.getSeat(), cities.getCal(), Color.GRAY, false);
        Edge _4 = new Edge(3, cities.getVanc(), cities.getCal(), Color.GRAY, false);
        Edge _5 = new Edge(6, cities.getCal(), cities.getWinn(), Color.WHITE, false);
        Edge _6 = new Edge(4, cities.getCal(), cities.getHel(), Color.GRAY, false);
        Edge _7 = new Edge(6, cities.getSeat(), cities.getHel(), Color.YELLOW, false);
        Edge _8 = new Edge(4, cities.getWinn(), cities.getHel(), Color.BLUE, false);
        Edge _9 = new Edge(6, cities.getPort(), cities.getSlc(), Color.BLUE, false);
        Edge _10 = new Edge(5, cities.getPort(), cities.getSanFr(), Color.GREEN, false);
        Edge _10b = new Edge(5, cities.getPort(), cities.getSanFr(), Color.PINK, false);
        Edge _11 = new Edge(5, cities.getSanFr(), cities.getSlc(), Color.ORANGE, false);
        Edge _11b = new Edge(5, cities.getSanFr(), cities.getSlc(), Color.WHITE, false);
        Edge _12 = new Edge(3, cities.getSanFr(), cities.getLax(), Color.PINK, false);
        Edge _12b = new Edge(3, cities.getSanFr(), cities.getLax(), Color.YELLOW, false);
        Edge _13 = new Edge(2, cities.getLax(), cities.getLasV(), Color.GRAY, false);
        Edge _14 = new Edge(3, cities.getLax(), cities.getPhx(), Color.GRAY, false);
        Edge _15 = new Edge(6, cities.getLax(), cities.getElP(), Color.BLACK, false);
        Edge _16 = new Edge(3, cities.getLasV(), cities.getSlc(), Color.ORANGE, false);
        Edge _17 = new Edge(3, cities.getSlc(), cities.getDvr(), Color.RED, false);
        Edge _17b = new Edge(3, cities.getSlc(), cities.getDvr(), Color.YELLOW, false);
        Edge _18 = new Edge(5, cities.getPhx(), cities.getDvr(), Color.WHITE, false);
        Edge _19 = new Edge(3, cities.getPhx(), cities.getSanFe(), Color.GRAY, false);
        Edge _20 = new Edge(3, cities.getPhx(), cities.getElP(), Color.GRAY, false);
        Edge _21 = new Edge(6, cities.getElP(), cities.getHou(), Color.GREEN, false);
        Edge _22 = new Edge(2, cities.getElP(), cities.getSanFe(), Color.GRAY, false);
        Edge _23 = new Edge(5, cities.getElP(), cities.getOmhC(), Color.YELLOW, false);
        Edge _24 = new Edge(4, cities.getElP(), cities.getDal(), Color.RED, false);
        Edge _25 = new Edge(2, cities.getHou(), cities.getNewO(), Color.GRAY, false);
        Edge _26 = new Edge(1, cities.getHou(), cities.getDal(), Color.GRAY, false);
        Edge _26b = new Edge(1, cities.getHou(), cities.getDal(), Color.GRAY, false);
        Edge _27 = new Edge(3, cities.getNewO(), cities.getlRock(), Color.GREEN, false);
        Edge _28 = new Edge(4, cities.getNewO(), cities.getAtl(), Color.ORANGE, false);
        Edge _28b = new Edge(4, cities.getNewO(), cities.getAtl(), Color.YELLOW, false);
        Edge _29 = new Edge(6, cities.getNewO(), cities.getMiami(), Color.RED, false);
        Edge _30 = new Edge(5, cities.getMiami(), cities.getAtl(), Color.BLUE, false);
        Edge _31 = new Edge(4, cities.getMiami(), cities.getCharl(), Color.PINK, false);
        Edge _32 = new Edge(2, cities.getCharl(), cities.getAtl(), Color.GRAY, false);
        Edge _33 = new Edge(2, cities.getCharl(), cities.getRal(), Color.GRAY, false);
        Edge _34 = new Edge(2, cities.getAtl(), cities.getRal(), Color.GRAY, false);
        Edge _34b = new Edge(2, cities.getAtl(), cities.getRal(), Color.GRAY, false);
        Edge _35 = new Edge(1, cities.getAtl(), cities.getNash(), Color.GRAY, false);
        Edge _36 = new Edge(2, cities.getRal(), cities.getWash(), Color.GRAY, false);
        Edge _36b = new Edge(2, cities.getRal(), cities.getWash(), Color.GRAY, false);
        Edge _37 = new Edge(3, cities.getRal(), cities.getNash(), Color.BLACK, false);
        Edge _38 = new Edge(2, cities.getRal(), cities.getPitt(), Color.GRAY, false);
        Edge _39 = new Edge(2, cities.getWash(), cities.getNyc(), Color.ORANGE, false);
        Edge _39b = new Edge(2, cities.getWash(), cities.getNyc(), Color.BLACK, false);
        Edge _40 = new Edge(2, cities.getWash(), cities.getPitt(), Color.GRAY, false);
        Edge _41 = new Edge(2, cities.getNyc(), cities.getBost(), Color.RED, false);
        Edge _41b = new Edge(2, cities.getNyc(), cities.getBost(), Color.YELLOW, false);
        Edge _42 = new Edge(3, cities.getNyc(), cities.getMont(), Color.BLUE, false);
        Edge _43 = new Edge(2, cities.getNyc(), cities.getPitt(), Color.WHITE, false);
        Edge _43b = new Edge(2, cities.getNyc(), cities.getPitt(), Color.GREEN, false);
        Edge _44 = new Edge(2, cities.getBost(), cities.getMont(), Color.GRAY, false);
        Edge _44b = new Edge(2, cities.getBost(), cities.getMont(), Color.GRAY, false);
        Edge _45 = new Edge(5, cities.getMont(), cities.getStm(), Color.BLACK, false);
        Edge _46 = new Edge(3, cities.getMont(), cities.getTor(), Color.GRAY, false);
        Edge _47 = new Edge(2, cities.getTor(), cities.getPitt(), Color.GRAY, false);
        Edge _48 = new Edge(2, cities.getTor(), cities.getStm(), Color.GRAY, false);
        Edge _49 = new Edge(4, cities.getTor(), cities.getChic(), Color.WHITE, false);
        Edge _50 = new Edge(6, cities.getTor(), cities.getDvr(), Color.PINK, false);
        Edge _51 = new Edge(4, cities.getPitt(), cities.getNash(), Color.YELLOW, false);
        Edge _52 = new Edge(3, cities.getPitt(), cities.getChic(), Color.ORANGE, false);
        Edge _52b = new Edge(3, cities.getPitt(), cities.getChic(), Color.BLACK, false);
        Edge _53 = new Edge(3, cities.getNash(), cities.getlRock(), Color.WHITE, false);
        Edge _54 = new Edge(2, cities.getNash(), cities.getStL(), Color.GRAY, false);
        Edge _55 = new Edge(2, cities.getlRock(), cities.getDal(), Color.GRAY, false);
        Edge _56 = new Edge(2, cities.getlRock(), cities.getOmhC(), Color.GRAY, false);
        Edge _57 = new Edge(2, cities.getlRock(), cities.getStL(), Color.GRAY, false);
        Edge _58 = new Edge(2, cities.getStL(), cities.getChic(), Color.WHITE, false);
        Edge _58b = new Edge(2, cities.getStL(), cities.getChic(), Color.GREEN, false);
        Edge _59 = new Edge(2, cities.getStL(), cities.getKanC(), Color.PINK, false);
        Edge _59b = new Edge(2, cities.getStL(), cities.getKanC(), Color.BLUE, false);
        Edge _60 = new Edge(4, cities.getChic(), cities.getOmh(), Color.BLUE, false);
        Edge _61 = new Edge(3, cities.getChic(), cities.getDul(), Color.RED, false);
        Edge _62 = new Edge(2, cities.getDal(), cities.getOmhC(), Color.GRAY, false);
        Edge _62b = new Edge(2, cities.getDal(), cities.getOmhC(), Color.GRAY, false);
        Edge _63 = new Edge(2, cities.getOmhC(), cities.getKanC(), Color.GRAY, false);
        Edge _63b = new Edge(2, cities.getOmhC(), cities.getKanC(), Color.GRAY, false);
        Edge _64 = new Edge(1, cities.getKanC(), cities.getOmh(), Color.GRAY, false);
        Edge _64b = new Edge(1, cities.getKanC(), cities.getOmh(), Color.GRAY, false);
        Edge _65 = new Edge(2, cities.getOmh(), cities.getDul(), Color.GRAY, false);
        Edge _65b = new Edge(2, cities.getOmh(), cities.getDul(), Color.GRAY, false);
        Edge _66 = new Edge(3, cities.getDul(), cities.getStm(), Color.GRAY, false);
        Edge _67 = new Edge(6, cities.getWinn(), cities.getStm(), Color.GRAY, false);
        Edge _68 = new Edge(4, cities.getDul(), cities.getWinn(), Color.BLACK, false);
        Edge _69 = new Edge(6, cities.getDul(), cities.getHel(), Color.ORANGE, false);
        Edge _70 = new Edge(5, cities.getOmh(), cities.getHel(), Color.RED, false);
        Edge _71 = new Edge(4, cities.getOmh(), cities.getDvr(), Color.PINK, false);
        Edge _72 = new Edge(4, cities.getKanC(), cities.getDvr(), Color.ORANGE, false);
        Edge _72b = new Edge(4, cities.getKanC(), cities.getDvr(), Color.BLACK, false);
        Edge _73 = new Edge(4, cities.getDvr(), cities.getOmhC(), Color.RED, false);
        Edge _74 = new Edge(3, cities.getOmhC(), cities.getSanFe(), Color.BLUE, false);
        Edge _75 = new Edge(2, cities.getSanFe(), cities.getDvr(), Color.GRAY, false);
        Edge _76 = new Edge(4, cities.getDvr(), cities.getHel(), Color.GREEN, false);
        Edge _77 = new Edge(3, cities.getSlc(), cities.getHel(), Color.PINK, false);

        _allEdges.add(_1);
        _allEdges.add(_1b);
        _allEdges.add(_2);
        _allEdges.add(_2b);
        _allEdges.add(_3);
        _allEdges.add(_4);
        _allEdges.add(_5);
        _allEdges.add(_6);
        _allEdges.add(_7);
        _allEdges.add(_8);
        _allEdges.add(_9);
        _allEdges.add(_10);
        _allEdges.add(_10b);
        _allEdges.add(_11);
        _allEdges.add(_11b);
        _allEdges.add(_12);
        _allEdges.add(_12b);
        _allEdges.add(_13);
        _allEdges.add(_14);
        _allEdges.add(_15);
        _allEdges.add(_16);
        _allEdges.add(_17);
        _allEdges.add(_17b);
        _allEdges.add(_18);
        _allEdges.add(_19);
        _allEdges.add(_20);
        _allEdges.add(_21);
        _allEdges.add(_22);
        _allEdges.add(_23);
        _allEdges.add(_24);
        _allEdges.add(_25);
        _allEdges.add(_26);
        _allEdges.add(_26b);
        _allEdges.add(_27);
        _allEdges.add(_28);
        _allEdges.add(_28b);
        _allEdges.add(_29);
        _allEdges.add(_30);
        _allEdges.add(_31);
        _allEdges.add(_32);
        _allEdges.add(_33);
        _allEdges.add(_34);
        _allEdges.add(_34b);
        _allEdges.add(_34);
        _allEdges.add(_35);
        _allEdges.add(_36);
        _allEdges.add(_36b);
        _allEdges.add(_37);
        _allEdges.add(_38);
        _allEdges.add(_39);
        _allEdges.add(_39b);
        _allEdges.add(_40);
        _allEdges.add(_41);
        _allEdges.add(_41b);
        _allEdges.add(_42);
        _allEdges.add(_43);
        _allEdges.add(_43b);
        _allEdges.add(_44);
        _allEdges.add(_44b);
        _allEdges.add(_45);
        _allEdges.add(_46);
        _allEdges.add(_47);
        _allEdges.add(_48);
        _allEdges.add(_49);
        _allEdges.add(_50);
        _allEdges.add(_51);
        _allEdges.add(_52);
        _allEdges.add(_52b);
        _allEdges.add(_53);
        _allEdges.add(_54);
        _allEdges.add(_55);
        _allEdges.add(_56);
        _allEdges.add(_57);
        _allEdges.add(_58);
        _allEdges.add(_58b);
        _allEdges.add(_59);
        _allEdges.add(_59b);
        _allEdges.add(_60);
        _allEdges.add(_61);
        _allEdges.add(_62);
        _allEdges.add(_62b);
        _allEdges.add(_63);
        _allEdges.add(_63b);
        _allEdges.add(_64);
        _allEdges.add(_64b);
        _allEdges.add(_65);
        _allEdges.add(_65b);
        _allEdges.add(_66);
        _allEdges.add(_67);
        _allEdges.add(_68);
        _allEdges.add(_69);
        _allEdges.add(_70);
        _allEdges.add(_71);
        _allEdges.add(_72);
        _allEdges.add(_72b);
        _allEdges.add(_73);
        _allEdges.add(_74);
        _allEdges.add(_75);
        _allEdges.add(_76);
        _allEdges.add(_77);

    }
}
