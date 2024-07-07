package Panels;
import javax.swing.*;
import java.awt.*;

public class ReporteClientesPanel extends JPanel {
    public ReporteClientesPanel() {
        setLayout(new BorderLayout());
        
        // Panel superior con filtros
        JPanel filtrosPanel = new JPanel();
        filtrosPanel.setLayout(new GridLayout(2, 3, 5, 5));
        
        JCheckBox fechasCheckBox = new JCheckBox("Fechas");
        filtrosPanel.add(fechasCheckBox);
        filtrosPanel.add(new JLabel("Fecha Inicio"));
        filtrosPanel.add(new JLabel("Fecha Fin"));
        
        filtrosPanel.add(new JLabel());
        filtrosPanel.add(new JTextField());
        filtrosPanel.add(new JTextField());
        
        JCheckBox clienteCheckBox = new JCheckBox("Clientes");
        filtrosPanel.add(clienteCheckBox);
        filtrosPanel.add(new JLabel("Clientes"));
        filtrosPanel.add(new JLabel());
        
        filtrosPanel.add(new JLabel());
        filtrosPanel.add(new JTextField());
        filtrosPanel.add(new JLabel());
        
        add(filtrosPanel, BorderLayout.NORTH);
        
        // Panel central con la tabla
        JPanel tablaPanel = new JPanel();
        tablaPanel.setLayout(new GridLayout(1, 1, 5, 5));
        
        String[] columnasRegistro = {"DNI/RUC", "Nombre/Razon Social", "Teléfono", "Compras"};
        Object[][] datosRegistro = {};  // Datos vacíos por ahora
        JTable registroTabla = new JTable(datosRegistro, columnasRegistro);
        
        tablaPanel.add(new JScrollPane(registroTabla));
        
        add(tablaPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reporte clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new ReporteClientesPanel());
        frame.setVisible(true);
    }
}
