package airbnb.doapps.me.airbnb.util;

import android.view.View;

import airbnb.doapps.me.airbnb.model.Place;

/**
 * Created by jorgeek on 21/09/17.
 */

public interface OnItemClickListener {

    void onItemClick( View view, int position,Place item);

}
