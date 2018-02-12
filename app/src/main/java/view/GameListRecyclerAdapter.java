package view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a340team.tickettoride.R;

import java.util.ArrayList;

/**
 * Created by mikeporet on 2/8/18.
 */

class GameListRecyclerAdapter extends RecyclerView.Adapter<GameListRecyclerAdapter.ViewHolder>{
    private ArrayList<String> _gameList;
    private ArrayList<String> _gameNumPlayersList;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public TextView GameName;
        public TextView NumberPlayers;
        public TextView GameID;


        public ViewHolder(final View itemView) {
            super(itemView);
            GameName = (TextView) itemView.findViewById(R.id.game_name);
            GameID = (TextView) itemView.findViewById(R.id.game_id_display);
            NumberPlayers = (TextView) itemView.findViewById(R.id.number_players);
            GameName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int ChosenGame =  getAdapterPosition();
            Intent intent = new Intent(v.getContext(), GameLobbyActivity.class);
            intent.putExtra("GameID", ChosenGame);
            intent.putExtra("GameName", GameName.toString());
            v.getContext().startActivity(intent);
        }
    }

    public GameListRecyclerAdapter(ArrayList<String> _gameList, ArrayList<String> _gameNumPlayersList) {
        this._gameList = _gameList;
        this._gameNumPlayersList = _gameNumPlayersList;
    }


    @Override
    public GameListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.game_list_item, parent, false);
        GameListRecyclerAdapter.ViewHolder viewHolder = new GameListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GameListRecyclerAdapter.ViewHolder holder, int position) {
        //Setup text displays
        TextView name = holder.GameName;
        name.setText(_gameList.get(position));

        TextView ID = holder.GameID;
        ID.setText(Integer.toString(position));

        TextView NumPlalyers = holder.GameID;
        NumPlalyers.setText(_gameNumPlayersList.get(position));

    }

    @Override
    public int getItemCount() {
        return _gameList.size();
    }
}
