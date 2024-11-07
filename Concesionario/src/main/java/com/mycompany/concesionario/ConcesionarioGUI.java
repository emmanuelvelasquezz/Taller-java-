package com.mycompany.concesionario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ConcesionarioGUI extends JFrame {
    private JTextField txtMarca, txtModelo, txtExtra;
    private JComboBox<String> cbTipo;
    private JTextArea taLista;
    private ArrayList<Vehiculo> vehiculos;

    public ConcesionarioGUI() {
        vehiculos = new ArrayList<>();
        setTitle("Concesionario de Vehículos");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Fija el tamaño de la ventana

        // Layout de la ventana
        setLayout(new BorderLayout());

        // Panel para los formularios
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5)); // 5 filas, 2 columnas
        add(panelFormulario, BorderLayout.NORTH);

        // Componentes del formulario
        panelFormulario.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panelFormulario.add(txtMarca);

        panelFormulario.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        panelFormulario.add(txtModelo);

        panelFormulario.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Motocicleta", "Auto", "Camion"});
        cbTipo.addActionListener(e -> actualizarCampoExtra());
        panelFormulario.add(cbTipo);

        panelFormulario.add(new JLabel("Cilindrada / Puertas / Carga:"));
        txtExtra = new JTextField();
        panelFormulario.add(txtExtra);

        JButton btnAgregar = new JButton("Agregar Vehículo");
        btnAgregar.addActionListener(e -> agregarVehiculo());
        panelFormulario.add(btnAgregar);

        // Panel para mostrar la lista de vehículos
        taLista = new JTextArea();
        taLista.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taLista);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void actualizarCampoExtra() {
        String tipo = (String) cbTipo.getSelectedItem();
        if ("Motocicleta".equals(tipo)) {
            txtExtra.setToolTipText("Cilindrada (cc)");
        } else if ("Auto".equals(tipo)) {
            txtExtra.setToolTipText("Número de puertas");
        } else if ("Camion".equals(tipo)) {
            txtExtra.setToolTipText("Capacidad de carga (kg)");
        }
        txtExtra.setText(""); // Limpiar el campo al cambiar tipo
    }

    private void agregarVehiculo() {
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String tipo = (String) cbTipo.getSelectedItem();
        String extra = txtExtra.getText();

        try {
            Vehiculo vehiculo;
            switch (tipo) {
                case "Motocicleta":
                    int cilindrada = Integer.parseInt(extra);
                    vehiculo = new Motocicleta(marca, modelo, cilindrada);
                    break;
                case "Auto":
                    int numPuertas = Integer.parseInt(extra);
                    vehiculo = new Auto(marca, modelo, numPuertas);
                    break;
                case "Camion":
                    int capacidadCarga = Integer.parseInt(extra);
                    vehiculo = new Camion(marca, modelo, capacidadCarga);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de vehículo no reconocido");
            }
            vehiculos.add(vehiculo);
            actualizarLista();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El valor extra debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarLista() {
        taLista.setText("");
        for (Vehiculo v : vehiculos) {
            taLista.append(v.getInfo() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConcesionarioGUI gui = new ConcesionarioGUI();
            gui.setVisible(true);
        });
    }
}
