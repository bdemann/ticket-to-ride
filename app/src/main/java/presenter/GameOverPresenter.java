package presenter;

import java.util.Observable;
import java.util.Observer;

import view.GameOverActivity;

/**
 * Created by mikeporet on 3/23/18.
 */


public class GameOverPresenter implements Observer{

    GameOverActivity activity;

    public GameOverPresenter(GameOverActivity activity) {
        this.activity = activity;
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
