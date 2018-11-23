package com.example.javierescobar.proyectofruticasmias;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Reporte extends Activity {
    private Spinner reporte;
    private Resources recursos;
    private String op[];
    private ArrayList ventas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
          ventas= Datos.obtenerVenta();
         reporte= findViewById(R.id.cmbreporte);

        recursos= this.getResources();

        op= recursos.getStringArray(R.array.reporte);
        ArrayAdapter<String> adapter = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, op);
        reporte.setAdapter(adapter);
    }


    public void generarReporte2 (View v){
        int opcion;
        String datos2;
        double cantidad;

        opcion=reporte.getSelectedItemPosition();

        switch (opcion){

            case 0:
                cantidad = Metodos.totalVentas(ventas);
                datos2 = getResources().getString(R.string.cantidad) + String.valueOf(cantidad);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.reporte1);
                builder.setMessage(datos2);
                builder.setNeutralButton("Ok", null);
                Dialog dialog = builder.create();
                dialog.show();
                break;
        }

    }
}
