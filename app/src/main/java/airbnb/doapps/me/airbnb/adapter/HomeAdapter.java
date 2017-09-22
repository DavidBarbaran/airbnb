package airbnb.doapps.me.airbnb.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import airbnb.doapps.me.airbnb.R;
import airbnb.doapps.me.airbnb.model.Home;

/**
 * Created by jorgeek on 20/09/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.CustomViewHolder> {
    private List<Home> homeItemList;
    private Context mContext;

    public HomeAdapter(Context context, List<Home> feedItemList) {
        this.homeItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_item, viewGroup,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Home item = homeItemList.get(i);
        item.setRecyclerView(customViewHolder.recycler);
        customViewHolder.tittleHeaderHometextView.setText(homeItemList.get(i).getTittle());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, homeItemList.get(i).getOrientation(), false);
        customViewHolder.recycler.setHasFixedSize(true);
        customViewHolder.recycler.setLayoutManager(mLayoutManager);
        customViewHolder.recycler.setAdapter(homeItemList.get(i).getAdapter());

        SnapHelper helper = new LinearSnapHelper();

        helper.attachToRecyclerView( customViewHolder.recycler);
    }

    @Override
    public int getItemCount() {
        return (null != homeItemList ? homeItemList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected RecyclerView recycler;
        protected TextView tittleHeaderHometextView;

        public CustomViewHolder(View view) {
            super(view);
            this.recycler= (RecyclerView) view.findViewById(R.id.home_recycler);
            this.tittleHeaderHometextView = (TextView) view.findViewById(R.id.tittle_header_home_item);
        }
    }
}