import javax.swing.*;
import java.awt.*;

public class VentasPanel extends JPanel {

    public VentasPanel() {
        setLayout(new BorderLayout());

        // Crear el panel superior para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Ventas"));

        // Agregar campos al panel de entrada
        inputPanel.add(new JLabel("Codigo de venta"));
        JTextField codigoVentaField = new JTextField();
        inputPanel.add(codigoVentaField);

        inputPanel.add(new JLabel("Vendedor"));
        JComboBox<String> vendedorComboBox = new JComboBox<>(new String[]{"Vendedor1", "Vendedor2"});
        inputPanel.add(vendedorComboBox);

        inputPanel.add(new JLabel("Tipo de documento"));
        JComboBox<String> tipoDocumentoComboBox = new JComboBox<>(new String[]{"Factura", "Boleta"});
        inputPanel.add(tipoDocumentoComboBox);

        inputPanel.add(new JLabel("Cliente"));
        JComboBox<String> clienteComboBox = new JComboBox<>(new String[]{"Cliente1", "Cliente2"});
        inputPanel.add(clienteComboBox);

        inputPanel.add(new JLabel("Fecha"));
        JTextField fechaField = new JTextField();
        inputPanel.add(fechaField);

        inputPanel.add(new JLabel("Medio de pago"));
        JComboBox<String> medioPagoComboBox = new JComboBox<>(new String[]{"Efectivo", "Tarjeta"});
        inputPanel.add(medioPagoComboBox);

        inputPanel.add(new JLabel("Producto"));
        JComboBox<String> productoComboBox = new JComboBox<>(new String[]{"Producto1", "Producto2"});
        inputPanel.add(productoComboBox);

        inputPanel.add(new JLabel("Cantidad"));
        JTextField cantidadField = new JTextField();
        inputPanel.add(cantidadField);

        JPanel agregarButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton agregarButton = new JButton("Agregar");
        agregarButtonPanel.add(agregarButton);
        inputPanel.add(new JLabel("")); // Espacio vacío
        inputPanel.add(new JLabel("")); // Espacio vacío
        inputPanel.add(new JLabel("")); // Espacio vacío
        inputPanel.add(agregarButtonPanel);

        add(inputPanel, BorderLayout.NORTH);

        // Crear la primera tabla
        String[] columnNames1 = {"Codigo de venta", "Vendedor", "Cliente", "Total", "Medio de pago", "Tipo de documento", "Fecha"};
        Object[][] data1 = new Object[5][7]; // 5 filas, 7 columnas
        JTable table1 = new JTable(data1, columnNames1);
        JScrollPane scrollPane1 = new JScrollPane(table1);

        // Crear la segunda tabla
        String[] columnNames2 = {"Codigo de venta", "Producto", "Cantidad", "Precio", "Total"};
        Object[][] data2 = new Object[5][5]; // 5 filas, 5 columnas
        JTable table2 = new JTable(data2, columnNames2);
        JScrollPane scrollPane2 = new JScrollPane(table2);

        // Crear un panel para las tablas
        JPanel tablePanel = new JPanel(new GridLayout(2, 1, 10, 10));
        tablePanel.add(scrollPane1);
        tablePanel.add(scrollPane2);

        add(tablePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new VentasPanel());
        frame.setVisible(true);
    }
}
