package view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.a340team.tickettoride.R;

import java.util.ArrayList;

public class GameSelection extends AppCompatActivity {

    private ArrayList<String> _gameList;
    private RecyclerView _recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selection);

        _gameList = new ArrayList<>();

        _recyclerView = (RecyclerView) findViewById(R.id.GameRecycler);

        GameListRecyclerAdapter adapter = new GameListRecyclerAdapter(_gameList);
        _recyclerView.setAdapter(adapter);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setTitle("Select a Game");
    }
}
