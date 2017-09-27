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
import android.widget.TextView;

import java.util.List;

import airbnb.doapps.me.airbnb.R;
import airbnb.doapps.me.airbnb.model.Info;
import airbnb.doapps.me.airbnb.util.ScreenUtil;

/**
 * Created by 0x7b1 on 9/21/17.
 */

public class InfoAdapter  extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {

    private List<Info> infoList;
    private Context mContext;

    public InfoAdapter(List<Info> infoList, Context mContext) {
        this.infoList = infoList;
        this.mContext = mContext;
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_place_item, parent,false);
        InfoAdapter.InfoViewHolder viewHolder = new InfoAdapter.InfoViewHolder(view);
        int spacing = (int) mContext.getResources().getDimension(R.dimen.spacing24);
        int margin = (int) mContext.getResources().getDimension(R.dimen.spacing4);
        view.getLayoutParams().width = (ScreenUtil.getScreenWidth(mContext) - (spacing*2)-(margin*8))/4;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        holder.infoTextView.setText(infoList.get(position).getInfo());
        holder.infoImageView.setImageResource(infoList.get(position).getImageInfo());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }


    class InfoViewHolder extends RecyclerView.ViewHolder {

        protected final View rootView;
        protected final ImageView infoImageView;
        protected final TextView infoTextView;


        InfoViewHolder (View view) {
            super(view);

            rootView = view;
            infoImageView =  view.findViewById(R.id.info_imageView);
            infoTextView =view.findViewById(R.id.info_textView);

        }
    }
}
