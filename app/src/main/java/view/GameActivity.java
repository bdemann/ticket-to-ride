package view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.a340team.tickettoride.R;

public class GameActivity extends AppCompatActivity {

    Button portland;
    Button miami;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_acitvity);

        portland = (Button) findViewById(R.id.portland);
        miami = (Button) findViewById(R.id.miami);

        portland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Portland", Toast.LENGTH_SHORT);

                toast.show();
            }
        });

        miami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Miami", Toast.LENGTH_SHORT);

                toast.show();
            }
        });

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // MotionEvent object holds X-Y values
//        if(event.getAction() == MotionEvent.ACTION_DOWN) {
//            String text = "You click at x = " + event.getX() + " and y = " + event.getY();
//            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
//        }
//
//        return super.onTouchEvent(event);
//    }
}
