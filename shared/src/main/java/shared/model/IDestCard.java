package shared.model;

/**
 * Created by paulinecausse on 2/28/18.
 */

public interface IDestCard {
    boolean isCompleted();

    void setCompleted(boolean completed);

    int getPoints();

    void setPoints(int pointAmt);

    String getDestination();

    void setDestination(String destination);

    String getStartingPoint();

    void setStartingPoint(String startingPoint);
}
