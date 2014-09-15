package mx.unam.saic.puntoycoma.controladores;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.fragments.PreferencesFragmentPyC;

/**
 * Created by jagspage2013 on 15/09/14.
 */
public class AcercaDe extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            addPreferencesFromResource(R.xml.info);

            crear_oyente();
        } else {
            try {
                getActionBar().setDisplayHomeAsUpEnabled(true);
            } catch (NullPointerException e) {

            }
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new PreferencesFragmentPyC())
                    .commit();
        }

        getListView().setDivider(new ColorDrawable(android.R.color.white));
        getListView().setDividerHeight(5);
    }


    @SuppressWarnings("deprecation")
    public void crear_oyente() {
        Preference.OnPreferenceClickListener clickListener = new Preference.OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference preference) {

                Intent intent = null;
                if (preference.getKey().compareTo("face_y") == 0) {
                    try {
                        getPackageManager().getPackageInfo(
                                "com.facebook.katana", 0);
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("fb://profile/353466471458710"));
                    } catch (Exception e) {
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.facebook.com/yobibytelabs"));
                    }

                } else if (preference.getKey().compareTo("twit_y") == 0) {

                    try {
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=yobibytelabs"));
                    } catch (Exception e) {
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/yobibytelabs"));
                    }

                } else if (preference.getKey().compareTo("face_s") == 0) {
                    try {
                        getPackageManager().getPackageInfo(
                                "com.facebook.katana", 0);
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("fb://profile/651107011570299"));
                    } catch (Exception e) {
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.facebook.com/SAICFI"));
                    }

                } else if (preference.getKey().compareTo("twit_s") == 0) {
                    try {
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=saicfi"));
                    } catch (Exception e) {
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/saicfi"));
                    }

                }

                startActivity(intent);
                return false;
            }
        };

        Preference face_s = findPreference("face_s");
        Preference twit_s = findPreference("twit_s");
        Preference face_y = findPreference("face_y");
        Preference twit_y = findPreference("twit_y");

        face_s.setOnPreferenceClickListener(clickListener);
        face_y.setOnPreferenceClickListener(clickListener);
        twit_s.setOnPreferenceClickListener(clickListener);
        twit_y.setOnPreferenceClickListener(clickListener);

    }

}
