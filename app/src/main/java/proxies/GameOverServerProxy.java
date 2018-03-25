package proxies;

import shared.command.Command;
import shared.command.ICommand;
import shared.facades.server.IGameOverServerFacade;
import shared.results.GameOverResult;
import shared.results.Result;
import tasks.TaskExecutor;

/**
 * Created by paulinecausse on 3/24/18.
 */

public class GameOverServerProxy implements IGameOverServerFacade {

    @Override
    public GameOverResult getLongestRoute() {
        Class<?>[] parmTypes = {};
        Object[] parmValues = {};

        ICommand command = generateGameOverServerFacadeCommand("getLongestRoute", parmTypes, parmValues);

        Result result = TaskExecutor.runTask(command);

        if(result.isExceptional()){
            return new GameOverResult(result.getExceptionType(), result.getExceptionMessage());
        }
        return (GameOverResult) result;
    }

    private ICommand generateGameOverServerFacadeCommand(String method, Class<?>[] parmTypes, Object[] parmValues){
        return new Command("server.facades.GameOverServerFacade", method, parmTypes, parmValues);
    }

    @Override
    public GameOverResult getTotalPoints() {
        Class<?>[] parmTypes = {};
        Object[] parmValues = {};

        ICommand command = generateGameOverServerFacadeCommand("getTotalPoints", parmTypes, parmValues);

        Result result = TaskExecutor.runTask(command);

        if(result.isExceptional()){
            return new GameOverResult(result.getExceptionType(), result.getExceptionMessage());
        }
        return (GameOverResult) result;
    }
}
