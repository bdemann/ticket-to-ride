package presenter;

import android.content.Context;
import android.content.Intent;

import java.util.Observable;
import java.util.Observer;

import guifacade.LoginGuiFacade;
import model.ClientRoot;
import view.GameSelectionActivity;

/**
 *
 * Created by Ben Nelson on 2/5/18.
 */

public class LoginPresenter implements ILoginPresenter, Observer {

    private ClientRoot _clientRoot;
    private Context _context;

    public LoginPresenter(ClientRoot clientRoot, Context appContext){
        this._clientRoot = clientRoot;
        this._context = appContext;

    }

    @Override
    public void update(Observable obs, Object o) {

        System.out.println("Login Presenter Update called\n");

        if(ClientRoot.getClientPlayer() != null && ClientRoot.getClientGame() == null){
            _getGamesList(ClientRoot.getClientPlayer().getUsername());
            Intent intent = new Intent(_context, GameSelectionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(intent);
        }
        else{
            System.out.println("Didn't do anything in the Login Presenter");
        }
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


    private String _getGamesList(String username){

        return LoginGuiFacade.getGamesList(username);
    }

}
