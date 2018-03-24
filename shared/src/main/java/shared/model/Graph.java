package shared.model;

import java.util.ArrayList;
import java.util.List;

import shared.model.interfaces.IGraph;

/**
 * Created by paulinecausse on 3/24/18.
 */

public class Graph implements IGraph{
    //list of a player's routes
    private List<Route> edges;
    //cities that are part of a player's routes
    //each city has a list of out-going edges
    private List<City> vertices;

    public Graph(List<Route> edges, List<City> vertex){
        this.edges = edges;
        this.vertices = vertex;

        setOutGoingEdged();
    }

    @Override
    public void setOutGoingEdged(){
        for(City city:vertices){
            String cityName = city.get_name();
            for(Route edge:edges){
                if(edge.getStart().get_name().equals(cityName)){
                    city.addOutGoingEdge(edge);
                }
            }
        }
    }

    @Override
    public List<City> getVertices(){
        return vertices;
    }

    @Override
    public List<Route> getEdges(){
        return edges;
    }

}
