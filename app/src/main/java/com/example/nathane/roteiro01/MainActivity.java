package com.example.nathane.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTexto = (TextView) findViewById(R.id.texto);
        Bundle bundle = getIntent().getExtras();
        String texto = bundle.getString("nome");
        mTexto.setText("Seja bem vindo,"  +texto+ "! ");
    }
}
