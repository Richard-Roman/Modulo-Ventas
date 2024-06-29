import javax.swing.*;
import java.awt.*;

public class VendedoresPanel extends JPanel {

    public VendedoresPanel() {
        setLayout(new BorderLayout());

        // Crear el panel superior para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Vendedores"));

        // Agregar campos al panel de entrada
        inputPanel.add(new JLabel("DNI"));
        JTextField dniField = new JTextField();
        inputPanel.add(dniField);

        inputPanel.add(new JLabel("Nombre"));
        JTextField nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Teléfono"));
        JTextField phoneField = new JTextField();
        inputPanel.add(phoneField);

        add(inputPanel, BorderLayout.NORTH);

        // Crear el panel central para la tabla
        String[] columnNames = {"DNI", "Nombre", "Teléfono"};
        Object[][] data = new Object[5][3]; // 5 filas, 3 columnas
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vendedores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new VendedoresPanel());
        frame.setVisible(true);
    }
}
