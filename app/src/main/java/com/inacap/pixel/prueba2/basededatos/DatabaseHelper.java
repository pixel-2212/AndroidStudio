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
    private static final String DB_NAME="bd_pf.db";
    private static final int DB_VERSION=1;

    public DatabaseHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlClientes="CREATE TABLE CLIENTES(" +
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
        String sqlp1="INSERT INTO PRODUCTOS(CODIGO, NOMBRE, PRECIO) " +
                "VALUES(000121,'CHOCMAN',3600)";
        sqLiteDatabase.execSQL(sqlp1);
        String sqlp2="INSERT INTO PRODUCTOS(CODIGO, NOMBRE, PRECIO) " +
                "VALUES(000123,'SUPER 8',2900)";
        sqLiteDatabase.execSQL(sqlp2);
        String sqlp3="INSERT INTO PRODUCTOS(CODIGO, NOMBRE, PRECIO) " +
                "VALUES(000127,'GOLAZO',3600)";
        sqLiteDatabase.execSQL(sqlp3);
        String sqlp4="INSERT INTO PRODUCTOS(CODIGO, NOMBRE, PRECIO) " +
                "VALUES(000125,'BOM BOM BUM',1900)";
        sqLiteDatabase.execSQL(sqlp4);
        String sqlp5="INSERT INTO PRODUCTOS(CODIGO, NOMBRE, PRECIO) " +
                "VALUES(000131,'PIN POP',1700)";
        sqLiteDatabase.execSQL(sqlp5);
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
    public void actualizarCliente(Cliente cliente){
        ContentValues valores = new ContentValues();
        valores.put("RUT",cliente.getRut());
        valores.put("N_LOCAL",cliente.getN_local());
        valores.put("N_CONTACTO",cliente.getN_contacto());
        valores.put("DIRECCION",cliente.getDireccion());
        valores.put("TELEFONO",cliente.getTelefono());
        valores.put("ESTADO",cliente.getEstado());
        getWritableDatabase().update("CLIENTES",valores,"RUT="+cliente.getRut(),null);
    }

}
