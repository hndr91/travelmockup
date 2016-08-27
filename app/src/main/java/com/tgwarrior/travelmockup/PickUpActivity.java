package com.tgwarrior.travelmockup;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PickUpActivity extends ActionBarActivity implements OnMapReadyCallback {

    @BindView(R.id.order) LinearLayout order;
    @BindView(R.id.cancel) LinearLayout cancel;
    @BindView(R.id.pickUp) LinearLayout pickUp;
    GPSTracker gpsTracker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);
        ButterKnife.bind(this);

        gpsTracker = new GPSTracker(this);
        SupportMapFragment map = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        map.getMapAsync(this);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ReceipeActivity.class);
                startActivity(i);
            }
        });

        pickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        double latitude = 0.0;
        double longitude = 0.0;

        /* zoom levels
        *
    1: World
    5: Landmass/continent
    10: City
    15: Streets
    20: Buildings

        * */

        float zoom = 17.0f;
        if(!gpsTracker.canGetLocation()){
            gpsTracker.showSettingsAlert();
        }else{
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
        }

        LatLng latLng = new LatLng(latitude,longitude);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoom));
        googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
    }
}
