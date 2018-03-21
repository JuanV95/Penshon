package com.example.alexander.penshon20;

import java.util.ArrayList;

public class listaPlaces{

    private static listaPlaces lista;

    private ArrayList<Place> places = new ArrayList<>();

    private listaPlaces(){

    }

    public static listaPlaces getInstance(){

        if(lista==null){

            lista = new listaPlaces();
        }

        return lista;
    }

    public void agregar(Place p){

        for (int i=0; i<places.size(); i++){

            if(places.get(i).getTitulo().equalsIgnoreCase(p.getTitulo())){

                break;
            }
        }

        places.add(p);
    }

    public Place getPlace(int i){

        return places.get(i);
    }

    public Place buscar(String titulo){

        Place p;

        for (int i=0;i<places.size();i++){

            p = places.get(i);

            if(p.getTitulo().equalsIgnoreCase(titulo)){

                return p;
            }
        }

        return null;
    }

    public int largo(){

        return places.size();
    }
}
