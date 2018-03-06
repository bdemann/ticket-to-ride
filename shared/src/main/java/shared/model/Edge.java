package shared.model;

import java.io.Serializable;

import shared.model.interfaces.IEdge;

/**
 * Created by paulinecausse on 2/28/18.
 */

public class Edge implements IEdge, Serializable{
    private int _length;
    private City _start;
    private City _end;
//    private List<Block> _blocks;
    private Color _color;
    private boolean _claimed;

    public Edge(int length, City start, City end, Color color, boolean claimed){
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

    public void setColor(Color color){ this._color = color; }

    public int getLength(){ return _length; }

    public City getStart(){ return _start; }

    public City getEnd(){ return _end; }

//    public List<Block> getBlocks(){ return _blocks; }

    public Color getColor(){ return _color; }

    @Override
    public int getValue() {
        switch (_length){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 10;
            case 6:
                return 15;
        }
        return 0;
    }
}
