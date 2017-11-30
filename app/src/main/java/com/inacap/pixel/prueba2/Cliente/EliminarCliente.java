package com.inacap.pixel.prueba2.Cliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.inacap.pixel.prueba2.R;

public class EliminarCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_cliente);
    }
    public void eliminarCliente(View view){
        Toast.makeText(this, "Cliente eliminado",Toast.LENGTH_SHORT).show();
    }
    public void volverClientes(View view){
        Intent intent = new Intent(EliminarCliente.this, Clientes.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EliminarCliente.this, Clientes.class);
        startActivity(intent);
    }

}
