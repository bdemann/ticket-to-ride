package view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.a340team.tickettoride.R;

/**
 *
 * Created by BenNelson on 3/6/18.
 */

public class DrawTrainCardsActivity extends AppCompatActivity{

    private ImageButton _trainCardOne;
    private ImageButton _trainCardTwo;
    private ImageButton _trainCardThree;
    private ImageButton _trainCardFour;
    private ImageButton _trainCardFive;
    private ImageButton _trainCardDeck;
    private Button _done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_trains);

        _initializeButtons();
        _createOnClickListeners();

    }

    private void _initializeButtons(){
        _trainCardOne = (ImageButton) findViewById(R.id.train_card_one);
        _trainCardTwo = (ImageButton) findViewById(R.id.train_card_two);
        _trainCardThree = (ImageButton) findViewById(R.id.train_card_three);
        _trainCardFour = (ImageButton) findViewById(R.id.train_card_four);
        _trainCardFive = (ImageButton) findViewById(R.id.train_card_five);
        _trainCardDeck = (ImageButton) findViewById(R.id.train_card_deck);
        _done = (Button) findViewById(R.id.train_cards_done_button);

    }

    private void _createOnClickListeners() {
        _trainCardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _trainCardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _trainCardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _trainCardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _trainCardFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _trainCardDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
