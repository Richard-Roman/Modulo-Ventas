import javax.swing.*;
import java.awt.*;

public class CategoriasPanel extends JPanel {

    public CategoriasPanel() {
        setLayout(new BorderLayout());

        // Crear el panel superior para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Categorías"));

        // Agregar campos al panel de entrada
        inputPanel.add(new JLabel("Código de Categoría"));
        JTextField codeField = new JTextField();
        inputPanel.add(codeField);

        inputPanel.add(new JLabel("Descripción"));
        JTextField descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        add(inputPanel, BorderLayout.NORTH);

        // Crear el panel central para la tabla
        String[] columnNames = {"Código de Categoría", "Descripción"};
        Object[][] data = new Object[5][2]; // 5 filas, 2 columnas
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir espacio alrededor

        JButton addButton = new JButton("Agregar");
        JButton updateButton = new JButton("Actualizar");
        JButton deleteButton = new JButton("Eliminar");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Categorías");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new CategoriasPanel());
        frame.setVisible(true);
    }
}
