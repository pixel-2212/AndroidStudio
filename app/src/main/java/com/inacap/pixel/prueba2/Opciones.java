package com.inacap.pixel.prueba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.inacap.pixel.prueba2.Cliente.Clientes;
import com.inacap.pixel.prueba2.Pedido.Pedidos;

public class Opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
    }
    public void openClientes(View view){
        Intent intent = new Intent(Opciones.this, Clientes.class);
        startActivity(intent);
    }
    public void openPedidos(View view){
        Intent intent = new Intent(Opciones.this, Pedidos.class);
        startActivity(intent);
    }
    public void cerrarSesion(View view){
        Intent intent = new Intent(Opciones.this, Login.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {

    }
}
