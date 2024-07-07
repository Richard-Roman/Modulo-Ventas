package Panels;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;

public class ProductosPanel extends JPanel {
   private JPanel mainContendPanel, contedPanel;
   private JTextField codigoProductoCampo, descripcionCampo, precioCampo,stockCampo;
   private JButton bBuscar, bRegistrar, bEliminar, bModificar, bLimpiar;
   private JTable tablaProductos;
   public ProductosPanel() {
      init();
      addComponentes();
   }
   private void init(){
      setLayout(new BorderLayout());
      addComponentListener(new reziseMoveListener()); 
   }
   
   private void addComponentes(){
      mainContendPanel = new JPanel(new BorderLayout());
      addCampos();   
      addTabla();
      add(mainContendPanel, BorderLayout.CENTER);
      addCrudMenu();
   }
   
   private void addCampos(){
      // Crear el panel superior para los campos de entrada
      //JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
      contedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
      contedPanel.setPreferredSize(new Dimension(800,170));
      
      JPanel productoIdPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      productoIdPanel.setPreferredSize(new Dimension(390,24));
      JLabel productoIdtxt = new JLabel("Código del producto:");
      productoIdtxt.setPreferredSize(new Dimension(150,24));
      productoIdPanel.add(productoIdtxt);
      codigoProductoCampo = new JTextField();
      codigoProductoCampo.setPreferredSize(new Dimension(150,24));
      productoIdPanel.add(codigoProductoCampo);
      contedPanel.add(productoIdPanel);
      
      JPanel descripcionPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      descripcionPanel.setPreferredSize(new Dimension(390,24));
      JLabel descripciontxt = new JLabel("Descripción:");
      descripciontxt.setPreferredSize(new Dimension(150,24));
      descripcionPanel.add(descripciontxt);
      descripcionCampo = new JTextField();
      descripcionCampo.setPreferredSize(new Dimension(150,24));
      descripcionPanel.add(descripcionCampo);
      contedPanel.add(descripcionPanel);
   
      
      JPanel precioPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      precioPanel.setPreferredSize(new Dimension(390,24));
      JLabel preciotxt = new JLabel("Precio:");
      preciotxt.setPreferredSize(new Dimension(150,24));
      precioPanel.add(preciotxt);
      precioCampo = new JTextField();
      precioCampo.setPreferredSize(new Dimension(150,24));
      precioPanel.add(precioCampo);
      contedPanel.add(precioPanel);
      
      JPanel stockPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      stockPanel.setPreferredSize(new Dimension(390,24));
      JLabel stocktxt = new JLabel("Stock");
      stocktxt.setPreferredSize(new Dimension(150,24));
      stockPanel.add(stocktxt);
      stockCampo = new JTextField();
      stockCampo.setPreferredSize(new Dimension(150,24));
      stockPanel.add(stockCampo);
      contedPanel.add(stockPanel);
      
      contedPanel.setBorder(BorderFactory.createTitledBorder("Productos"));
      contedPanel.setBackground(Color.white);
      mainContendPanel.add(contedPanel, BorderLayout.NORTH);
   }
   
   private void addTabla(){
      // Crear el panel central para la tabla
      String[] columnNames = {"Código del producto", "Descripción", "Precio", "Stock"};
      Object[][] data = new Object[5][4]; // 5 filas, 4 columnas
      tablaProductos = new JTable(data, columnNames);
      
      TableColumnModel columnModel = tablaProductos.getColumnModel();
   
        // Ajustar el ancho de las columnas
      columnModel.getColumn(0).setPreferredWidth(160);
      columnModel.getColumn(1).setPreferredWidth(350);
      columnModel.getColumn(2).setPreferredWidth(80);
      columnModel.getColumn(3).setPreferredWidth(80);
        // Ajustar ancho mínimo y máximo
      columnModel.getColumn(0).setMinWidth(130);
      columnModel.getColumn(1).setMinWidth(250);
      columnModel.getColumn(2).setMinWidth(60);
      columnModel.getColumn(3).setMinWidth(60);
      
      columnModel.getColumn(0).setMaxWidth(130);
      columnModel.getColumn(2).setMaxWidth(120);
      columnModel.getColumn(3).setMaxWidth(120);
      
      JScrollPane scrollPane = new JScrollPane(tablaProductos);
   
      mainContendPanel.add(scrollPane, BorderLayout.CENTER);
   }
   
   private void addCrudMenu(){
      JPanel crudPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel crudBotons = new JPanel(new GridLayout(5, 1, 15, 5));
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
      if(d.getWidth()<=740){
         tablaProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      } else {
         tablaProductos.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
      }
      if(d.getWidth()<=946){
         contedPanel.setPreferredSize(new Dimension(800,170));
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
      JFrame frame = new JFrame("Productos");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 400);
      frame.add(new ProductosPanel());
      frame.setVisible(true);
   }
}
