package com.example.primera_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLoginAceptar;
    Button btnRegistrar;
    EditText edtLoginEmail;
    EditText edtLoginPass;
    private static int count = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLoginAceptar = findViewById(R.id.btnLoginAceptar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        edtLoginEmail = findViewById(R.id.edtLoginEmail);
        edtLoginPass = findViewById(R.id.edtLoginPass);

        btnLoginAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarDatos(edtLoginEmail.getText().toString(), edtLoginPass.getText().toString());
            }
        });

           btnRegistrar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                 Registar();
               }
           });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.mnuPrincE_mail:

                return true;

            case R.id.mnuPrincContacto:

                return true;

            case R.id.mnuPrincCartProy:

                return true;

            case R.id.mnuPrincSalir:

                finish();

            default:
                return true;
        }
    }

    private void Registar() {
        Intent intent = new Intent(this, RegistrarActivity.class);
        startActivity(intent);
    }



    private void ValidarDatos(String mail, String password)
    {
        if(mail.equals("jose@correo.com") && password.equals("1234"))
        {
            Toast.makeText(this, "Ingreso Correcto", Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent(this, HomeActivity.class);
            count = 0;
            startActivity(intent);
        }else{
            count++;
            Toast.makeText(this, "Datos no Validos", Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent(this, MainActivity.class);
            startActivity(intent);
            if(count <= 3) return;
            {
                Toast.makeText(this, "Supero los intentos posibles", Toast.LENGTH_LONG).show();
                count = 0;
            }

        }
    }
}