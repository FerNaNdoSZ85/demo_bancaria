package org.info23;

public class Admin {
    private int id_admin;
    private String nombre;

    //Metodos
    // [Clasificador] [tipo_retorno] nombreMetodo ([<expresiones>])

    //setters
    public int getId_admin() {
        return this.id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
