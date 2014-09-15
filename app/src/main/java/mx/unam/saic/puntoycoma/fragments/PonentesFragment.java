package mx.unam.saic.puntoycoma.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.adaptadores.PonenteAdapter;
import mx.unam.saic.puntoycoma.controladores.ActivityPuntoYComa;
import mx.unam.saic.puntoycoma.objetos.Listas;
import mx.unam.saic.puntoycoma.util.Constants;

/**
 * Created by jagspage2013 on 14/09/14.
 */
public class PonentesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context contexto;

    public static Fragment newInstanceOf(int sectionNumber){
        PonentesFragment fragment = new PonentesFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ((ActivityPuntoYComa) activity).onSectionAttached(
                    getArguments().getInt(Constants.ARG_SECTION_NUMBER));
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
        contexto = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new PonenteAdapter(Listas.ponentes);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ponentes, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.pon_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(contexto);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

}
