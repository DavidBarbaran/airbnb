package airbnb.doapps.me.airbnb.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import airbnb.doapps.me.airbnb.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchPlacesActivity extends AppCompatActivity {

    @BindView(R.id.search_places_editText)
    EditText searchPlacesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_places);

        ButterKnife.bind(this);


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.e("1","ok");

                //searchPlacesEditText.setFocusable(true);
                //searchPlacesEditText.setFocusableInTouchMode(true);
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
        overridePendingTransition(R.anim.exit_to_bottom, 0);
        super.onBackPressed();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart","ok");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume","ok");
    }

}
