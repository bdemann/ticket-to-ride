package presenter;

import java.util.Observable;
import java.util.Observer;

import model.ClientRoot;
import view.GameSelectionActivity;

/**
 *
 * Created by BenNelson on 2/12/18.
 */

public class GameSelectionPresenter implements Observer{

    private ClientRoot _clientRoot;
    private GameSelectionActivity _gameSelectionActivity;


    public GameSelectionPresenter(ClientRoot clientRoot, GameSelectionActivity gameSelectionActivity){

        this._clientRoot = clientRoot;
        this._gameSelectionActivity = gameSelectionActivity;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Game Selection Update called\n");
    }


}
