package view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.a340team.tickettoride.R;

import model.ClientRoot;
import shared.model.Color;
import shared.model.TrainCard;
import shared.model.TrainCardSet;
import shared.model.interfaces.IGameInfo;

/**
 *
 * Created by BenNelson on 3/6/18.
 */

public class DrawTrainCardsActivity extends AppCompatActivity implements IDrawTrainCardsView{

    private ImageButton _trainCardOne;
    private ImageButton _trainCardTwo;
    private ImageButton _trainCardThree;
    private ImageButton _trainCardFour;
    private ImageButton _trainCardFive;
    private ImageButton _trainCardDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_trains);
        _initializeImageButtons(ClientRoot.getClientGameInfo());
        _createOnClickListeners();

    }

    private void _initializeImageButtons(IGameInfo gameInfo){


        _trainCardOne = (ImageButton) findViewById(R.id.train_card_one);
        _trainCardTwo = (ImageButton) findViewById(R.id.train_card_two);
        _trainCardThree = (ImageButton) findViewById(R.id.train_card_three);
        _trainCardFour = (ImageButton) findViewById(R.id.train_card_four);
        _trainCardFive = (ImageButton) findViewById(R.id.train_card_five);
        _trainCardDeck = (ImageButton) findViewById(R.id.train_card_deck);

        TrainCard cardOne = gameInfo.getFaceUpCards().get(0);
        TrainCard cardTwo = gameInfo.getFaceUpCards().get(1);
        TrainCard cardThree = gameInfo.getFaceUpCards().get(2);
        TrainCard cardFour = gameInfo.getFaceUpCards().get(3);
        TrainCard cardFive = gameInfo.getFaceUpCards().get(4);

        _trainCardOne.setImageResource(_getCardImage(cardOne));
        _trainCardTwo.setImageResource(_getCardImage(cardTwo));
        _trainCardThree.setImageResource(_getCardImage(cardThree));
        _trainCardFour.setImageResource(_getCardImage(cardFour));
        _trainCardFive.setImageResource(_getCardImage(cardFive));
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
    }

    private int _getCardImage(TrainCard trainCard) {
        if (trainCard.getColor().equals(Color.BLACK)) {
            return R.drawable.black;
        } else if (trainCard.getColor().equals(Color.BLUE)) {
            return R.drawable.blue;
        } else if (trainCard.getColor().equals(Color.GREEN)) {
            return R.drawable.green;
        } else if (trainCard.getColor().equals(Color.ORANGE)) {
            return R.drawable.orange;
        } else if (trainCard.getColor().equals(Color.YELLOW)) {
            return R.drawable.yellow;
        } else if (trainCard.getColor().equals(Color.WHITE)) {
            return R.drawable.white;
        } else if (trainCard.getColor().equals(Color.RED)) {
            return R.drawable.red;
        } else if (trainCard.getColor().equals(Color.PINK)) {
            return R.drawable.pink;
        } else {//RAINBOW
            return R.drawable.rainbow;
        }
    }


    @Override
    public void drawFaceUpCard() {

    }

    @Override
    public void drawCardFromDeck() {

    }
}
