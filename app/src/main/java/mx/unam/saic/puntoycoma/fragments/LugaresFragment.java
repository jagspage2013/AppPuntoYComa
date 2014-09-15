package mx.unam.saic.puntoycoma.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.controladores.ActivityPuntoYComa;
import mx.unam.saic.puntoycoma.objetos.Listas;
import mx.unam.saic.puntoycoma.util.Constants;

/**
 * Created by jagspage2013 on 13/09/14.
 */
public class LugaresFragment extends Fragment implements View.OnClickListener {


    private GoogleMap mMap;


    public static Fragment newInstanceOf(int sectionNumber) {
        LugaresFragment fragment = new LugaresFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MapsInitializer.initialize(activity); // iniciamos el mapa!
        try {
            ((ActivityPuntoYComa) activity).onSectionAttached(
                    getArguments().getInt(Constants.ARG_SECTION_NUMBER));
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_lugares, null);
        vi.findViewById(R.id.btn_ciencias).setOnClickListener(this);
        vi.findViewById(R.id.btn_ingenieria).setOnClickListener(this);
        vi.findViewById(R.id.btn_posgrado).setOnClickListener(this);
        return vi;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (mMap == null)
            mMap = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        iniciaMapa();
        for (int i = 0; i < 3; i++)
            agregaIconos(i);

    }

    private void agregaIconos(int i) {
        MarkerOptions op = new MarkerOptions().
                position(new LatLng(Listas.lugares.get(i).getLatitud(), Listas.lugares.get(i).getLongitud())).
                title(Listas.lugares.get(i).getNombre()).icon(BitmapDescriptorFactory.fromResource(R.drawable.facs));

        mMap.addMarker(op);

    }

    private void iniciaMapa() {
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.getUiSettings().setCompassEnabled(false);
        mMap.getUiSettings().setAllGesturesEnabled(false);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                .target(new LatLng(19.3280742, -99.1816948))
                .zoom(15)
                .build()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ciencias:
                ubicarCede(0);
                break;
            case R.id.btn_ingenieria:
                ubicarCede(1);
                break;
            case R.id.btn_posgrado:
                ubicarCede(2);
                break;
        }
    }

    private void ubicarCede(int i) {
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder()
                .target(new LatLng(Listas.lugares.get(i).getLatitud(), Listas.lugares.get(i).getLongitud()))
                .zoom(17.0f)
                .tilt(90)
                .build()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            SupportMapFragment f = (SupportMapFragment) getFragmentManager()
                    .findFragmentById(R.id.map);
            if (f != null)
                getFragmentManager().beginTransaction().remove(f).commit();
        } catch (Exception e) {
        }

    }
}