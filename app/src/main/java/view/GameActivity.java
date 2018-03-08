package view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.a340team.tickettoride.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.ClientRoot;
import shared.model.CardSet;
import shared.model.City;
import shared.model.CityPoint;
import shared.model.DestCard;
import shared.model.Hand;
import shared.model.Route;
import shared.model.Train;
import shared.model.TrainCard;
import shared.model.interfaces.Card;

import static shared.model.initialized_info.DestCardId.*;

public class GameActivity extends AppCompatActivity implements IGameActivity{

    //DEMO
    Button _demoButton;
    //Map
    ImageView mapView;
    //Click Buttons
    Button _drawTrains;
    Button _claimRoute;
    Button _drawDestinations;
    Button _myGame;
    Button _chatStats;
    //Cities
    Button portland;
    Button vancouver;
    Button seattle;
    Button san_francisco;
    Button los_angeles;
    Button calgary;
    Button helena;
    Button salt_lake_city;
    Button las_vegas;
    Button phoenix;
    Button el_paso;
    Button santa_fe;
    Button denver;
    Button winnipeg;
    Button duluth;
    Button omaha;
    Button kansas_city;
    Button oklahoma_city;
    Button dallas;
    Button houston;
    Button saul_st_marie;
    Button chicago;
    Button st_louis;
    Button little_rock;
    Button new_orleans;
    Button nashville;
    Button atlanta;
    Button toronto;
    Button pittsburgh;
    Button charleston;
    Button raleigh;
    Button washington;
    Button new_york;
    Button boston;
    Button montreal;
    Button miami;
    //Button Array
    ArrayList<Button> _cityButtons;
    ArrayList<String> _citiesSelected = new ArrayList<>();
    private int _maxCitiesSelected = 2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_acitvity);
        //Make the mape
        mapView = (ImageView) findViewById(R.id.map_image);

        //TODO Delete me DEMO STUFF
        //*****DEMO CRAP ******* DELETE AFTER PHASE 2//

        _demoButton = (Button) findViewById(R.id.demo_button);
        _demoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RUNDEMO();
            }
        });

        //*****END OF DEMO CRAP ********//

        //Initialize Components
        _initializeButtons();
        _createOnClickListeners(_cityButtons);
        _createFunctionButtonListeners();
        _setCityButtons(false);
        displayStartDestCards();

    }


    @Override
    public void onBackPressed() {
        //We don't want them to leave the game.
        ViewUtilities.displayMessage("You Can't Leave The Game.\n " +
                "Never Give Up.", this);
    }

    private void _createOnClickListeners(List<Button> _cityButtons){

         final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.atlanta);
         View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _cityListeners(view, mediaPlayer);
            }
        };

        for (int i = 0; i < _cityButtons.size(); i++) {
            _cityButtons.get(i).setOnClickListener(clickListener);
        }
    }

    private void _cityListeners(View view, MediaPlayer mediaPlayer) {
        if(_citiesSelected.size() < _maxCitiesSelected) {
            Button button = (Button) view;
            String text = button.getText().toString();

            /*
            if (text.equals(ATLANTA)) {
                text = "atlanta nanana";
                mediaPlayer.start();
            }
            */
            if (text.equals(HOUSTON)) {
                _citiesSelected.add(HOUSTON);
            }
            if (text.equals(EL_PASO)) {
                _citiesSelected.add(EL_PASO);

            }


            ViewUtilities.displayMessage(text, view.getContext());
        }
        else{
            ViewUtilities.displayMessage("You've Selected 2 Cities\nPress Claim Route to End", view.getContext());
        }
    }

    private void _createFunctionButtonListeners(){
        _drawTrains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawTrainCards();
            }
        });

        _claimRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                claimRoute();
            }
        });

        _drawDestinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawDestinations();
            }
        });

        _myGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayGame();
            }
        });

        _chatStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Do something please!
                ViewUtilities.displayMessage("Chat and Stats\nShould Show", view.getContext());
            }
        });
    }

    private void _initializeButtons(){
        //Click buttons
        _drawTrains = (Button) findViewById(R.id.draw_trains);
        _claimRoute = (Button) findViewById(R.id.claim_route);
        _drawDestinations = (Button) findViewById(R.id.draw_destinations);
        _myGame = (Button) findViewById(R.id.my_game);
        _chatStats = (Button) findViewById(R.id.chats_stats);

        //find buttons
        portland = (Button) findViewById(R.id.portland);
        new_york = (Button) findViewById(R.id.new_york);
        vancouver = (Button) findViewById(R.id.vancouver);
        seattle = (Button) findViewById(R.id.seattle);
        san_francisco = (Button) findViewById(R.id.san_francisco);
        los_angeles = (Button) findViewById(R.id.los_angeles);
        calgary = (Button) findViewById(R.id.calgary);
        helena = (Button) findViewById(R.id.helena);
        denver = (Button) findViewById(R.id.denver);
        santa_fe = (Button) findViewById(R.id.santa_fe);
        el_paso = (Button) findViewById(R.id.el_paso);
        salt_lake_city = (Button) findViewById(R.id.salt_lake_city);
        winnipeg = (Button) findViewById(R.id.winnipeg);
        duluth = (Button) findViewById(R.id.duluth);
        omaha = (Button) findViewById(R.id.omaha);
        kansas_city = (Button) findViewById(R.id.kansas_city);
        oklahoma_city = (Button) findViewById(R.id.oklahoma_city);
        dallas = (Button) findViewById(R.id.dallas);
        houston = (Button) findViewById(R.id.houston);
        new_orleans = (Button) findViewById(R.id.new_orleans);
        little_rock = (Button) findViewById(R.id.little_rock);
        st_louis = (Button) findViewById(R.id.st_louis);
        chicago = (Button) findViewById(R.id.chicago);
        saul_st_marie = (Button) findViewById(R.id.saul_st_marie);
        nashville = (Button) findViewById(R.id.nashville);
        atlanta = (Button) findViewById(R.id.atlanta);
        charleston = (Button) findViewById(R.id.charleston);
        raleigh = (Button) findViewById(R.id.raleigh);
        washington = (Button) findViewById(R.id.washington);
        pittsburgh = (Button) findViewById(R.id.pittsburgh);
        new_york = (Button) findViewById(R.id.new_york);
        boston = (Button) findViewById(R.id.boston);
        montreal = (Button) findViewById(R.id.montreal);
        las_vegas = (Button) findViewById(R.id.las_vegas);
        phoenix = (Button) findViewById(R.id.phoenix);
        toronto = (Button) findViewById(R.id.toronto);
        miami = (Button) findViewById(R.id.miami);


        //Add buttons to list
        _cityButtons = new ArrayList<>();
        _cityButtons.add(portland);
        _cityButtons.add(vancouver);
        _cityButtons.add(seattle);
        _cityButtons.add(san_francisco);
        _cityButtons.add(los_angeles);
        _cityButtons.add(calgary);
        _cityButtons.add(helena);
        _cityButtons.add(salt_lake_city);
        _cityButtons.add(las_vegas);
        _cityButtons.add(phoenix);
        _cityButtons.add(el_paso);
        _cityButtons.add(santa_fe);
        _cityButtons.add(denver);
        _cityButtons.add(winnipeg);
        _cityButtons.add(duluth);
        _cityButtons.add(omaha);
        _cityButtons.add(kansas_city);
        _cityButtons.add(oklahoma_city);
        _cityButtons.add(dallas);
        _cityButtons.add(houston);
        _cityButtons.add(saul_st_marie);
        _cityButtons.add(chicago);
        _cityButtons.add(st_louis);
        _cityButtons.add(little_rock);
        _cityButtons.add(new_orleans);
        _cityButtons.add(nashville);
        _cityButtons.add(atlanta);
        _cityButtons.add(toronto);
        _cityButtons.add(pittsburgh);
        _cityButtons.add(charleston);
        _cityButtons.add(raleigh);
        _cityButtons.add(washington);
        _cityButtons.add(new_york);
        _cityButtons.add(boston);
        _cityButtons.add(montreal);
        _cityButtons.add(miami);
    }

    private void _setCityButtons(boolean value){
        portland.setEnabled(value);
        vancouver.setEnabled(value);
        seattle.setEnabled(value);
        san_francisco.setEnabled(value);
        los_angeles.setEnabled(value);
        calgary.setEnabled(value);
        helena.setEnabled(value);
        salt_lake_city.setEnabled(value);
        las_vegas.setEnabled(value);
        phoenix.setEnabled(value);
        el_paso.setEnabled(value);
        santa_fe.setEnabled(value);
        denver.setEnabled(value);
        winnipeg.setEnabled(value);
        duluth.setEnabled(value);
        omaha.setEnabled(value);
        kansas_city.setEnabled(value);
        oklahoma_city.setEnabled(value);
        dallas.setEnabled(value);
        houston.setEnabled(value);
        saul_st_marie.setEnabled(value);
        chicago.setEnabled(value);
        st_louis.setEnabled(value);
        little_rock.setEnabled(value);
        new_orleans.setEnabled(value);
        nashville.setEnabled(value);
        atlanta.setEnabled(value);
        toronto.setEnabled(value);
        pittsburgh.setEnabled(value);
        charleston.setEnabled(value);
        raleigh.setEnabled(value);
        washington.setEnabled(value);
        new_york.setEnabled(value);
        boston.setEnabled(value);
        montreal.setEnabled(value);
        miami.setEnabled(value);
    }

    private void _setDrawButtons(boolean value) {
        _drawTrains.setEnabled(value);
        _drawDestinations.setEnabled(value);
    }

    @Override
    public void displayStartDestCards() {
        Intent intent = new Intent(this, DrawDestinationsActivity.class);
        intent.putExtra(ViewUtilities.GAME_START, true);
        startActivity(intent);
    }

    @Override
    public void drawTrainCards() {
        Intent intent = new Intent(this, DrawTrainCardsActivity.class);
        startActivity(intent);
    }

    @Override
    public void claimRoute() {
        _setCityButtons(true);
        _setDrawButtons(false);
        int tint = Color.argb(50, 0, 0, 0);
        mapView.setColorFilter(tint);
        //mapView.setBackgroundColor(tint);

        if(_citiesSelected.size() == 2) {

            City houston = new City(new CityPoint(580, 540), HOUSTON);
            City elPaso = new City(new CityPoint(345, 480), EL_PASO);
            Route r = new Route();
            r.setStart(houston);
            r.setEnd(elPaso);
            r.setLength(6);
            List<Route> routes = new ArrayList<>();
            routes.add(r);

            _drawRoutes(routes);

            ViewUtilities.displayMessage("You Claimed:\nStart: " + _citiesSelected.get(0) +"\nDest: " + _citiesSelected.get(1), this);
            _setCityButtons(false);
            _setDrawButtons(true);
            _citiesSelected.clear();
            tint = Color.argb(0, 0, 0, 0);
            mapView.setColorFilter(tint);
            //mapView.setBackgroundColor(getResources().getColor(R.color.mapBackground));
        }



    }

    private void _drawRoutes(List<Route> routes) {

        DrawUtilities myDrawer = new DrawUtilities(this);

        myDrawer.drawRoutes(routes, mapView);
        /*
        Drawer myDrawer = new Drawer(this);
        Bitmap mapImg = BitmapFactory.decodeResource(getResources(), R.mipmap.ticket_to_ride_map_with_routes);
        Canvas canvas = new Canvas(mapImg);
        canvas.drawBitmap(mapImg, 0, 0, null);

        myDrawer.drawRoute(canvas, routes);*/

    }

    @Override
    public void drawDestinations() {
        Intent intent = new Intent(this, DrawDestinationsActivity.class);
        intent.putExtra(ViewUtilities.GAME_START, false);
        startActivity(intent);

    }

    @Override
    public void displayGame() {
        Intent intent = new Intent(this, GameInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void displayChat() {

    }

    //TODO Delete me DEMO STUFF 2
    //Delete after phase 2 **************//
    private void RUNDEMO(){

        //DRAW TRAIN CARDS
        Hand<TrainCard> list = ClientRoot.getClientPlayer().getTrainCardHand();
        List<TrainCard> trainList = list.get_cards();
        for(int i = 0; i < 6; i++){
            trainList.add(new TrainCard(shared.model.Color.GREEN, 1));
            trainList.add(new TrainCard(shared.model.Color.BLACK, 1));
        }
        ClientRoot.getClientPlayer().setTrainCards(trainList);

        //For Player one
        Map<String, Integer> trainCount = ClientRoot.getClientGameInfo().getPlayerHandSizes();
        int count = trainCount.get(0);




        //Draw Destination Cards
        CardSet s = ClientRoot.getClientPlayer().getUnresolvedDestCards();
        List<DestCard> destList = s.cards;
        DestCard _17 = new DestCard(CHICAGO, LOS_ANGELES, 16);
        DestCard _18 = new DestCard(PITTSBURGH, DENVER, 11);
        destList.add(_17);
        destList.add(_18);
        ClientRoot.getClientPlayer().setUnresolvedDestCards(destList);

        //Claim a route
        //Update the game history
        //Update the game info
        //Player's turn is over

    }
    //**********************************//
}