package mx.unam.saic.puntoycoma.fragments;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import mx.unam.saic.puntoycoma.R;

/**
 * Created by jagspage2013 on 15/09/14.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class PreferencesFragmentPyC extends PreferenceFragment implements Preference.OnPreferenceClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.info);
        Preference face_s = findPreference("face_s");
        Preference twit_s = findPreference("twit_s");
        Preference face_y = findPreference("face_y");
        Preference twit_y = findPreference("twit_y");

        face_s.setOnPreferenceClickListener(this);
        face_y.setOnPreferenceClickListener(this);
        twit_s.setOnPreferenceClickListener(this);
        twit_y.setOnPreferenceClickListener(this);

    }

    @Override
    public boolean onPreferenceClick(Preference preference) {

        Intent intent = null;
        if (preference.getKey().compareTo("face_y") == 0) {
            try {
                getActivity().getPackageManager().getPackageInfo(
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
                getActivity().getPackageManager().getPackageInfo(
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
}
