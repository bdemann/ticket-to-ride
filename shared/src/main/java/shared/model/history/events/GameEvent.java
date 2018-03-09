package shared.model.history.events;

import java.io.Serializable;

import shared.model.interfaces.Message;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameEvent implements Serializable, Message{
    private String username;
    private String event;
    private long time;

    public GameEvent(String username, String event, long time) {
        this.username = username;
        this.event = event;
        this.time = time;
    }

    public String toString(){
        return this.username + ": " + this.event;
    }

    @Override
    public String getMessage() {
        return event;
    }

    @Override
    public long getTime() {
        return time;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
