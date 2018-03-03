package shared.model.initialized_info;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import shared.model.City;
import shared.model.Edge;

/**
 * Created by paulinecausse on 3/2/18.
 */

public class Edges {
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

        Edge _1 = new Edge(1, cities.getVanc(), cities.getSeat(), "grey", false);
        Edge _1b = new Edge(1, cities.getVanc(), cities.getSeat(), "grey", false);
        Edge _2 = new Edge(1, cities.getSeat(), cities.getPort(), "grey",false);
        Edge _2b = new Edge(1, cities.getSeat(), cities.getPort(), "grey",false);
        Edge _3 = new Edge(4, cities.getSeat(), cities.getCal(), "grey", false);
        Edge _4 = new Edge(3, cities.getVanc(), cities.getCal(), "grey", false);
        Edge _5 = new Edge(6, cities.getCal(), cities.getWinn(), "white", false);
        Edge _6 = new Edge(4, cities.getCal(), cities.getHel(), "grey", false);
        Edge _7 = new Edge(6, cities.getSeat(), cities.getHel(), "yellow", false);
        Edge _8 = new Edge(4, cities.getWinn(), cities.getHel(), "blue", false);
        Edge _9 = new Edge(6, cities.getPort(), cities.getSlc(), "blue", false);
        Edge _10 = new Edge(5, cities.getPort(), cities.getSanFr(), "green", false);
        Edge _10b = new Edge(5, cities.getPort(), cities.getSanFr(), "pink", false);
        Edge _11 = new Edge(5, cities.getSanFr(), cities.getSlc(), "orange", false);
        Edge _11b = new Edge(5, cities.getSanFr(), cities.getSlc(), "white", false);
        Edge _12 = new Edge(3, cities.getSanFr(), cities.getLax(), "pink", false);
        Edge _12b = new Edge(3, cities.getSanFr(), cities.getLax(), "yellow", false);
        Edge _13 = new Edge(2, cities.getLax(), cities.getLasV(), "grey", false);
        Edge _14 = new Edge(3, cities.getLax(), cities.getPhx(), "grey", false);
        Edge _15 = new Edge(6, cities.getLax(), cities.getElP(), "black", false);
        Edge _16 = new Edge(3, cities.getLasV(), cities.getSlc(), "orange", false);
        Edge _17 = new Edge(3, cities.getSlc(), cities.getDvr(), "red", false);
        Edge _17b = new Edge(3, cities.getSlc(), cities.getDvr(), "yellow", false);
        Edge _18 = new Edge(5, cities.getPhx(), cities.getDvr(), "white", false);
        Edge _19 = new Edge(3, cities.getPhx(), cities.getSanFe(), "grey", false);
        Edge _20 = new Edge(3, cities.getPhx(), cities.getElP(), "grey", false);
        Edge _21 = new Edge(6, cities.getElP(), cities.getHou(), "green", false);
        Edge _22 = new Edge(2, cities.getElP(), cities.getSanFe(), "grey", false);
        Edge _23 = new Edge(5, cities.getElP(), cities.getOmhC(), "yellow", false);
        Edge _24 = new Edge(4, cities.getElP(), cities.getDal(), "red", false);
        Edge _25 = new Edge(2, cities.getHou(), cities.getNewO(), "grey", false);
        Edge _26 = new Edge(1, cities.getHou(), cities.getDal(), "grey", false);
        Edge _26b = new Edge(1, cities.getHou(), cities.getDal(), "grey", false);
        Edge _27 = new Edge(3, cities.getNewO(), cities.getlRock(), "green", false);
        Edge _28 = new Edge(4, cities.getNewO(), cities.getAtl(), "orange", false);
        Edge _28b = new Edge(4, cities.getNewO(), cities.getAtl(), "yellow", false);
        Edge _29 = new Edge(6, cities.getNewO(), cities.getMiami(), "red", false);
        Edge _30 = new Edge(5, cities.getMiami(), cities.getAtl(), "blue", false);
        Edge _31 = new Edge(4, cities.getMiami(), cities.getCharl(), "pink", false);
        Edge _32 = new Edge(2, cities.getCharl(), cities.getAtl(), "grey", false);
        Edge _33 = new Edge(2, cities.getCharl(), cities.getRal(), "grey", false);
        Edge _34 = new Edge(2, cities.getAtl(), cities.getRal(), "grey", false);
        Edge _34b = new Edge(2, cities.getAtl(), cities.getRal(), "grey", false);
        Edge _35 = new Edge(1, cities.getAtl(), cities.getNash(), "grey", false);
        Edge _36 = new Edge(2, cities.getRal(), cities.getWash(), "grey", false);
        Edge _36b = new Edge(2, cities.getRal(), cities.getWash(), "grey", false);
        Edge _37 = new Edge(3, cities.getRal(), cities.getNash(), "black", false);
        Edge _38 = new Edge(2, cities.getRal(), cities.getPitt(), "grey", false);
        Edge _39 = new Edge(2, cities.getWash(), cities.getNyc(), "orange", false);
        Edge _39b = new Edge(2, cities.getWash(), cities.getNyc(), "black", false);
        Edge _40 = new Edge(2, cities.getWash(), cities.getPitt(), "grey", false);
        Edge _41 = new Edge(2, cities.getNyc(), cities.getBost(), "red", false);
        Edge _41b = new Edge(2, cities.getNyc(), cities.getBost(), "yellow", false);
        Edge _42 = new Edge(3, cities.getNyc(), cities.getMont(), "blue", false);
        Edge _43 = new Edge(2, cities.getNyc(), cities.getPitt(), "white", false);
        Edge _43b = new Edge(2, cities.getNyc(), cities.getPitt(), "green", false);
        Edge _44 = new Edge(2, cities.getBost(), cities.getMont(), "grey", false);
        Edge _44b = new Edge(2, cities.getBost(), cities.getMont(), "grey", false);
        Edge _45 = new Edge(5, cities.getMont(), cities.getStm(), "black", false);
        Edge _46 = new Edge(3, cities.getMont(), cities.getTor(), "grey", false);
        Edge _47 = new Edge(2, cities.getTor(), cities.getPitt(), "grey", false);
        Edge _48 = new Edge(2, cities.getTor(), cities.getStm(), "grey", false);
        Edge _49 = new Edge(4, cities.getTor(), cities.getChic(), "white", false);
        Edge _50 = new Edge(6, cities.getTor(), cities.getDvr(), "pink", false);
        Edge _51 = new Edge(4, cities.getPitt(), cities.getNash(), "yellow", false);
        Edge _52 = new Edge(3, cities.getPitt(), cities.getChic(), "orange", false);
        Edge _52b = new Edge(3, cities.getPitt(), cities.getChic(), "black", false);
        Edge _53 = new Edge(3, cities.getNash(), cities.getlRock(), "white", false);
        Edge _54 = new Edge(2, cities.getNash(), cities.getStL(), "grey", false);
        Edge _55 = new Edge(2, cities.getlRock(), cities.getDal(), "grey", false);
        Edge _56 = new Edge(2, cities.getlRock(), cities.getOmhC(), "grey", false);
        Edge _57 = new Edge(2, cities.getlRock(), cities.getStL(), "grey", false);
        Edge _58 = new Edge(2, cities.getStL(), cities.getChic(), "white", false);
        Edge _58b = new Edge(2, cities.getStL(), cities.getChic(), "green", false);
        Edge _59 = new Edge(2, cities.getStL(), cities.getKanC(), "pink", false);
        Edge _59b = new Edge(2, cities.getStL(), cities.getKanC(), "blue", false);
        Edge _60 = new Edge(4, cities.getChic(), cities.getOmh(), "blue", false);
        Edge _61 = new Edge(3, cities.getChic(), cities.getDul(), "red", false);
        Edge _62 = new Edge(2, cities.getDal(), cities.getOmhC(), "grey", false);
        Edge _62b = new Edge(2, cities.getDal(), cities.getOmhC(), "grey", false);
        Edge _63 = new Edge(2, cities.getOmhC(), cities.getKanC(), "grey", false);
        Edge _63b = new Edge(2, cities.getOmhC(), cities.getKanC(), "grey", false);
        Edge _64 = new Edge(1, cities.getKanC(), cities.getOmh(), "grey", false);
        Edge _64b = new Edge(1, cities.getKanC(), cities.getOmh(), "grey", false);
        Edge _65 = new Edge(2, cities.getOmh(), cities.getDul(), "grey", false);
        Edge _65b = new Edge(2, cities.getOmh(), cities.getDul(), "grey", false);
        Edge _66 = new Edge(3, cities.getDul(), cities.getStm(), "grey", false);
        Edge _67 = new Edge(6, cities.getWinn(), cities.getStm(), "grey", false);
        Edge _68 = new Edge(4, cities.getDul(), cities.getWinn(), "black", false);
        Edge _69 = new Edge(6, cities.getDul(), cities.getHel(), "orange", false);
        Edge _70 = new Edge(5, cities.getOmh(), cities.getHel(), "red", false);
        Edge _71 = new Edge(4, cities.getOmh(), cities.getDvr(), "pink", false);
        Edge _72 = new Edge(4, cities.getKanC(), cities.getDvr(), "orange", false);
        Edge _72b = new Edge(4, cities.getKanC(), cities.getDvr(), "black", false);
        Edge _73 = new Edge(4, cities.getDvr(), cities.getOmhC(), "red", false);
        Edge _74 = new Edge(3, cities.getOmhC(), cities.getSanFe(), "blue", false);
        Edge _75 = new Edge(2, cities.getSanFe(), cities.getDvr(), "grey", false);
        Edge _76 = new Edge(4, cities.getDvr(), cities.getHel(), "green", false);
        Edge _77 = new Edge(3, cities.getSlc(), cities.getHel(), "pink", false);

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
