package view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.a340team.tickettoride.R;

import java.util.ArrayList;

import model.ClientRoot;
import presenter.GameLobbyPresenter;

public class GameLobbyActivity extends AppCompatActivity implements IGameLobbyActivity{

    private RecyclerView _recycler;
    private EditText _chatText;
    private ImageButton _sendButton;
    private Button _startGameButton;
    private TextView _playerList;
    private String _gameID;
    ArrayList<String> player_names;

    private GameLobbyPresenter _gameLobbyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);

        //Setup _gameLobbyPresenter
        _gameLobbyPresenter = new GameLobbyPresenter(this);
        ClientRoot.addClientRootObserver(_gameLobbyPresenter);

        _gameID = getIntent().getStringExtra("GameID");

        _recycler = (RecyclerView) findViewById(R.id.chat_recycler);
        _chatText = (EditText) findViewById(R.id.chat_text);
        _sendButton = (ImageButton) findViewById(R.id.send_button);
        _startGameButton = (Button) findViewById(R.id.start_game_button);
        _playerList = (TextView) findViewById(R.id.current_players);

        _makeOnClickListeners();

        _gameLobbyPresenter.listGame();
        _gameLobbyPresenter.listPlayers();


    }

    @Override
    public void _makeOnClickListeners(){
        _startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_gameLobbyPresenter.checkNumPlayers()) {
                    //Alert others that the game will begin.
                    _gameLobbyPresenter.startGame();

                   startGame();
                }
                else{
                    Toast toast = Toast.makeText(view.getContext(), "Not enough players!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    @Override
    public void updateGameName(String name){
        setTitle(name);
    }

    @Override
    public void updatePlayerList(String players) {

        //This gets called by the _gameLobbyPresenter. It is called with a string listing the players
        //separated by commas "Player One, Player Two, Player Three...."
        _playerList.setText(players);
    }

    @Override
    public void onBackPressed(){
        String message = _gameLobbyPresenter.leaveGame();
        _displayMessage(message);
    }

    private void _displayMessage(String message) {
        //Just pop up a toast letting the user know what happened
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), message, duration);
        toast.show();
    }

    @Override
    public void startGame() {
        _gameLobbyPresenter.startGame();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
