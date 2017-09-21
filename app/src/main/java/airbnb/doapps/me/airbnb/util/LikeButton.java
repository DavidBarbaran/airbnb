package airbnb.doapps.me.airbnb.util;

import android.content.Context;
import android.util.AttributeSet;

import airbnb.doapps.me.airbnb.R;

/**
 * Created by jorgeek on 21/09/17.
 */

public class LikeButton extends com.like.LikeButton {
    public LikeButton(Context context) {
        super(context);
        setIconSizeDp(25);
        setUnlikeDrawableRes(R.drawable.ic_like);
        setLikeDrawableRes(R.drawable.ic_like_pressed);
    }

    public LikeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setIconSizeDp(25);
        setUnlikeDrawableRes(R.drawable.ic_like);
        setLikeDrawableRes(R.drawable.ic_like_pressed);
    }

    public LikeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setIconSizeDp(25);
        setUnlikeDrawableRes(R.drawable.ic_like);
        setLikeDrawableRes(R.drawable.ic_like_pressed);
    }
}
