package presenter;

import view.LoginActivity;

/**
 *
 * Created by mikeporet on 2/5/18.
 */

public class LoginPresenter implements ILoginPresenter {



    private static LoginPresenter _instance;

    public static LoginPresenter instance() {

        if (_instance == null)
            _instance = new LoginPresenter();

        return _instance;
    }

    private LoginPresenter() { }

    //Makes the singleton code a little cleaner
    public static void signIn(){
        LoginPresenter.instance()._signIn();
    }




    @Override
    public void _registerPasswordChanged() {

    }

    @Override
    public void _confirmPasswordChanged() {

    }

    @Override
    public void _signIn() {
        //Since this is called, we need to get the sign in information from the view
        //then we can communicate with the LoginGuiFacade


    }

    @Override
    public void _register() {

    }
}
