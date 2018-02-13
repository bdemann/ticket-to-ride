package view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.a340team.tickettoride.R;

import java.util.ArrayList;

import model.ClientRoot;
import presenter.GameSelectionPresenter;

public class GameSelectionActivity extends AppCompatActivity implements IGameSelection{

    private ArrayList<String> _gameNameList;
    private ArrayList<Integer> _gameIDList;
    private ArrayList<String> _gameNumPlayersList;
    private RecyclerView _recyclerView;
    private Button _createGameButton;
    private GameSelectionPresenter _gameSelectionPresenter;

    //Adapter
    private GameListRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selection);

        _setUpObserver();

        _gameNameList = new ArrayList<>();
        _gameIDList = new ArrayList<>();
        _gameNumPlayersList = new ArrayList<>();

        _recyclerView = (RecyclerView) findViewById(R.id.GameRecycler);
        _createGameButton = (Button) findViewById(R.id.create_new_game_button);

        adapter = new GameListRecyclerAdapter(_gameNameList, _gameIDList, _gameNumPlayersList, _gameSelectionPresenter);
        _recyclerView.setAdapter(adapter);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));


        _createGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateGameActivity.class);
                startActivity(intent);
            }
        });

        setTitle("Select a Game");
    }

    private void _setUpObserver(){
        ClientRoot root = ClientRoot.instance();
        _gameSelectionPresenter = new GameSelectionPresenter(root, this);
        root.addObserver(_gameSelectionPresenter);

    }

    public void updateGameList(ArrayList<String> _gameList, ArrayList<Integer> _gameIDList, ArrayList<String> _gameNumPlayersList){
        adapter.updateGameList(_gameList,_gameIDList,_gameNumPlayersList);
    }

    public void goToGameLobby(){
        Intent intent = new Intent(this, GameLobbyActivity.class);
        startActivity(intent);
    }
}
