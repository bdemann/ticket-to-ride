package shared.server.facades;

/**
 * Created by Ben on 2/6/2018.
 */

public interface ILoginServerFacade {
    public boolean login(String username, String password);
    public boolean register(String username, String password);
}
