package Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;

public class f_main extends JFrame{
   private xButton ventas, productos, cliente, vendedor, documentosPago, MediosPago, consultas, reportes, salir;
   ImageIcon icon;
   f_main(){
      super();
      init();
      initComponentes();
      setVisible(true);
   }
   
   private void init(){
      icon = new ImageIcon("src/resources/icon/MainIcon.png");
      System.out.println(icon);
      this.setIconImage(icon.getImage());
      
      this.setMinimumSize(new Dimension(1200, 800));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      
   }
   
   private void initComponentes(){
      addMenuComponetes();
   }
   
   private void addMenuComponetes(){
      //// Botones
      JPanel BarraOpciones = new JPanel(new GridBagLayout());
      BarraOpciones.setBackground(new Color(255, 165, 0));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = GridBagConstraints.RELATIVE;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.NORTH;
      gbc.weightx = 1.0;
      gbc.insets = new Insets(0, 0, 0, 0);


      ventas = new xButton("VENTAS");
      productos = new xButton("PRODUCTOS");
      cliente = new xButton("CLIENTES");
      vendedor = new xButton("PERSONAL");
      documentosPago = new xButton("DOCUMENTOS DE PAGO");
      MediosPago = new xButton("MEDIOS DE PAGO");
      consultas = new xButton("CONSULTAS");
      reportes = new xButton("REPORTES");
      salir = new xButton("SALIR");
      
      BarraOpciones.add(ventas,gbc);
      BarraOpciones.add(cliente,gbc);
      BarraOpciones.add(productos,gbc);
      BarraOpciones.add(vendedor,gbc);
      BarraOpciones.add(documentosPago,gbc);
      BarraOpciones.add(MediosPago,gbc);
      BarraOpciones.add(consultas,gbc);
      BarraOpciones.add(reportes,gbc);
      BarraOpciones.add(new JLabel(),gbc); // Separador
      BarraOpciones.add(salir,gbc);
      //BarraOpciones.setOrientation(SwingConstants.VERTICAL);
      gbc.weighty = 1.0;
      BarraOpciones.add(Box.createVerticalGlue(), gbc);
        
      add(BarraOpciones, BorderLayout.WEST);
   }
   
   public static void main(String args[]){
      f_main ap = new f_main();
   }
}