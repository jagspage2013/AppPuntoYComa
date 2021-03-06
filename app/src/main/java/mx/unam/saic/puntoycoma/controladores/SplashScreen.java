package mx.unam.saic.puntoycoma.controladores;

import java.util.Timer;
import java.util.TimerTask;
 

import mx.unam.saic.puntoycoma.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
 

public class SplashScreen extends Activity {
 
    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 1500;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
 
        setContentView(R.layout.splashscreen);
 
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
 
                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);
 
                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };
 
        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
 
}
