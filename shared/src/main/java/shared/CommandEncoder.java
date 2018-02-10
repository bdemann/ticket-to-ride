package shared;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import shared.commandResults.CommandResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class CommandEncoder {
    private static CommandEncoder _instance = new CommandEncoder();
    private XStream xStream;

    private CommandEncoder(){
        xStream = new XStream(new DomDriver());
    }

    public static CommandResult decodeCommandResults(InputStream inputStream){
        return (CommandResult) _instance.xStream.fromXML(inputStream);
    }

    public static void encodeCommandResults(CommandResult results, OutputStream responseBody) {
        _instance.xStream.toXML(results, responseBody);
    }

    public static void encodeCommand(Command command, OutputStream outputStream) {
        _instance.xStream.toXML(command, outputStream);
    }

    public static ICommand decodeCommand(InputStream inputStream) {
        return (ICommand) _instance.xStream.fromXML(inputStream);
    }

    public static void encodeTestResults(Object o, OutputStream outputStream) {
        _instance.xStream.toXML(o, outputStream);
    }
}
