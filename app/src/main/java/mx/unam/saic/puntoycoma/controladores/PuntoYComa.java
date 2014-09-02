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
    //parse sirve para hacer el baacken de la aplicación más fácil  guardar los datos en la nube sin tanto esfuerzo 
    //al igual que nos ayudara a mandar push notification a los usuarios
    //lo estamos utilizando para ayudarnos con el login ya sea con facebook, twitter o google+
    //con esto una vez que el usuario a escojido su metodo de logeo unicamente podrá accesar con este 

    @Override
    public void onCreate() {
        super.onCreate();
        //agregamos un objeto del tipo parse
        ParseObject.registerSubclass(RegistroAlumno.class);
        //el metodo initialie recibe el contecto, el id de la aplicacion y la clave del cliente
        Parse.initialize(this,"1ql3XlJtl10nO1X86VjWoTvoltA7XDQuWI1agRL0", "8HUgFFJYx1pl0JXiDyuEINGcNYwxRnlC3SKyTEHT");
        ParseUser.enableAutomaticUser();

		/*
		 * For more information on app security and Parse ACL:
		 * https://www.parse.com/docs/android_guide#security-recommendations
		 */

        //restrigimos el acceso a los datos
        ParseACL defaultACL = new ParseACL();

		/*
		 * If you would like all objects to be private by default, remove this
		 * line
		 */
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

    }
}
