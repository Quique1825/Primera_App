package com.example.primera_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
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
                  Toast.makeText(MainActivity.this,"Ir a Registrar", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
                   startActivity(intent);
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
                    EnviarEmail();
                return true;

            case R.id.mnuPrincContacto:
                 LlamadaTelefonica();
                return true;

            case R.id.mnuPrincCartProy:
                CarteraLaboral();
                return true;

            case R.id.mnuPrincSalir:
                finish();

            default:
                return true;
        }
    }

    // ---- Inicio void Email ---
    void EnviarEmail(){
        composeEmail(new String[]{"quique30081976@gmail.com"}, "Solicitud de Contacto",
                "Es de nuestro interes contactarnos con Ud. Saludos");
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void composeEmail(String[] addresses, String subject, String contenido) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, contenido);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    // ---- Fin void Email ----

    // ---- Inicio void llamada ---
    public void LlamadaTelefonica(){
        dialPhoneNumber("2954537215");
    }
    @SuppressLint("QueryPermissionsNeeded")
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    // ---- Fin void Llamada ----


    // ---- Inicio void GITHUB ---
    public void CarteraLaboral()
    {
        searchWeb("https://github.com/Quique1825");
    }
    @SuppressLint("QueryPermissionsNeeded")
    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    // ---- Fin void GITHUB ----



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