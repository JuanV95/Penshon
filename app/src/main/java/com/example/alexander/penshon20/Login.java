package com.example.alexander.penshon20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends AppCompatActivity {

    listaPlaces places = listaPlaces.getInstance();
    //DB db = new DB();
    listaLogin usu = listaLogin.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        MultiDex.install(this);

        Place p = new Place("Braulio", "Pension estudiantil", BitmapFactory.decodeResource(getResources(), R.drawable.casa1), "Rawson 310 Valparaíso Chile" , 140000, "Bonita pension para estudiantes", true, true, true, true, true, true, "Nada de weed");
        places.agregar(p);

        /*try {
            ResultSet rs = db.execute("select * from publicaciones");
            if (rs != null) {
                while (rs.next()) {
                    Bitmap bitmap = BitmapFactory.decodeFile(rs.getString("imagen"));
                    Place p =new Place(rs.getString("nombre"),rs.getString("titulo"),bitmap,rs.getString("direccion"),rs.getInt("costo"),rs.getString("descripcion"),rs.getBoolean("wifi"),rs.getBoolean("baño"),rs.getBoolean("mascota"),rs.getBoolean("cocina"),rs.getBoolean("tv"),rs.getBoolean("lavadora"),rs.getString("normas"));
                    places.agregar(p);
                    p=null;
                }
            }
            else
            {
                Toast.makeText(this,"no hay internet",Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            Toast.makeText(this,"me cai",Toast.LENGTH_LONG).show();
        }*/


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onBuscar(View view) {

        String user;
        String pass;
        EditText location_tf;
        Intent siguiente = new Intent(Login.this, Catalogos.class);
        AlertDialog.Builder errorLogin = new AlertDialog.Builder(Login.this);

        errorLogin.setTitle("Error");
        errorLogin.setMessage("Nombre de usuario o contraseña incorreta");
        errorLogin.setCancelable(true);

        location_tf = (EditText) findViewById(R.id.userName);
        user = location_tf.getText().toString();
        location_tf = (EditText) findViewById(R.id.userPass);
        pass = location_tf.getText().toString();

        if(verificarUsuario(user, pass)){

            siguiente.putExtra("perfil",user);
            startActivity(siguiente);

        }else{

            errorLogin.create();
            errorLogin.show();

        }


        /*location_tf = (EditText) findViewById(R.id.userName);
        usuario = location_tf.getText().toString();
        location_tf = (EditText) findViewById(R.id.userPass);
        pass = location_tf.getText().toString();

        try {

            ResultSet rs = db.execute("select * from login");
            if (rs != null) {
                while (rs.next()) {
                    Usuarios u =new Usuarios(rs.getString("ciudad"),rs.getString("contraseña"),rs.getString("correo"),rs.getString("genero"),rs.getString("imagen"),rs.getString("nombre"),rs.getString("nickname"),rs.getString("region"),rs.getString("telefono"));
                    usu.agregar(u);
                    u=null;
                }
            }
            else
            {
                Toast.makeText(this,"no hay internet",Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            Toast.makeText(this,"me cai",Toast.LENGTH_LONG).show();
        }
        for(int i=0;i<usu.largo();i++) {
            if (usuario.equalsIgnoreCase(usu.getUsu(i).getNickname()) && pass.equalsIgnoreCase(usu.getUsu(i).getContraseña())) {
                siguiente.putExtra("perfil",usu.getUsu(i).getNickname());
                startActivity(siguiente);

            } else {

                errorLogin.create();
                errorLogin.show();

            }
        }*/

    }

    protected void onPause(){
        super.onPause();
        finish();       //termina la actividad
    }

    public boolean verificarUsuario(String user, String pass){

        if(user.equalsIgnoreCase("juan") && pass.equalsIgnoreCase("juan")){

            return true;

        }else{

            return false;
        }
    }
}
