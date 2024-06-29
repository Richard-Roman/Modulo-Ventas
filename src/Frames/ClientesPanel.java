import javax.swing.*;
import java.awt.*;

public class ClientesPanel extends JPanel {

    public ClientesPanel() {
        setLayout(new BorderLayout());

        // Crear el panel superior para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Clientes"));

        // Agregar campos al panel de entrada
        inputPanel.add(new JLabel("Tipo de identificación"));
        JPanel idPanel = new JPanel();
        JCheckBox dniCheckBox = new JCheckBox("DNI");
        JCheckBox rucCheckBox = new JCheckBox("RUC");
        idPanel.add(dniCheckBox);
        idPanel.add(rucCheckBox);
        inputPanel.add(idPanel);

        inputPanel.add(new JLabel("Número de identificación"));
        JTextField idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Nombre / Razón social"));
        JTextField nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Teléfono"));
        JTextField phoneField = new JTextField();
        inputPanel.add(phoneField);

        add(inputPanel, BorderLayout.NORTH);

        // Crear el panel central para la tabla
        String[] columnNames = {"Tipo de identificación", "Número de identificación", "Nombre/Razón Social", "Teléfono"};
        Object[][] data = new Object[5][4]; // 5 filas, 4 columnas
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new ClientesPanel());
        frame.setVisible(true);
    }
}
