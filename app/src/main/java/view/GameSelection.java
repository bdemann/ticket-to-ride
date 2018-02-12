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

public class GameSelection extends AppCompatActivity implements IGameSelection{

    private ArrayList<String> _gameList;
    private RecyclerView _recyclerView;
    private Button _createGameButton;
    private Button _joinGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selection);

        _gameList = new ArrayList<>();

        _recyclerView = (RecyclerView) findViewById(R.id.GameRecycler);
        _createGameButton = (Button) findViewById(R.id.create_new_game_button);
        _joinGameButton = (Button) findViewById(R.id.join_game_button);

        GameListRecyclerAdapter adapter = new GameListRecyclerAdapter(_gameList);
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
}
