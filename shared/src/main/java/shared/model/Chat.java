package shared.model;

/**
 * Created by Ben on 2/6/2018.
 */

public class Chat {
    private Player speaker;
    private String message;
    private long time;

    public IPlayer getSpeaker() {
        return speaker;
    }
}
