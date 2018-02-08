package presenter;

import view.LoginActivity;

/**
 *
 * Created by mikeporet on 2/5/18.
 */

public class LoginPresenter implements ILoginPresenter {


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
        System.out.println("USERNAME: " + username + "\n");
        System.out.println("PASSWORD: " + password + "\n");
    }

    @Override
    public void register() {

    }
}
