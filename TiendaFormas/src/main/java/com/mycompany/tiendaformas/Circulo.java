package com.mycompany.tiendaformas;

public class Circulo extends Forma {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public String getTipo() {
        return "Círculo";
    }
}

