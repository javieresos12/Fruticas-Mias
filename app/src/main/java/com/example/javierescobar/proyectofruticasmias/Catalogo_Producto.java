package com.example.javierescobar.proyectofruticasmias;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Catalogo_Producto extends AppCompatActivity implements AdaptadorProducto.OnProductoClickListener {
    private RecyclerView lstProductos;
    private ArrayList<Producto> productos;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private String db = "Productos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo__producto);

        lstProductos = findViewById(R.id.lstProductos);
        productos = new ArrayList<>();

        final AdaptadorProducto adaptadorProducto = new AdaptadorProducto(productos,this);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lstProductos.setLayoutManager(llm);
        lstProductos.setAdapter(adaptadorProducto);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                productos.clear();
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot :dataSnapshot.getChildren()){
                        Producto p = snapshot.getValue(Producto.class);
                        productos.add(p);
                    }
                }
                adaptadorProducto.notifyDataSetChanged();
                Datos.setProductos(productos);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onProductoClick(Producto p) {
        Intent i = new Intent(Catalogo_Producto.this,DetalleProducto.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());
        b.putString("codigo",p.getCodigo());
        b.putString("nombre",p.getNombre());
        b.putString("precio",String.valueOf(p.getPrecio()));
        b.putString("descripcion",p.getDescripcion());
        b.putString("foto",p.getFoto());
        i.putExtra("datos",b);
        startActivity(i);
        finish();
    }
}
