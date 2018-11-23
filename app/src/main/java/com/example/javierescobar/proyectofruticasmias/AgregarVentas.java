package com.example.javierescobar.proyectofruticasmias;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
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
    private EditText buscar, cantidad;
    private TextView nombreProd, precioProd;
    private TableLayout tabla;
    private DatabaseReference databaseReference;
    private String db = "Clientes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        cmbClientes = findViewById(R.id.cmbClientes);
        buscar = findViewById(R.id.txtCodigoBuscar);
        nombreProd = findViewById(R.id.txtProductoN);
        precioProd = findViewById(R.id.txtPrecioProd);
        cantidad = findViewById(R.id.txtCantidad);
        tabla = findViewById(R.id.tabla);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> clientes = new ArrayList<String>();

                for (DataSnapshot areaSnapshot: dataSnapshot.getChildren()){
                    String nombre = areaSnapshot.child("nombre").getValue(String.class);
                    String cedula = areaSnapshot.child("cedula").getValue(String.class);
                    String cliente = cedula + " - "+nombre;
                    clientes.add(cliente);
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

    public void buscarCliente(View v){
        databaseReference.child("Productos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String cod = buscar.getText().toString();

                for (DataSnapshot areaSnapshot: dataSnapshot.getChildren()){
                    String codigoProducto = areaSnapshot.child("codigo").getValue(String.class);
                    if (cod.equalsIgnoreCase(codigoProducto)){
                        String nombreProducto = areaSnapshot.child("nombre").getValue(String.class);
                        Long precio = areaSnapshot.child("precio").getValue(Long.class);
                        nombreProd.setText(nombreProducto);
                        precioProd.setText(String.valueOf(precio));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void guardar(){
        String id, client, produc;
        int cant, subt,total;

        id = Datos.getId();
        client = cmbClientes.getSelectedItem().toString();
        produc = nombreProd.getText().toString();
        cant = Integer.parseInt(cantidad.getText().toString());
        subt = Integer.parseInt(precioProd.getText().toString());
        total = cant*subt;

        Venta v = new Venta(id, client, produc, cant, subt, total);
        v.guardar();
        limpiar();
    }

    public void limpiar(){
        buscar.setText("");
        nombreProd.setText("");
        precioProd.setText("");
        cantidad.setText("");
        buscar.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void agregarVenta(View v){
        String client, produc;
        int cant, subt,total, pos=0;

        client = cmbClientes.getSelectedItem().toString();
        produc = nombreProd.getText().toString();
        cant = Integer.parseInt(cantidad.getText().toString());
        subt = Integer.parseInt(precioProd.getText().toString());
        total = cant*subt;

        guardar();
        Snackbar.make(v,getResources().getString(R.string.ventaGuardada),Snackbar.LENGTH_SHORT).show();

        TableRow fila = new TableRow(this);
        TextView c1 = new TextView(this);
        TextView c2 = new TextView(this);
        TextView c3 = new TextView(this);
        TextView c4 = new TextView(this);
        TextView c5 = new TextView(this);
        TextView c6 = new TextView(this);

        pos = pos+1;
        c1.setText("" + pos);
        c2.setText(client);
        c3.setText(produc);
        c4.setText(Integer.toString(cant));
        c5.setText(Integer.toString(subt));
        c6.setText(Integer.toString(total));

        fila.addView(c1);
        fila.addView(c2);
        fila.addView(c3);
        fila.addView(c4);
        fila.addView(c5);
        fila.addView(c6);

        tabla.addView(fila);
    }
}
