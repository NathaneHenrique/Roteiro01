package com.example.nathane.roteiro01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class CadastroActivity extends AppCompatActivity {


    private EditText mNome;
    private EditText mSobrenome;
    private EditText mUsuario;
    private EditText mSenha;
    private EditText mConfirmarSenha;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Recupera as id's do xml
        mNome = (EditText) findViewById(R.id.usuarioNome);
        mSobrenome = (EditText) findViewById(R.id.usuarioSobrenome);
        mUsuario = (EditText) findViewById(R.id.usuarioSenha);
        mSenha = (EditText) findViewById(R.id.confirmarSenha);
        mConfirmarSenha = (EditText) findViewById(R.id.confirmarSenha);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
    }




    private void logar(){
        String nome  = mNome.getText().toString();
        String sobrenome = mSobrenome.getText().toString();
        String identUsuario = mUsuario.getText().toString();
        String senha = mSenha.getText().toString();
        String confirmarsenha = mConfirmarSenha.getText().toString();

        if(nome.equalsIgnoreCase("nathane")&& sobrenome.equalsIgnoreCase("henrique") && identUsuario.equalsIgnoreCase("123")
                && senha.equalsIgnoreCase("123") && confirmarsenha.equals(senha)){
            Intent intent = new Intent(this,MainActivity.class );
            Bundle bundle = new Bundle();
            bundle.putString("nome", nome);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();


        }else{
            View focus = null;
            boolean exibir = false;
            if(TextUtils.isEmpty(nome)){
                mNome.setError("Campo vazio");
                focus = mNome;
                exibir = true;
            }
            if (TextUtils.isEmpty(sobrenome)){
                mSobrenome.setError("Campo vazio");
                focus = mSobrenome;
                exibir = true;
            }if (TextUtils.isEmpty(identUsuario)){
                mUsuario.setError("Campo vazio");
                focus = mUsuario;
                exibir = true;
            }if(TextUtils.isEmpty(senha)){
                mSenha.setError("Campo vazio");
                focus = mSenha;
                exibir = true;

            }if(TextUtils.isEmpty(confirmarsenha)){
                mConfirmarSenha.setError("Campo vazio");
                focus = mConfirmarSenha;
                exibir = true;

            }

            else{
                mConfirmarSenha.setError("Senha incorreta");
                focus = mConfirmarSenha;
                exibir = true;

            }
            if (exibir){
                focus.requestFocus();
            }
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
