package airbnb.doapps.me.airbnb.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import airbnb.doapps.me.airbnb.R;
import butterknife.BindView;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        int status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getActivity());

        if(status == ConnectionResult.SUCCESS){
            Log.e("good","good");
            mapView = rootView.findViewById(R.id.map);
            mapView.onCreate(savedInstanceState);
            mapView.onResume();
            mapView.getMapAsync(this);

            MapsInitializer.initialize(this.getActivity());

        } else {
            Log.e("failed","f");

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getActivity(),10);
            dialog.show();
        }
        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setScrollGesturesEnabled(false);
        LatLng loc = new LatLng(-11.9359177, -77.0459141);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(loc,19);
        mMap.animateCamera(cameraUpdate);

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(loc.latitude, loc.longitude))
                .radius(20)
                .strokeColor(ResourcesCompat.getColor(getResources(), R.color.turquoise, null))
                .fillColor(ResourcesCompat.getColor(getResources(), R.color.turquoise80, null))
                .strokeWidth(3));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}