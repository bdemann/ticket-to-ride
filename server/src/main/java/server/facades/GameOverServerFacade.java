package server.facades;

import java.util.ArrayList;
import java.util.List;

import server.facades.helpers.LongestPath;
import server.model.ServerRoot;
import server.poller.ClientNotifications;
import shared.command.ICommand;
import shared.facades.server.IGameOverServerFacade;
import shared.model.City;
import shared.model.Graph;
import shared.model.Player;
import shared.model.Route;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;
import shared.model.interfaces.IRoute;
import shared.results.GameOverResult;
import shared.results.Result;

/**
 * Created by paulinecausse on 3/24/18.
 */

public class GameOverServerFacade implements IGameOverServerFacade {
    public int getLongestRoute(IGame currentGame) {
        List<IPlayer> players = currentGame.getPlayers();
        List<IRoute> allRoutes = currentGame.getClaimedRoutes();

        IPlayer winner = null;
        int tempLP;
        int longestRoute = 0;
        for(IPlayer currentPlayer: players){
            Graph playerGraph = setPlayerGraph(currentPlayer, allRoutes);
            tempLP = getPlayerLongestRoute(playerGraph);
            if(tempLP > longestRoute){
                longestRoute = tempLP;
                winner = currentPlayer;
            }
        }

        currentGame.setPlayerWithLongestRoute(winner.getUsername());

        return getWinningPlayerID(winner,players);
    }

    private int getWinningPlayerID(IPlayer player,List<IPlayer> players){
        int i;
        for(i = 0; i < players.size(); i++){
            if(players.get(i).getUsername().equals(player.getUsername())){
                return i;
            }
        }

        return -1;
    }

    private int getPlayerLongestRoute(Graph graph){
        LongestPath lp = new LongestPath();
        int longestPath = 0;
        int tempLP;
        for(City city: graph.getVertices()){
            tempLP = lp.initLongestPath(graph.getVertices(),city);
            if(tempLP > longestPath){
                longestPath = tempLP;
            }
        }

        return longestPath;
    }

    private Graph setPlayerGraph(IPlayer player, List<IRoute> allRoutes){
        List<IRoute> playerRoute = setEdges(player,allRoutes);
        List<City> playerCities = setCities(playerRoute);

        return new Graph(playerRoute,playerCities,player.getUsername());
    }

    private List<IRoute> setEdges(IPlayer player, List<IRoute> allRoutes){
        List<IRoute> playerRoutes = new ArrayList<>();
        for(IRoute route:allRoutes){
            if(route.getOwner().equals(player.getUsername())){
                playerRoutes.add(route);
            }
        }

        return playerRoutes;
    }

    private List<City> setCities(List<IRoute> playerRoutes){
        List<City> playerCities = new ArrayList<>();
        for(IRoute route: playerRoutes){
            if(!findCity(playerCities,route.getStart())){
                playerCities.add(route.getStart());
            }
            if(!findCity(playerCities,route.getEnd())){
                playerCities.add(route.getEnd());
            }
        }

        return playerCities;
    }

    private boolean findCity(List<City> cities, City currentCity){
        boolean cityExists = false;
        for(City city:cities){
            if(currentCity.get_name().equals(city.get_name())){
                cityExists = true;
            }
        }

        return cityExists;
    }

}
