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

import com.a340team.tickettoride.R;

import java.util.ArrayList;

public class GameLobbyActivity extends AppCompatActivity implements IGameLobbyActivity{

    private RecyclerView _recycler;
    private EditText _chatText;
    private ImageButton _sendButton;
    private Button _startGameButton;
    private TextView _playerList;
    private String _gameID;
    ArrayList<String> player_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);

        _gameID = getIntent().getStringExtra("GameID");

        _recycler = (RecyclerView) findViewById(R.id.chat_recycler);
        _chatText = (EditText) findViewById(R.id.chat_text);
        _sendButton = (ImageButton) findViewById(R.id.send_button);
        _startGameButton = (Button) findViewById(R.id.start_game_button);
        _playerList = (TextView) findViewById(R.id.current_players);

        _makeOnClickListeners();

        //Put Game name in title bar
        setTitle("Game: " + getIntent().getStringExtra("GameName"));
    }

    @Override
    public void _makeOnClickListeners(){
        _startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), GameAcitvity.class);
            startActivity(intent);
            }
        });
    }

    @Override
    public void UpdatePlayerList(String players) {
        _playerList.setText(players);
    }
}
