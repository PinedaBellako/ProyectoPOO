package org.example;

import org.example.Vista.VentanaPremios;
import org.example.controlador.ControladorPremios;

public class Main {
    public static void main(String[] args) {
        VentanaPremios view = new VentanaPremios("Premios Nobel");
        ControladorPremios controller = new ControladorPremios(view);
    }
}