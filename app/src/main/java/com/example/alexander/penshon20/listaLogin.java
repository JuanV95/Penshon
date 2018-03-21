package com.example.alexander.penshon20;

import java.util.ArrayList;

/**
 * Created by Michi on 19-11-2016.
 */

public class listaLogin {
    private static listaLogin lista;
    private ArrayList<Usuarios> usu = new ArrayList<>();

    public void agregar(Usuarios u){

        usu.add(u);
    }

    public Usuarios getUsu(int i){

        return usu.get(i);
    }


    public int largo(){

        return usu.size();
    }
    public static listaLogin getInstance(){

        if(lista==null){

            lista = new listaLogin();
        }

        return lista;
    }
}
