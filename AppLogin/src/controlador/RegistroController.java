/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmRegistro;
import vista.FrmLogin;
import javax.swing.JOptionPane;


/**
 *
 * @author Jonathan Alexis Sanchez Rodriguez
 */
public class RegistroController {

    private UsuarioDAO dao = new UsuarioDAO();

    public void procesarRegistro(String nombre, String apellido, String email, 
            String usuario, String contrasena, String confirmar, 
            byte[] foto, FrmRegistro vista) {

       
        if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty()
                || contrasena.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

       
        if (!contrasena.equals(confirmar)) {
            JOptionPane.showMessageDialog(vista, "Las contraseñas no coinciden.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

       
        if (contrasena.length() < 6) {
            JOptionPane.showMessageDialog(vista, "La contraseña debe tener al menos 6 caracteres.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        
        if (dao.usuarioExiste(usuario)) {
            JOptionPane.showMessageDialog(vista, "El nombre de usuario ya está en uso.",
                    "Usuario duplicado", JOptionPane.WARNING_MESSAGE);
            return;
        }

       
        Usuario u = new Usuario(nombre, apellido, email, usuario, contrasena, foto);

        boolean ok = dao.insertar(u);

        if (ok) {
            JOptionPane.showMessageDialog(vista,
                    "Usuario registrado correctamente. Ahora puedes iniciar sesión.",
                    "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            new FrmLogin().setVisible(true);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al guardar en la base de datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}