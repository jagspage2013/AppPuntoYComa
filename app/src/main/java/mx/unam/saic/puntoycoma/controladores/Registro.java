package mx.unam.saic.puntoycoma.controladores;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.SaveCallback;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.objetos.RegistroAlumno;
import mx.unam.saic.puntoycoma.util.Constants;

//supongo que lo cambiaste para poder usar los menus
public class Registro extends ActionBarActivity {

    private Button registrar;
    private Spinner escuela;
    private Spinner carrera;
    private EditText otraEscuela;
    private EditText otraCarrera;
    private int op1, op2;//se declaran de forma global para usarlas como la posicion de los spinners
    public String[] escuelas;
    public String[] carreras;
    private String _escuela;
    private String _carrera;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        registrar = (Button) findViewById(R.id.button1);
        escuela = (Spinner) findViewById(R.id.escuela);
        carrera = (Spinner) findViewById(R.id.carrera);
        otraEscuela = (EditText) findViewById(R.id.otraescuela);
        otraCarrera = (EditText) findViewById(R.id.otracarrera);

        carreras = getResources().getStringArray(R.array.opc_carrera);//importamos los arrays, ya no son declarados dentro de esta
        escuelas = getResources().getStringArray(R.array.opc_escuela);//clase si no dentro de los arvhivos xml que se llaman aqui

        otraEscuela.setVisibility(View.INVISIBLE);
        otraCarrera.setVisibility(View.INVISIBLE);
        adaptarSpinner1();
        adaptarSpinner2();
        agregarEventoBoton();

    }

    //con este metodo se agregara al registro la escuela y carrera ya sea de los spinners o bien de los casos
    //especiales en los que la escuela o carrera no esten agregados en el spinner
    private void agregarEventoBoton() {
        registrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                if (op1 !=escuelas.length-1  && op2 != carreras.length-1) {
                    if (otraEscuela.getVisibility() == View.VISIBLE)
                        _escuela = otraEscuela.getText().toString();
                    else
                        _escuela = escuelas[op1];

                    if (otraCarrera.getVisibility() == View.VISIBLE)
                        _carrera = otraCarrera.getText().toString();
                    else
                        _carrera = carreras[op2];

                    if (!_escuela.isEmpty() && !_carrera.isEmpty()) {
                        enviarRegistro(_escuela, _carrera);
                        Log.d("SAIC","OP:"+escuelas.length+carreras.length);//salidas del registro
                    } else {
                        Toast.makeText(getBaseContext(), "Completa el registro", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getBaseContext(), "Completa el registro", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    //todo esto servira para el registro de los usuarios que entraran a punto y comma, con esto se guardaran los datos de
    //los usuarios en la nuve
    private void enviarRegistro(String escuela, String carrera) {
        RegistroAlumno reg = new RegistroAlumno();
        reg.setNombre(Constants.getName(this));
        reg.setEscuela(escuela);
        reg.setCarrera(carrera);
        try {
            reg.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reg.saveEventually(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(getBaseContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Error al Registrar", Toast.LENGTH_SHORT).show();

                }
            }
        });

        goToNextActivity();
    }

    private void adaptarSpinner1() {
        //agrgamos un adaptador para que por defecto tenga una opción seleccionada
        HintAdapter adapter = new HintAdapter(this, escuelas, android.R.layout.simple_spinner_item);
        final int count = adapter.getCount() - 1;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        escuela.setAdapter(adapter);
        escuela.setSelection(adapter.getCount());
        escuela.setOnItemSelectedListener(
            new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                                           android.view.View v, int position, long id) {
                    op1 = position;
                    if (position == count) {
                        otraEscuela.setVisibility(View.VISIBLE);
                    } else {
                        otraEscuela.setVisibility(View.INVISIBLE);
                    }

                }

                public void onNothingSelected(AdapterView<?> parent) {
                }
        });
    }

    private void adaptarSpinner2() {

        HintAdapter adapter = new HintAdapter(this, carreras, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final int count = adapter.getCount() - 1;
        carrera.setAdapter(adapter);
        carrera.setSelection(adapter.getCount());
        carrera.setOnItemSelectedListener(
            new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                                           android.view.View v, int position, long id) {
                    op2 = position;
                    if (position == count) {
                        otraCarrera.setVisibility(View.VISIBLE);
                    } else {
                        otraCarrera.setVisibility(View.INVISIBLE);
                    }
                }

                public void onNothingSelected(AdapterView<?> parent) {
                }
        });

    }
    //se genera una clase para adaptar los spinners y aparte ponerle una pista
    class HintAdapter extends ArrayAdapter<String> {

        public HintAdapter(Context theContext, String[] objects, int theLayoutResId) {
            super(theContext, theLayoutResId, android.R.id.text1, objects);
        }

        @Override
        public int getCount() {
            int count = super.getCount();
            return count > 0 ? count - 1 : count;
        }
    }

    private void goToNextActivity(){
        Intent intent = new Intent(Registro.this,ActivityPuntoYComa.class);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.HONEYCOMB){
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        } else{
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(intent);
    }
}
