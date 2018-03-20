package com.example.personal.pdlilybethconde;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PalabrasActivity extends AppCompatActivity {

    TextView txtrespuesta, txttituloazar, txtrespuestaazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);
        iniUI();
    }

    private void iniUI(){
        txtrespuesta = (TextView) findViewById(R.id.TxtRespuesta);
        txttituloazar = (TextView) findViewById(R.id.TxtTituloAzar);
        txtrespuestaazar = (TextView) findViewById(R.id.TxtRespuestaAzar);

        String respuesta = getIntent().getStringExtra("TextoParrafo");
        String temp[] = respuesta.split(" ");
        int cantidadNombres = temp.length;
        txtrespuesta.setText(String.valueOf(cantidadNombres));

        String numero = getIntent().getStringExtra("NumeroPalabras");

        Double aleatorio = Math.floor(Math.random()*(temp.length));
        int index = Integer.valueOf(aleatorio.intValue());
        String seleccionado = temp[index];
        txttituloazar.setText("Palabras obtenidas al  azar: "+numero);
        txtrespuestaazar.setText(seleccionado);
    }
}
