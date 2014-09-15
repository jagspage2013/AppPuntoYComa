package mx.unam.saic.puntoycoma.adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.viewpagerindicator.IconPagerAdapter;

import mx.unam.saic.puntoycoma.fragments.EventoFragment;
import mx.unam.saic.puntoycoma.util.Constants;

/**
 * Created by jagspage2013 on 13/09/14.
 */
public class DayPagerAdapter extends FragmentStatePagerAdapter  {


    public DayPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Log.d(Constants.TAG,"Entra get item del pager");return EventoFragment.newInstanceOf(i);
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "17 Sept";
            case 1: return "18 Sept";
            case 2: return "19 Sept";
        }
        return null;
    }
}
