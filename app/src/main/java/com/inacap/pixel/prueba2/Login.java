package com.inacap.pixel.prueba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Objects;

import static android.R.attr.id;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void iniciarSesion(View view){
        String user = ((EditText)findViewById(R.id.user)).getText().toString();
        String pass = ((EditText)findViewById(R.id.password)).getText().toString();
        if (user.equals("admin") && pass.equals("12345") || user.equals("user") && pass.equals("54321")){
            Intent intent = new Intent(Login.this, Opciones.class);
            startActivity(intent);
            if (user.equals("admin")){
                Toast.makeText(this,"Bienvenido admin", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Bienvenido user", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
