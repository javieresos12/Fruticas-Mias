package com.example.javierescobar.proyectofruticasmias;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class AgregarCliente extends AppCompatActivity {
    private EditText nombre, apellido, telefono, direccion, cedula;
    private Resources recursos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cliente);

        cedula = findViewById(R.id.txtCedula);
        nombre = findViewById(R.id.txtNombreCliente);
        apellido = findViewById(R.id.txtApellido);
        telefono = findViewById(R.id.txtTelefono);
        direccion = findViewById(R.id.txtDireccion);

        recursos = this.getResources();
    }

    public void guardar(View v){
        String id, ced, nomb, apel, telef, direc;

        id = Datos.getId();
        ced = cedula.getText().toString();
        nomb = nombre.getText().toString();
        apel = apellido.getText().toString();
        telef = telefono.getText().toString();
        direc = direccion.getText().toString();


        if (validar()) {

            Cliente c =new Cliente(id,ced,nomb,apel,telef,direc);
            c.guardar();
            limpiar();
            Snackbar.make(v, getResources().getString(R.string.guardado_exitoso_cliente), Snackbar.LENGTH_SHORT)
                    .show();

        }
    }

    public boolean  validar(){
        String nom2, ape2, tel2, dire2;

        nom2=nombre.getText().toString();
        ape2= apellido.getText().toString();
        tel2= telefono.getText().toString();
        dire2= direccion.getText().toString();

        if (nom2.isEmpty()){
            nombre.setError(recursos.getString(R.string.Enomb));
            nombre.requestFocus();
            return false;
        }
        if (ape2.isEmpty()){
            apellido.setError(recursos.getString(R.string.Eapelli));
            apellido.requestFocus();
            return false;
        }

        if (tel2.isEmpty()){
            telefono.setError(recursos.getString(R.string.Etel));
            telefono.requestFocus();
            return false;
        }
        if (dire2.isEmpty()){
            direccion.setError(recursos.getString(R.string.Edirec));
            direccion.requestFocus();
            return false;
        }
     return true;

    }

    public void limpiar(){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        direccion.setText("");
        nombre.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void limpiar(View v){
        limpiar();
    }
}
