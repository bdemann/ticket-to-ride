package guiless;

import facade.GameSelectionClientFacade;
import shared.Command;

/**
 * Created by bdemann on 2/20/18.
 */

public class MiscTest {

    public static void main(String[] args){
        Class<?>[] parmTypes = {String.class};
        Object[] parm = {"bdemann"};
        Command command = new Command("facade.GameSelectionClientFacade", "updateGameList", parmTypes, parm);
        System.out.println(command);
        try {
            command.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(GameSelectionClientFacade.class);
    }
}
