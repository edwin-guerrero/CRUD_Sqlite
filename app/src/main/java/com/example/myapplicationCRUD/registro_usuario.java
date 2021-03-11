package com.example.myapplicationCRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplicationCRUD.utilidades.Utilidades;

public class registro_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        EditText campoId = (EditText) findViewById(R.id.t_id);
        EditText campoNombre = (EditText) findViewById(R.id.t_nombre);
        EditText campoTelefono = (EditText) findViewById(R.id.t_telefono);
    }

    public void valores(){

    }

    public void onClick(View view) {
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        //Se abre conexión a la BD
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        //se indica que se abre para registrar
        SQLiteDatabase db = conn.getWritableDatabase();

        //Se usa para obtener el valor capturado y asignarlo a las constantes
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());

    }
}