package com.inacap.pixel.prueba2.Cliente;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.inacap.pixel.prueba2.R;
import com.inacap.pixel.prueba2.basededatos.DatabaseHelper;

import static android.support.v7.appcompat.R.styleable.View;

public class VerClientes extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ver_clientes);
        DatabaseHelper basedeDatos = new DatabaseHelper(this); //creacion del puntero
        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from CLIENTES", null);
            int cantidad = c.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    String linea = c.getString(0) + " | " + c.getString(1) + " | " + c.getString(2);
                    ;
                    arreglo[i] = linea;
                    i++;
                } while (c.moveToNext());
            }
            ListView lista=getListView();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
//            final ListView lista = (ListView) findViewById(R.id.Mostrardatos);
            lista.setAdapter(adapter);
            /*lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                    Intent intent=new Intent(VerClientes.this,InfoCliente.class);
                    intent.putExtra(InfoCliente.EXTRA_CLIENTE_NUMERO,i);
                    startActivity(intent);
                }
            });*/
        }
    }
    @Override
    public void onListItemClick(ListView listView, View item, int posicion, long id){
        Intent intent=new Intent(VerClientes.this,InfoCliente.class);
        intent.putExtra(InfoCliente.EXTRA_CLIENTE_NUMERO,posicion);
        startActivity(intent);
    }
}

