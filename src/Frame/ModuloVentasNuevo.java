package Frame;

import javax.swing.*;
import java.awt.*;
import SwingComponents.*;
import java.awt.event.*;

public class ModuloVentasNuevo extends JFrame {
    
    private xButton ventas, productos, cliente, vendedor, documentosPago, MediosPago, consultas, reportes, salir;
    private ImageIcon icon;

    public ModuloVentasNuevo() {
        // Configuración de la ventana
        setTitle("Modulo de ventas - Maestros");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        
        // Inicializar icono
        icon = new ImageIcon("src/resources/icon/MainIcon.png");
        this.setIconImage(icon.getImage());
        
        // Crear el panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);
        add(mainPanel);
        
        // Crear el panel izquierdo con botones
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(new Color(255, 165, 0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 0, 0);

        ventas = new xButton("VENTAS");
        productos = new xButton("PRODUCTOS");
        cliente = new xButton("CLIENTES");
        vendedor = new xButton("PERSONAL");
        documentosPago = new xButton("DOCUMENTOS DE PAGO");
        MediosPago = new xButton("MEDIOS DE PAGO");
        consultas = new xButton("CONSULTAS");
        reportes = new xButton("REPORTES");
        salir = new xButton("SALIR");

        leftPanel.add(ventas, gbc);
        leftPanel.add(cliente, gbc);
        leftPanel.add(productos, gbc);
        leftPanel.add(vendedor, gbc);
        leftPanel.add(documentosPago, gbc);
        leftPanel.add(MediosPago, gbc);
        leftPanel.add(consultas, gbc);
        leftPanel.add(reportes, gbc);
        leftPanel.add(new JLabel(), gbc); // Separador
        leftPanel.add(salir, gbc);
        gbc.weighty = 1.0;
        leftPanel.add(Box.createVerticalGlue(), gbc);

        add(leftPanel, BorderLayout.WEST);
        
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
            ModuloVentasNuevo ventana = new ModuloVentasNuevo();
            ventana.setVisible(true);
        });
    }
}