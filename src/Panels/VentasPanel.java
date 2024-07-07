package Panels;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import SwingComponents.*;

public class VentasPanel extends JPanel {
   private JPanel mainContendPanel;
   private JButton bBuscar, bRegistrar, bEliminar, bModificar, bLimpiar;
   private JTextField cantidadCampo;
   private JComboBox<String> vendedorComboBox, documentoPagoComboBox, 
      clienteComboBox, medioPagoComboBox, productoComboBox;
  private xCampo codigoVentaCampo;
   public VentasPanel() {
      init();
      addComponentes();
   }
    
   private void init(){
      setLayout(new BorderLayout());
      //setBackground(Color.white);
      //setOpaque(false);
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
      JPanel contedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
      contedPanel.setPreferredSize(new Dimension(800,200));
      //JPanel inputPanel = new JPanel(new GridLayout(4, 4, 10, 10));
      contedPanel.setBorder(BorderFactory.createTitledBorder("Ventas"));
      contedPanel.setBackground(Color.white);
      contedPanel.setOpaque(true);
        // Agregar campos al panel de entrada
      xCampo codigoVentaCampo = new xCampo("Codigo de venta:");
      codigoVentaCampo.setAllSize(new Dimension(340,24));
      contedPanel.add(codigoVentaCampo);
      /*JPanel ventaIdPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      ventaIdPanel.setPreferredSize(new Dimension(340,24));
      JLabel ventaIdtxt = new JLabel("Codigo de venta:");
      ventaIdtxt.setPreferredSize(new Dimension(150,24));
      ventaIdPanel.add(ventaIdtxt);
      JTextField codigoVentaField = new JTextField();
      codigoVentaField.setPreferredSize(new Dimension(150,24));
      ventaIdPanel.add(codigoVentaField);
      contedPanel.add(ventaIdPanel);*/
   
      xComboBox vendedorCombo = new xComboBox("Vendedor:", new String[]{"Vendedor1", "Vendedor2"});
      vendedorCombo.setAllSize(new Dimension(340,24));
      /*JPanel vendedorPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      vendedorPanel.setPreferredSize(new Dimension(340,24));
      JLabel vendedortxt = new JLabel("Vendedor:");
      vendedortxt.setPreferredSize(new Dimension(150,24));
      vendedorPanel.add(vendedortxt);
      vendedorComboBox = new JComboBox<>(new String[]{"Vendedor1", "Vendedor2"});
      vendedorComboBox.setPreferredSize(new Dimension(150,24));
      vendedorPanel.add(vendedorComboBox);*/
      contedPanel.add(vendedorCombo);
      
      xComboBox documentoPagoCombo = new xComboBox("Tipo de documento:", new String[]{"Factura", "Boleta"});
      documentoPagoCombo.setAllSize(new Dimension(340,24));
      /*vendedorCombo.setAllSize(new Dimension(340,24));
      JPanel documentoPagoPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      documentoPagoPanel.setPreferredSize(new Dimension(340,24));
      JLabel documentoPagotxt = new JLabel("Tipo de documento:");
      documentoPagotxt.setPreferredSize(new Dimension(150,24));
      documentoPagoPanel.add(documentoPagotxt);
      documentoPagoComboBox = new JComboBox<>(new String[]{"Factura", "Boleta"});
      documentoPagoComboBox.setPreferredSize(new Dimension(150,24));
      documentoPagoPanel.add(documentoPagoComboBox);*/
      contedPanel.add(documentoPagoCombo);
      
      xComboBox ClienteCombo = new xComboBox("Cliente:", new String[]{"Cliente1", "Cliente2"});
      ClienteCombo.setAllSize(new Dimension(340,24));
      /*JPanel clientePanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      clientePanel.setPreferredSize(new Dimension(340,24));
      JLabel clientetxt = new JLabel("Cliente:");
      clientetxt.setPreferredSize(new Dimension(150,24));
      clientePanel.add(clientetxt);
      clienteComboBox = new JComboBox<>(new String[]{"Cliente1", "Cliente2"});
      clienteComboBox.setPreferredSize(new Dimension(150,24));
      clientePanel.add(clienteComboBox);*/
      contedPanel.add(ClienteCombo);
      
      JPanel fechaPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      fechaPanel.setPreferredSize(new Dimension(340,24));
      JLabel fechatxt = new JLabel("Fecha:");
      fechatxt.setPreferredSize(new Dimension(150,24));
      fechaPanel.add(fechatxt);
      JTextField fechaCampo = new JTextField();
      fechaCampo.setPreferredSize(new Dimension(150,24));
      fechaPanel.add(fechaCampo);
      contedPanel.add(fechaPanel);
      
      xComboBox medioPagoCombo = new xComboBox("Cliente:", new String[]{"Cliente1", "Cliente2"});
      medioPagoCombo.setAllSize(new Dimension(340,24));
      /*JPanel medioPagoPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      medioPagoPanel.setPreferredSize(new Dimension(340,24));
      JLabel medioPagotxt = new JLabel("Medio de pago:");
      medioPagotxt.setPreferredSize(new Dimension(150,24));
      medioPagoPanel.add(medioPagotxt);
      medioPagoComboBox = new JComboBox<>(new String[]{"Efectivo", "Tarjeta"});
      medioPagoComboBox.setPreferredSize(new Dimension(150,24));
      medioPagoPanel.add(medioPagoComboBox);*/
      contedPanel.add(medioPagoCombo);
      
      xComboBox productoCombo = new xComboBox("Cliente:", new String[]{"Cliente1", "Cliente2"});
      productoCombo.setAllSize(new Dimension(340,24));
      /*JPanel productoPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      productoPanel.setPreferredSize(new Dimension(340,24));
      JLabel productotxt = new JLabel("Producto:");
      productotxt.setPreferredSize(new Dimension(150,24));
      productoPanel.add(productotxt);
      productoComboBox = new JComboBox<>(new String[]{"Producto1", "Producto2"});
      productoComboBox.setPreferredSize(new Dimension(150,24));
      productoPanel.add(productoComboBox);*/
      contedPanel.add(productoCombo);
      
      xCampo cantidadCampo = new xCampo("Cantidad:");
      cantidadCampo.setAllSize(new Dimension(340,24));
      contedPanel.add(cantidadCampo);
      /*JPanel cantidadPanel =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      cantidadPanel.setPreferredSize(new Dimension(340,24));
      JLabel cantidadtxt = new JLabel("Cantidad:");
      cantidadtxt.setPreferredSize(new Dimension(150,24));
      cantidadPanel.add(cantidadtxt);
      cantidadCampo = new JTextField();
      cantidadCampo.setPreferredSize(new Dimension(150,24));
      cantidadPanel.add(cantidadCampo);
      contedPanel.add(cantidadPanel);*/
      
      mainContendPanel.add(contedPanel, BorderLayout.NORTH);
   }
   
   private void  addTabla(){
       // Crear la primera tabla
      String[] columnNames1 = {"Codigo de venta", "Vendedor", "Cliente", "Total", "Medio de pago", "Tipo de documento", "Fecha"};
      Object[][] data1 = new Object[5][7]; // 5 filas, 7 columnas
      JTable VentasTabla = new JTable(data1, columnNames1);
      TableColumnModel columnModelVentas = VentasTabla.getColumnModel();
      
        // Ajustar el ancho de las columnas
      columnModelVentas.getColumn(0).setPreferredWidth(160);
      columnModelVentas.getColumn(1).setPreferredWidth(350);
      columnModelVentas.getColumn(2).setPreferredWidth(80);
      columnModelVentas.getColumn(3).setPreferredWidth(80);
        // Ajustar ancho mínimo y máximo
      columnModelVentas.getColumn(0).setMinWidth(130);
      columnModelVentas.getColumn(1).setMinWidth(250);
      columnModelVentas.getColumn(2).setMinWidth(60);
      columnModelVentas.getColumn(3).setMinWidth(60);
      
      //columnModelVentas.getColumn(0).setMaxWidth(130);
      //columnModelVentas.getColumn(2).setMaxWidth(120);
      //columnModelVentas.getColumn(3).setMaxWidth(120);
      
      JScrollPane scrollPaneVentasTabla = new JScrollPane(VentasTabla);
   
        // Crear la segunda tabla
      String[] columnNames2 = {"Codigo de venta", "Producto", "Cantidad", "Precio", "Total"};
      Object[][] data2 = new Object[5][5]; // 5 filas, 5 columnas
      JTable detalleVentaTabla= new JTable(data2, columnNames2);
      
      TableColumnModel columnModelDetalleVenta = detalleVentaTabla.getColumnModel();
      
      // Ajustar el ancho de las columnas
      columnModelDetalleVenta.getColumn(0).setPreferredWidth(160);
      columnModelDetalleVenta.getColumn(1).setPreferredWidth(350);
      columnModelDetalleVenta.getColumn(2).setPreferredWidth(80);
      columnModelDetalleVenta.getColumn(3).setPreferredWidth(80);
        // Ajustar ancho mínimo y máximo
      columnModelDetalleVenta.getColumn(0).setMinWidth(130);
      columnModelDetalleVenta.getColumn(1).setMinWidth(250);
      columnModelDetalleVenta.getColumn(2).setMinWidth(60);
      columnModelDetalleVenta.getColumn(3).setMinWidth(60);
      
      columnModelDetalleVenta.getColumn(0).setMaxWidth(130);
      columnModelDetalleVenta.getColumn(2).setMaxWidth(120);
      columnModelDetalleVenta.getColumn(3).setMaxWidth(120);
      
      JScrollPane scrollPaneDetalleVentaTabla = new JScrollPane(detalleVentaTabla);
   
        // Crear un panel para las tablas
      JPanel tablaVentas=new JPanel(new BorderLayout());
      tablaVentas.add(scrollPaneVentasTabla, BorderLayout.CENTER);
      tablaVentas.setBorder(BorderFactory.createTitledBorder("Registro ventas"));
      
      JPanel tablaDetalleVentas=new JPanel(new BorderLayout());
      tablaDetalleVentas.add(scrollPaneDetalleVentaTabla, BorderLayout.CENTER);
      tablaDetalleVentas.setBorder(BorderFactory.createTitledBorder("Detalle de venta"));
      
      JPanel tablasPanel = new JPanel(new GridLayout(2, 1, 10, 10));
      tablasPanel.add(tablaDetalleVentas);
      tablasPanel.add(tablaVentas);
      
      mainContendPanel.add(tablasPanel, BorderLayout.CENTER);
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

   public static void main(String[] args) {
      JFrame frame = new JFrame("Ventas");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 600);
      frame.add(new VentasPanel());
      frame.setVisible(true);
   }
}
