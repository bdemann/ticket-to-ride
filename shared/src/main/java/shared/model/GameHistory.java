package shared.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bdemann on 2/28/18.
 */

public class GameHistory {
    private List<GameEvent> history;

    public GameHistory(){
        history = new ArrayList<>();
    }

    public void addEvent(GameEvent event){
        history.add(event);
    }
}
