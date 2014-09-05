package mx.unam.saic.puntoycoma.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jagspage2013 on 28/08/14.
 */
//clase que se encarga de guardar en memoria el nombre del usuario y regresar el nombre
public class Constants {

    public static final String TAG = "puntoycoma";

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
