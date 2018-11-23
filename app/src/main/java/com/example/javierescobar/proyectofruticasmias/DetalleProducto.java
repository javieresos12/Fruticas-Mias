package com.example.javierescobar.proyectofruticasmias;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class DetalleProducto extends AppCompatActivity {
    private TextView txtCodigo;
    private TextView txtProducto;
    private TextView txtPrecio;
    private TextView txtDescripcion;
    private Bundle bundle;
    private Intent i;
    private ImageView foto;
    private String id, codigo, nombre, precio, descripcion,fot;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        txtCodigo=findViewById(R.id.txtCodigo);
        txtProducto=findViewById(R.id.txtproductoE);
        txtPrecio=findViewById(R.id.txtPrecioE);
        txtDescripcion=findViewById(R.id.txtDescripcionE);
        foto=findViewById(R.id.fotoE);

        storageReference = FirebaseStorage.getInstance().getReference();
        i = getIntent();
        bundle = i.getBundleExtra("datos");

        id=bundle.getString("id");
        codigo=bundle.getString("codigo");
        nombre=bundle.getString("nombre");
        precio=bundle.getString("precio");
        descripcion=bundle.getString("descripcion");
        fot=bundle.getString("foto");

        txtCodigo.setText(codigo);
        txtProducto.setText(nombre);
        txtPrecio.setText(precio);
        txtDescripcion.setText(descripcion);

        storageReference.child(fot).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(foto);
            }
        });
    }
}
