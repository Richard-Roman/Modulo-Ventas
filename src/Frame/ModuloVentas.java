package Frame;

import javax.swing.*;
import java.awt.*;

public class ModuloVentas extends JFrame {
    
    public ModuloVentas() {
        // Configuración de la ventana
        setTitle("Modulo de ventas - Maestros");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        
        // Crear el panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);
        add(mainPanel);
        
        // Crear el panel izquierdo con botones
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.DARK_GRAY);
        
        String[] buttonNames = {"Productos", "Clientes", "Tipo de documentos", "Metodos de pago", "Imprimir"};
        for (String name : buttonNames) {
            JButton button = new JButton(name);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            leftPanel.add(button);
            leftPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botones
        }
        
        mainPanel.add(leftPanel, BorderLayout.WEST);
        
        // Crear la barra de menús
        JMenuBar menuBar = new JMenuBar();
        
        JMenu maestrosMenu = new JMenu("Gestion");
        JMenu transaccionesMenu = new JMenu("Ventas");
        JMenu consultasMenu = new JMenu("Consultas");
        JMenu reportesMenu = new JMenu("Reportes");
        
        menuBar.add(maestrosMenu);
        menuBar.add(transaccionesMenu);
        menuBar.add(consultasMenu);
        menuBar.add(reportesMenu);
        
        setJMenuBar(menuBar);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModuloVentas ventana = new ModuloVentas();
            ventana.setVisible(true);
        });
    }
}
