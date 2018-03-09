package shared.model;

import java.io.Serializable;

import shared.model.interfaces.IPlayer;
import shared.model.interfaces.Message;

/**
 * Created by Ben on 2/6/2018.
 */

public class Chat implements Serializable, Message {
    private Player speaker;
    private String message;
    private long time;

    public IPlayer getSpeaker() {
        return speaker;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public long getTime() {
        return time;
    }

    @Override
    public String getUsername() {
        return speaker.getUsername();
    }
}
