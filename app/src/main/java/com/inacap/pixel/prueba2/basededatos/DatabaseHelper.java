package com.inacap.pixel.prueba2.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.inacap.pixel.prueba2.Cliente.Cliente;

/**
 * Created by Pixel on 27-11-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="bd_productosfrescos.db";
    private static final int DB_VERSION=1;

    public DatabaseHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlClientes="CREATE TABLE CLIENTES(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "RUT TEXT, N_LOCAL TEXT, N_CONTACTO TEXT, " +
                "DIRECCION TEXT, TELEFONO TEXT, ESTADO TEXT)";
        sqLiteDatabase.execSQL(sqlClientes);
        String sqlPedidos="CREATE TABLE PEDIDOS(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "RUT_CLIENTE TEXT, FECHA TEXT, " +
                "PRODUCTOS TEXT, TOTAL TEXT, ESTADO TEXT)";
        sqLiteDatabase.execSQL(sqlPedidos);
        String sqlProductos="CREATE TABLE PRODUCTOS(" +
                "CODIGO INTEGER, NOMBRE TEXT, PRECIO INTEGER)";
        sqLiteDatabase.execSQL(sqlProductos);
        ContentValues valores=new ContentValues();
        valores.put("CODIGO",000121);
        valores.put("NOMBRE","CHOCMAN");
        valores.put("PRECIO",3600);
        getWritableDatabase().insert("PRODUCTOS", null, valores);
        valores.put("CODIGO",000123);
        valores.put("NOMBRE","SUPER 8");
        valores.put("PRECIO",2900);
        getWritableDatabase().insert("PRODUCTOS", null, valores);
        valores.put("CODIGO",000127);
        valores.put("NOMBRE","GOLAZO");
        valores.put("PRECIO",3600);
        getWritableDatabase().insert("PRODUCTOS", null, valores);
        valores.put("CODIGO",000125);
        valores.put("NOMBRE","BOM BOM BUM");
        valores.put("PRECIO",1900);
        getWritableDatabase().insert("PRODUCTOS", null, valores);
        valores.put("CODIGO",000131);
        valores.put("NOMBRE","PIN POP");
        valores.put("PRECIO",1700);
        getWritableDatabase().insert("PRODUCTOS", null, valores);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CLIENTES");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PEDIDOS");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCTOS");
    }
    //METODO 2 (FALLIDO)
    /*public void insertarCliente(String rut, String n_local, String n_contacto, String direccion, String telefono, String estado){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO CLIENTES" +
                    " (RUT, N_LOCAL, N_CONTACTO, DIRECCION, TELEFONO, ESTADO) " +
                    " VALUES('" + rut + "', '" + n_local + "', '" + n_contacto +"', '" + direccion +"'," +
                    " '" + telefono +"', '" + estado +"') ");
            db.close();
        }
    }*/
    //METODO 3 (FALLIDO)
    public void ingresarCliente(Cliente cliente){
        ContentValues valores = new ContentValues();
        valores.put("RUT",cliente.getRut());
        valores.put("N_LOCAL",cliente.getN_local());
        valores.put("N_CONTACTO",cliente.getN_contacto());
        valores.put("DIRECCION",cliente.getDireccion());
        valores.put("TELEFONO",cliente.getTelefono());
        valores.put("ESTADO",cliente.getEstado());
        getWritableDatabase().insert("CLIENTES",null,valores);
    }
}
