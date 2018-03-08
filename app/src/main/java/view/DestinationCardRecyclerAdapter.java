package view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a340team.tickettoride.R;

import java.util.ArrayList;

import model.ClientRoot;
import presenter.CreateJoinPresenter;
import presenter.GameSelectionPresenter;

/**
 * Created by mikeporet on 2/8/18.
 */

class DestinationCardRecyclerAdapter extends RecyclerView.Adapter<DestinationCardRecyclerAdapter.ViewHolder>{
    private ArrayList<String> _gameList;
    private ArrayList<Integer> _gameIDList;
    private ArrayList<String> _gameNumPlayersList;

    private GameSelectionPresenter presenter;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public ImageView DestinationCardImage;
        public TextView Complete;



        public ViewHolder(final View itemView) {
            super(itemView);
            DestinationCardImage = (ImageView) itemView.findViewById(R.id.recycler_dest_card);
            Complete = (TextView) itemView.findViewById(R.id.complete_dest_card);

        }

        @Override
        public void onClick(View v) {
            //This recycler view just displays information. YAY! Easy!
        }
    }

    public DestinationCardRecyclerAdapter(ArrayList<String> _gameList, ArrayList<Integer> _gameIDList, ArrayList<String> _gameNumPlayersList,
                                   GameSelectionPresenter presenter) {
        this._gameList = _gameList;
        this._gameIDList = _gameIDList;
        this._gameNumPlayersList = _gameNumPlayersList;
        this.presenter = presenter;
    }


    @Override
    public DestinationCardRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.game_list_item, parent, false);
        DestinationCardRecyclerAdapter.ViewHolder viewHolder = new DestinationCardRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DestinationCardRecyclerAdapter.ViewHolder holder, int position) {
        //Setup text displays
        TextView name = holder.GameName;
        name.setText(_gameList.get(position));

        TextView ID = holder.GameID;
        ID.setText(Integer.toString(_gameIDList.get(position)));

        TextView NumPlayers = holder.NumberPlayers;
        NumPlayers.setText(_gameNumPlayersList.get(position));

    }

    @Override
    public int getItemCount() {
        return _gameList.size();
    }

    public void updateGameList(ArrayList<String> _gameList, ArrayList<Integer> _gameIDList, ArrayList<String> _gameNumPlayersList) {
        this._gameList = _gameList;
        this._gameIDList = _gameIDList;
        this._gameNumPlayersList = _gameNumPlayersList;
//        notifyDataSetChanged();
    }
}
