package presenter;

/**
 *
 * Created by BenNelson on 2/6/18.
 */

public interface ILoginPresenter {

    void _registerPasswordChanged();
    void _confirmPasswordChanged();
    void _signIn(String username, String password);
    void _register();
}
