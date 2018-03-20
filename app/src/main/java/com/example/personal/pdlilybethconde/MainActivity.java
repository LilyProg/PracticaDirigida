package com.example.personal.pdlilybethconde;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ObjectInputValidation;

public class MainActivity extends AppCompatActivity {

    EditText txttexto, txtnumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void initUI(){
        txtnumero = (EditText) findViewById(R.id.TxtNumero);
        txttexto = (EditText)findViewById(R.id.TxtTexto);
    }

    public void VerRespuesta(View view) {
        if(inputValidation()) {
            Intent intent = new Intent(MainActivity.this,PalabrasActivity.class);
            //finalizar actividad
            //enviar valor
            String texto = String.valueOf(txttexto.getText());
            String numero = String.valueOf(txtnumero.getText());
            intent.putExtra("TextoParrafo", texto);
            intent.putExtra("NumeroPalabras", numero);
            //fin envio de valor
            MainActivity.this.startActivity(intent);
        }
    }

    private boolean inputValidation() {

        if(txttexto.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this.getApplicationContext(), R.string.texto_mensaje_validacion,
                    Toast.LENGTH_LONG).show();
            return false;
        }

        if(txtnumero.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this.getApplicationContext(), R.string.numero_mensaje_validacion,
                    Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
