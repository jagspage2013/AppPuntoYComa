package mx.unam.saic.puntoycoma.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.adaptadores.DayPagerAdapter;
import mx.unam.saic.puntoycoma.controladores.ActivityPuntoYComa;
import mx.unam.saic.puntoycoma.util.Constants;

public class DiasFragment extends Fragment {

    ViewPager pager ;
    TabPageIndicator indicator;


    public static Fragment newInstanceOf(int sectionNumber){
        DiasFragment fragment = new DiasFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dias, container, false);
        pager = (ViewPager)view.findViewById(R.id.pager);
        indicator = (TabPageIndicator)view.findViewById(R.id.pagerIndicator);
        pager.setAdapter( new DayPagerAdapter(getFragmentManager()));
        pager.setOffscreenPageLimit(3);
        indicator.setViewPager(pager);
        return view;
    }
}
