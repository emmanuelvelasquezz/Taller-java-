package formas.geométricas.abstrac;

public class Rectangulo extends Forma {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public String info() {
        return "Rectángulo - Ancho: " + ancho + ", Alto: " + alto + ", Área: " + calcularArea();
    }
}
