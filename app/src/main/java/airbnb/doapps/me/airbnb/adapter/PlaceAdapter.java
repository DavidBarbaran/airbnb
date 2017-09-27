package airbnb.doapps.me.airbnb.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import airbnb.doapps.me.airbnb.R;
import airbnb.doapps.me.airbnb.model.Place;
import airbnb.doapps.me.airbnb.util.OnItemClickListener;
import airbnb.doapps.me.airbnb.util.ScreenUtil;

/**
 * Created by jorgeek on 20/09/17.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ItemPlaceViewHolder> {

    private List<Place> placeItemList;
    private Context mContext;
    private static OnItemClickListener onItemClickListener;

    public PlaceAdapter(List<Place> placeItemList, Context mContext, OnItemClickListener onItemClickListener) {
        this.placeItemList = placeItemList;
        this.mContext = mContext;
        this.onItemClickListener  = onItemClickListener;
    }

    public PlaceAdapter(List<Place> placeItemList, Context mContext) {
        this.placeItemList = placeItemList;
        this.mContext = mContext;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @Override
    public ItemPlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item, parent,false);
        PlaceAdapter.ItemPlaceViewHolder viewHolder = new PlaceAdapter.ItemPlaceViewHolder(view);
        int spacing = (int) mContext.getResources().getDimension(R.dimen.spacing24);
        int margin = (int) mContext.getResources().getDimension(R.dimen.spacing6);
        view.getLayoutParams().width = ScreenUtil.getScreenWidth(mContext)-(spacing*2)-(margin*2);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemPlaceViewHolder holder, final int position) {
        holder.imagePlace.setImageResource(placeItemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return placeItemList.size();
    }

    class ItemPlaceViewHolder extends RecyclerView.ViewHolder {

        protected final View rootView;
        protected final ImageView imagePlace;
        protected final TextView tittlePlaceTextView;
        protected final TextView descriptionPlaceTextView;
        protected final TextView priceTextView;
        protected final RatingBar calificationRatingBar;
        protected final TextView calificationTextView;

        ItemPlaceViewHolder(View view) {
            super(view);

            rootView = view;
            imagePlace =  view.findViewById(R.id.place_image);
            tittlePlaceTextView =view.findViewById(R.id.tittle_place_textview);
            descriptionPlaceTextView =view.findViewById(R.id.description_textview);
            priceTextView = view.findViewById(R.id.price_place_textview);
            calificationRatingBar = view.findViewById(R.id.calification_ratingbar);
            calificationTextView = view.findViewById(R.id.calification_textview);

            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position  = ItemPlaceViewHolder.super.getAdapterPosition();
                    onItemClickListener.onItemClick(view,position,placeItemList.get(position));
                }
            });
        }
    }
}