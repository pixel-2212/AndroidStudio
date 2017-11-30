package com.inacap.pixel.prueba2.Cliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.inacap.pixel.prueba2.Opciones;
import com.inacap.pixel.prueba2.R;

public class Clientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
    }
    public void agregarCliente(View view){
        Intent intent = new Intent(Clientes.this, AgregarCliente.class);
        startActivity(intent);
    }
    public void viewClientes(View view){
        Toast msgError = Toast.makeText(this, "Ver Clientes", Toast.LENGTH_SHORT);
        msgError.show();
        /*Intent intent = new Intent(Clientes.this, VerClientes.class);
        startActivity(intent);*/
    }
    public void deleteCliente(View view){
        Intent intent = new Intent(Clientes.this, EliminarCliente.class);
        startActivity(intent);
    }
    public void volverOpciones(View view){
        Intent intent = new Intent(Clientes.this, Opciones.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Clientes.this, Opciones.class);
        startActivity(intent);
    }
}
