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

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.adaptadores.EventoAdapter;
import mx.unam.saic.puntoycoma.controladores.ActivityPuntoYComa;
import mx.unam.saic.puntoycoma.fragments.dummy.DummyContent;
import mx.unam.saic.puntoycoma.util.Constants;


public class EventoFragment extends Fragment  {

    private OnEventFragmentInteraction mListener;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context contexto;

    public static  Fragment newInstanceOf(int sectionNumber){
        EventoFragment fragment = new EventoFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new EventoAdapter(DummyContent.ITEMS);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evento, container, false);
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
        try {
            mListener = (OnEventFragmentInteraction) activity;
            ((ActivityPuntoYComa) activity).onSectionAttached(
                    getArguments().getInt(Constants.ARG_SECTION_NUMBER));
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnEventFragmentInteraction {
        public void onEventFragmentInteraction(String id);
    }

}
