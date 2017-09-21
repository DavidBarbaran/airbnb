package airbnb.doapps.me.airbnb.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import airbnb.doapps.me.airbnb.R;
import airbnb.doapps.me.airbnb.adapter.SearchPlaceNameAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class SearchPlacesActivity extends AppCompatActivity {

    @BindView(R.id.search_places_editText)
    EditText searchPlacesEditText;

    @BindView(R.id.places_name_recycler)
    RecyclerView placesNameRecycler;

    private SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_places);

        ButterKnife.bind(this);
        showkeyboard();
        sectionAdapter = new SectionedRecyclerViewAdapter();


        List<String> countries = new ArrayList<>();
        for (String contact : getResources().getStringArray(R.array.countries_array)) {
            countries.add(contact);
        }

        List<String> all = new ArrayList<>();
        all.add("Cerca de aqui");

        List<String> popular = new ArrayList<>();
        for (String contact : getResources().getStringArray(R.array.popular_places_array)) {
            popular.add(contact);
        }

        sectionAdapter.addSection(new SearchPlaceNameAdapter(null, all));
        sectionAdapter.addSection(new SearchPlaceNameAdapter("Busquedas recientes", countries));
        sectionAdapter.addSection(new SearchPlaceNameAdapter("Lugares populares cercanos", popular));


        placesNameRecycler.setLayoutManager(new LinearLayoutManager(this));
        placesNameRecycler.setAdapter(sectionAdapter);
    }

    private void showkeyboard(){

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        searchPlacesEditText.requestFocus();
                    }
                });

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

            }
        });
        t.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.quiet_animation, R.anim.exit_to_bottom);
    }

}
