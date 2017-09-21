package airbnb.doapps.me.airbnb.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import airbnb.doapps.me.airbnb.R;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by jorgeek on 20/09/17.
 */


    public class SearchPlaceNameAdapter extends StatelessSection {

        String title;
        List<String> list;

    public SearchPlaceNameAdapter(String title, List<String> list) {
            super(new SectionParameters.Builder(R.layout.search_place_names_item)
                    .headerResourceId(R.layout.section_search_header)
                    .build());

            this.title = title;
            this.list = list;
        }

        @Override
        public int getContentItemsTotal() {
            return list.size();
        }

        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
            final ItemViewHolder itemHolder = (ItemViewHolder) holder;

            String name = list.get(position);
            itemHolder.namePlaceEditText.setText(name);
            //itemHolder.imgItem.setImageResource(name.hashCode() % 2 == 0 ? R.drawable.ic_face_black_48dp : R.drawable.ic_tag_faces_black_48dp);

            /*itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), String.format("Clicked on position #%s of Section %s", sectionAdapter.getPositionInSection(itemHolder.getAdapterPosition()), title), Toast.LENGTH_SHORT).show();
                }
            });*/
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderViewHolder(view);
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.searchHeaderItemTextView.setText(title);
            if(title==null){
                headerHolder.searchHeaderItemTextView.setVisibility(View.GONE);
            }
        }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        final TextView searchHeaderItemTextView;

        HeaderViewHolder(View view) {
            super(view);
            searchHeaderItemTextView = view.findViewById(R.id.search_header_item_textView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        final View rootView;
        //private final ImageView imgItem;
        final TextView namePlaceEditText;

        ItemViewHolder(View view) {
            super(view);

            rootView = view;
            //imgItem = (ImageView) view.findViewById(R.id.imgItem);
            namePlaceEditText =view.findViewById(R.id.name_place_textview);
        }
    }

}



