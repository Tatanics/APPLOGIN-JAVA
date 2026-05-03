/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package applogin;
import vista.FrmLogin;
import javax.swing.SwingUtilities;


/**
 *
 * @author Jonathan Alexis Sanchez Rodriguez
 */
public class AppLogin {

    public static void main(String[] args) {
        // Ejecutar en el hilo de la interfaz gráfica (EDT)
        SwingUtilities.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }
    
}
