package com.inacap.pixel.prueba2.Cliente;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.inacap.pixel.prueba2.R;
import com.inacap.pixel.prueba2.basededatos.DatabaseHelper;


public class AgregarCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cliente);
        /*Spinner spinner = (Spinner) findViewById(R.id.spinnerC);
        String[] estado = {"Activo","Inactivo"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estado));*/
    }
    //METODO 1 (FALLIDO)
    /*public void addCliente(View view){
        String rut=((EditText)findViewById(R.id.rut)).getText().toString();
        String n_local=((EditText)findViewById(R.id.n_local)).getText().toString();
        String n_contacto=((EditText)findViewById(R.id.n_contacto)).getText().toString();
        String direccion=((EditText)findViewById(R.id.direccion)).getText().toString();
        String telefono=((EditText)findViewById(R.id.telefono)).getText().toString();
        Spinner mySpinner=(Spinner) findViewById(R.id.spinnerC);
        String estado = mySpinner.getSelectedItem().toString();
        String estado="activo";
        DatabaseHelper basedeDatos = new DatabaseHelper(this);
        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null) {
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("RUT",rut);
            registronuevo.put("N_LOCAL", n_local);
            registronuevo.put("N_CONTACTO", n_contacto);
            registronuevo.put("DIRECCION", direccion);
            registronuevo.put("TELEFONO", telefono);
            registronuevo.put("ESTADO", estado);
            db.insert("CLIENTES", null, registronuevo);
        }
        db.close();
        Toast.makeText(AgregarCliente.this, "Cliente agregado", Toast.LENGTH_SHORT).show();
    }*/
    //METODO 2 (FALLIDO)
    /*public void crearusuario(View view){
        String rut=((EditText)findViewById(R.id.rut)).getText().toString();
        String n_local=((EditText)findViewById(R.id.n_local)).getText().toString();
        String n_contacto=((EditText)findViewById(R.id.n_contacto)).getText().toString();
        String direccion=((EditText)findViewById(R.id.direccion)).getText().toString();
        String telefono=((EditText)findViewById(R.id.telefono)).getText().toString();
        String estado="activo";
        DatabaseHelper db=new DatabaseHelper(this);
        db.insertarCliente(rut, n_local, n_contacto, direccion, telefono, estado);
        db.close();
        Toast.makeText(AgregarCliente.this, "Cliente agregado", Toast.LENGTH_SHORT).show();
    }*/
    //METODO 3 (FALLIDO)
    public void ingresar(View view){
        String rut=((EditText)findViewById(R.id.rut)).getText().toString();
        String n_local=((EditText)findViewById(R.id.n_local)).getText().toString();
        String n_contacto=((EditText)findViewById(R.id.n_contacto)).getText().toString();
        String direccion=((EditText)findViewById(R.id.direccion)).getText().toString();
        String telefono=((EditText)findViewById(R.id.telefono)).getText().toString();
        String estado="activo";
        Cliente cliente=new Cliente(rut,n_local,n_contacto,direccion,telefono,estado);
        DatabaseHelper db = new DatabaseHelper(this);
        db.ingresarCliente(cliente);
        Toast.makeText(this, "Cliente agregado", Toast.LENGTH_SHORT).show();
    }
    public void cancelar(View view){
        Intent intent = new Intent(AgregarCliente.this, Clientes.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AgregarCliente.this, Clientes.class);
        startActivity(intent);
    }

}
