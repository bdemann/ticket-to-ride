package view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a340team.tickettoride.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import shared.model.interfaces.Message;

/**
 * Created by bdemann on 3/8/18.
 */

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.ViewHolder> {

    List<? extends Message> messages;

    public MessageRecyclerAdapter(List<? extends Message> messages){
        this.messages = messages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.chat_item, parent, false);
        MessageRecyclerAdapter.ViewHolder viewHolder = new MessageRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView message = holder.message;
        TextView username = holder.username;
        TextView date = holder.date;

        Message m = messages.get(position);

        message.setText(m.getMessage());
        username.setText(m.getUsername());
        DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, HH:mm:ss z");
        date.setText(dateFormat.format(m.getTime()));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView message;
        public TextView username;
        public TextView date;

        public ViewHolder(final View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.message);
            username = (TextView) itemView.findViewById(R.id.metadata_username);
            date = (TextView) itemView.findViewById(R.id.metadata_time);

        }

        @Override
        public void onClick(View v) {
            //This recycler view just displays information. YAY! Easy!
        }
    }
}
