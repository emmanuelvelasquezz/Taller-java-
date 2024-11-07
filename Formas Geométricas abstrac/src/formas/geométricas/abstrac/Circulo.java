package formas.geométricas.abstrac;

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
    public String info() {
        return "Círculo - Radio: " + radio + ", Área: " + calcularArea();
    }
}

