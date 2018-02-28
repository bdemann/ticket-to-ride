package shared.model;

import java.util.List;

/**
 * Created by paulinecausse on 2/28/18.
 */

public class Edge implements IEdge {
    private int _length;
    private String _start;
    private String _end;
    private List<Block> _blocks;
    private String _color;

    public Edge(int length, String start, String end, String color){
        this._color = color;
        this._start = start;
        this._end = end;
        this._length = length;
    }

    public void setLength(int length){ this._length = length; }

    public void setStart(String start){ this._start = start; }

    public void setEnd(String end){ this._end = end; }

    public void setBlocks(List<Block> blocks){ this._blocks = blocks; }

    public void setColor(String color){ this._color = color; }

    public int getLength(){ return _length; }

    public String getStart(){ return _start; }

    public String getEnd(){ return _end; }

    public List<Block> getBlocks(){ return _blocks; }

    public String getColor(){ return _color; }
}
