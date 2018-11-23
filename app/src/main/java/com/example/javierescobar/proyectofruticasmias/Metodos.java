package com.example.javierescobar.proyectofruticasmias;

import java.util.ArrayList;

public class Metodos {


    public static  double totalVentas (ArrayList<Venta> ventas){
        double suma =0;
        for (int i=0; i<ventas.size(); i++){
            suma = suma+ventas.get(i).getTotal();
        }
        return suma;
    }

    public static int CantidadVentasRealizadas (ArrayList<Venta> ventas){
        return ventas.size();
    }


   /* public static String  ClienteConMasCompras (ArrayList<Venta> ventas, ArrayList<Cliente> clientes){
       double  mayor=0;
       String idC, idV, nombre="", apellido="";
       int contador=0, i2=0;
       for (int i=0; i<clientes.size(); i++) {
           contador=0;
           idC=clientes.get(i).getId();
           for (int j = 0; j < ventas.size(); j++) {
               idV=ventas.get(j).getCliente().getId();
               if (idC.equalsIgnoreCase(idV)) {
                  contador++;
               }
           }
           if (contador>=mayor){
               mayor=contador;
               i2=i;
           }
       }
       nombre=clientes.get(i2).getNombre();
       apellido=clientes.get(i2).getApellido();
        return "Nombre: "+ nombre+"  Apellido: "+apellido+"";
    }*/
}
