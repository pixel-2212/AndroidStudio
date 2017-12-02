package com.inacap.pixel.prueba2.Cliente;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inacap.pixel.prueba2.R;
import com.inacap.pixel.prueba2.basededatos.DatabaseHelper;

public class InfoCliente extends AppCompatActivity {

    public static final String EXTRA_CLIENTE_NUMERO="ClienteNro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_cliente);
        int ClienteNro=(Integer)getIntent().getExtras().get(EXTRA_CLIENTE_NUMERO);
        EditText rut=(EditText) findViewById(R.id.rutinfo);
        EditText n_l=(EditText) findViewById(R.id.n1info);
        EditText n_c=(EditText) findViewById(R.id.n2info);
        EditText dire=(EditText) findViewById(R.id.dirinfo);
        EditText tele=(EditText) findViewById(R.id.telinfo);
        EditText estado=(EditText)findViewById(R.id.estadoinfo);

        DatabaseHelper basedeDatos = new DatabaseHelper(this); //creacion del puntero
        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from CLIENTES", null);
            //c.move(ClienteNro);
            //String linea=c.getString(1);
            String r = new String();
            String n1= new String();
            String n2= new String();
            String d= new String();
            String t= new String();
            String e= new String();
            c.move(ClienteNro);
            if(ClienteNro==0){
                c.moveToFirst();
                //do{
                String linea=c.getString(0);
                String linea1=c.getString(1);
                String linea2=c.getString(2);
                String linea3=c.getString(3);
                String linea4=c.getString(4);
                String linea5=c.getString(5);
                r=linea;
                n1=linea1;
                n2=linea2;
                d=linea3;
                t=linea4;
                e=linea5;
                //}while(c.moveToNext());
            }else{
                if (c.move(ClienteNro)){
                    //do{
                    String linea=c.getString(0);
                    String linea1=c.getString(1);
                    String linea2=c.getString(2);
                    String linea3=c.getString(3);
                    String linea4=c.getString(4);
                    String linea5=c.getString(5);
                    r=linea;
                    n1=linea1;
                    n2=linea2;
                    d=linea3;
                    t=linea4;
                    e=linea5;
                    //}while(c.moveToNext());
                }
            }
            rut.setText(r);
            n_l.setText(n1);
            n_c.setText(n2);
            dire.setText(d);
            tele.setText(t);
            estado.setText(e);
        }
    }
    public void actualizarCliente(){
        String rut=((EditText)findViewById(R.id.rutinfo)).getText().toString();
        String n_local=((EditText)findViewById(R.id.n1info)).getText().toString();
        String n_contacto=((EditText)findViewById(R.id.n2info)).getText().toString();
        String direccion=((EditText)findViewById(R.id.dirinfo)).getText().toString();
        String telefono=((EditText)findViewById(R.id.telinfo)).getText().toString();
        String estado="activo";
        Cliente cliente = new Cliente(rut,n_local,n_contacto,direccion,telefono,estado);
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        databaseHelper.actualizarCliente(cliente);
        Toast.makeText(this, "Cliente actualizado", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(InfoCliente.this, Clientes.class);
        startActivity(intent);
    }
}
