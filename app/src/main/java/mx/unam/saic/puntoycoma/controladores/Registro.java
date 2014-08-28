package mx.unam.saic.puntoycoma.controladores;

import mx.unam.saic.puntoycoma.R;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Registro extends ActionBarActivity{
	Button registrar;
	Spinner escuela;
	Spinner carrera;
	EditText otraEscuela;
	EditText otraCarrera;

	
	
	boolean flag1=false;//en caso de otra escuela
	boolean flag2=false;//en caso de que no este selecionada ninguna escuela
	boolean flag3=false;//en caso de otra carrera
	boolean flag4=false;//en caso que no este seleccionada ninguna carrera
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        
        registrar=(Button) findViewById(R.id.button1);
        agregarEventoBoton();
        
        escuela=(Spinner) findViewById(R.id.escuela);
        carrera=(Spinner) findViewById(R.id.carrera);
        adaptarSpinner1();
        adaptarSpinner2();
        
        otraEscuela=(EditText) findViewById(R.id.otraescuela);
        otraCarrera=(EditText) findViewById(R.id.otracarrera);
        otraEscuela.setVisibility(View.INVISIBLE);
        otraCarrera.setVisibility(View.INVISIBLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
	}


    private void agregarEventoBoton(){
		registrar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0)
			{
				Toast.makeText(Registro.this, "boton1", Toast.LENGTH_SHORT).show();


                if(fla)
                enviarRegistro(carrera.getSelectedItemPosition(), escuela.getSelectedItemPosition());
			}
		});
	}

    private void enviarRegistro(int selectedItemPosition, int selectedItemPosition1) {

    }

    private void adaptarSpinner1(){
		
		String [] listaEscuelas={"Escuela...","UNAM","IPN","UAM","Otra"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listaEscuelas);
		escuela.setAdapter(adapter);
		
		escuela.setOnItemSelectedListener(
		        new AdapterView.OnItemSelectedListener() {
		        public void onItemSelected(AdapterView<?> parent,
		            android.view.View v, int position, long id) {
		                
		        	if(position==3&& position >0){
		        		flag1=true;
		        		otraEscuela.setVisibility(View.VISIBLE);
		        	}else{
                        flag1=false;
                        otraEscuela.setVisibility(View.INVISIBLE);
                    }

		        }
		 
		        public void onNothingSelected(AdapterView<?> parent) {
		            flag2=true;
		        }
		});
		
		
	}
	
private void adaptarSpinner2(){
		
		String [] listaCarreras={"Carrera...","Ingeniería en computación","Ciencias de la computación","Informatica","Otra"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listaCarreras);
		carrera.setAdapter(adapter);
		carrera.setOnItemSelectedListener(
		        new AdapterView.OnItemSelectedListener() {
		        public void onItemSelected(AdapterView<?> parent,
		            android.view.View v, int position, long id) {
		        	if(position==3 && position >0){
		        		flag3=true;
		        		otraCarrera.setVisibility(View.VISIBLE);
		        	}else{
                        flag3=false;
                        otraCarrera.setVisibility(View.INVISIBLE);
                    }
		        }
		 
		        public void onNothingSelected(AdapterView<?> parent) {
		            flag4=true;
		        }
		});
		
	}

}
