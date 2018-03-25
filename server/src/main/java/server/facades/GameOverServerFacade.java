package server.facades;

import java.util.ArrayList;
import java.util.List;

import shared.facades.server.IGameOverServerFacade;
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
    @Override
    public GameOverResult getLongestRoute(IGame game) {

        return new GameOverResult("","");
    }

    public List<EndGameTotals> _calculatePoints(IGame game){
        List<IPlayer> players = game.getPlayers();

        //A list of totals with indexes correspoinding to the players
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

            //Longest Route Bonus
            getLongestRoute(game);

            //Calculate total points
            int total_points = u_dest_points + claimed_route_points;
            end.setTotal_points(total_points);
            endGameTotals.add(end);
        }

        //Return the values
        return endGameTotals;
    }

    @Override
    public GameOverResult getLongestRoute() {
        return null;
    }

    @Override
    public GameOverResult getTotalPoints() {
        return null;
    }
}
