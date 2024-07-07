package Panels;
import ClasesGestion.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import SwingComponents.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import ClasesBase.cliente;
import ClasesBase.persona;

public class ClientesPanel extends JPanel {
   private JPanel cetroPanel, mainContendPanel,contedPanel;
   private JTable tablaClientes;
   private JRadioButton dniButton, rucButton;
   private xCampo idCampo,nameCampo,phoneCampo;
   private String[][] data;
   private JButton bBuscar, bRegistrar, bEliminar, bModificar, bLimpiar;
   private gestionClientes RegistroClientes;
   private DefaultTableModel tableModel;
   
   public ClientesPanel(gestionClientes RegistroClientes) {
      init();
      this.RegistroClientes = RegistroClientes;
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
      contedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
      contedPanel.setPreferredSize(new Dimension(800,100));
      JPanel tipoId =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      tipoId.setPreferredSize(new Dimension(390,24));
      JLabel tipoIdtxt = new JLabel("Tipo de identificación:");
      tipoIdtxt.setPreferredSize(new Dimension(150,24));
      tipoId.add(tipoIdtxt);
      JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
      idPanel.setBackground(Color.red);
      ButtonGroup group = new ButtonGroup();
      dniButton = new JRadioButton("DNI");
      dniButton.setSelected(true);
      rucButton = new JRadioButton("RUC");
      group.add(dniButton);
      group.add(rucButton);
      idPanel.add(dniButton);
      idPanel.add(rucButton);
      tipoId.add(idPanel);
      contedPanel.add(tipoId);
      
      idCampo = new xCampo("Número de identificación:");
      idCampo.setAllSize(new Dimension(390,24));
      contedPanel.add(idCampo);
      
      /*JPanel numeroId =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      numeroId.setPreferredSize(new Dimension(390,24));
      JLabel numeroIdtxt = new JLabel("Número de identificación:");
      numeroIdtxt.setPreferredSize(new Dimension(150,24));
      numeroId.add(numeroIdtxt);
      idField = new JTextField();
      idField.setPreferredSize(new Dimension(150,24));
      numeroId.add(idField);
      contedPanel.add(numeroId);*/
      
      nameCampo = new xCampo("Nombre / Razón social:");
      nameCampo.setAllSize(new Dimension(390,24));
      contedPanel.add(nameCampo);
      /*JPanel nombreRuc =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      nombreRuc.setPreferredSize(new Dimension(390,24));
      JLabel nombretxt = new JLabel("Nombre / Razón social:");
      nombretxt.setPreferredSize(new Dimension(150,24));
      nombreRuc.add(nombretxt);
      nameField = new JTextField();
      nameField.setPreferredSize(new Dimension(150,24));
      nombreRuc.add(nameField);
      contedPanel.add(nombreRuc);*/
      
      phoneCampo = new xCampo("Teléfono:");
      phoneCampo.setAllSize(new Dimension(390,24));
      contedPanel.add(phoneCampo);
      /*JPanel telefono =new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
      telefono.setPreferredSize(new Dimension(390,24));
      JLabel telefonotxt = new JLabel("Teléfono:");
      telefonotxt.setPreferredSize(new Dimension(150,24));
      telefono.add(telefonotxt);
      phoneField = new JTextField();
      phoneField.setPreferredSize(new Dimension(150,24));
      telefono.add(phoneField);
      contedPanel.add(telefono);*/
   
      contedPanel.setBorder(BorderFactory.createTitledBorder("Clientes"));
      contedPanel.setBackground(Color.white);
      mainContendPanel.add(contedPanel, BorderLayout.NORTH);
   }
   
   private void actualizarTabla(){
      tableModel.setRowCount(0);
      for (String[] row : data) {
            tableModel.addRow(row);
        }
   }
   
   private void addTabla() {
        // Crear el panel central para la tabla
      String[] columnNames = {"Tipo de identificación", "Número de identificación", "Nombre/Razón Social", "Teléfono"};
      data = RegistroClientes.getRegistro();
      tableModel = new DefaultTableModel(columnNames, 0);
      actualizarTabla();
      tablaClientes = new JTable(tableModel);
        //
      TableColumnModel columnModel = tablaClientes.getColumnModel();
   
        // Ajustar el ancho de las columnas
      columnModel.getColumn(0).setPreferredWidth(160);
      columnModel.getColumn(1).setPreferredWidth(180);
      columnModel.getColumn(2).setPreferredWidth(350);
      columnModel.getColumn(3).setPreferredWidth(130);
   
        // Ajustar ancho mínimo y máximo
      columnModel.getColumn(0).setMinWidth(130);
      columnModel.getColumn(1).setMinWidth(150);
      columnModel.getColumn(2).setMinWidth(300);
      columnModel.getColumn(3).setMinWidth(130);
   
        // Configurar tamaño preferido de la tabla para el viewport
        
      JScrollPane scrollPane = new JScrollPane(tablaClientes);
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
   
        // Añadir el JScrollPane al panel central
      mainContendPanel.add(scrollPane, BorderLayout.CENTER);
   }
   
   private void addCrudMenu(){
      JPanel crudPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel crudBotons = new JPanel(new GridLayout(5, 1, 15, 5));
      bBuscar = new JButton("Buscar");
      bBuscar.addActionListener(new buttonListener());
      bRegistrar = new JButton("Registrar");
      bRegistrar.addActionListener(new buttonListener());
      bEliminar = new JButton("Eliminar");
      bEliminar.addActionListener(new buttonListener());
      bModificar = new JButton("Modificar");
      bModificar.addActionListener(new buttonListener());
      bLimpiar = new JButton("Limpiar");
      bLimpiar.addActionListener(new buttonListener());
      
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
      if(d.getWidth()<=919){
         tablaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      } else {
         tablaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
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
   
   class buttonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         String nameBoton = ((JButton) e.getSource()).getText();
         switch(nameBoton){
            case "Buscar": //verDatos(); 
               break;
            case "Registrar": registrar(); 
               break;
            case "Eliminar":// eliminar(); 
               break;
            case "Modificar": //modificar(); 
               break;
            case "Limpiar"://limpiar(); 
               break;
         }
      }
   }
   
   private void registrar(){
      String tipoId, id, nombre;
      Integer telefono = 0;
      if(dniButton.isSelected()){
         tipoId = dniButton.getText();
      } else {
         tipoId = rucButton.getText();
      }
      if(idCampo.getFieldText()==null){
         JOptionPane.showMessageDialog(this, "Ingrese el numero de " + tipoId, "CLIENTE", JOptionPane.ERROR_MESSAGE);
      } else {
         id = idCampo.getFieldText();
         if(nameCampo.getFieldText()==null){
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del cliente. ", "CLIENTE " + tipoId + ": " + id, JOptionPane.ERROR_MESSAGE);
         } else {
            nombre = nameCampo.getFieldText();
            try{
               if(phoneCampo.getFieldText()==null){
                  JOptionPane.showMessageDialog(this, "Ingrese el numero del Telefono del cliente ", "CLIENTE "  + tipoId + ": " + id, JOptionPane.ERROR_MESSAGE);
               } else{
                  telefono = Integer.parseInt(phoneCampo.getFieldText());
               }
               cliente c = new cliente(id,nombre, telefono, tipoId);
               RegistroClientes.agregarCliente(c);
               data = RegistroClientes.getRegistro();
               actualizarTabla();
               tablaClientes.repaint();
               RegistroClientes.imprimir();
            }catch (NumberFormatException ex){
               JOptionPane.showMessageDialog(this, "Ingrese correctamente el número de teléfono", "CLIENTE", JOptionPane.ERROR_MESSAGE);
            }
            
         }
         
      }
      //dniButton, rucButton;
      //idCampo,nameCampo,phoneCampo;
   }
   
   
   public static void main(String[] args) {
      JFrame frame = new JFrame("Clientes");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 400);
      frame.add(new ClientesPanel(new gestionClientes()));
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}
