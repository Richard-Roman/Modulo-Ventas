package Panels;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;

public class VendedoresPanel extends JPanel {
   private JPanel cetroPanel, mainContendPanel, contedPanel;
   private JTable tablaVendedores;
   private JTextField idField, nameField, phoneField;
   private String[][] data;

   public VendedoresPanel() {
      init();
      addComponentes();
   }

   private void init() {
      setLayout(new BorderLayout());
      addComponentListener(new reziseMoveListener());
   }

   private void addComponentes() {
      mainContendPanel = new JPanel(new BorderLayout());
      addCampos();
      addTabla();
      add(mainContendPanel, BorderLayout.CENTER);
      addCrudMenu();
   }

   private void addCampos() {
        // Crear el panel superior para los campos de entrada
      contedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
      contedPanel.setPreferredSize(new Dimension(800, 135));
        
        // Panel para número de identificación (DNI)
      JPanel numeroDniPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
      numeroDniPanel.setPreferredSize(new Dimension(390, 24));
      JLabel numeroDniLabel = new JLabel("Número de DNI:");
      numeroDniLabel.setPreferredSize(new Dimension(150, 24));
      numeroDniPanel.add(numeroDniLabel);
      idField = new JTextField();
      idField.setPreferredSize(new Dimension(150, 24));
      numeroDniPanel.add(idField);
      contedPanel.add(numeroDniPanel);
        
        // Panel para nombres completos
      JPanel nombresPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
      nombresPanel.setPreferredSize(new Dimension(390, 24));
      JLabel nombresLabel = new JLabel("Nombres completos:");
      nombresLabel.setPreferredSize(new Dimension(150, 24));
      nombresPanel.add(nombresLabel);
      nameField = new JTextField();
      nameField.setPreferredSize(new Dimension(150, 24));
      nombresPanel.add(nameField);
      contedPanel.add(nombresPanel);
        
        // Panel para teléfono
      JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
      telefonoPanel.setPreferredSize(new Dimension(390, 24));
      JLabel telefonoLabel = new JLabel("Teléfono:");
      telefonoLabel.setPreferredSize(new Dimension(150, 24));
      telefonoPanel.add(telefonoLabel);
      phoneField = new JTextField();
      phoneField.setPreferredSize(new Dimension(150, 24));
      telefonoPanel.add(phoneField);
      contedPanel.add(telefonoPanel);
        
      contedPanel.setBorder(BorderFactory.createTitledBorder("Vendedores"));
      contedPanel.setBackground(Color.white);
      mainContendPanel.add(contedPanel, BorderLayout.NORTH);
   }

   private void addTabla() {
        // Crear el panel central para la tabla
      String[] columnNames = {"Número de DNI", "Nombres completos", "Teléfono"};
      data = new String[5][3]; // 5 filas, 3 columnas
      tablaVendedores = new JTable(data, columnNames);
        
      data[0][0] = "76153157";
      data[0][1] = "Richard adan Roman Tocto";
      data[0][2] = "926557569";
        
      TableColumnModel columnModel = tablaVendedores.getColumnModel();
        
        // Ajustar el ancho de las columnas
      columnModel.getColumn(0).setPreferredWidth(180);
      columnModel.getColumn(1).setPreferredWidth(350);
      columnModel.getColumn(2).setPreferredWidth(130);
        
        // Ajustar ancho mínimo y máximo
      columnModel.getColumn(0).setMinWidth(150);
      columnModel.getColumn(1).setMinWidth(300);
      columnModel.getColumn(2).setMinWidth(130);
        
      JScrollPane scrollPane = new JScrollPane(tablaVendedores);
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
      mainContendPanel.add(scrollPane, BorderLayout.CENTER);
   }

   private void addCrudMenu() {
      JPanel crudPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel crudBotons = new JPanel(new GridLayout(5, 1, 15, 5));
      JButton bBuscar, bRegistrar, bEliminar, bModificar, bLimpiar;
      bBuscar = new JButton("Buscar");
      bRegistrar = new JButton("Registrar");
      bEliminar = new JButton("Eliminar");
      bModificar = new JButton("Modificar");
      bLimpiar = new JButton("Limpiar");
        
      crudBotons.add(bBuscar);
      crudBotons.add(bRegistrar);
      crudBotons.add(bEliminar);
      crudBotons.add(bModificar);
      crudBotons.add(bLimpiar);
        
      crudPanel.add(crudBotons);
      add(crudPanel, BorderLayout.EAST);
   }

   public void reSizeMinMode(){
      Dimension d = getSize();
      System.out.println("Hola   " + d);
      if(d.getWidth()<=760){
         tablaVendedores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      } else {
         tablaVendedores.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
      }
      if(d.getWidth()<=946){
         contedPanel.setPreferredSize(new Dimension(800,135));
         mainContendPanel.repaint();
         mainContendPanel.revalidate();
      } else {
         contedPanel.setPreferredSize(new Dimension(800,100));
         mainContendPanel.repaint();
         mainContendPanel.revalidate();
      }
   }
   
   class reziseMoveListener extends ComponentAdapter{
   
      public void componentResized(ComponentEvent e) {
         reSizeMinMode();
         System.out.println("El panel ha cambiado de tamaño a: " + getSize());
      }
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("Vendedores");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 400);
      frame.add(new VendedoresPanel());
      frame.setVisible(true);
   }
}

