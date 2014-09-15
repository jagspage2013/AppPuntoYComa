package mx.unam.saic.puntoycoma.controladores;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.fragments.DiasFragment;
import mx.unam.saic.puntoycoma.fragments.EventoFragment;
import mx.unam.saic.puntoycoma.fragments.LugaresFragment;
import mx.unam.saic.puntoycoma.fragments.NavigationDrawerFragment;
import mx.unam.saic.puntoycoma.fragments.PonentesFragment;
import mx.unam.saic.puntoycoma.objetos.Listas;
import mx.unam.saic.puntoycoma.objetos.Lugar;
import mx.unam.saic.puntoycoma.objetos.Ponente;
import mx.unam.saic.puntoycoma.util.Constants;

public class ActivityPuntoYComa extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks{

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private int CURRENT_FRAG;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_punto_ycoma);
        fragmentManager = getSupportFragmentManager();
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        CURRENT_FRAG = 0;

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        Listas listas = new Listas();
        fragmentManager.beginTransaction().replace(R.id.container, DiasFragment.newInstanceOf(CURRENT_FRAG)).commit();

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Log.d(Constants.TAG, "La posición es : " + position);
        if(position!=CURRENT_FRAG) {
            switch (position) {
                case 0: {
                    fragmentManager.beginTransaction().replace(R.id.container, DiasFragment.newInstanceOf(position)).commit();
                    CURRENT_FRAG = 0;
                    }
                    break;
                case 1: {
                    fragmentManager.beginTransaction().replace(R.id.container, LugaresFragment.newInstanceOf(position)).commit();
                    CURRENT_FRAG = 1;
                    }
                    break;
                case 2:{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eventbrite.es/e/12890043467")));
                }
                break;
                case 3:{
                    startActivity(new Intent(ActivityPuntoYComa.this,AcercaDe.class));

                }
                break;
            }
        }
        Log.d(Constants.TAG,"Posición actual:  ... YOLO "+CURRENT_FRAG );
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getString(R.string.title_section1);
                break;
            case 1:
                mTitle = getString(R.string.title_section2);
                break;
            default:
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.activity_punto_ycoma, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

}
