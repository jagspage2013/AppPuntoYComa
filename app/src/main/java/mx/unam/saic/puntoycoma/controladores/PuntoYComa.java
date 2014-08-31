package mx.unam.saic.puntoycoma.controladores;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import mx.unam.saic.puntoycoma.objetos.RegistroAlumno;

/**
 * Created by jagspage2013 on 28/08/14.
 */
public class PuntoYComa extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(RegistroAlumno.class);

        Parse.initialize(this,"1ql3XlJtl10nO1X86VjWoTvoltA7XDQuWI1agRL0", "8HUgFFJYx1pl0JXiDyuEINGcNYwxRnlC3SKyTEHT");
        ParseUser.enableAutomaticUser();

		/*
		 * For more information on app security and Parse ACL:
		 * https://www.parse.com/docs/android_guide#security-recommendations
		 */
        ParseACL defaultACL = new ParseACL();

		/*
		 * If you would like all objects to be private by default, remove this
		 * line
		 */
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

    }
}
