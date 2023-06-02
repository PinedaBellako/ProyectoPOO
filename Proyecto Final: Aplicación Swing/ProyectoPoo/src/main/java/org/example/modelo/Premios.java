package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Premios {
    private int Id;
    private String Categoria;
    private String Condecorado;
    private String Nacionalidad;
    private String Fecha;
    private String Url;

    public Premios() {
    }

    public Premios(int id, String categoria, String condecorado, String nacionalidad, String fecha, String url) {
        Id = id;
        Categoria = categoria;
        Condecorado = condecorado;
        Nacionalidad = nacionalidad;
        Fecha = fecha;
        Url = url;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getCondecorado() {
        return Condecorado;
    }

    public void setCondecorado(String condecorado) {
        Condecorado = condecorado;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public String toString() {
        return "Premios{" +
                "Id=" + Id +
                ", Categoria='" + Categoria + '\'' +
                ", Condecorado='" + Condecorado + '\'' +
                ", Nacionalidad='" + Nacionalidad + '\'' +
                ", Fecha='" + Fecha + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }

    public ImageIcon getImagen()throws MalformedURLException {
        URL url = new URL(this.Url);
        return new ImageIcon(url);
    }
}
