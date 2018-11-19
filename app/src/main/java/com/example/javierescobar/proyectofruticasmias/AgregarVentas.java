package com.example.javierescobar.proyectofruticasmias;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AgregarVentas extends AppCompatActivity {
    private Intent i;
    private Spinner cmbClientes;
    //private ArrayList<Cliente> clientes;
    private DatabaseReference databaseReference;
    private String db = "Clientes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        cmbClientes = findViewById(R.id.cmbClientes);


        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> clientes = new ArrayList<String>();

                for (DataSnapshot areaSnapshot: dataSnapshot.getChildren()){
                    String nombreCliente = areaSnapshot.child("nombre").getValue(String.class);
                    clientes.add(nombreCliente);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AgregarVentas.this, android.R.layout.simple_spinner_item, clientes);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cmbClientes.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
