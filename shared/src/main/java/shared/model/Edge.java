package shared.model;

/**
 * Created by paulinecausse on 2/28/18.
 */

public class Edge implements IEdge {
    private int _length;
    private City _start;
    private City _end;
//    private List<Block> _blocks;
    private String _color;
    private boolean _claimed;

    public Edge(int length, City start, City end, String color, boolean claimed){
        this._color = color;
        this._start = start;
        this._end = end;
        this._length = length;
        this._claimed = claimed;
    }




    public void setLength(int length){ this._length = length; }

    public void setStart(City start){ this._start = start; }

    public void setEnd(City end){ this._end = end; }

//    public void setBlocks(List<Block> blocks){ this._blocks = blocks; }

    public void setColor(String color){ this._color = color; }

    public int getLength(){ return _length; }

    public City getStart(){ return _start; }

    public City getEnd(){ return _end; }

//    public List<Block> getBlocks(){ return _blocks; }

    public String getColor(){ return _color; }
}
