package shared.model.history.events;

import java.io.Serializable;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameEvent implements Serializable{
    private String username;
    private String event;

    public GameEvent(String username, String event) {
        this.username = username;
        this.event = event;
    }

    public String toString(){
        return this.username + ": " + this.event;
    }
}
