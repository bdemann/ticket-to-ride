package shared.model;

import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * Created by paulinecausse on 2/28/18.
 */

public interface IEdge {
    void setLength(int length);

    void setStart(String start);

    void setEnd(String end);

    void setBlocks(List<Block> blocks);

    void setColor(String color);

    int getLength();

    String getStart();

    String getEnd();

    List<Block> getBlocks();

    String getColor();
}
