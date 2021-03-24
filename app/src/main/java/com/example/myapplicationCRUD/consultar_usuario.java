package com.example.myapplicationCRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicationCRUD.utilidades.Utilidades;

public class consultar_usuario extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono;

    //Instancia clase  conexion sql

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        conn=new ConexionSQLiteHelper( getApplicationContext(),"bd_usuarios",null,1);

        campoId=(EditText) findViewById(R.id.documentoId);
        campoNombre= (EditText)findViewById(R.id.campoNombreConsulta);
        campoTelefono=(EditText) findViewById(R.id.campoTelefonoConsulta);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnConsultar:
                consultar();
                break;
            case R.id.btnActualizar:
                break;
            case R.id.btnEliminar:
                break;
        }
    }

    private void consultar() {
        //abrir base de dato modo lectura
        SQLiteDatabase db = conn.getReadableDatabase();
        //parametros de consulta
        String[] parametro ={campoId.getText().toString()};
        //parametros de retorno
        String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};

        //En caso de consultar un registro que no exista se usa try
        try {
            //cursor para enviar la consulta a la bd
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",parametro,null,null,null);
            //se mueve el cursor al primer resultado, en este caso es solo 1
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void limpiar() {
        campoNombre.setText("");
        campoTelefono.setText("");
    }
}