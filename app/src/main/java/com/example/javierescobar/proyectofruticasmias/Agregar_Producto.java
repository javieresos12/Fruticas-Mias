package com.example.javierescobar.proyectofruticasmias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Agregar_Producto extends AppCompatActivity {

    EditText nombreProducto, precio, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__producto);
        nombreProducto= findViewById(R.id.txtnombrep);
        precio= findViewById(R.id.txtprecio);
        descripcion= findViewById(R.id.txtDescripcion);
    }

    public void guardar (){
    }

    public void borrar(View v ){
        limpiar();
    }

   public void limpiar(){
        nombreProducto.setText("");
        precio.setText("");
        descripcion.setText("");
        nombreProducto.requestFocus();

    }
}
