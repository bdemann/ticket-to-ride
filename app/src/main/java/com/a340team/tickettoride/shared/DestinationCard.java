package com.a340team.tickettoride.shared;

/**
 * Created by BenNelson on 2/2/18.
 *
 * Destination cards give or take away points as indicated by the number on the card.
 * Add points to a player's score if the route is successfully claimed by the player.
 *
 * The card has a (unique?) route from one city to another.
 * The card also has a point amount.
 */

public class DestinationCard {

    private Route route;
    private int pointAmt;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private boolean completed;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getPointAmt() {
        return pointAmt;
    }

    public void setPointAmt(int pointAmt) {
        this.pointAmt = pointAmt;
    }
}
