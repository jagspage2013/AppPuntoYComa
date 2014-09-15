package mx.unam.saic.puntoycoma.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.adaptadores.EventoAdapter;
import mx.unam.saic.puntoycoma.objetos.Listas;
import mx.unam.saic.puntoycoma.util.Constants;


public class EventoFragment extends Fragment  {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context contexto;

    public static  Fragment newInstanceOf(int sectionNumber){
        EventoFragment fragment = new EventoFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ARG_DAY, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new EventoAdapter(Listas.getListaPorLugar(getArguments().getInt(Constants.ARG_DAY)),contexto);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evento, container, false);
        ((TextView)view.findViewById(R.id.lbl_dia_VIEW)).setText(Constants.CEDES[getArguments().getInt(Constants.ARG_DAY)]);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(contexto);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        contexto = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
