package es.joseljg.ejemplo2activitiesazul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.joseljg.ejemplo2activitiesazul.clases.Ciudad;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_CIUDAD = "es.joseljg.MainActivity.ciudad";
    public static final String EXTRA_HABITANTES = "es.joseljg.MainActivity.habitantes";
    public static final String EXTRA_OBJETO_CIUDAD = "es.joselg.MainActivity.objetoCiudad" ;
    private EditText edt_ciudad = null;
    private EditText edt_habitantes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_ciudad = (EditText) findViewById(R.id.edt_ciudad);
        edt_habitantes = (EditText) findViewById(R.id.edt_habitantes);
    }

    public void ir_activity2(View view) {
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }

    public void enviarActivity2(View view) {
        Intent intent = new Intent(this,Activity2.class);
        //-------------------------------------------------------------
        String ciudad = edt_ciudad.getText().toString();
        String textoHabitantes = edt_habitantes.getText().toString();
        int habitantes = 0;
        try {
            habitantes = Integer.valueOf(textoHabitantes);
            Ciudad c = new Ciudad(ciudad, habitantes);
            intent.putExtra(EXTRA_OBJETO_CIUDAD, c);
           // Bundle extras = new Bundle();
           // extras.putString(EXTRA_CIUDAD, ciudad);
           // extras.putInt(EXTRA_HABITANTES, habitantes);
           // intent.putExtras(extras);
           // intent.putExtra(EXTRA_CIUDAD, ciudad);
          //  intent.putExtra(EXTRA_HABITANTES, habitantes);
            //-------------------------------------------------------------
            startActivity(intent);
        }
        catch (Exception e) {
            edt_habitantes.setError("pon un numero");
        }

    }
}