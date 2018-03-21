package com.example.alexander.penshon20;

import android.graphics.Bitmap;

import java.util.ArrayList;


public class Place {

    private int costo;
    private Bitmap imagen;
    private String descripcion;
    private String titulo;
    private ArrayList<String> comentarios= new ArrayList<>();
    private boolean wifi = false;
    private boolean bano = false;
    private boolean mascota = false;
    private boolean cocina = false;
    private boolean tv = false;
    private boolean lavadora = false;
    private String direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }

    private String normas;


    public Place(String nombre,String titulo, Bitmap imagen,String direccion,int costo,String descripcion,boolean wifi,boolean bano,boolean mascota,boolean cocina,boolean tv,boolean lavadora, String normas) {
        this.titulo=titulo;
        this.direccion=direccion;
        this.costo=costo;
        this.descripcion=descripcion;
        this.wifi=wifi;
        this.bano=bano;
        this.mascota=mascota;
        this.cocina=cocina;
        this.tv=tv;
        this.lavadora=lavadora;
        this.normas=normas;
        this.imagen=imagen;
    }

    public Place(String nombre,String titulo,String direccion,int costo,String descripcion,boolean wifi,boolean bano,boolean mascota,boolean cocina,boolean tv,boolean lavadora, String normas) {
        this.titulo=titulo;
        this.direccion=direccion;
        this.costo=costo;
        this.descripcion=descripcion;
        this.wifi=wifi;
        this.bano=bano;
        this.mascota=mascota;
        this.cocina=cocina;
        this.tv=tv;
        this.lavadora=lavadora;
        this.normas=normas;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isBano() {
        return bano;
    }

    public void setBano(boolean bano) {
        this.bano = bano;
    }

    public boolean isMascota() {
        return mascota;
    }

    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }

    public boolean isCocina() {
        return cocina;
    }

    public void setCocina(boolean cocina) {
        this.cocina = cocina;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isLavadora() {
        return lavadora;
    }

    public void setLavadora(boolean lavadora) {
        this.lavadora = lavadora;
    }

    public String getNormas() {
        return normas;
    }

    public void setNormas(String normas) {
        this.normas = normas;
    }

    public Place() {

    }

    public String getTitulo(){

        return titulo;
    }

    public String getDireccion(){

        return direccion;
    }

    public Bitmap getImagen(){

        return imagen;
    }

}
