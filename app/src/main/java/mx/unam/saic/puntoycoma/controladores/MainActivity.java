package mx.unam.saic.puntoycoma.controladores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.LoginButton;
import com.facebook.widget.ProfilePictureView;

import mx.unam.saic.puntoycoma.R;


public class MainActivity extends ActionBarActivity {

    private LoginButton loginButton;
    private ProfilePictureView profilePictureView;
    private TextView greeting;
    //private ViewGroup controlsContainer;
    private UiLifecycleHelper uiHelper;
    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.onResume();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (session != null && state.isOpened()) {
            Log.i("SAIC", "Logged in...");
            makeARequest(session);
        } else if (state.isClosed()) {
            Log.i("SAIC", "Logged out...");
        }
    }

    private void makeARequest(final Session session) {

        Request request = Request.newMeRequest(session, new Request.GraphUserCallback() {
            @Override
            public void onCompleted(GraphUser user, Response response) {
                if(session == Session.getActiveSession()){
                    if(user!= null){
                        Log.d("SAIC","EL USUARIO ES : "+ user.getFirstName());

                    }
                }
                if (response.getError() != null) {
                    Log.d("SAIC","EL Error ES : "+ response.getRawResponse());
                }
            }
        });
        request.executeAsync();
    }

}
