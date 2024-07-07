package Panels;
import javax.swing.*;
import java.awt.*;

public class ReporteVentasPanel extends JPanel {
    public ReporteVentasPanel() {
        setLayout(new BorderLayout());
        
        // Panel superior con filtros
        JPanel filtrosPanel = new JPanel();
        filtrosPanel.setLayout(new GridLayout(4, 3, 5, 5));
        
        JCheckBox fechasCheckBox = new JCheckBox("Fechas");
        filtrosPanel.add(fechasCheckBox);
        filtrosPanel.add(new JLabel("Fecha Inicio"));
        filtrosPanel.add(new JLabel("Fecha Fin"));
        
        filtrosPanel.add(new JLabel());
        filtrosPanel.add(new JTextField());
        filtrosPanel.add(new JTextField());
        
        JCheckBox clienteCheckBox = new JCheckBox("Cliente");
        filtrosPanel.add(clienteCheckBox);
        filtrosPanel.add(new JLabel("Cliente"));
        filtrosPanel.add(new JLabel());
        
        filtrosPanel.add(new JLabel());
        filtrosPanel.add(new JTextField());
        filtrosPanel.add(new JLabel());
        
        JCheckBox vendedorCheckBox = new JCheckBox("Vendedor");
        filtrosPanel.add(vendedorCheckBox);
        filtrosPanel.add(new JLabel("Vendedor"));
        filtrosPanel.add(new JLabel());
        
        filtrosPanel.add(new JLabel());
        filtrosPanel.add(new JTextField());
        filtrosPanel.add(new JLabel());
        
        JCheckBox productoCheckBox = new JCheckBox("Producto");
        filtrosPanel.add(productoCheckBox);
        filtrosPanel.add(new JLabel("Producto"));
        filtrosPanel.add(new JLabel());
        
        filtrosPanel.add(new JLabel());
        filtrosPanel.add(new JTextField());
        filtrosPanel.add(new JLabel());
        
        add(filtrosPanel, BorderLayout.NORTH);
        
        // Panel central con las tablas
        JPanel tablasPanel = new JPanel();
        tablasPanel.setLayout(new GridLayout(2, 1, 5, 5));
        
        String[] columnasRegistro = {"Codigo de venta", "Vendedor", "Cliente", "Total", "Medio de pago", "Tipo de documento", "Fecha"};
        Object[][] datosRegistro = {};  // Datos vacíos por ahora
        JTable registroTabla = new JTable(datosRegistro, columnasRegistro);
        
        String[] columnasDetalle = {"Codigo de venta", "Producto", "Cantidad", "Precio", "Total"};
        Object[][] datosDetalle = {};  // Datos vacíos por ahora
        JTable detalleTabla = new JTable(datosDetalle, columnasDetalle);
        
        tablasPanel.add(new JScrollPane(registroTabla));
        tablasPanel.add(new JScrollPane(detalleTabla));
        
        add(tablasPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reporte ventas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new ReporteVentasPanel());
        frame.setVisible(true);
    }
}
