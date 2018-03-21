package com.example.alexander.penshon20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Publicacion extends AppCompatActivity {

    listaPlaces places = listaPlaces.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicacion);

        cargarPublicacion();

    }

    public void onClick(View view) {
        Intent tarea = getIntent();
        String nombre = tarea.getStringExtra("nombre");
        Intent come= new Intent(this,Publicacion.class);
        TextView t=(TextView) findViewById(R.id.TxtNombre);
        come.putExtra("comentario",t.getText().toString());
        come.putExtra("nombre",nombre);
        startActivity(come);
    }

    protected void onPause(){
        super.onPause();
        finish();
    }

    public void cargarPublicacion(){

        Intent tarea = getIntent();
        String nombre = tarea.getStringExtra("nombre");
        String com = tarea.getStringExtra("comentario");
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();

        Place p = new Place();
        p=places.buscar(nombre);

        p.getComentarios().add(com);

        TextView d=(TextView) findViewById(R.id.Descripcion);
        d.setText(p.getDescripcion());
        TextView titulo=(TextView) findViewById(R.id.titulo);
        titulo.setText(p.getTitulo()+": ");
        TextView direc=(TextView) findViewById(R.id.direccion);
        direc.setText(p.getDireccion());
        TextView costo=(TextView) findViewById(R.id.Costo);
        costo.setText(Integer.toString(p.getCosto()));
        TextView normas=(TextView) findViewById(R.id.Normas);
        normas.setText(p.getNormas());
        TextView comentario=(TextView) findViewById(R.id.comentario1);
        comentario.setText(p.getComentarios().get(p.getComentarios().size()-1));

        if(p.getComentarios().size()>2) {
            TextView comentario1 = (TextView) findViewById(R.id.comentario2);
            comentario1.setVisibility(View.VISIBLE);
            comentario1.setText(p.getComentarios().get(p.getComentarios().size() - 2));
        }
        else {
            TextView comentario1 = (TextView) findViewById(R.id.comentario2);
            comentario1.setVisibility(View.GONE);
        }
        if(p.getComentarios().size()>3) {
            TextView comentario2 = (TextView) findViewById(R.id.comentario3);
            comentario2.setVisibility(View.VISIBLE);
            comentario2.setText(p.getComentarios().get(p.getComentarios().size()-3));
        }
        else {
            TextView comentario1 = (TextView) findViewById(R.id.comentario3);
            comentario1.setVisibility(View.GONE);
        }
        if(p.getTitulo().equals("Pieza personal"))
        {
            ImageView casa=(ImageView) findViewById(R.id.imageView);
            casa.setImageResource(R.drawable.casa1);
            ImageView foto=(ImageView) findViewById(R.id.imageView2);
            foto.setImageResource(R.drawable.teo);
        }
        if(p.getTitulo().equals("Pieza compartida"))
        {
            ImageView casa=(ImageView) findViewById(R.id.imageView);
            casa.setImageResource(R.drawable.casa2);
            ImageView foto=(ImageView) findViewById(R.id.imageView2);
            foto.setImageResource(R.drawable.braulio);
        }
        if(!p.isBano())
        {
            ImageView bano=(ImageView) findViewById(R.id.baño);
            bano.setVisibility(View.GONE);
        }
        if(!p.isCocina())
        {
            ImageView cocina=(ImageView) findViewById(R.id.cocina);
            cocina.setVisibility(View.GONE);
        }
        if(!p.isLavadora())
        {
            ImageView lavadora=(ImageView) findViewById(R.id.lavadora);
            lavadora.setVisibility(View.GONE);
        }
        if(!p.isMascota())
        {
            ImageView mascota=(ImageView) findViewById(R.id.mascota);
            mascota.setVisibility(View.GONE);
        }
        if(!p.isTv())
        {
            ImageView tv=(ImageView) findViewById(R.id.tv);
            tv.setVisibility(View.GONE);
        }
        if(!p.isWifi())
        {
            ImageView wifi=(ImageView) findViewById(R.id.wifi);
            wifi.setVisibility(View.GONE);
        }
    }
}

