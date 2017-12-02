package com.inacap.pixel.prueba2.Cliente;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.inacap.pixel.prueba2.R;
import com.inacap.pixel.prueba2.basededatos.DatabaseHelper;

public class EliminarCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_cliente);
    }
    public void eliminarCliente(View view){
        String rut = ((EditText)findViewById(R.id.rutdelete)).getText().toString();
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String sqldelete="DELETE FROM CLIENTES WHERE RUT='"+rut+"'";
        db.execSQL(sqldelete);
        EditText xd=(EditText)findViewById(R.id.rutdelete);
        xd.setText("");
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
