package com.tis91d.appcomb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    // Contenedores:

    private EditText tripTime;
    private EditText costoFuel;
    private EditText eta;
    private EditText costoTrip;
    private EditText viaje;
    private Button btnCalcular;

    //Variables Globales:

    int velocidad = 100;
    double rendimiento = 16;


    private void iniciar(){

        // Inicializar Contenedores:

        tripTime = (EditText)findViewById(R.id.tripTime);
        costoFuel = (EditText)findViewById(R.id.costoFuel);
        eta = (EditText)findViewById(R.id.ETA);
        costoTrip = (EditText)findViewById(R.id.costoTrip);
        viaje = (EditText)findViewById(R.id.destino);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        // Inicializar el Boton:

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calcular();
            }
        });
    }


    private void calcular(){

        // Obtener valores de distancia y costo por litro:

        int distancia = Integer.parseInt(viaje.getText().toString());
        int costoLitro = Integer.parseInt(costoFuel.getText().toString());

        // Calcular costo de combustible:

        int rendimientoTotal = (int) (distancia / rendimiento);
        int costoCombustible = (rendimientoTotal * costoLitro);

        // Calcular Hora Estimada de Llegada:

        int sec = (distancia * 3600) / velocidad;
        int hor = sec / 3600;
        int min = (sec - hor* 3600) / 60;
        int TT = sec - hor * 3600 - min * 60;

        //Presentar:

        costoTrip.setText(String.valueOf("$" + costoCombustible));
        eta.setText(String.valueOf(hor + " Hrs " + min + " Min " + TT + " Seg "));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
    }
}