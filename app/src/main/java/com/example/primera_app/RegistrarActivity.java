package com.example.primera_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {

    Button btnRegConfirmar;
    EditText edtRegNombre;
    EditText edtRegTelefono;
    EditText edtRegEmail;
    EditText edtRegPass;
    EditText edtRegConfPass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        btnRegConfirmar = findViewById(R.id.btnRegConfirmar);
        edtRegNombre = findViewById(R.id.edtRegNombre);
        edtRegTelefono = findViewById(R.id.edtRegTelefono);
        edtRegEmail = findViewById(R.id.edtRegEmail);
        edtRegPass = findViewById(R.id.edtRegPass);
        edtRegConfPass = findViewById(R.id.edtRegConfPass);

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