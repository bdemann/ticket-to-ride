package shared.model;

import java.util.List;

/**
 * Created by paulinecausse on 2/28/18.
 */

public interface IRoute {
    void setEdges(List<Edge> edges);

    void setLength(int length);

    void setStart(String start);

    void setEnd(String end);

    List<Edge> getEdges();

    int getLength();

    String getStart();

    String getEnd();
}
