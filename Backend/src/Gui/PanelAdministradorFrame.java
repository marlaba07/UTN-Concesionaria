package Gui;

import Excepcion.VehiculoException;
import Modelo.Automovil;
import Modelo.Moto;
import Modelo.Vehiculo;
import Servicio.Impl.ConcesionariaServicioImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;

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
        model.addColumn("Stock");
        model.addColumn("Tipo");

        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 130, 550, 200);
        panel.add(scrollPane);

        // Inicializar el servicio de la concesionaria
        concesionariaServicio = new ConcesionariaServicioImpl();

        // Lógica para agregar un vehículo
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo diálogo para ingresar los datos del vehículo
                JDialog dialog = new JDialog(PanelAdministradorFrame.this, "Agregar Vehículo", true);
                dialog.setSize(400, 350); // Ajustar tamaño para hacerlo más pequeño
                dialog.setLocationRelativeTo(PanelAdministradorFrame.this);
                dialog.setLayout(new BorderLayout(10, 10)); // Espacios entre componentes y bordes

                JPanel panelCampos = new JPanel();
                panelCampos.setLayout(new GridLayout(8, 2, 5, 5)); // Ajustar filas, columnas, espacios horizontal y vertical

                JLabel labelMarca = new JLabel("Marca:");
                JTextField textFieldMarca = new JTextField();
                panelCampos.add(labelMarca);
                panelCampos.add(textFieldMarca);

                JLabel labelModelo = new JLabel("Modelo:");
                JTextField textFieldModelo = new JTextField();
                panelCampos.add(labelModelo);
                panelCampos.add(textFieldModelo);

                JLabel labelColor = new JLabel("Color:");
                JTextField textFieldColor = new JTextField();
                panelCampos.add(labelColor);
                panelCampos.add(textFieldColor);

                JLabel labelAnio = new JLabel("Año:");
                JTextField textFieldAnio = new JTextField();
                panelCampos.add(labelAnio);
                panelCampos.add(textFieldAnio);

                JLabel labelPrecio = new JLabel("Precio:");
                JTextField textFieldPrecio = new JTextField();
                panelCampos.add(labelPrecio);
                panelCampos.add(textFieldPrecio);

                JLabel labelStock = new JLabel("Stock:");
                JTextField textFieldStock = new JTextField();
                panelCampos.add(labelStock);
                panelCampos.add(textFieldStock);

                JLabel labelTipo = new JLabel("Tipo:");
                JComboBox<String> comboBoxTipo = new JComboBox<>(new String[]{"", "automovil", "moto"});
                panelCampos.add(labelTipo);
                panelCampos.add(comboBoxTipo);

                // Hacer los campos de texto más pequeños
                Dimension fieldDimension = new Dimension(150, 24);
                textFieldMarca.setPreferredSize(fieldDimension);
                textFieldModelo.setPreferredSize(fieldDimension);
                textFieldColor.setPreferredSize(fieldDimension);
                textFieldAnio.setPreferredSize(fieldDimension);
                textFieldPrecio.setPreferredSize(fieldDimension);
                textFieldStock.setPreferredSize(fieldDimension);

                // Panel para el campo adicional
                JLabel labelCantPuertasCilindrada = new JLabel();
                JTextField textFieldCantPuertasCilindrada = new JTextField();
                textFieldCantPuertasCilindrada.setPreferredSize(fieldDimension);

                // Mantener el campo adicional oculto inicialmente
                labelCantPuertasCilindrada.setVisible(false);
                textFieldCantPuertasCilindrada.setVisible(false);
                panelCampos.add(labelCantPuertasCilindrada);
                panelCampos.add(textFieldCantPuertasCilindrada);

                // Agregar el panel de campos al diálogo con márgenes
                JPanel panelMargen = new JPanel(new BorderLayout());
                panelMargen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panelMargen.add(panelCampos, BorderLayout.CENTER);
                dialog.add(panelMargen, BorderLayout.CENTER);

                // Listener para el combo box de tipo
                comboBoxTipo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String seleccion = (String) comboBoxTipo.getSelectedItem();

                        if ("automovil".equals(seleccion)) {
                            labelCantPuertasCilindrada.setText("Cantidad de Puertas:");
                            textFieldCantPuertasCilindrada.setVisible(true);
                            labelCantPuertasCilindrada.setVisible(true);
                        } else if ("moto".equals(seleccion)) {
                            labelCantPuertasCilindrada.setText("Cilindrada:");
                            textFieldCantPuertasCilindrada.setVisible(true);
                            labelCantPuertasCilindrada.setVisible(true);
                        } else {
                            labelCantPuertasCilindrada.setVisible(false);
                            textFieldCantPuertasCilindrada.setVisible(false);
                        }

                        dialog.revalidate();
                        dialog.repaint();
                    }
                });

                // Botón de confirmación
                JButton btnAgregarConfirmar = new JButton("Agregar");
                JPanel panelBoton = new JPanel();
                panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Alinear botón a la derecha
                panelBoton.add(btnAgregarConfirmar);

                // Agregar el panel del botón al diálogo
                dialog.add(panelBoton, BorderLayout.SOUTH);

                btnAgregarConfirmar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String marca                    = textFieldMarca.getText();
                        String modelo                   = textFieldModelo.getText();
                        String color                    = textFieldColor.getText();
                        String anioStr                  = textFieldAnio.getText();
                        String precioStr                = textFieldPrecio.getText();
                        String stockStr                 = textFieldStock.getText();
                        String tipo                     = (String) comboBoxTipo.getSelectedItem();
                        String cantPuertasCilindradaStr = textFieldCantPuertasCilindrada.getText();

                        // Validar que todos los campos estén completos
                        if (marca.isEmpty() || modelo.isEmpty() || color.isEmpty() || anioStr.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty() || Objects.requireNonNull(tipo).isEmpty() || (labelCantPuertasCilindrada.isVisible() && cantPuertasCilindradaStr.isEmpty())) {
                            JOptionPane.showMessageDialog(dialog, "Error, complete todos los campos antes de agregar el vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Validar que los campos de texto no contengan números
                        if (!marca.matches("[a-zA-Z\\s]+") || !modelo.matches("[a-zA-Z\\s]+") || !color.matches("[a-zA-Z\\s]+")) {
                            JOptionPane.showMessageDialog(dialog, "Error, ingrese el formato correcto para cada caso. (Texto)", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        try {
                            // Validar que los campos numéricos sean válidos
                            int anio = Integer.parseInt(anioStr);
                            double precio = Double.parseDouble(precioStr);
                            int stock = Integer.parseInt(stockStr);

                            if ("automovil".equals(tipo)) {
                                int cantPuertas = Integer.parseInt(cantPuertasCilindradaStr);
                                concesionariaServicio.agregarVehiculo(new Automovil(0, marca, modelo, color, anio, precio, stock, tipo, cantPuertas, null));
                            } else if ("moto".equals(tipo)) {
                                double cilindrada = Double.parseDouble(cantPuertasCilindradaStr);
                                concesionariaServicio.agregarVehiculo(new Moto(0, marca, modelo, color, anio, precio, stock, cilindrada));
                            }

                            // Mostrar mensaje de éxito
                            JOptionPane.showMessageDialog(dialog, "Vehículo agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                            // Cerrar el diálogo después de agregar
                            dialog.dispose();

                            // Actualizar la tabla de vehículos
                            mostrarVehiculosEnTabla(concesionariaServicio.obtenerTodosVehiculos(), model);

                        } catch (NumberFormatException ex) {
                            // Mostrar mensaje de error si hay un problema con los valores numéricos
                            JOptionPane.showMessageDialog(dialog, "Error, ingrese el formato correcto para cada caso. (Numerico)", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (VehiculoException ex) {
                            // Mostrar mensaje de error si ocurre una excepción específica de vehículo
                            JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (Exception ex) {
                            // Mostrar mensaje de error genérico
                            JOptionPane.showMessageDialog(dialog, "Ocurrió un error al intentar agregar el vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                dialog.setVisible(true);
            }
        });

        // Lógica para modificar un vehículo
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo diálogo para la modificación de vehículo
                JDialog dialog = new JDialog(PanelAdministradorFrame.this, "Modificar Vehículo", true);
                dialog.setSize(400, 350); // Tamaño ajustado para el modal (mismo tamaño que el de agregar)
                dialog.setLocationRelativeTo(null); // Centrar el modal en la pantalla
                dialog.setLayout(new BorderLayout());

                // Panel principal del diálogo
                JPanel panelPrincipal = new JPanel(new BorderLayout());
                panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // Panel para los campos de entrada
                JPanel panelCampos = new JPanel();
                panelCampos.setLayout(new GridLayout(8, 2, 5, 5)); // Ajustar filas, columnas, espacios horizontal y vertical

                JLabel labelID = new JLabel("ID del vehículo:");
                JTextField textFieldID = new JTextField();
                JButton btnCorroborar = new JButton("Corroborar");

                // Estilo de los campos y botones
                textFieldID.setPreferredSize(new Dimension(150, 24));
                btnCorroborar.setPreferredSize(new Dimension(120, 24));

                panelCampos.add(labelID);
                panelCampos.add(textFieldID);
                panelCampos.add(new JLabel()); // Espacio en blanco
                panelCampos.add(btnCorroborar);

                JLabel labelMarca = new JLabel("Marca:");
                JTextField textFieldMarca = new JTextField();
                textFieldMarca.setEnabled(false); // Inicialmente deshabilitado
                panelCampos.add(labelMarca);
                panelCampos.add(textFieldMarca);

                JLabel labelModelo = new JLabel("Modelo:");
                JTextField textFieldModelo = new JTextField();
                textFieldModelo.setEnabled(false); // Inicialmente deshabilitado
                panelCampos.add(labelModelo);
                panelCampos.add(textFieldModelo);

                JLabel labelColor = new JLabel("Color:");
                JTextField textFieldColor = new JTextField();
                textFieldColor.setEnabled(false); // Inicialmente deshabilitado
                panelCampos.add(labelColor);
                panelCampos.add(textFieldColor);

                JLabel labelAnio = new JLabel("Año:");
                JTextField textFieldAnio = new JTextField();
                textFieldAnio.setEnabled(false); // Inicialmente deshabilitado
                panelCampos.add(labelAnio);
                panelCampos.add(textFieldAnio);

                JLabel labelPrecio = new JLabel("Precio:");
                JTextField textFieldPrecio = new JTextField();
                textFieldPrecio.setEnabled(false); // Inicialmente deshabilitado
                panelCampos.add(labelPrecio);
                panelCampos.add(textFieldPrecio);

                JLabel labelStock = new JLabel("Stock:");
                JTextField textFieldStock = new JTextField();
                textFieldStock.setEnabled(false); // Inicialmente deshabilitado
                panelCampos.add(labelStock);
                panelCampos.add(textFieldStock);

                // Botón para confirmar la modificación
                JButton btnConfirmar = new JButton("Modificar");
                btnConfirmar.setPreferredSize(new Dimension(120, 24));
                btnConfirmar.setEnabled(false); // Inicialmente deshabilitado

                // Acción del botón "Corroborar"
                btnCorroborar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(textFieldID.getText());

                            // Obtener el vehículo por ID
                            Vehiculo vehiculo = concesionariaServicio.obtenerVehiculoPorID(id);

                            // Mostrar los campos para modificación con los datos actuales del vehículo
                            textFieldMarca.setText(vehiculo.getMarca());
                            textFieldModelo.setText(vehiculo.getModelo());
                            textFieldColor.setText(vehiculo.getColor());
                            textFieldAnio.setText(String.valueOf(vehiculo.getAnio()));
                            textFieldPrecio.setText(String.valueOf(vehiculo.getPrecio()));
                            textFieldStock.setText(String.valueOf(vehiculo.getStock()));

                            // Habilitar los campos para modificación
                            textFieldMarca.setEnabled(true);
                            textFieldModelo.setEnabled(true);
                            textFieldColor.setEnabled(true);
                            textFieldAnio.setEnabled(true);
                            textFieldPrecio.setEnabled(true);
                            textFieldStock.setEnabled(true);
                            btnConfirmar.setEnabled(true);

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(dialog, "Ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (VehiculoException ex) {
                            JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // Acción del botón "Confirmar"
                btnConfirmar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id        = Integer.parseInt(textFieldID.getText());
                            String marca  = textFieldMarca.getText();
                            String modelo = textFieldModelo.getText();
                            String color  = textFieldColor.getText();
                            int anio      = Integer.parseInt(textFieldAnio.getText());
                            double precio = Double.parseDouble(textFieldPrecio.getText());
                            int stock     = Integer.parseInt(textFieldStock.getText());

                            // Actualizar el vehículo
                            Vehiculo vehiculo = concesionariaServicio.obtenerVehiculoPorID(id);
                            vehiculo.setMarca(marca);
                            vehiculo.setModelo(modelo);
                            vehiculo.setColor(color);
                            vehiculo.setAnio(anio);
                            vehiculo.setPrecio(precio);
                            vehiculo.setStock(stock);

                            // Guardar cambios en el JSON
                            concesionariaServicio.actualizarVehiculo(id, vehiculo);

                            // Mostrar mensaje de éxito
                            JOptionPane.showMessageDialog(dialog, "Vehículo actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                            // Cerrar el diálogo después de modificar
                            dialog.dispose();

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(dialog, "Ingrese valores numéricos válidos para año, precio y stock.", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (VehiculoException ex) {
                            JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // Panel para el botón de confirmar
                JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                panelBoton.add(btnConfirmar);

                // Agregar componentes al panel principal
                panelPrincipal.add(panelCampos, BorderLayout.CENTER);
                panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

                // Agregar panel principal al diálogo
                dialog.add(panelPrincipal);

                // Mostrar el diálogo de modificación
                dialog.setVisible(true);
            }
        });

        // Lógica para eliminar un vehículo por ID
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
                        } finally {
                            // Limpiar el campo de texto en cualquier caso
                            textFieldId.setText("");
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
                    vehiculo.getPrecio(),
                    vehiculo.getStock(),
                    vehiculo.getTipo()
            };

            model.addRow(row);
        }
    }
}