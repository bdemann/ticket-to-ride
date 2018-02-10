package shared;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.lang.reflect.Method;

import shared.commandResults.CommandResult;

/**
 * Created by paulinecausse on 2/3/18.
 */

/**
 * Command class that creates the command objects
 */
public class Command implements ICommand{
//    private String _className;
//    private String _methodName;
////    private Class<?>[] _parmTypes;
//    private Object[] _parms;
//    private String[] _parmTypes;
//    private String[] _parametersAsJsonStrings;
//
////    public Command(String className, String methodName, Class<?>[] parmTypes, Object[] parms) {
////        this._className = className;
////        this._methodName = methodName;
////        this._parmTypes = parmTypes;
////        this._parms = parms;
////    }
//    public Command(String className, String methodName, String[] parmTypes, Object[] parms) {
//        this._className = className;
//        this._methodName = methodName;
//        this._parmTypes = parmTypes;
//        this._parms = parms;
//    }
//    )
//    public Gson gson = new Gson();
//
//    public Command(InputStreamReader inputStreamReader) {
//        Command tempCommand = (Command)gson.fromJson(inputStreamReader, Command.class);
//
//        _methodName = tempCommand.getMethodName();
//        _parmTypes = tempCommand.getParameterTypeNames();
//        _parametersAsJsonStrings = tempCommand.getParametersAsJsonStrings();
//        createParameterTypes();
//        _parms = new Object[_parametersAsJsonStrings.length];
//        for(int i = 0; i < _parametersAsJsonStrings.length; i++) {
//            _parms[i] = gson.fromJson(_parametersAsJsonStrings[i], _parametersTypes[i]);
//        }
//    }
//
//    private final void createParameterTypes() {
//        parametersTypes = new Class<?>[_parmType.length];
//        for(int i = 0; i < _parmTypes.length; i++) {
//            try {
//                _parameterTypes[i] = getClassFor(_parmTypes[i]);
//            } catch (ClassNotFoundException e) {
//                System.err.println("ERROR: IN Command.execute could not create a parameter type from the parameter type name " +
//                        parmTypes[i]);
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private Class<?>[] convertParmTypes(){
//        Class<?>[] paramTypes = {};
//        try{
//            for(int i = 0; i < _parmTypes.length; i++) {
//                paramTypes[i] = Class.forName(_parmTypes[i]);
//            }
//        } catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
//
//        return paramTypes;
//    }
//
//    public CommandResult execute() throws Exception{
//        try {
//            Class<?> receiver = Class.forName(_className);
//
//            Method method = receiver.getMethod(_methodName,convertParmTypes());
//            Object t = receiver.newInstance();
//            return (CommandResult) method.invoke(t, _parms);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
////
////    public String toString() {
////        StringBuffer result = new StringBuffer();
////        result.append("_methodName = " + _methodName + "\n");
////
////        result.append("    _parmTypes = ");
////
////        Class<?>[] parmTypeArray = convertParmTypes();
////
////        for(Class parmType : parmTypeArray) {
////            result.append(parmType + ", ");
////        }
////        result.delete(result.length()-2, result.length());
////        result.append("\n");
////
////        result.append("    _parms = ");
////        if(_parms == null) {
////            result.append("null\n");
////        } else {
////            for(Object parameter : _parms) {
////                result.append(parameter);
////                result.append("(" + parameter.getClass().getName() + ")");
////                result.append(", ");
////            }
////            result.delete(result.length()-2, result.length());
////        }
////
////        return result.toString();
////        return "hello";
////    }
//
//    public String getMethodName() {
//        return _methodName;
//    }
//
//    public String[] getParameterTypeNames() {
//        return _parmTypes;
//    }
//
//    public Object[] getParameters() {
//        return _parms;
//    }
//
//    public String[] getParametersAsJsonStrings() {
//        return _parametersAsJsonStrings;
//    }

    private static Gson gson = new Gson();

    private String className;
    private String methodName;
    private String[] parameterTypeNames;
    private Object[] parameters;
    private String[] parametersAsJsonStrings;
    private Class<?>[] parameterTypes;

    public Command(String className, String methodName, String[] parameterTypeNames, Object[] parameters) {
        this.className = className;
        this.methodName = methodName;
        this.parameterTypeNames = parameterTypeNames;
        this.parametersAsJsonStrings = new String[parameters.length];
        for(int i = 0; i < parameters.length; i++) {
//            parametersAsJsonStrings[i] = gson.toJson(parameters[i]);
            parametersAsJsonStrings[i] = CommandEncoder.encodeGeneric(parameters[i]);
        }
        this.parameters = null;
    }

    public Command(InputStreamReader inputStreamReader) {
//        Command tempCommand = (Command)gson.fromJson(inputStreamReader, Command.class);
        Command tempCommand = CommandEncoder.decodeCommand2(inputStreamReader);

        className = tempCommand.getClassName();
        methodName = tempCommand.getMethodName();
        parameterTypeNames = tempCommand.getParameterTypeNames();
        parametersAsJsonStrings = tempCommand.getParametersAsJsonStrings();
        createParameterTypes();
        parameters = new Object[parametersAsJsonStrings.length];
        for(int i = 0; i < parametersAsJsonStrings.length; i++) {
            parameters[i] = gson.fromJson(parametersAsJsonStrings[i], parameterTypes[i]);
        }
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String[] getParameterTypeNames() {
        return parameterTypeNames;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public String[] getParametersAsJsonStrings() {
        return parametersAsJsonStrings;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("methodName = " + methodName + "\n");

        result.append("    parameterTypeNames = ");
        for(String parameterTypeName : parameterTypeNames) {
            result.append(parameterTypeName + ", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("\n");

        result.append("    parametersAsJsonStrings = ");
        for(String parameterString : parametersAsJsonStrings) {
            result.append("'" + parameterString + "'");
            result.append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("\n");

        result.append("    parameters = ");
        if(parameters == null) {
            result.append("null\n");
        } else {
            for(Object parameter : parameters) {
                result.append(parameter);
                result.append("(" + parameter.getClass().getName() + ")");
                result.append(", ");
            }
            result.delete(result.length()-2, result.length());
        }

        return result.toString();
    }
    //    public CommandResult execute() throws Exception{
//        try {
//            Class<?> receiver = Class.forName(_className);
//
//            Method method = receiver.getMethod(_methodName,convertParmTypes());
//            Object t = receiver.newInstance();
//            return (CommandResult) method.invoke(t, _parms);
//        } catch (Exception e) {
//            throw e;
//        }
//    }

    public CommandResult execute() throws Exception{
        CommandResult result;
        try {
            Class<?> receiver = Class.forName(className);
            Method method = receiver.getMethod(methodName, parameterTypes);
            Object t = receiver.newInstance();
            result = (CommandResult) method.invoke(t, parameters);
        } catch (NoSuchMethodException | SecurityException e) {
            System.out.println("ERROR: Could not find the method " + methodName + ", or, there was a security error");
            result = new CommandResult("NoSuchMethod",e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("Illegal accesss while trying to execute the method " + methodName);
            result = new CommandResult("IllegalAccessException", e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: Illegal argument while trying to find the method " + methodName);
            result = new CommandResult("IllegalArgumentException", e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private final void createParameterTypes() {
        parameterTypes = new Class<?>[parameterTypeNames.length];
        for(int i = 0; i < parameterTypeNames.length; i++) {
            try {
                parameterTypes[i] = getClassFor(parameterTypeNames[i]);
            } catch (ClassNotFoundException e) {
                System.err.println("ERROR: IN Command.execute could not create a parameter type from the parameter type name " +
                        parameterTypeNames[i]);
                e.printStackTrace();
            }
        }
    }

    public final Class<?> getClassFor(String className)
            throws ClassNotFoundException
    {
        Class<?> result = null;
        switch (className) {
            case "boolean" :
                result = boolean.class; break;
            case "byte"    :
                result = byte.class;    break;
            case "char"    :
                result = char.class;    break;
            case "double"  :
                result = double.class;  break;
            case "float"   :
                result = float.class;   break;
            case "int"     :
                result = int.class;     break;
            case "long"    :
                result = long.class;    break;
            case "short"   :
                result = short.class;   break;
            case "String"  :
                result = String.class;  break;
            default:
                result = Class.forName(className);
        }
        return result;
    }

}
