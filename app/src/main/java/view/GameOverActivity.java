package view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.a340team.tickettoride.R;

public class GameOverActivity extends AppCompatActivity {

    //Fields for all of the widgets
    TextView player_1;
    TextView player_2;
    TextView player_3;
    TextView player_4;
    TextView player_5;
    TextView player_1_dest;
    TextView player_2_dest;
    TextView player_3_dest;
    TextView player_4_dest;
    TextView player_5_dest;
    TextView player_1_udest;
    TextView player_2_udest;
    TextView player_3_udest;
    TextView player_4_udest;
    TextView player_5_udest;
    TextView player_1_claimed;
    TextView player_2_claimed;
    TextView player_3_claimed;
    TextView player_4_claimed;
    TextView player_5_claimed;
    TextView player_1_long;
    TextView player_2_long;
    TextView player_3_long;
    TextView player_4_long;
    TextView player_5_long;
    TextView player_1_total;
    TextView player_2_total;
    TextView player_3_total;
    TextView player_4_total;
    TextView player_5_total;
    Button done_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        intializeViews();


    }

    private void intializeViews(){

        player_1 = (TextView) findViewById(R.id.go_player1);
        player_2 = (TextView) findViewById(R.id.go_player2);
        player_3 = (TextView) findViewById(R.id.go_player3);
        player_4 = (TextView) findViewById(R.id.go_player4);
        player_5 = (TextView) findViewById(R.id.go_player5);
        player_1_dest = (TextView) findViewById(R.id.player_1_dest);
        player_2_dest = (TextView) findViewById(R.id.player_2_dest);
        player_3_dest = (TextView) findViewById(R.id.player_3_dest);
        player_4_dest = (TextView) findViewById(R.id.player_4_dest);
        player_5_dest = (TextView) findViewById(R.id.player_5_dest);
        player_1_udest = (TextView) findViewById(R.id.player_1_udest);
        player_2_udest = (TextView) findViewById(R.id.player_2_udest);
        player_3_udest = (TextView) findViewById(R.id.player_3_udest);
        player_4_udest = (TextView) findViewById(R.id.player_4_udest);
        player_5_udest = (TextView) findViewById(R.id.player_5_udest);
        player_1_claimed = (TextView) findViewById(R.id.player_1_claimed);
        player_2_claimed = (TextView) findViewById(R.id.player_2_claimed);
        player_3_claimed = (TextView) findViewById(R.id.player_3_claimed);
        player_4_claimed = (TextView) findViewById(R.id.player_4_claimed);
        player_5_claimed = (TextView) findViewById(R.id.player_5_claimed);
        player_1_long = (TextView) findViewById(R.id.player_1_long);
        player_2_long = (TextView) findViewById(R.id.player_2_long);
        player_3_long = (TextView) findViewById(R.id.player_3_long);
        player_4_long = (TextView) findViewById(R.id.player_4_long);
        player_5_long = (TextView) findViewById(R.id.player_5_long);
        player_1_total = (TextView) findViewById(R.id.player_1_total);
        player_2_total = (TextView) findViewById(R.id.player_2_total);
        player_3_total = (TextView) findViewById(R.id.player_3_total);
        player_4_total = (TextView) findViewById(R.id.player_4_total);
        player_5_total = (TextView) findViewById(R.id.player_5_total);
        done_button = (Button) findViewById(R.id.game_over_done);
    }
}
