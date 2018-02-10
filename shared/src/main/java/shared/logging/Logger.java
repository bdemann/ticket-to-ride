package shared.logging;

/**
 * Created by bdemann on 2/9/18.
 */

public class Logger {

    public static final Logger _instance = new Logger();

    private Logger(){

    }

    public static void log(Object message, Level level){
        System.out.println(message.toString());
    }

    public static void log(Object message){
        log(message, Level.ALL);
    }

    public static void log(int message){
        log(new Integer(message), Level.ALL);
    }
}
