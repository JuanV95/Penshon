package com.example.alexander.penshon20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class VerPerfil extends AppCompatActivity {
/*
    listaLogin usu = listaLogin.getInstance();
    EditText nombre = (EditText) findViewById(R.id.nombre);
    EditText telefono = (EditText) findViewById(R.id.telefono);
    EditText correo = (EditText) findViewById(R.id.correo);*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_ver_perfil);
        listaLogin usu = listaLogin.getInstance();
       String cd ;

        Intent tarea = getIntent();
        String perfil= tarea.getStringExtra("perfil");

        TextView nombre = (TextView) findViewById(R.id.nombre);
        TextView region = (TextView) findViewById(R.id.ciudadR);
        TextView telefono = (TextView) findViewById(R.id.telefono);
        TextView correo = (TextView) findViewById(R.id.correo);




        for(int i=0;i<usu.largo();i++) {
            if (usu.getUsu(i).getNickname().equals(perfil)) {
                cd = usu.getUsu(i).getCiudad()+" " + usu.getUsu(i).getRegion();//esto de aca era lo q queria comentar y se bo
                nombre.setText(usu.getUsu(i).getNombre());// para probar la base de datos
                region.setText(cd);
                telefono.setText(usu.getUsu(i).getTelefono().toString());

                correo.setText(usu.getUsu(i).getCorreo());
            }

        }

    }



    public void onEditar(View view){
        Intent hola = getIntent();
        String nombre = hola.getStringExtra("perfil");


        Intent editar = new Intent(this,EditarPerfil.class);
        editar.putExtra("perfil",nombre);
        startActivity(editar);
    }


}
