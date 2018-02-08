package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by BenNelson on 2/7/18.
 *
 * The point of this class is to hold certain methods that all or most views will use.
 */

class ViewUtilities {

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
}
