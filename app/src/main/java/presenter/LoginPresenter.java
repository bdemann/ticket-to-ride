package presenter;

import android.content.Context;

import java.util.Observable;
import java.util.Observer;

import guifacade.LoginGuiFacade;
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
    public String signIn(String username, String password) {

        return LoginGuiFacade.signIn(username, password);
    }


    @Override
    public String register(String username, String password) {

        return LoginGuiFacade.register(username,password);
    }

}
