package airbnb.doapps.me.airbnb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import airbnb.doapps.me.airbnb.activity.SearchPlacesActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.cardView)
    CardView searchBarCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.search_bar_text)
    public void startSearchActivity(){

        startActivity(new Intent(this, SearchPlacesActivity.class));
        overridePendingTransition(R.anim.enter_to_top, R.anim.quiet_animation);
    }
}
