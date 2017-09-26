package airbnb.doapps.me.airbnb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import airbnb.doapps.me.airbnb.R;
import airbnb.doapps.me.airbnb.model.Room;

/**
 * Created by 0x7b1 on 9/21/17.
 */

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder>{

    private List<Room> infoList;
    private Context mContext;

    public RoomAdapter(List<Room> infoList, Context mContext) {
        this.infoList = infoList;
        this.mContext = mContext;
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_item, parent,false);
        RoomAdapter.RoomViewHolder viewHolder = new RoomAdapter.RoomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RoomViewHolder holder, int position) {
        holder.roomImageView.setImageResource(infoList.get(position).getImage());
        holder.tittleRoomTextView.setText(infoList.get(position).getTittle());
        holder.descriptionRoomTextView.setText(infoList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    class RoomViewHolder extends RecyclerView.ViewHolder {

        protected final View rootView;
        protected final ImageView roomImageView;
        protected final TextView tittleRoomTextView;
        protected final TextView descriptionRoomTextView;


        RoomViewHolder (View view) {
            super(view);

            rootView = view;
            roomImageView =  view.findViewById(R.id.room_imageView);
            tittleRoomTextView =view.findViewById(R.id.tittle_room_textView);
            descriptionRoomTextView=view.findViewById(R.id.description_room_textView);

        }
    }
}
