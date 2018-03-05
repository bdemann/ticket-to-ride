package view;

import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.a340team.tickettoride.BuildConfig;
import com.a340team.tickettoride.R;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    ImageView mapView;
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

    ArrayList<Button> _cityButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_acitvity);

        mapView = (ImageView) findViewById(R.id.map_image);
//        Matrix matrix = new Matrix();
//        matrix.preScale(.5f,.5f);
//        mapView.setImageMatrix(matrix);

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

        //Add buttons to list
        _cityButtons = new ArrayList();

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
        


        _createOnClickListeners(_cityButtons);


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


    private void _createOnClickListeners(List<Button> _cityButtons){

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.atlanta);
         View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String text = button.getText().toString();
                if(text.equals("atlanta")){
                    text = "atlanta nanana";

                    mediaPlayer.start();
                }

                Toast toast = Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT);

                toast.show();
            }
        };

        for (int i = 0; i < _cityButtons.size(); i++)
            _cityButtons.get(i).setOnClickListener(clickListener);

//        portland.setOnClickListener(clickListener);
//        new_york.setOnClickListener(clickListener);

    }

}