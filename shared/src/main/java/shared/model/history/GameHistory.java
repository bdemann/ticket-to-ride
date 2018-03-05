package shared.model.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import shared.model.history.events.GameEvent;

/**
 * Created by bdemann on 2/28/18.
 */

public class GameHistory implements Serializable{
    private List<GameEvent> history;

    public GameHistory(){
        history = new ArrayList<>();
    }

    public void addEvent(GameEvent event){
        history.add(event);
    }
}
