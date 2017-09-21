package airbnb.doapps.me.airbnb.util;

import android.view.View;

import airbnb.doapps.me.airbnb.activity.HomeActivity;
import airbnb.doapps.me.airbnb.model.PlaceItem;

/**
 * Created by jorgeek on 21/09/17.
 */

public interface OnItemClickListener {

    void onItemClick( View view, int position,PlaceItem item);

}
