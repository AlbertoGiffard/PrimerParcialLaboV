package com.example.testingclase;

import java.io.Serializable;

public class PersonaModel implements Serializable {
    private String nombre;
    private String contrasenia;
    private String tipo;

    public PersonaModel(String nombre, String contrasenia, String tipo) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + nombre + '\'' +
                ", Contrasenia='" + contrasenia + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public void setModel(PersonaModel personaModel){
        this.setNombre(personaModel.getNombre());
        this.setContrasenia(personaModel.getContrasenia());
        this.setTipo(personaModel.getTipo());
    }
}
