package Gui;

import Excepcion.VehiculoException;
import Modelo.Vehiculo;
import Servicio.Impl.ConcesionariaServicioImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class PanelAdministradorFrame extends JFrame {
    private final ConcesionariaServicioImpl concesionariaServicio;

    public PanelAdministradorFrame() {
        setTitle("Panel de Administrador");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        // Botones
        JButton btnAgregar = new JButton("Agregar Vehículo");
        btnAgregar.setBounds(30, 30, 150, 30);
        panel.add(btnAgregar);

        JButton btnModificar = new JButton("Modificar Vehículo");
        btnModificar.setBounds(200, 30, 150, 30);
        panel.add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar Vehículo");
        btnEliminar.setBounds(370, 30, 150, 30);
        panel.add(btnEliminar);

        JButton btnObtenerTodos = new JButton("Obtener todos los vehículos");
        btnObtenerTodos.setBounds(30, 80, 200, 30);
        panel.add(btnObtenerTodos);

        JButton btnObtenerPorId = new JButton("Buscar vehículo");
        btnObtenerPorId.setBounds(250, 80, 200, 30);
        panel.add(btnObtenerPorId);

        // Tabla para mostrar la lista de vehículos
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Color");
        model.addColumn("Año");
        model.addColumn("Precio");

        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 130, 550, 200);
        panel.add(scrollPane);

        // Inicializar el servicio de la concesionaria
        concesionariaServicio = new ConcesionariaServicioImpl();

        // Manejar eventos de los botones
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar un vehículo
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar un vehículo

            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo diálogo para ingresar el ID del vehículo a eliminar
                JDialog dialog = new JDialog(PanelAdministradorFrame.this, "Eliminar Vehículo", true);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(PanelAdministradorFrame.this);
                dialog.setLayout(null);

                JLabel labelId = new JLabel("ID del Vehículo:");
                labelId.setBounds(20, 30, 150, 30);
                dialog.add(labelId);

                JTextField textFieldId = new JTextField();
                textFieldId.setBounds(20, 60, 250, 30);
                dialog.add(textFieldId);

                JButton btnEliminarConfirmar = new JButton("Eliminar");
                btnEliminarConfirmar.setBounds(100, 100, 100, 30);
                dialog.add(btnEliminarConfirmar);

                btnEliminarConfirmar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idText = textFieldId.getText();
                        try {
                            int id = Integer.parseInt(idText);

                            try {
                                // Intentar eliminar el vehículo
                                concesionariaServicio.eliminarVehiculo(id);

                                // Mostrar mensaje de éxito
                                JOptionPane.showMessageDialog(dialog, "Vehículo eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                                // Cerrar el diálogo después de eliminar
                                dialog.dispose();

                                // Actualizar la tabla de vehículos
                                mostrarVehiculosEnTabla(concesionariaServicio.obtenerTodosVehiculos(), model);

                            } catch (VehiculoException ex) {
                                // Mostrar mensaje de error si el ID no existe
                                JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } catch (NumberFormatException ex) {
                            // Mostrar mensaje de error si el ID ingresado no es un número válido
                            JOptionPane.showMessageDialog(dialog, "Por favor ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                dialog.setVisible(true);
            }
        });


        // Lógica para obtener todos los vehículos
        btnObtenerTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lógica para obtener todos los vehículos
                    HashMap<Integer, Vehiculo> listaVehiculos = concesionariaServicio.obtenerTodosVehiculos();

                    // Mostrar los vehículos en la tabla
                    mostrarVehiculosEnTabla(listaVehiculos, model);
                } catch (VehiculoException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        // Lógica para obtener todos los vehículos que coincidan con la marca elegida por el usuario
        btnObtenerPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(PanelAdministradorFrame.this, "Buscar vehículo por marca", true);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(PanelAdministradorFrame.this);
                dialog.setLayout(null);

                JLabel labelNombre = new JLabel("Marca del vehículo:");
                labelNombre.setBounds(20, 30, 150, 30);
                dialog.add(labelNombre);

                JTextField textFieldNombre = new JTextField();
                textFieldNombre.setBounds(20, 60, 250, 30);
                dialog.add(textFieldNombre);

                JButton btnBuscar = new JButton("Buscar");
                btnBuscar.setBounds(100, 100, 100, 30);
                dialog.add(btnBuscar);

                btnBuscar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // El usuario ingresará la marca
                        String marca = textFieldNombre.getText();

                        try {
                            // Obtener todos los vehículos que coincidan con la marca
                            HashMap<Integer, Vehiculo> vehiculosEncontrados = concesionariaServicio.obtenerVehiculosPorMarca(marca);

                            // Mostrar los vehículos encontrados en la tabla
                            mostrarVehiculosEnTabla(vehiculosEncontrados, model);

                            // Cerrar el diálogo después de buscar
                            dialog.dispose();

                        } catch (VehiculoException ex) {
                            JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            // Limpiar el campo de texto después de la búsqueda, ya sea éxito o error
                            textFieldNombre.setText("");
                        }
                    }
                });

                dialog.setVisible(true);
            }
        });

        setVisible(true);
    }

    // Método para mostrar los vehículos en la tabla
    private void mostrarVehiculosEnTabla(HashMap<Integer, Vehiculo> listaVehiculos, DefaultTableModel model) {
        model.setRowCount(0);
        for (Vehiculo vehiculo : listaVehiculos.values()) {
            Object[] row = {
                    vehiculo.getId(),
                    vehiculo.getMarca(),
                    vehiculo.getModelo(),
                    vehiculo.getColor(),
                    vehiculo.getAnio(),
                    vehiculo.getPrecio()
            };

            model.addRow(row);
        }
    }
}