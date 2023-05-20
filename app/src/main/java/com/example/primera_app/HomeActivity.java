package com.example.primera_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button btnHmtelefcel;
    Button btnHminternet;
    Button btnHmtelfijo;

   @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnHmtelefcel = findViewById(R.id.btnHmtelefcel);
        btnHminternet = findViewById(R.id.btnHminternet);
        btnHmtelfijo = findViewById(R.id.btnHmtelfijo);

        btnHmtelefcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Vas a ver Celulares", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, TelCelActivity.class);
                startActivity(intent);
            }
        });

        btnHminternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Vas a ver Routers", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, IntertActivity.class);
                startActivity(intent);
            }
        });

        btnHmtelfijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Vas a ver Telefonos Fijos", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, TelFijoActivity.class);
                startActivity(intent);
            }
        });
    }
}
