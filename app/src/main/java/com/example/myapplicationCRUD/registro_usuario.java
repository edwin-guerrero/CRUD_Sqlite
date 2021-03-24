package com.example.myapplicationCRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicationCRUD.utilidades.Utilidades;

import java.text.BreakIterator;

public class registro_usuario extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        campoId = (EditText) findViewById(R.id.t_id);
        campoNombre = (EditText) findViewById(R.id.t_nombre);
        campoTelefono = (EditText) findViewById(R.id.t_telefono);
    }

    public void valores() {

    }

    public void onClick(View view) {

        registrarUsuarios();
        //registrarUsuariosSQL();
    }

    private void registrarUsuariosSQL() {
        //Se abre conexión a la BD
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        //metodo para abrir la base de datos
        SQLiteDatabase db = conn.getWritableDatabase();
        db.close();
        //insert into USUARIOS (ID,NOMBRE,TELEFONO) values (1,'cristian','3245')
        String insert="INSERT INTO "+Utilidades.TABLA_USUARIO
                +" ( "+ Utilidades.CAMPO_ID+","+ Utilidades.CAMPO_NOMBRE +","+ Utilidades.CAMPO_TELEFONO +" ) " +
                " VALUES ("+ campoId.getText().toString()+",'"+campoNombre.getText().toString()+"','"+campoTelefono.getText().toString()+"')";

        db.execSQL(insert);

    }

    private void registrarUsuarios() {
        //Se abre conexión a la BD
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        //metodo para abrir la base de datos
        SQLiteDatabase db = conn.getWritableDatabase();

        //Se usa para obtener el valor capturado y asignarlo a las constantes
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

        Toast.makeText( getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
    }
}