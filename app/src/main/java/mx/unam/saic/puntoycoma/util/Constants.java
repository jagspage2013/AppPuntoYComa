package mx.unam.saic.puntoycoma.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Constants {

    public static final String TAG = "puntoycoma";
    public static int CURRENT_FRAG ;
    public static final String  ARG_SECTION_NUMBER = "section_number";


    public static void setName(Context context,String name){
        SharedPreferences.Editor edit =  context.getSharedPreferences(Constants.TAG,Context.MODE_PRIVATE).edit();
        edit.putString("nombre",name);
        edit.apply();
    }

    public static String getName(Context context){
        String nombre = context.getSharedPreferences(Constants.TAG,Context.MODE_PRIVATE).getString("nombre","");
        return nombre;
    }
}
