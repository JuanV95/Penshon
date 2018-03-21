package com.example.alexander.penshon20;

/**
 * Created by Michi on 19-11-2016.
 */

public class Usuarios {
    private String ciudad;
    private String contraseña;
    private String correo;
    private String genero;
    private String imagen;
    private String nickname;
    private String nombre;
    private String region;
    private String telefono;


    public Usuarios(String ciudad,String contraseña,String correo,String genero,String imagen,String nombre,String nickname,String region,String telefono)
    {
        this.ciudad=ciudad;
        this.contraseña=contraseña;
        this.correo=correo;
        this.genero=genero;
        this.imagen=imagen;
        this.nombre=nombre;
        this.nickname=nickname;
        this.region=region;
        this.telefono=telefono;
    }
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
