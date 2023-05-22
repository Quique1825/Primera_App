package com.example.primera_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {

    EditText edtRegNombre;
    EditText edtRegApellido;
    EditText edtRegPais;
    EditText edtRegCiudad;
    EditText edtRegEmail;
    EditText edtRegPass;

    Button btnRegConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtRegNombre = findViewById(R.id.edtRegNombre);
        edtRegApellido = findViewById(R.id.edtRegApellido);
        edtRegPais = findViewById(R.id.edtRegPais);
        edtRegCiudad = findViewById(R.id.edtRegCiudad);
        edtRegEmail = findViewById(R.id.edtRegEmail);
        edtRegPass = findViewById(R.id.edtRegPass);

        btnRegConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ConfirmarRegistro();
            }
        });
    }

    private void ConfirmarRegistro(){
        Toast.makeText(this, "Registro Confirmado", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}