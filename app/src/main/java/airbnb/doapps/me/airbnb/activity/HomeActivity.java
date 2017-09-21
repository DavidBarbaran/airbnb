package airbnb.doapps.me.airbnb.activity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import airbnb.doapps.me.airbnb.R;
import airbnb.doapps.me.airbnb.adapter.HomeAdapter;
import airbnb.doapps.me.airbnb.adapter.PlaceAdapter;
import airbnb.doapps.me.airbnb.model.Homeitem;
import airbnb.doapps.me.airbnb.model.PlaceItem;
import airbnb.doapps.me.airbnb.util.OnItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.cardView)
    CardView searchBarCardView;

    @BindView(R.id.search_places_result_recycler)
    RecyclerView searchPlacesResultRecycler;

    private HomeAdapter homeAdapter;
    private List<Homeitem> homeItemList = new ArrayList<>();

    public static final String EXTRA_ANIMAL_ITEM = "animal_image_url";
    public static final String EXTRA_ANIMAL_IMAGE_TRANSITION_NAME = "animal_image_transition_name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        homeAdapter = new HomeAdapter(this, homeItemList);
        searchPlacesResultRecycler.setLayoutManager(new LinearLayoutManager(this));
        searchPlacesResultRecycler.setAdapter(homeAdapter);
        setData();
    }

    private void setData(){

        final List<PlaceItem> listItems = new ArrayList<>();

        PlaceItem placeItem = new PlaceItem();
        placeItem.setImagePlace(R.drawable.place);

        listItems.add(placeItem);
        listItems.add(placeItem);
        listItems.add(placeItem);
        listItems.add(placeItem);
        listItems.add(placeItem);

        PlaceAdapter placeAdapter = new PlaceAdapter(listItems,this);

        ((PlaceAdapter) placeAdapter ).setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, PlaceItem item) {
                startSharedActivity(view,position,item);
            }

        });

        Homeitem item = new Homeitem("Alojamientos",placeAdapter,LinearLayoutManager.HORIZONTAL);

        homeItemList.add(item);

        homeItemList.add(new Homeitem("Experiencias",placeAdapter,LinearLayoutManager.HORIZONTAL));

        homeItemList.add(new Homeitem("Otros lugares...",placeAdapter,LinearLayoutManager.HORIZONTAL));
    }

    @OnClick(R.id.search_bar_text)
    public void startSearchActivity(){
        startActivity(new Intent(this, SearchPlacesActivity.class));
        overridePendingTransition(R.anim.enter_to_top, R.anim.quiet_animation);
    }

    public void startSharedActivity(View view, int position, PlaceItem item) {

        View sharedView = view.findViewById(R.id.place_imageView);
        String transitionName = getString(R.string.image_transition_name);

        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this,  sharedView, transitionName);

        Intent intent = new Intent(this, PlaceDetailActivity.class);
        intent.putExtra("item", item);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}