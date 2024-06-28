package Gui;

import Modelo.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AccesoFrame extends JFrame {
    private static final String JSON_FILE_USUARIOS  = "Backend/Archivos/usuarios.json";
    public AccesoFrame() {
        // ----------------- CABECERA DEL LOGIN
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon iconoApp = new ImageIcon("Backend/Recursos/Imagenes/iconoApp.png");
        setIconImage(iconoApp.getImage());
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        // ----------------- INPUTS PARA INGRESAR
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(30, 30, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(110, 30, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(30, 70, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(110, 70, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(110, 110, 160, 25);
        panel.add(loginButton);


        // ----------------- EVENTOS DE INICIO DE SESIÓN
        // Manejar el evento del botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion(userText, passwordText);
            }
        });

        // "Enter" en el campo de texto del usuario
        userText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion(userText, passwordText);
            }
        });

        // "Enter" en el campo de texto de la contraseña
        passwordText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion(userText, passwordText);
            }
        });

        setVisible(true);
    }
    private void iniciarSesion(JTextField userText, JPasswordField passwordText) {
        String usuario      = userText.getText();
        String contrasena   = new String(passwordText.getPassword());
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Cargar el archivo JSON
            Usuario[] usuarios = mapper.readValue(new File(JSON_FILE_USUARIOS), Usuario[].class);
            boolean credencialesValidas = false;

            // Verificar las credenciales ingresadas contra las del archivo JSON
            for (Usuario user : usuarios) {
                if (usuario.equals(user.getUsuario()) && contrasena.equals(user.getContrasena())) {
                    credencialesValidas = true;
                    break;
                }
            }

            // Si las credenciales son correctas, abrir Panel Administrador y cerrar Login
            if (credencialesValidas) {
                new PanelAdministradorFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Inténtalo de nuevo.");
                userText.setText("");
                passwordText.setText("");
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
