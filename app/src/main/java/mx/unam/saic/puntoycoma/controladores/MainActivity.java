package mx.unam.saic.puntoycoma.controladores;

import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.util.ConnectionDetector;
import mx.unam.saic.puntoycoma.util.Constants;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {


    private GoogleApiClient apiClient;
    private ConnectionResult mConnectionResult;
    private UiLifecycleHelper uiHelper;
    private boolean mIntentInProgress;
    private boolean mSignInClicked;
    private static final int RC_SIGN_IN = 0;
    private SignInButton btn_sign_in;


    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if (!Constants.getName(this).equals("")) {
            goToNextActivity();
        }
        //controles de ¿facebook?
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);
        apiClient = new GoogleApiClient.Builder(this).
                addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN).build();

        btn_sign_in = ((SignInButton) findViewById(R.id.sing_in_button));
        btn_sign_in.setOnClickListener(this);


        if (!(ConnectionDetector.isConnectedToInternet(this))) {
            Log.d(Constants.TAG, "No está Conectado a internet...");
        }

        //int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        /*if (status != ConnectionResult.SUCCESS) { // Google Play Services are not available
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,
                    this, requestCode);
            dialog.show();
        }*/



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sing_in_button:
                signInToGooglePlus();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);

    }

    //aqui se guarda el estado de la conexion, si se logro o no
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);


        if (requestCode == RC_SIGN_IN) {
            if (resultCode != RESULT_OK) {
                mSignInClicked = false;
            }
            mIntentInProgress = false;
            if (!apiClient.isConnecting()) {
                apiClient.connect();
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.onResume();

    }


    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        apiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (apiClient.isConnected()) {
            apiClient.disconnect();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    //dice el estado de la secion, si esta iniciada o no
    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (session != null && state.isOpened()) {
            Log.i(Constants.TAG, "Logged in...");
            if (Constants.getName(this).equals("")) {
                makeARequest(session);
            } else {
                if(!Constants.getName(this).equals(""))
                    goToNextActivity();
            }

        } else if (state.isClosed()) {
            Log.i(Constants.TAG, "Logged out...");
            Constants.setName(this, "");
        }
    }

    //ayudara con el estado de la secion en ¿facebook?
    private void makeARequest(final Session session) {

        Request request = Request.newMeRequest(session, new Request.GraphUserCallback() {
            @Override
            public void onCompleted(GraphUser user, Response response) {
                if (session == Session.getActiveSession()) {
                    if (user != null) {
                        Log.d(Constants.TAG, "EL USUARIO ES : " + user.getFirstName() + user.getMiddleName() + user.getLastName());
                        Constants.setName(getApplicationContext(), user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName());
                        goToFormularioActivity();

                    }
                    if (response.getError() != null) {
                        Log.d(Constants.TAG, "EL Error ES : " + response.getRawResponse());
                    }
                }
            }
        });
        request.executeAsync();
    }

    //si se resuelven todos los errores
    @Override
    public void onConnected(Bundle bundle) {
        mSignInClicked = false;
        if (Constants.getName(this).equals("")) {
            getProfileInformation();
        }
    }


    private void goToFormularioActivity() {
        Intent intent = new Intent(MainActivity.this, Registro.class);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.HONEYCOMB) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(intent);
    }


    @Override
    public void onConnectionSuspended(int i) {
        apiClient.connect();
    }

    //si PlusClient falla este actuara para tratar de estableces la conexion
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        if (!result.hasResolution()) {
            //GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(), this, 0).show();
            return;
        }

        if (!mIntentInProgress) {
            mConnectionResult = result;
            if (mSignInClicked) {
                resolveSignInError();
            }
        }

    }

    private void resolveSignInError() {
        if(mConnectionResult != null) {
            if (mConnectionResult.hasResolution()) {
                try {
                    mIntentInProgress = true;
                    mConnectionResult.startResolutionForResult(this, RC_SIGN_IN);
                } catch (IntentSender.SendIntentException e) {
                    mIntentInProgress = false;
                    apiClient.connect();
                }
            }
        }
    }


    private void signInToGooglePlus() {

        if (!apiClient.isConnecting()) {
            mSignInClicked = true;
            resolveSignInError();
        }
    }


    private void getProfileInformation() {
        try {
            if (Plus.PeopleApi.getCurrentPerson(apiClient) != null) {
                Person currentPerson = Plus.PeopleApi
                        .getCurrentPerson(apiClient);
                String personName = currentPerson.getDisplayName();

                if (!personName.equals("")) {
                    Constants.setName(this, personName);
                    goToFormularioActivity();
                }

            } else {
                Toast.makeText(getApplicationContext(),
                        "Person information is null", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goToNextActivity() {
        Intent intent = new Intent(MainActivity.this, ActivityPuntoYComa.class);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.HONEYCOMB) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(intent);
    }
}
