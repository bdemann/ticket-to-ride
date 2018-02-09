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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public TextView GameName;



        public ViewHolder(final View itemView) {
            super(itemView);
            GameName = (TextView) itemView.findViewById(R.id.game_list_item);
            GameName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String ChosenGame =  _gameList.get(getAdapterPosition());
        }
    }

    public GameListRecyclerAdapter(ArrayList<String> _gameList) {
        this._gameList = _gameList;
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
        TextView name = holder.GameName;
        name.setText(_gameList.get(position));

    }

    @Override
    public int getItemCount() {
        return _gameList.size();
    }
}
