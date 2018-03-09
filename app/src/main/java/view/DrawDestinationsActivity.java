package view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.a340team.tickettoride.R;

import java.util.ArrayList;
import java.util.List;

import model.ClientRoot;
import presenter.DrawDestinationsPresenter;
import presenter.IDrawDestinationsPresenter;
import shared.model.CardSet;
import shared.model.DestCard;


/**
 * activity for drawing dest cards
 * Created by BenNelson on 3/6/18.
 */

public class DrawDestinationsActivity extends AppCompatActivity implements IDrawDestinationsView {

    private ImageButton _destCardOne;
    private ImageButton _destCardTwo;
    private ImageButton _destCardThree;
    private Button _confirm;
    private List<Integer> _chosenCards = new ArrayList<>();
    private IDrawDestinationsPresenter _destinationsPresenter;
    static int FIRST_CARD = 1;
    static int SECOND_CARD = 2;
    static int THIRD_CARD = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_cards);
        boolean isStartOfGame = this.getIntent().getBooleanExtra(ViewUtilities.GAME_START, true);

        _initializePresenter();
        _initializeButtons(isStartOfGame);
        _initializeDestCards(isStartOfGame);
        _createListeners();


    }

    //This method will show the client what cards to choose from
    private void _initializeDestCards(boolean isStartOfGame) {
        if(isStartOfGame){
            //We need to get the right cards from the presenter.
            List<DestCard> destCards = _destinationsPresenter.getStarterDestinationCards();
            _displayDestinationCards(destCards);

        }
        //It's not the start of the game, so we need to draw
        else{
            List<DestCard> destCards = _destinationsPresenter.drawDestinationCards();
            _displayDestinationCards(destCards);
        }
    }

    private void _displayDestinationCards(List<DestCard> destCards) {
        ArrayList<Integer> imagePaths = ViewUtilities.createDestCardImagePaths(destCards);
        _destCardOne.setImageResource(imagePaths.get(0));
        _destCardTwo.setImageResource(imagePaths.get(1));
        _destCardThree.setImageResource(imagePaths.get(2));
    }

    //Just make the buttons
    private void _initializeButtons(boolean isStartOfGame) {
        _destCardOne = (ImageButton) findViewById(R.id.destCard1);
        _destCardTwo = (ImageButton) findViewById(R.id.destCard2);
        _destCardThree = (ImageButton) findViewById(R.id.destCard3);
        _confirm = (Button) findViewById(R.id.draw_destinations_confirm);

        if(!isStartOfGame){
            TextView instructions = (TextView) findViewById(R.id.drawDestInstructions);
            instructions.setText(R.string.chooseAtLeastOneDestCard);
        }
    }

    private void _initializePresenter(){
        _destinationsPresenter = new DrawDestinationsPresenter();
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
                _chosenCards.add(FIRST_CARD);
            }
        });

        _destCardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lock the image button
                _destCardTwo.setEnabled(false);
                _destCardTwo.setColorFilter(tint); // Green Tint
                _chosenCards.add(SECOND_CARD);

            }
        });

        _destCardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lock the image button
                _destCardThree.setEnabled(false);
                _destCardThree.setColorFilter(tint); // Green Tint
                _chosenCards.add(THIRD_CARD);

            }
        });

        _confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send information to the server
                if(_chosenCards.size() > 1){
                    //Send the chosen cards onto the player, and the discard to the server

                    //TODO delete me, I was part of DEMO ---------------------------------|
                    CardSet s = ClientRoot.getClientPlayer().getUnresolvedDestCards();
                    List<DestCard> destList = s.cards;

                    if(!_chosenCards.contains(FIRST_CARD)){
                        destList.remove(0);
                    }
                    if(!_chosenCards.contains(SECOND_CARD)){
                        destList.remove(1);
                    }
                    if(!_chosenCards.contains(THIRD_CARD)){
                        destList.remove(2);
                    }
                    ClientRoot.getClientPlayer().setUnresolvedDestCards(destList);
                    ClientRoot.getClientPlayer().setDestCards(destList);
                    //END OF DELETE ME ---------------------------------------------------|

                    //Then finish the activity
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    activity.finish();
                }
                else{
                    ViewUtilities.displayMessage("You need at least 2.", view.getContext());
                }

            }
        });
    }

}
