package airbnb.doapps.me.airbnb.model;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import java.util.List;

/**
 * Created by jorgeek on 20/09/17.
 */

public class Home {

    private String tittle;
    private RecyclerView.Adapter adapter;
    private int orientation;
    private SnapHelper snap;
    private RecyclerView recyclerView;

    public Home(String tittle, RecyclerView.Adapter adapter, int orientation, SnapHelper snap) {
        this.tittle = tittle;
        this.adapter = adapter;
        this.orientation = orientation;
        this.snap = snap;
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

    public SnapHelper getSnap() {
        return snap;
    }

    public void setSnap(SnapHelper snap) {
        this.snap = snap;
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
