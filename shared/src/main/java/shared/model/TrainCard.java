package shared.model;
/**
 * Created by BenNelson on 2/2/18.
 */
public class TrainCard implements ITrainCard{
    private String _color;
    private int _actionWeight;

    public TrainCard(String color,int actionWeight) {
        this._color = color;
        this._actionWeight = actionWeight;
    }

    public TrainCard(){

    }

    @Override
    public void setColor(String color){
        this._color = color;
    }

    @Override
    public String getColor(){
        return _color;
    }

    @Override
    public void setActionWeight(int actionWeight){
        this._actionWeight = actionWeight;
    }

    @Override
    public int getActionWeight(){
        return _actionWeight;
    }
}
