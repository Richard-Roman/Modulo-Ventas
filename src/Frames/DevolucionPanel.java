import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevolucionPanel extends JPanel {

    public DevolucionPanel() {
        setLayout(new BorderLayout());

        // Crear el panel superior para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Devolución de Producto"));

        // Agregar campos al panel de entrada
        inputPanel.add(new JLabel("Código de Venta:"));
        JTextField codigoVentaField = new JTextField();
        inputPanel.add(codigoVentaField);

        inputPanel.add(new JLabel("Código de Producto:"));
        JTextField codigoProductoField = new JTextField();
        inputPanel.add(codigoProductoField);

        inputPanel.add(new JLabel("Cantidad a Devolver:"));
        JTextField cantidadField = new JTextField();
        inputPanel.add(cantidadField);

        inputPanel.add(new JLabel("Razón de Devolución:"));
        JTextField razonField = new JTextField();
        inputPanel.add(razonField);

        // Botón de Procesar Devolución
        JButton procesarButton = new JButton("Procesar Devolución");
        procesarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se procesa la devolución
                String codigoVenta = codigoVentaField.getText();
                String codigoProducto = codigoProductoField.getText();
                int cantidad = Integer.parseInt(cantidadField.getText());
                String razon = razonField.getText();

                procesarDevolucion(codigoVenta, codigoProducto, cantidad, razon);
            }
        });

        add(inputPanel, BorderLayout.CENTER);
        add(procesarButton, BorderLayout.SOUTH);
    }

    // Método para procesar la devolución
    private void procesarDevolucion(String codigoVenta, String codigoProducto, int cantidad, String razon) {
        // Lógica para registrar la devolución y emitir una nota de crédito
        // Esto puede incluir actualizar la base de datos, generar un documento PDF, etc.
        // Por ahora, sólo mostramos un mensaje
        JOptionPane.showMessageDialog(this, "Devolución procesada:\n" +
                "Código de Venta: " + codigoVenta + "\n" +
                "Código de Producto: " + codigoProducto + "\n" +
                "Cantidad: " + cantidad + "\n" +
                "Razón: " + razon);

        // Aquí iría el código para registrar la devolución en la base de datos y emitir la nota de crédito
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Devolución de Producto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new DevolucionPanel());
        frame.setVisible(true);
    }
}
