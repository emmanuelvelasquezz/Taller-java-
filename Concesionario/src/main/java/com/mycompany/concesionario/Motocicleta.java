package com.mycompany.concesionario;

public class Motocicleta extends Vehiculo {
    private int cilindrada;

    public Motocicleta(String marca, String modelo, int cilindrada) {
        super(marca, modelo);
        this.cilindrada = cilindrada;
    }

    @Override
    public String getInfo() {
        return "Motocicleta: " + marca + " " + modelo + " - Cilindrada: " + cilindrada + "cc";
    }
}
