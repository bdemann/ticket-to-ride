package com.a340team.tickettoride.shared.client;

/**
 * This is an interface that will be shared by the CLIENT PROXY CLASSES on the server, and the
 * CLIENT FACADE CLASSES on the client.
 *
 * Created by BenNelson on 2/3/18.
 */

public interface IGameLobbyClient {

    void sendChat();
    void startGame();
}
