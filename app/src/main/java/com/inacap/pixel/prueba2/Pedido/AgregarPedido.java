package com.inacap.pixel.prueba2.Pedido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.inacap.pixel.prueba2.Cliente.AgregarCliente;
import com.inacap.pixel.prueba2.Cliente.Clientes;
import com.inacap.pixel.prueba2.R;

public class AgregarPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_pedido);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerP);
        String[] estado = {"Pendiente","Entregado"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estado));
    }
    public void cancelar(View view){
        Intent intent = new Intent(AgregarPedido.this, Pedidos.class);
        startActivity(intent);
    }
    public void addPedido(View view){
        Toast.makeText(this, "Pedido Agregado", Toast.LENGTH_SHORT).show();
    }
}
