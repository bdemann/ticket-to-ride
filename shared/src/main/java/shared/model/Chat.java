package shared.model;

import java.io.Serializable;

import shared.model.interfaces.IPlayer;
import shared.model.interfaces.Message;

/**
 * Created by Ben on 2/6/2018.
 */

public class Chat implements Serializable, Message {
    private IPlayer speaker;
    private String message;
    private long time;

    public Chat(IPlayer speaker, String message, long time) {
        this.speaker = speaker;
        this.message = message;
        this.time = time;
    }

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
