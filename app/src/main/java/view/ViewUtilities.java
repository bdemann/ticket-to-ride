package view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import shared.model.DestCard;

/**
 *
 * Created by BenNelson on 2/7/18.
 *
 * The point of this class is to hold certain methods that all or most views will use.
 */

class ViewUtilities {

    static String GAME_START = "gameStart";
    static boolean containsSpecialCharacters(String str){

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(str);

        if (!matcher.matches()) {
            //Contains special characters
            return true;
        }

        //Doesn't contain special characters
        return false;
    }

    static void displayMessage(String message, AppCompatActivity activity) {
        //Just pop up a toast letting the user know what happened
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(activity, message, duration);
        toast.show();
    }

    static void displayMessage(String message, Context context) {
        //Just pop up a toast letting the user know what happened
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    static ArrayList<Integer> createDestCardImagePaths(List<DestCard> destCards) {
        ArrayList<Integer> imagePathList = new ArrayList<>();
        for (DestCard card : destCards) {
            int path = _findImagePath(card.getStartingPoint(), card.getDestination());
            imagePathList.add(path);
        }
        return imagePathList;
    }

    private static int _findImagePath(String startingPoint, String destination) {
        return 0;
    }
}
