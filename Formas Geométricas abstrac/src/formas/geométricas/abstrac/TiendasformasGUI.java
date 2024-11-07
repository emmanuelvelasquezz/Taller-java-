package formas.geométricas.abstrac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TiendasformasGUI extends JFrame {
    private ArrayList<Forma> formas = new ArrayList<>();
    private JTextArea areaResultado;
    private JTextField txtRadio, txtAncho, txtAlto;

    public TiendasformasGUI() {
        setTitle("Tienda de Formas Geométricas");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Panel para agregar círculos
        JPanel panelCirculo = new JPanel();
        panelCirculo.setLayout(new FlowLayout());
        panelCirculo.add(new JLabel("Radio del Círculo:"));
        txtRadio = new JTextField(10);
        panelCirculo.add(txtRadio);
        JButton btnAgregarCirculo = new JButton("Agregar Círculo");
        panelCirculo.add(btnAgregarCirculo);
        btnAgregarCirculo.addActionListener(e -> agregarCirculo());

        // Panel para agregar rectángulos
        JPanel panelRectangulo = new JPanel();
        panelRectangulo.setLayout(new FlowLayout());
        panelRectangulo.add(new JLabel("Ancho del Rectángulo:"));
        txtAncho = new JTextField(10);
        panelRectangulo.add(txtAncho);
        panelRectangulo.add(new JLabel("Alto del Rectángulo:"));
        txtAlto = new JTextField(10);
        panelRectangulo.add(txtAlto);
        JButton btnAgregarRectangulo = new JButton("Agregar Rectángulo");
        panelRectangulo.add(btnAgregarRectangulo);
        btnAgregarRectangulo.addActionListener(e -> agregarRectangulo());

        // Área de resultado
        areaResultado = new JTextArea(10, 40);
        areaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultado);

        // Botón para mostrar áreas
        JButton btnMostrarAreas = new JButton("Mostrar Áreas");
        btnMostrarAreas.addActionListener(e -> mostrarAreas());

        add(panelCirculo);
        add(panelRectangulo);
        add(btnMostrarAreas);
        add(scrollPane);
    }

    private void agregarCirculo() {
        try {
            double radio = Double.parseDouble(txtRadio.getText());
            formas.add(new Circulo(radio));
            txtRadio.setText("");
            areaResultado.append("Círculo agregado.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido para el radio.");
        }
    }

    private void agregarRectangulo() {
        try {
            double ancho = Double.parseDouble(txtAncho.getText());
            double alto = Double.parseDouble(txtAlto.getText());
            formas.add(new Rectangulo(ancho, alto));
            txtAncho.setText("");
            txtAlto.setText("");
            areaResultado.append("Rectángulo agregado.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos para ancho y alto.");
        }
    }

    private void mostrarAreas() {
        areaResultado.setText("Lista de Formas y sus Áreas:\n");
        for (Forma forma : formas) {
            areaResultado.append(forma.info() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TiendasformasGUI().setVisible(true);
        });
    }
}
