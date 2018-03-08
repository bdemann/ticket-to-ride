package view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.a340team.tickettoride.R;

import java.util.List;
import java.util.Map;

import presenter.GameInfoPresenter;
import shared.model.TrainCard;
import shared.model.interfaces.IEdge;
import shared.model.interfaces.IGameInfo;

public class GameInfoActivity extends AppCompatActivity {

    private TextView _player1;
    private TextView _player2;
    private TextView _player3;
    private TextView _player4;
    private TextView _player5;

    private TextView _player1Points;
    private TextView _player2Points;
    private TextView _player3Points;
    private TextView _player4Points;
    private TextView _player5Points;

    private TextView _player1Trains;
    private TextView _player2Trains;
    private TextView _player3Trains;
    private TextView _player4Trains;
    private TextView _player5Trains;

    private TextView _player1Cards;
    private TextView _player2Cards;
    private TextView _player3Cards;
    private TextView _player4Cards;
    private TextView _player5Cards;

    private TextView _player1Routes;
    private TextView _player2Routes;
    private TextView _player3Routes;
    private TextView _player4Routes;
    private TextView _player5Routes;

    private TextView _redNumber;
    private TextView _greenNumber;
    private TextView _blueNumber;
    private TextView _orangeNumber;
    private TextView _yellowNumber;
    private TextView _pinkNumber;
    private TextView _blackNumber;
    private TextView _whiteNumber;
    private TextView _rainbowNumber;


    private GameInfoPresenter _gameInfoPresenter;

    private DestinationCardRecyclerAdapter _adapter;
    private RecyclerView _destinationRecycler;

    //Todo: Destinatin Cards as a Recycler View!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);

        _initializeGuiElements();
        _initializePresenter();
        _initializeInfo();
        _initializePlayerHand();
        _setUpRecycler();
    }

    private void _setUpRecycler(){
        _destinationRecycler = (RecyclerView) findViewById(R.id.destination_recycler);
        _adapter = new DestinationCardRecyclerAdapter(_gameInfoPresenter.getDestinationCards(),
                _gameInfoPresenter.getCompleteDestinations());
        _destinationRecycler.setAdapter(_adapter);
        _destinationRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void _initializePresenter(){
        _gameInfoPresenter = new GameInfoPresenter(this);
    }

    private void _initializeGuiElements(){
        _player1 = (TextView) findViewById(R.id.player1);
        _player2 = (TextView) findViewById(R.id.player2);
        _player3 = (TextView) findViewById(R.id.player3);
        _player4 = (TextView) findViewById(R.id.player4);
        _player5 = (TextView) findViewById(R.id.player5);

        _player1Points = (TextView) findViewById(R.id.player1_points);
        _player2Points = (TextView) findViewById(R.id.player2_points);
        _player3Points = (TextView) findViewById(R.id.player3_points);
        _player4Points = (TextView) findViewById(R.id.player4_points);
        _player5Points = (TextView) findViewById(R.id.player5_points);

        _player1Trains = (TextView) findViewById(R.id.player1_trains);
        _player2Trains = (TextView) findViewById(R.id.player2_trains);
        _player3Trains = (TextView) findViewById(R.id.player3_trains);
        _player4Trains = (TextView) findViewById(R.id.player4_trains);
        _player5Trains = (TextView) findViewById(R.id.player5_trains);

        _player1Cards = (TextView) findViewById(R.id.player1_cards);
        _player2Cards = (TextView) findViewById(R.id.player2_cards);
        _player3Cards = (TextView) findViewById(R.id.player3_cards);
        _player4Cards = (TextView) findViewById(R.id.player4_cards);
        _player5Cards = (TextView) findViewById(R.id.player5_cards);

        _player1Routes = (TextView) findViewById(R.id.player1_routes);
        _player2Routes = (TextView) findViewById(R.id.player2_routes);
        _player3Routes = (TextView) findViewById(R.id.player3_routes);
        _player4Routes = (TextView) findViewById(R.id.player4_routes);
        _player5Routes = (TextView) findViewById(R.id.player5_routes);

        _redNumber = (TextView) findViewById(R.id.red_number);
        _greenNumber = (TextView) findViewById(R.id.green_number);
        _blueNumber = (TextView) findViewById(R.id.blue_number);
        _pinkNumber = (TextView) findViewById(R.id.pink_number);
        _orangeNumber = (TextView) findViewById(R.id.orange_number);
        _yellowNumber = (TextView) findViewById(R.id.yellow_number);
        _blackNumber = (TextView) findViewById(R.id.black_number);
        _whiteNumber = (TextView) findViewById(R.id.white_number);
        _rainbowNumber = (TextView) findViewById(R.id.rainbow_number);
    }

    private void _initializeInfo(){
        IGameInfo gameInfo = _gameInfoPresenter.getStarterGameInfo();
        System.out.println("Size player list in Activity: " + gameInfo.getPlayers().size());
        _updateGameInfo(gameInfo.getPlayers(), gameInfo.getPlayerPoints(), gameInfo.getPlayerHandSizes(),
                gameInfo.getClaimedRoutes(), gameInfo.getRemainingTrains());
    }

    private void _initializePlayerHand(){
        List<TrainCard> playerHand = _gameInfoPresenter.getStarterPlayerHand();
        _updatePlayerHand(playerHand);

    }

    private String numberOfRoutes(Map<String, IEdge> claimedRoutes, String player){
        System.out.println("Size of claimedRoutes: " + claimedRoutes.size());

        int number = 0;
        for (Map.Entry<String, IEdge> entry : claimedRoutes.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if(entry.getKey().equals(player)){
                number++;
            }
        }

        String numAsStr = Integer.toString(number);
        return numAsStr;
    }

    private String _getNumberOfCards(List<TrainCard> playerHand, String color){
        int cardCount = 0;
        for(TrainCard trainCard : playerHand){
            if(trainCard.getColor().toString().equals(color)){
                cardCount++;
            }
        }
        String numAsStr = Integer.toString(cardCount);
        return numAsStr;
    }

    public void _updatePlayerHand(List<TrainCard> playerHand){
        if(playerHand.size() == 0){
            String zero = "0";
            _redNumber.setText(zero);
            _greenNumber.setText(zero);
            _blueNumber.setText(zero);
            _pinkNumber.setText(zero);
            _orangeNumber.setText(zero);
            _yellowNumber.setText(zero);
            _blackNumber.setText(zero);
            _whiteNumber.setText(zero);
            _rainbowNumber.setText(zero);
        }
        else{
            _redNumber.setText(_getNumberOfCards(playerHand, "red"));
            _greenNumber.setText(_getNumberOfCards(playerHand, "green"));
            _blueNumber.setText( _getNumberOfCards(playerHand, "blue"));
            _pinkNumber.setText(_getNumberOfCards(playerHand, "pink"));
            _orangeNumber.setText(_getNumberOfCards(playerHand, "orange"));
            _yellowNumber.setText(_getNumberOfCards(playerHand, "yellow"));
            _blackNumber.setText(_getNumberOfCards(playerHand, "black"));
            _whiteNumber.setText(_getNumberOfCards(playerHand, "white"));
            _rainbowNumber.setText(_getNumberOfCards(playerHand, "rainbow"));
        }
    }


    public void _updateGameInfo(List<String> players, Map<String, Integer> playerPoints, Map<String, Integer> playerHandSize,
                                Map<String, IEdge> claimedRoutes, Map<String, Integer> playerRemainingTrains){
        _player1.setText(players.get(0));
        String points = playerPoints.get(players.get(0)).toString();
        _player1Points.setText(points);
        String handSize = playerHandSize.get(players.get(0)).toString();
        _player1Cards.setText(handSize);
        String numTrains = playerRemainingTrains.get(players.get(0)).toString();
        _player1Trains.setText(numTrains);
        _player1Routes.setText(numberOfRoutes(claimedRoutes, players.get(0)));

        _player2.setText(players.get(1));
        points = playerPoints.get(players.get(1)).toString();
        _player2Points.setText(points);
        handSize = playerHandSize.get(players.get(1)).toString();
        _player2Cards.setText(handSize);
        numTrains = playerRemainingTrains.get(players.get(1)).toString();
        _player2Trains.setText(numTrains);
        _player2Routes.setText(numberOfRoutes(claimedRoutes, players.get(1)));

        if(players.size() != 3){
            _player3.setText("--");
            _player3Points.setText("--");
            _player3Cards.setText("--");
            _player3Trains.setText("--");
            _player3Routes.setText("--");
        }
        else{
            _player3.setText(players.get(2));
            points = playerPoints.get(players.get(2)).toString();
            _player3Points.setText(points);
            handSize = playerHandSize.get(players.get(2)).toString();
            _player3Cards.setText(handSize);
            numTrains = playerRemainingTrains.get(players.get(2)).toString();
            _player3Trains.setText(numTrains);
            _player3Routes.setText(numberOfRoutes(claimedRoutes, players.get(2)));
        }

        if(players.size() != 4){
            _player4.setText("--");
            _player4Points.setText("--");
            _player4Cards.setText("--");
            _player4Trains.setText("--");
            _player4Routes.setText("--");
        }
        else{
            _player4.setText(players.get(3));
            points = playerPoints.get(players.get(3)).toString();
            _player4Points.setText(points);
            handSize = playerHandSize.get(players.get(3)).toString();
            _player4Cards.setText(handSize);
            numTrains = playerRemainingTrains.get(players.get(3)).toString();
            _player4Trains.setText(numTrains);
            _player4Routes.setText(numberOfRoutes(claimedRoutes, players.get(3)));
        }

        if(players.size() != 5){
            _player5.setText("--");
            _player5Points.setText("--");
            _player5Cards.setText("--");
            _player5Trains.setText("--");
            _player5Routes.setText("--");
        }
        else{
            _player5.setText(players.get(4));
            points = playerPoints.get(players.get(4)).toString();
            _player5Points.setText(points);
            handSize = playerHandSize.get(players.get(4)).toString();
            _player5Cards.setText(handSize);
            numTrains = playerRemainingTrains.get(players.get(4)).toString();
            _player5Trains.setText(numTrains);
            _player5Routes.setText(numberOfRoutes(claimedRoutes, players.get(4)));
        }
    }
}
