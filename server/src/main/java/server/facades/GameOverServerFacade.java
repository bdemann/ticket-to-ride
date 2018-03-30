package server.facades;

import java.util.ArrayList;
import java.util.List;

import server.facades.helpers.LongestPath;
import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import shared.command.ICommand;
import java.util.ArrayList;
import java.util.List;

import shared.facades.server.IGameOverServerFacade;
import shared.model.City;
import shared.model.DestCard;
import shared.model.DestCardSet;
import shared.model.EndGameTotals;
import shared.model.Graph;
import shared.model.Player;
import shared.model.Route;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;
import shared.model.interfaces.IRoute;
import shared.model.DestCard;
import shared.model.DestCardSet;
import shared.model.EndGameTotals;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;
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

        if(winner == null){
            return -1;
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

    public GameOverResult getTotalPoints(IGame game){
        game = ServerRoot.getGame(game.getId());
        List<IPlayer> players = game.getPlayers();


        //Longest Route Bonus
        int winnerID = getLongestRoute(game);

        //A list of totals with indexes corresponding to the players
        List<EndGameTotals> endGameTotals = new ArrayList<>();

        //Loop through each player to calculate points
        for (int i = 0; i < players.size(); i++){
            IPlayer current_player = players.get(i);
            EndGameTotals end = new EndGameTotals();

            //Unclaimed destinations
            int u_dest_points = 0;

            DestCardSet unclaimed_cards = current_player.getUnresolvedDestCards();

            for (DestCard d : unclaimed_cards) {
                u_dest_points -= d.getPoints();
            }
            end.setUnclaimed_destination_points(u_dest_points);

            //Claimed Route points
            int claimed_route_points = current_player.getScore();
            end.setClaimed_route_points(claimed_route_points);

            if (winnerID == i){
                end.setLongest_route_bonus(60);
            }
            else
                end.setLongest_route_bonus(0);

            //Calculate total points
            int total_points = u_dest_points + claimed_route_points + end.getLongest_route_bonus();
            end.setTotal_points(total_points);
            endGameTotals.add(end);
        }

        //Return the values
        return new GameOverResult(endGameTotals, true, ClientCommands.getCommandList(players.get(0).getUsername()));
    }

}
