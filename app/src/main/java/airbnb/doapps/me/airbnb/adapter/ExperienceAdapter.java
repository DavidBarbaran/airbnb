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
 * Created by jorgeek on 26/09/17.
 */

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ItemExpViewHolder>{

    private List<Place> placeItemList;
    private Context mContext;
    private static OnItemClickListener onItemClickListener;

    public ExperienceAdapter(List<Place> placeItemList, Context mContext, OnItemClickListener onItemClickListener) {
        this.placeItemList = placeItemList;
        this.mContext = mContext;
        this.onItemClickListener  = onItemClickListener;
    }

    public ExperienceAdapter(List<Place> placeItemList, Context mContext) {
        this.placeItemList = placeItemList;
        this.mContext = mContext;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @Override
    public ExperienceAdapter.ItemExpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_item, parent,false);
        ExperienceAdapter.ItemExpViewHolder viewHolder = new ExperienceAdapter.ItemExpViewHolder(view);
        int spacing = (int) mContext.getResources().getDimension(R.dimen.spacing24);
        int margin = (int) mContext.getResources().getDimension(R.dimen.spacing6);
        view.getLayoutParams().width =  (ScreenUtil.getScreenWidth(mContext)-(spacing*2)-(margin*2))/2;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ExperienceAdapter.ItemExpViewHolder holder, final int position) {
        holder.expImage.setImageResource(placeItemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return placeItemList.size();
    }

    class ItemExpViewHolder extends RecyclerView.ViewHolder {

        protected final View rootView;
        protected final ImageView expImage;
        protected final TextView tittleExpTextView;
        protected final TextView descriptionExpTextView;
        protected final TextView priceExpTextView;
        protected final RatingBar calificationRatingBar;
        protected final TextView calificationTextView;

        ItemExpViewHolder(View view) {
            super(view);

            rootView = view;
            expImage =  view.findViewById(R.id.experience_image);
            tittleExpTextView =view.findViewById(R.id.tittle_expe_textview);
            descriptionExpTextView =view.findViewById(R.id.description_exp_textview);
            priceExpTextView = view.findViewById(R.id.price_exp_textview);
            calificationRatingBar = view.findViewById(R.id.calification_ratingbar);
            calificationTextView = view.findViewById(R.id.calification_textview);

            /*rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position  = PlaceAdapter.ItemPlaceViewHolder.super.getAdapterPosition();
                    onItemClickListener.onItemClick(view,position,placeItemList.get(position));
                }
            });
            */
        }
    }

}
