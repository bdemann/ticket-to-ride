package presenter;

import java.util.Observable;
import java.util.Observer;

import model.ClientRoot;
import shared.model.Player;
import view.LoginActivity;

/**
 *
 * Created by Ben Nelson on 2/5/18.
 */

public class LoginPresenter implements ILoginPresenter, Observer {

    private ClientRoot _clientRoot;

    public LoginPresenter(ClientRoot clientRoot){
        this._clientRoot = clientRoot;
    }

    @Override
    public void update(Observable obs, Object o) {

        System.out.println("Update called\n");
        /*if(o instanceof Player)
        {
            System.out.println("Object was player\n");
        }*/
    }

    @Override
    public void registerPasswordChanged() {

    }

    @Override
    public void confirmPasswordChanged() {

    }

    @Override
    public void signIn(String username, String password) {
        //Since this is called, we need to get the sign in information from the view
        //then we can communicate with the LoginGuiFacade
        //System.out.println("USERNAME: " + username + "\n");
        //System.out.println("PASSWORD: " + password + "\n");
        Player p = new Player(username, password);

        _clientRoot.setClientPlayer(p);
    }

    @Override
    public void register() {

    }

}
