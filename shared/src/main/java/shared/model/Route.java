package shared.model;

import java.util.List;

import shared.model.interfaces.IRoute;

/**
 * Created by BenNelson on 2/2/18.
 */
public class Route implements IRoute {
    private List<Edge> _edges;
    private int _length;
    private City _start;
    private City end;

    public Route(){}

    @Override
    public void setEdges(List<Edge> edges){ this._edges = edges; }

    @Override
    public void setLength(int length){ this._length = length; }

    @Override
    public void setStart(City start){this._start = start; }

    @Override
    public void setEnd(City end){this.end = end; }

    @Override
    public List<Edge> getEdges(){ return _edges; }

    @Override
    public int getLength(){ return _length; }

    @Override
    public City getStart(){ return _start; }

    @Override
    public City getEnd(){ return end; }
}
