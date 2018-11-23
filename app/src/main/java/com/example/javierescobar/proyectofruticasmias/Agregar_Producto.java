package com.example.javierescobar.proyectofruticasmias;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class Agregar_Producto extends AppCompatActivity {

    private  EditText nombreProducto, precio, descripcion;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;
    private ImageView foto;
    private Uri uri;
    private StorageReference storageReference;
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__producto);
        nombreProducto= findViewById(R.id.txtNombre);
        precio= findViewById(R.id.txtprecio);
        descripcion= findViewById(R.id.txtDescripcion);

        storageReference = FirebaseStorage.getInstance().getReference();
        recursos = this.getResources();
    }

    public void guardar (View v){
        String nombre, descripcion2, id="", foto;
        double precio2;

        id=Datos.getId();
        foto= id+".jpg";
        nombre=nombreProducto.getText().toString();
        descripcion2= descripcion.getText().toString();
        precio2= Double.parseDouble(precio.getText().toString());

        Producto p = new Producto( id, nombre, precio2, descripcion2,foto);
        p.guardar();
        subir_foto(foto);
        limpiar();
        Snackbar.make(v,getResources().getString(R.string.productoAgregagoexitoxamente),Snackbar.LENGTH_SHORT)
                .show();

    }

    public boolean validar(){
       String nom2, des2, pre2;

       nom2=nombreProducto.getText().toString();
       des2=descripcion.getText().toString();
       pre2= precio.getText().toString();

       if (nom2.isEmpty()){
           nombreProducto.setError(recursos.getString(R.string.erp));
           nombreProducto.requestFocus();
           return false;
       }
       if (des2.isEmpty()){
           descripcion.setError(recursos.getString(R.string.erd));
           descripcion.requestFocus();
           return false;
       }

       if (pre2.isEmpty()){
           precio.setError(recursos.getString(R.string.erpre));
           precio.requestFocus();
           return false;
       }
     return true;

    }

    public void seleccionar_foto(View v){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,
                getResources().getString(R.string.seleccionarFoto)),1);
    }

    private void subir_foto(String foto){
        StorageReference child = storageReference.child(foto);
        UploadTask uploadTask = child.putFile(uri);
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
