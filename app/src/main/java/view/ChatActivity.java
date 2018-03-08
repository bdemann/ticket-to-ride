package view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.a340team.tickettoride.R;

public class ChatActivity extends AppCompatActivity {

    ImageButton _sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        _sendButton = (ImageButton) findViewById(R.id.send_button);

    }
}
