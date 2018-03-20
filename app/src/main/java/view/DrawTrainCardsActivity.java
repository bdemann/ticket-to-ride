package view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.a340team.tickettoride.R;

import java.util.concurrent.ThreadLocalRandom;

import model.ClientRoot;
import presenter.DrawTrainCardsPresenter;
import shared.model.Color;
import shared.model.TrainCard;
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
    private int _trainCardsDrawn;
    private DrawTrainCardsPresenter _presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the drawn cards to zero
        _trainCardsDrawn = 0;
        setContentView(R.layout.activity_draw_trains);
        _initializePresenter();
        _initializeImageButtons(ClientRoot.getClientGameInfo());
        _createOnClickListeners();

    }

    private void _initializePresenter(){
        _presenter = new DrawTrainCardsPresenter(this);
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
                drawFaceUpCard(1);
            }
        });

        _trainCardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawFaceUpCard(2);
            }
        });

        _trainCardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawFaceUpCard(3);
            }
        });

        _trainCardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawFaceUpCard(4);
            }
        });

        _trainCardFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawFaceUpCard(5);
            }
        });

        _trainCardDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawCardFromDeck();
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

    //DELETE THIS LATER...THIS IS JUST FOR PHASE 2 PASS OFF ANIMATION
    private int _tempGetRandomDrawable() {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int min = 1;
        int max = 9;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        if (randomNum == 1) {
            return R.drawable.black;
        } else if (randomNum == 2) {
            return R.drawable.blue;
        } else if (randomNum == 3) {
            return R.drawable.green;
        } else if (randomNum == 4) {
            return R.drawable.orange;
        } else if (randomNum == 5) {
            return R.drawable.yellow;
        } else if (randomNum == 6) {
            return R.drawable.white;
        } else if (randomNum == 7) {
            return R.drawable.red;
        } else if (randomNum == 8) {
            return R.drawable.pink;
        } else {//RAINBOW
            return R.drawable.rainbow;
        }
    }

    //EDIT THIS LATER...STRICTLY IMPLEMENTED FOR PHASE 2 PASS OFF
    @Override
    public void drawFaceUpCard(int cardNum) {
        //TEMPORARY FOR PASS OFF
        if(!(_trainCardsDrawn > 2)) {
            _presenter.drawFaceUpCard(cardNum);
//            if (cardNum == 1) {
//                _trainCardOne.setImageResource(_tempGetRandomDrawable());
//            }
//            if (cardNum == 2) {
//                _trainCardTwo.setImageResource(_tempGetRandomDrawable());
//            }
//            if (cardNum == 3) {
//                _trainCardThree.setImageResource(_tempGetRandomDrawable());
//            }
//            if (cardNum == 4) {
//                _trainCardFour.setImageResource(_tempGetRandomDrawable());
//            }
//            if (cardNum == 5) {
//                _trainCardFive.setImageResource(_tempGetRandomDrawable());
//            }

            //Alert the user they drew a card
            _trainCardsDrawn++;
            ViewUtilities.displayMessage(Integer.toString(_trainCardsDrawn) + " Cards Drawn.", this);
        }
        else {
            ViewUtilities.displayMessage("You've drawn enough.", this);
        }
    }

    @Override
    public void drawCardFromDeck() {
        //TODO we should make these the same kind of name
        _presenter.drawFaceDownCard();
    }
}
