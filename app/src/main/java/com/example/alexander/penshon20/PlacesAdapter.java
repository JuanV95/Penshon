package com.example.alexander.penshon20;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class PlacesAdapter extends ArrayAdapter<Place> {
    private Context mycontext;
    private int mylayoutResourceID;
    private Place mydata[] = null;

    public PlacesAdapter(Context context, int layoutResourceID, Place[] data){
        super(context,layoutResourceID,data);

        this.mycontext = context;
        this.mylayoutResourceID = layoutResourceID;
        this.mydata = data;
    }

    @NonNull
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        PlaceHolder holder = null;

        if(row == null){

            LayoutInflater inflater = ((Activity)mycontext).getLayoutInflater();
            row = inflater.inflate(mylayoutResourceID,parent,false);

            holder = new PlaceHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imagen_single_post_circuito);
            holder.titulo = (TextView) row.findViewById(R.id.tv_titulo_single_post_circuito);
            holder.descripcion = (TextView) row.findViewById(R.id.tv_contenido_single_post_circuito);
            row.setTag(holder);

        }else{

            holder = (PlaceHolder)row.getTag();

        }

        Place p = mydata[position];
        holder.imagen.setImageBitmap(p.getImagen());
        holder.titulo.setText(p.getTitulo());
        holder.descripcion.setText(p.getDescripcion());

        return row;

    }

    static class PlaceHolder{
        ImageView imagen;
        TextView titulo;
        TextView descripcion;
    }
}
