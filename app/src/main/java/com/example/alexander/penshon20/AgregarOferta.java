package com.example.alexander.penshon20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.frosquivel.magicalcamera.MagicalCamera;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AgregarOferta extends AppCompatActivity {

    private static final int RESIZE_PHOTO_PIXELS_PERCENTAGE = 3000 ;
    private MagicalCamera magicalcamera;
    private ImageView mSetImage;
    listaPlaces lis = listaPlaces.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_oferta);

        magicalcamera = new MagicalCamera(this,RESIZE_PHOTO_PIXELS_PERCENTAGE);
        mSetImage = (ImageView) findViewById(R.id.imagenCasa);
    }

    public void Onclick(View view)
    {
        ImageView imagen = (ImageView) findViewById(R.id.imagenCasa);
        EditText titulo = (EditText) findViewById(R.id.titulo);
        EditText direccion = (EditText) findViewById(R.id.direccion);
        EditText costo = (EditText) findViewById(R.id.costo);
        EditText normas = (EditText) findViewById(R.id.normas);
        EditText descripcion = (EditText) findViewById(R.id.descripcion);

        CheckBox wifi = (CheckBox) findViewById(R.id.wifi);
        CheckBox mascota = (CheckBox) findViewById(R.id.mascota);
        CheckBox lavadora = (CheckBox) findViewById(R.id.lavadora);
        CheckBox cocina = (CheckBox) findViewById(R.id.cocina);
        CheckBox bano = (CheckBox) findViewById(R.id.baño);
        CheckBox tv = (CheckBox) findViewById(R.id.tv);



        DB db = new DB();
        Bitmap bitmap=magicalcamera.getMyPhoto();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, baos);
        byte[] b= baos.toByteArray();


        db.execute("INSERT INTO publicaciones (nombre,titulo,direccion,costo,descripcion,wifi,baño,mascota,cocina,tv,lavadora,normas,imagen) VALUES ('nombre','"+titulo.getText().toString()+"','"+direccion.getText().toString()+"','"+Integer.parseInt(costo.getText().toString())+"','"+descripcion.getText().toString()+"','"+wifi.isChecked()+"','"+bano.isChecked()+"','"+mascota.isChecked()+"','"+cocina.isChecked()+"','"+tv.isChecked()+"','"+lavadora.isChecked()+"','"+normas.getText().toString()+"','"+magicalcamera.getMyPhoto().getNinePatchChunk()+"')");
        Place casa = new Place("hol",titulo.getText().toString(),magicalcamera.getMyPhoto(),direccion.getText().toString(),Integer.parseInt(costo.getText().toString()),descripcion.getText().toString(),wifi.isChecked(),bano.isChecked(),mascota.isChecked(),cocina.isChecked(),tv.isChecked(),lavadora.isChecked(),normas.getText().toString()) ;

        lis.agregar(casa); // agrega a la lista


        Intent siguiente = new Intent(AgregarOferta.this, Catalogos.class);
        startActivity(siguiente);


    }

    public void onSubirImagen(View view){
        magicalcamera.selectedPicture("Seleccione el que mas le agrada");

    }

    protected void onPause(){
        super.onPause();
              //termina la actividad
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        magicalcamera.resultPhoto(requestCode, resultCode, data);
        mSetImage.setImageBitmap(magicalcamera.getMyPhoto());

    }

}
