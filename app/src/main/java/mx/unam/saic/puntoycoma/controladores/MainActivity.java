package mx.unam.saic.puntoycoma.controladores;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.plus.PlusClient;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.util.ConnectionDetector;


public class MainActivity extends ActionBarActivity implements View.OnClickListener,ConnectionCallbacks, OnConnectionFailedListener{

    public static final int REQUEST_CODE_RESOLVE_ERR = 9000;
    private ProgressDialog mConnectionProgressDialog;
    private PlusClient mPlusClient;
    private ConnectionResult mConnectionResult;
    private Button registro;
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
        mPlusClient = new PlusClient.Builder(this,this,this).
        setActions("http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity").
        setScopes("PLUS_LOGIN").
        build();

        findViewById(R.id.sing_in_button).setOnClickListener(this);
        mConnectionProgressDialog = new ProgressDialog(this);
        mConnectionProgressDialog.setMessage("Iniciando Sesión");

        if(!(new ConnectionDetector(this).isConnectedToInternet())){
            Log.d("SAIC","No está Conectado a internet... haz algo duh");
        }

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (status != ConnectionResult.SUCCESS) { // Google Play Services are not available
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,
                    this, requestCode);
            dialog.show();
        }
		
		//agregando registro
		registro = (Button) findViewById(R.id.ir_registrar);
        registro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
            }
        });


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
        if (requestCode == REQUEST_CODE_RESOLVE_ERR && resultCode == RESULT_OK) {
            mConnectionResult = null;
            mPlusClient.connect();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPlusClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlusClient.disconnect();
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
                        Log.d("SAIC","EL USUARIO ES : "+ user.getFirstName() + user.getMiddleName() +user.getLastName());
                    }
                }
                if (response.getError() != null) {
                    Log.d("SAIC","EL Error ES : "+ response.getRawResponse());
                }
            }
        });
        request.executeAsync();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mConnectionProgressDialog.dismiss();
        //Log.d("SAIC","Google Plus name = "+name);
    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        if(connectionResult.hasResolution()){
            try {
                connectionResult.startResolutionForResult(this,REQUEST_CODE_RESOLVE_ERR);
            }catch (IntentSender.SendIntentException e){
                mPlusClient.connect();
            }
        }
        mConnectionResult = connectionResult;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.sing_in_button && !mPlusClient.isConnected()){
            if(mConnectionResult == null){
                mConnectionProgressDialog.show();
            }else{
                try {
                    mConnectionResult.startResolutionForResult(this,REQUEST_CODE_RESOLVE_ERR);
                }catch (IntentSender.SendIntentException e){
                    mConnectionResult=null;
                    mPlusClient.connect();
                }
            }
        }
    }
}
