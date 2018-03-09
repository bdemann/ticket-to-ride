package presenter;

import android.content.Intent;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import facade.guifacade.ChatHistoryGuiFacade;
import model.ClientRoot;
import shared.model.Chat;
import shared.model.history.events.GameEvent;
import shared.model.interfaces.IGame;
import view.ChatActivity;
import view.GameLobbyActivity;

/**
 * Created by bdemann on 3/8/18.
 */

public class ChatHistoryPresenter implements Observer {

    private ChatActivity _chatActivity;

    public ChatHistoryPresenter(ChatActivity chatActivity){
        this._chatActivity = chatActivity;
    }

    @Override
    public void update(Observable observable, Object o) {
        _chatActivity.updateChats(getChats());
        _chatActivity.updateEvents(getEvents());
    }

    public void sendChat(){
        ChatHistoryGuiFacade.sendChat(_chatActivity.getMessage());
    }

    public List<Chat> getChats() {
        return ChatHistoryGuiFacade.getChats();
    }

    public List<GameEvent> getEvents() {
        return ChatHistoryGuiFacade.getEvents();
    }
}
