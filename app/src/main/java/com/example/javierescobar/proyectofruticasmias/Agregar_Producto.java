package com.example.javierescobar.proyectofruticasmias;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Agregar_Producto extends AppCompatActivity {

    private  EditText nombreProducto, precio, descripcion;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;
    private ImageView foto;
    private Uri uri;
    private StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__producto);
        nombreProducto= findViewById(R.id.txtNombre);
        precio= findViewById(R.id.txtprecio);
        descripcion= findViewById(R.id.txtDescripcion);

        storageReference = FirebaseStorage.getInstance().getReference();
    }

    public void guardar (){
        String nombre, descripcion2, id="", foto;
        double precio2;

        //  id=Datos.getId();
        foto= id+".jpg";
        nombre=nombreProducto.getText().toString();
        descripcion2= descripcion.getText().toString();
        precio2= Double.parseDouble(precio.getText().toString());

        Producto p = new Producto( id, nombre, precio2, descripcion2,foto);



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
