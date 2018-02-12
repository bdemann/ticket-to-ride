package presenter;

import android.content.Context;

import java.util.Observable;
import java.util.Observer;

import guifacade.CreateGameGuiFacade;
import model.ClientRoot;

/**
 * Created by mikeporet on 2/11/18.
 */

public class CreateGamePresenter implements ICreateGamePresenter, Observer {

    private ClientRoot _clientRoot;
    private Context _context;

    public CreateGamePresenter(){
//        this._clientRoot = clientRoot;
//        this._context = appContext;

    }

    @Override
    public void update(Observable obs, Object o) {

        System.out.println("Update called\n");

//        if(_clientRoot.getClientPlayer() != null && _clientRoot.getClientGame() == null){
//            Intent intent = new Intent(_context, GameSelectionActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            _context.startActivity(intent);
//        }
    }

    @Override
    public void createGame(int numberPlayer){
        CreateGameGuiFacade.createGame(numberPlayer);

    }

}

