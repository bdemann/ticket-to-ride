package view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.a340team.tickettoride.R;

import model.ClientRoot;
import poller.Poller;

public class ServerDownActivity extends AppCompatActivity {

    Button try_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_down);
        try_again = (Button) findViewById(R.id.try_button);
        try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ClientRoot.isServerDown()){
                    finish();
                }
                else{
                    ViewUtilities.displayMessage("Nope... The server is still down", view.getContext());
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!ClientRoot.isServerDown()){
            finish();
        }
        else{
            ViewUtilities.displayMessage("Nope... The server is still down", this);
        }
    }
}