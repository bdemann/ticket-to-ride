package view;

/**
 *
 * Created by BenNelson on 2/6/18.
 */

public interface ILoginView {

    void enableSignIn(boolean enabled);
    void enableRegister(boolean enabled);
    void setUsername(String username);
    void setPassword(String password);
    String getUsernameSignIn();
    String getPasswordSignIn();
    String getUsernameRegister();
    String getPasswordRegister();
    void displayMessage(String message);


}
