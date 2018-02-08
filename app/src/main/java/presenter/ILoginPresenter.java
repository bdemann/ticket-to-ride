package presenter;

/**
 *
 * Created by BenNelson on 2/6/18.
 */

interface ILoginPresenter {

    void registerPasswordChanged();
    void confirmPasswordChanged();
    void signIn(String username, String password);
    void register(String username, String password);
}
