package proxies;

import shared.command.Command;
import shared.command.ICommand;
import shared.facades.server.IGameServerFacade;
import shared.model.TrainCardSet;
import shared.model.interfaces.IEdge;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;
import shared.results.Result;
import tasks.TaskExecutor;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameServerProxy implements IGameServerFacade {
    @Override
    public ClaimRouteResult claimRoute(IEdge route, TrainCardSet cards, String username) {
        Class<?>[] parmTypes = {IEdge.class, TrainCardSet.class, String.class};
        Object[] parmValues = {route, cards, username};

        ICommand command = _generateGameServerFacadeCommand("claimRoute", parmTypes, parmValues);

        Result result = TaskExecutor.runTask(command);

        if(result.getCommandSuccess()){
            return (ClaimRouteResult) result;
        }
        return new ClaimRouteResult(result.getExceptionType(), result.getExceptionMessage());
    }

    @Override
    public DrawCardsResult drawTrainCard(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};

        ICommand command = _generateGameServerFacadeCommand("drawTrainCard", parmTypes, parmValues);

        Result result = TaskExecutor.runTask(command);

        if(result.getCommandSuccess()){
            return (DrawCardsResult) result;
        }
        return new DrawCardsResult(result.getExceptionType(), result.getExceptionMessage());
    }

    @Override
    public DrawCardsResult drawTicketCards(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};

        ICommand command = _generateGameServerFacadeCommand("drawTicketCards", parmTypes, parmValues);

        Result result = TaskExecutor.runTask(command);

        if(result.getCommandSuccess()){
            return (DrawCardsResult) result;
        }
        return new DrawCardsResult(result.getExceptionType(), result.getExceptionMessage());
    }

    private ICommand _generateGameServerFacadeCommand(String method, Class<?>[] parmTypes, Object[] parmValues){
        return new Command("server.facade.GamerServerFacade", method, parmTypes, parmValues);
    }
}
