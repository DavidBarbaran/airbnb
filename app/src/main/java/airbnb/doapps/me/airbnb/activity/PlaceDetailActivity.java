package airbnb.doapps.me.airbnb.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import airbnb.doapps.me.airbnb.R;
import airbnb.doapps.me.airbnb.adapter.InfoAdapter;
import airbnb.doapps.me.airbnb.adapter.RoomAdapter;
import airbnb.doapps.me.airbnb.fragment.MapsFragment;
import airbnb.doapps.me.airbnb.model.Info;
import airbnb.doapps.me.airbnb.model.Place;
import airbnb.doapps.me.airbnb.model.Room;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlaceDetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_place_imageview)
    ImageView detailPlaceImageview;

    @BindView(R.id.transparent_toolbar)
    Toolbar transparentToolbar;

    @BindView(R.id.info_recycler)
    RecyclerView infoRecycler;

    @BindView(R.id.room_recycler)
    RecyclerView roomRecycler;


    private LinearLayoutManager horizontalLayoutManager;

    private InfoAdapter infoAdapter;
    private List<Info> listInfo = new ArrayList<>();

    private RoomAdapter roomAdapter;
    private List<Room> listRoom = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        ButterKnife.bind(this);

        Place item = (Place) getIntent().getSerializableExtra("item");
        detailPlaceImageview.setImageResource(item.getImagePlace());

        // Custom toolbar

        setSupportActionBar(transparentToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        transparentToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Recycler Info

        infoAdapter = new InfoAdapter(listInfo,this);
        horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        infoRecycler.setLayoutManager(horizontalLayoutManager);

        infoRecycler.setAdapter(infoAdapter);
        infoRecycler.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        setInfoData();

        // Recycler room

        roomAdapter = new RoomAdapter(listRoom,this);
        horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        roomRecycler.setLayoutManager(horizontalLayoutManager);
        roomRecycler.setAdapter(roomAdapter);
        setRoomData();


        // Google Maps


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_map, new MapsFragment(), "map")
                .disallowAddToBackStack()
                .commit();


    }

    @OnClick(R.id.tittle_place_text)
    public void startMapActivity(){
        startActivity(new Intent(this, MapsFragment.class));
    }

    private void setInfoData(){
        listInfo.add(new Info("6 huespedes",R.drawable.ic_guest));
        listInfo.add(new Info("3 dormitorios",R.drawable.ic_room));
        listInfo.add(new Info("3 camas",R.drawable.ic_bed));
        listInfo.add(new Info("2 baños",R.drawable.ic_shower));
    }

    private void setRoomData(){
        listRoom.add(new Room(R.drawable.ic_bed,"Dormitorio 1","1 cama king size"));
        listRoom.add(new Room(R.drawable.ic_coach,"Zonas comunes","1 sófa"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
