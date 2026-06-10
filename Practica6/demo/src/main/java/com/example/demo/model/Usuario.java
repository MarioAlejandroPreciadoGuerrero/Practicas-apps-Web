package com.example.demo.model;

public class Usuario {
    private String nombre;
    private String email;
    private String password;
    private String txt_nickName;
    private String rad_genero;
    private String sel_suscription;
    private String Birth_day;
    private String terms;
    private String coments;

    public Usuario (){


    }

    public Usuario (String nombre, String email, String password, String nickName, String genero, String tipoSuscripcion, String fechaNacimiento, String terms) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.txt_nickName = nickName;
        this.rad_genero = genero;
        this.sel_suscription = tipoSuscripcion;
        this.Birth_day = fechaNacimiento;
        this.terms = terms;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    public String getCorreo() {
        return email;
    }
}
