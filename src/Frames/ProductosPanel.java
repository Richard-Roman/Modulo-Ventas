import javax.swing.*;
import java.awt.*;

public class ProductosPanel extends JPanel {

    public ProductosPanel() {
        setLayout(new BorderLayout());

        // Crear el panel superior para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Productos"));

        // Agregar campos al panel de entrada
        inputPanel.add(new JLabel("Código del producto"));
        JTextField codeField = new JTextField();
        inputPanel.add(codeField);

        inputPanel.add(new JLabel("Descripción"));
        JTextField descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Precio"));
        JTextField priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Stock"));
        JTextField stockField = new JTextField();
        inputPanel.add(stockField);

        add(inputPanel, BorderLayout.NORTH);

        // Crear el panel central para la tabla
        String[] columnNames = {"Código del producto", "Descripción", "Precio", "Stock"};
        Object[][] data = new Object[5][4]; // 5 filas, 4 columnas
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new ProductosPanel());
        frame.setVisible(true);
    }
}
