package shared;

import com.google.gson.Gson;

import java.io.Serializable;
import java.lang.reflect.Method;

import shared.commandResults.CommandResult;

/**
 * Created by paulinecausse on 2/3/18.
 */

/**
 * Command class that creates the command objects
 */
public class Command implements ICommand, Serializable {
    private String _className;
    private String _methodName;
    private Class<?>[] _parmTypes;
    private Object[] _parms;

    public Command(String className, String methodName, Class<?>[] parmTypes, Object[] parms) {
        this._className = className;
        this._methodName = methodName;
        this._parmTypes = parmTypes;
        this._parms = parms;
    }

    public CommandResult execute() throws Exception{
        try {
            Class<?> receiver = Class.forName(_className);
            Method method = receiver.getMethod(_methodName,_parmTypes);
            Object t = receiver.newInstance();
            return (CommandResult) method.invoke(t, _parms);
        } catch (Exception e) {
            throw e;
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("_methodName = " + _methodName + "\n");

        result.append("\t_parmTypes = ");

        for(Class parmType : _parmTypes) {
            result.append(parmType + ", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("\n");

        result.append("\t_parms = ");
        if(_parms == null) {
            result.append("null\n");
        } else {
            for(Object parameter : _parms) {
                result.append(parameter);
                result.append("(" + parameter.getClass().getName() + ")");
                result.append(", ");
            }
            result.delete(result.length()-2, result.length());
        }

        return result.toString();
    }

}
