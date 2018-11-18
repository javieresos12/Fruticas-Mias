package com.example.javierescobar.proyectofruticasmias;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

    public class AdaptadorCliente{
        private ArrayList<Cliente> clientes;
        private OnClienteClickListener clickListener;

    public AdaptadorCliente(ArrayList<Cliente> clientes, OnClienteClickListener clickListener) {
        this.clientes = clientes;
        this.clickListener = clickListener;
    }

    public void onBindViewHolder(final ClienteViewHolder holder, int position){
        final Cliente c = clientes.get(position);
        holder.nombre.setText(c.getNombre());
        holder.apellido.setText(c.getApellido());
        holder.telefono.setText(c.getTel());
        holder.direccion.setText(c.getDireccion());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClienteClick(c);
            }
        });
    }

    public int getItemCount(){
        return clientes.size();
    }

    public static class ClienteViewHolder extends RecyclerView.ViewHolder{
        private EditText nombre, apellido, telefono, direccion;
        private View v;

        public ClienteViewHolder(View itemView){
            super(itemView);
            v = itemView;
            nombre = v.findViewById(R.id.txtNombreCliente);
            apellido = v.findViewById(R.id.txtApellido);
            telefono = v.findViewById(R.id.txtTelefono);
            direccion = v.findViewById(R.id.txtDireccion);

        }
    }

    public interface OnClienteClickListener{
        void onClienteClick(Cliente c);
    }
}
