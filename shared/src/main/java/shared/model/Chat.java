package shared.model;

import java.io.Serializable;

import shared.model.interfaces.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public class Chat implements Serializable {
    private Player speaker;
    private String message;
    private long time;

    public IPlayer getSpeaker() {
        return speaker;
    }
}
