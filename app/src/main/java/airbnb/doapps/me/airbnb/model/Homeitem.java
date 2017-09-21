package airbnb.doapps.me.airbnb.model;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by jorgeek on 20/09/17.
 */

public class Homeitem {

    private String tittle;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private int orientation;

    public Homeitem(String tittle, RecyclerView.Adapter adapter, int orientation) {
        this.tittle = tittle;
        this.adapter = adapter;
        this.orientation = orientation;
    }


    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
