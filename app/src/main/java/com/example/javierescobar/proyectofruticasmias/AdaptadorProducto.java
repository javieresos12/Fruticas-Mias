package com.example.javierescobar.proyectofruticasmias;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorProducto extends
        RecyclerView.Adapter<AdaptadorProducto.ProductoViewHolder> {
    private ArrayList<Producto> Producto;
    private OnProductoClickListener clickListener;

    //constructor
        public AdaptadorProducto(ArrayList<Producto> productos,
                                 OnProductoClickListener clickListener){
            this.Producto=productos;
            this.clickListener = clickListener;
        }


        @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto,parent,false);
        return new ProductoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ProductoViewHolder holder, int position) {
        final Producto p = Producto.get(position);
        StorageReference storageReference = FirebaseStorage.getInstance()
                .getReference();
        storageReference.child(p.getFoto()).getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(holder.foto);
                    }
                });
        //holder.foto.setImageResource(p.getFoto());
        holder.descripcion.setText(p.getDescripcion());
        holder.nombre.setText(p.getNombre());
        holder.precio.setText(String.valueOf(p.getPrecio()));

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onProductoClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Producto.size();
    }


    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
            private ImageView foto;
            private TextView nombre;
            private TextView precio;
            private TextView descripcion;
            private View v;

            public ProductoViewHolder (View itemView){
                super(itemView);
                v = itemView;
                foto = v.findViewById(R.id.foto);
                nombre = v.findViewById(R.id.txtnombrep);
                precio = v.findViewById(R.id.txtprecio);
                descripcion = v.findViewById(R.id.txtDescripcion);
            }
    }

    public interface OnProductoClickListener{
        void onProductoClick(Producto p);
    }
}
