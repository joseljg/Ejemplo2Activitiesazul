package es.joseljg.ejemplo2activitiesazul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static es.joseljg.ejemplo2activitiesazul.MainActivity.*;

public class Activity2 extends AppCompatActivity {

    private TextView txt_recibido = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //-------------------------------------------------------
        txt_recibido = findViewById(R.id.txt_recibido);
        //-------------------------------------------------------
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            String ciudad = extras.getString(EXTRA_CIUDAD);
            // String ciudad = intent.getStringExtra(EXTRA_CIUDAD);
            if (ciudad != null) {
                // int habitantes = intent.getIntExtra(EXTRA_HABITANTES, 0);
                int habitantes = extras.getInt(EXTRA_HABITANTES);
                //------------------------------------------------------
                String texto = "ciudad:" + ciudad + "\n" + "habitantes:" + String.valueOf(habitantes);
                //-------------------------------------------------------
                txt_recibido.setText(texto);
            }
        }
    }

    public void cerrarActivity2(View view)
    {
        finish();
    }
}