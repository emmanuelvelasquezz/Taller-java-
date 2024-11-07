package com.mycompany.concesionario;

public class Camion extends Vehiculo {
    private int capacidadCarga;

    public Camion(String marca, String modelo, int capacidadCarga) {
        super(marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String getInfo() {
        return "Camion: " + marca + " " + modelo + " - Capacidad de carga: " + capacidadCarga + "kg";
    }
}
