package cl.ipgv.frutossecoschillan2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.ipgv.frutossecoschillan2.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng frutosbosque = new LatLng(-36.614653, -72.091267);
        LatLng frutosbosque2 = new LatLng(-36.612638, -72.103820);
        LatLng frutosbosque3 = new LatLng(-36.612156, -72.089572);
        LatLng frutosbosque4 = new LatLng(-36.615204, -72.105043);
        LatLng frutosbosque5 = new LatLng(-36.612379, -72.108004);

        mMap.addMarker(new MarkerOptions().position(frutosbosque).title("Tienda De Frutos Del Bosque"));
        mMap.addMarker(new MarkerOptions().position(frutosbosque2).title("Central Frutos Del Bosque"));
        mMap.addMarker(new MarkerOptions().position(frutosbosque3).title("Bodega Frutos Del Bosque"));
        mMap.addMarker(new MarkerOptions().position(frutosbosque4).title("Tienda Frutos Del Bosque Ajeno"));
        mMap.addMarker(new MarkerOptions().position(frutosbosque5).title("Recursos Frutos Del Bosque"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(frutosbosque));
        mMap.setMinZoomPreference(4.0F);
        mMap.setMaxZoomPreference(18.0F);

    }
}