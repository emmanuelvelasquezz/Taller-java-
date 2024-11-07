package com.mycompany.concesionario;

public class Auto extends Vehiculo {
    private int numPuertas;

    public Auto(String marca, String modelo, int numPuertas) {
        super(marca, modelo);
        this.numPuertas = numPuertas;
    }

    @Override
    public String getInfo() {
        return "Auto: " + marca + " " + modelo + " - Puertas: " + numPuertas;
    }
}
