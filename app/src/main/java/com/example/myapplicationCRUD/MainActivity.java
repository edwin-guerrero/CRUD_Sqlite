package com.example.myapplicationCRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se especifica que indique el contexto , nombre de la base, factpry null, y version de la bd
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    }
    public void onClick (View view){
        Intent miIntent = null;
        switch (view.getId()){
            case R.id.b_registrar:
                miIntent=new Intent(MainActivity.this,registro_usuario.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}