package com.julianyepes.conversorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ePesos, eDolares;
    Button  bConvertir;
    Double pesos, dolares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//configura el contenido en la vista
                                                //debe comentarse para probar programacion con java
                                                //si R esta de color rojo el error esta en los xml
                                                //se le manda un codigo en hexa

        //las interfaces se pueden crear de tres maneras diferentes

        //1. ejemplo de programacion de una interfaz con java
        /*TextView texto= new TextView(this);
        texto.setText("Prueba de programacion java");
        setContentView(texto);*/

        //2.por medio de el codigo en xml


        ePesos = (EditText)findViewById(R.id.ePesos);
        eDolares =(EditText)findViewById(R.id.eDolares);
        bConvertir = (Button)findViewById(R.id.bConvertir);

        bConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( !eDolares.getText().toString().equals("") && ePesos.getText().toString().equals("") ){
                    dolares = Double.parseDouble( eDolares.getText().toString() );
                    //pesos = Double.parseDouble( ePesos.getText().toString() );

                    pesos = dolares * 3000;
                    ePesos.setText( pesos.toString());//string.valueOf(pesos)
                }
                else if( eDolares.getText().toString().equals("") && !ePesos.getText().toString().equals("") ){
                    //dolares = Double.parseDouble( eDolares.getText().toString() );
                    pesos = Double.parseDouble( ePesos.getText().toString() );

                    dolares = pesos / 3000;
                    eDolares.setText( dolares.toString());//string.valueOf(pesos)
                }else {
                    Toast.makeText(getApplicationContext(),"Un campo debe estar vacio",Toast.LENGTH_SHORT).show();
                }

                if( eDolares.getText().toString().equals("") && ePesos.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(),"No hay valor",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
