package com.mycompany.tiendaformas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TiendaFormasGUI extends JFrame {
    private JComboBox<String> comboFormas;
    private JTextField txtRadio, txtAncho, txtAlto;
    private JTextArea areaResultados;
    private ArrayList<Forma> formas;

    public TiendaFormasGUI() {
        formas = new ArrayList<>();

        setTitle("Tienda de Formas Geométricas");
        setSize(500,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de Entrada
        JPanel panelEntrada = new JPanel(new GridLayout(5, 2, 5, 5));
        
        comboFormas = new JComboBox<>(new String[]{"Círculo", "Rectángulo"});
        txtRadio = new JTextField();
        txtAncho = new JTextField();
        txtAlto = new JTextField();
        
        panelEntrada.add(new JLabel("Forma:"));
        panelEntrada.add(comboFormas);
        panelEntrada.add(new JLabel("Radio (solo para círculo):"));
        panelEntrada.add(txtRadio);
        panelEntrada.add(new JLabel("Ancho (solo para rectángulo):"));
        panelEntrada.add(txtAncho);
        panelEntrada.add(new JLabel("Alto (solo para rectángulo):"));
        panelEntrada.add(txtAlto);

        add(panelEntrada, BorderLayout.NORTH);

        // Panel de Botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar Forma");
        JButton btnMostrar = new JButton("Mostrar Áreas");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);
        
        add(panelBotones, BorderLayout.CENTER);

        // Área de Resultados
        areaResultados = new JTextArea(8, 20);
        areaResultados.setEditable(false);
        add(new JScrollPane(areaResultados), BorderLayout.SOUTH);

        // Evento para botón Agregar
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarForma();
            }
        });

        // Evento para botón Mostrar
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAreas();
            }
        });
    }

    private void agregarForma() {
        String tipo = (String) comboFormas.getSelectedItem();
        
        try {
            if ("Círculo".equals(tipo)) {
                double radio = validarCampoNumerico(txtRadio.getText(), "Radio");
                formas.add(new Circulo(radio));
                areaResultados.append("Círculo agregado con radio: " + radio + "\n");
            } else if ("Rectángulo".equals(tipo)) {
                double ancho = validarCampoNumerico(txtAncho.getText(), "Ancho");
                double alto = validarCampoNumerico(txtAlto.getText(), "Alto");
                formas.add(new Rectangulo(ancho, alto));
                areaResultados.append("Rectángulo agregado con ancho: " + ancho + " y alto: " + alto + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double validarCampoNumerico(String texto, String campo) throws NumberFormatException {
        if (texto.isEmpty()) {
            throw new NumberFormatException("El campo " + campo + " está vacío.");
        }
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El campo " + campo + " debe ser un número válido.");
        }
    }

    private void mostrarAreas() {
        areaResultados.setText(""); // Limpiar área de resultados
        for (Forma forma : formas) {
            areaResultados.append(forma.getTipo() + " - Área: " + forma.calcularArea() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TiendaFormasGUI frame = new TiendaFormasGUI();
            frame.setVisible(true);
        });
    }
}
