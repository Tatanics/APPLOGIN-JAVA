/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmLogin;
import vista.FrmBienvenida;
import javax.swing.JOptionPane;
/**
 *
 * @author Jonathan Alexis Sanchez Rodriguez
 */
public class LoginController {

    private UsuarioDAO dac = new UsuarioDAO();

    /**
     * Valida las credenciales y redirige al formulario correcto.
     * @param usuario nombre de usuario ingresado
     * @param contrasena contraseña ingresada
     * @param vista referencia al FrmLogin para cerrarla si el login es exitoso
     */
    public void procesarLogin(String usuario, String contrasena, FrmLogin vista) {

       
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                "Por favor ingresa usuario y contraseña.",
                "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

      
        Usuario u = dac.login(usuario, contrasena);

 
        if (u != null) {
            // Login exitoso: abrir bienvenida y cerrar login
            new FrmBienvenida(u).setVisible(true);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista,
                "Usuario o contraseña incorrectos.",
                "Error de acceso", JOptionPane.ERROR_MESSAGE);
        }
    }
}