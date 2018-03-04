package shared.model.interfaces;

import java.util.List;

import shared.model.City;
import shared.model.Edge;

/**
 * Created by paulinecausse on 2/28/18.
 */

public interface IRoute {
    void setEdges(List<Edge> edges);

    void setLength(int length);

    void setStart(City start);

    void setEnd(City end);

    List<Edge> getEdges();

    int getLength();

    City getStart();

    City getEnd();
}
