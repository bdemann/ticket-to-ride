package view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.a340team.tickettoride.R;

import model.ClientRoot;

/**
 * activity for drawing dest cards
 * Created by BenNelson on 3/6/18.
 */

public class DrawDestinationsActivity extends AppCompatActivity implements IDrawDestinationsView {

    private ImageButton _destCardOne;
    private ImageButton _destCardTwo;
    private ImageButton _destCardThree;
    private Button _confirm;
    private TextView _instructions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_cards);
        boolean isStartOfGame = this.getIntent().getBooleanExtra(ViewUtilities.GAME_START, true);
        if(isStartOfGame){
            System.out.println("WAS THE START OF THE GAME");
        }
        _initializeButtons(isStartOfGame);
        _createListeners();


    }

    //Just make the buttons
    private void _initializeButtons(boolean isStartOfGame) {
        _destCardOne = (ImageButton) findViewById(R.id.destCard1);
        _destCardTwo = (ImageButton) findViewById(R.id.destCard2);
        _destCardThree = (ImageButton) findViewById(R.id.destCard3);
        _confirm = (Button) findViewById(R.id.draw_destinations_confirm);
        _instructions = (TextView) findViewById(R.id.drawDestInstructions);

        if(!isStartOfGame){
            _instructions.setText(R.string.chooseAtLeastOneDestCard);
        }
    }

    //Make the listeners for the image buttons
    private void _createListeners() {
        final int tint = Color.argb(128, 0, 200, 0);
        _destCardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lock the image button
                _destCardOne.setEnabled(false);
                _destCardOne.setColorFilter(tint); // Green Tint
            }
        });

        _destCardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lock the image button
                _destCardTwo.setEnabled(false);
                _destCardTwo.setColorFilter(tint); // Green Tint

            }
        });

        _destCardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lock the image button
                _destCardThree.setEnabled(false);
                _destCardThree.setColorFilter(tint); // Green Tint

            }
        });

        _confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send information to the server

                //Then finish the activity
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.finish();
            }
        });
    }

}
