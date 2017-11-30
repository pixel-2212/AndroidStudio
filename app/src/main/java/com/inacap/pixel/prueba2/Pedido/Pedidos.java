package com.inacap.pixel.prueba2.Pedido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.inacap.pixel.prueba2.Opciones;
import com.inacap.pixel.prueba2.R;

public class Pedidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
    }
    public void agregarPedido(View view){
        Intent intent = new Intent(Pedidos.this, AgregarPedido.class);
        startActivity(intent);
    }
    public void verPedidos(View view){
        Toast.makeText(this, "Ver Pedidos", Toast.LENGTH_SHORT).show();
    }
    public void volverOpciones(View view){
        Intent intent = new Intent(Pedidos.this, Opciones.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Pedidos.this, Opciones.class);
        startActivity(intent);
    }
}
