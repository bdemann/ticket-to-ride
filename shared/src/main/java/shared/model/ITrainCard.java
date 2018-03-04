package shared.model;

/**
 * Created by paulinecausse on 2/28/18.
 */

public interface ITrainCard extends Card {
    void setColor(Color color);

    void setActionWeight(int actionWeight);

    int getActionWeight();

    Color getColor();
}
