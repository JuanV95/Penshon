package com.example.alexander.penshon20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class EditarPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }



    public void Onclick(View view) {
        Intent hola = getIntent();
        String nombre = hola.getStringExtra("perfil");

        ImageView imagen = (ImageView) findViewById(R.id.fotoperfil);
        EditText nombreusr = (EditText) findViewById(R.id.nombre);
        EditText ciudad = (EditText) findViewById(R.id.ciudad);
        EditText region = (EditText) findViewById(R.id.region);
        EditText telefono = (EditText) findViewById(R.id.telefono);//este es int quizas puede necesitar algun casteo :o ojo piojo
        EditText correo = (EditText) findViewById(R.id.correo);
        RadioGroup sexo = (RadioGroup) findViewById(R.id.sexo);
        EditText pass = (EditText) findViewById(R.id.pass1);

        DB db = new DB();
        if (!nombreusr.getText().toString().equals(""))
            db.execute("update login set nombre='" + nombreusr.getText().toString() + "' where nickname='" + nombre + "'");
        if (!ciudad.getText().toString().equals(""))
            db.execute("update login set ciudad='" + ciudad.getText().toString() + "' where nickname='" + nombre + "'");
        if (!pass.getText().toString().equals(""))
            db.execute("update login set contraseña='" + pass.getText().toString() + "' where nickname='" + nombre + "'");
        if (!correo.getText().toString().equals(""))
            db.execute("update login set correo='" + correo.getText().toString() + "' where nickname='" + nombre + "'");
        if (!sexo.toString().equals(""))
            db.execute("update login set genero='" + sexo.toString() + "' where nickname='" + nombre + "'");
        if (!region.getText().toString().equals(""))
            db.execute("update login set region='" + region.getText().toString() + "' where nickname='" + nombre + "'");
        if (!telefono.getText().toString().equals(""))
            db.execute("update login set telefono='" + telefono.getText().toString() + "' where nickname='" + nombre + "'");

        Intent siguiente = new Intent(this, Catalogos.class);
        siguiente.putExtra("perfil",nombre);
        startActivity(siguiente);
    }



}
