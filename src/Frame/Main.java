package Frame;
import Panels.*;
import ClasesGestion.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;

public class Main extends JFrame{
   private JPanel titlePanel, centroPanel, centroContentPanel, navPanel, leftPanel, navLeft;
   private ImageIcon icon;
   
   private JMenu menuMaestros, menuOperaciones, menuConsultas, menuReportes;
   
   private JMenuItem mItemClientes, mItemProductos, mItemVendedores, mItemVenta,mItemDevolucion,
         mItemConsultaVentas, mItemConsultaProductos, mItemConsultaClientes, mItemConsultaVendedores,
         mItemReporteVentas, mItemReporteProductos, mItemReporteClientes, mItemReporteVendedores;
         
   private JPanel contendPanel, panelClientes, panelProductos,
         panelVendedores,panelVenta, panelDevolucion, 
         panelConsultaVentas, panelConsultaProductos, panelConsultaClientes,
         panelConsultaVendedores;
   
   private JButton btn1, btn2, btn3, btn4, btn5;
   
   private JLabel tituloLabel;
   
   private gestionClientes registroClientes;
   
   public Main(){
      super();
      init();
   
   }
   
   private void initRegistros(){
      registroClientes = new gestionClientes();
   }
   
   private void init(){
      //
      setTitle("XION - Registrar Venta");
      icon = new ImageIcon("Icon/MainIcon.png");
      setIconImage(icon.getImage());
      setLayout(new BorderLayout());
      setSize(new Dimension(1280,1024));
      setMinimumSize(new Dimension(960,720));
      
      initRegistros(); // gestionador de registros
      
      componentes();// COMPONENTES SWING
      
      //
      //addComponentListener(new reziseMoveListener());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   
   private void componentes(){
   
      // NAVEGADOR CABECERA
      addNavPanel();
      
      // MENU IZQUIERDO
      addLeftPanel();
      
      // PANEL CENTRAL
      addCentroPanel();
      //
   }
   
   // NAVEGADOR - CABECERA
   
   private void addNavPanel(){
      
      JMenuBar nav = new JMenuBar(); // Barra de menus
      
      // Menu MAESTROS
      menuMaestros = new JMenu("Maestros");
      mItemClientes = new JMenuItem("Clientes");
      mItemClientes.addActionListener(new menuItemActionEvent());
      mItemProductos = new JMenuItem("Productos");
      mItemProductos.addActionListener(new menuItemActionEvent());
      mItemVendedores = new JMenuItem("Vendedores");
      mItemVendedores.addActionListener(new menuItemActionEvent());
      
      menuMaestros.add(mItemClientes);
      menuMaestros.add(mItemProductos);
      menuMaestros.add(mItemVendedores);
      
      nav.add(menuMaestros);
      
      // Menu OPERACIONES
      menuOperaciones = new JMenu("Operaciones");
      mItemVenta = new JMenuItem("Ventas");
      mItemVenta.addActionListener(new menuItemActionEvent());
      mItemDevolucion = new JMenuItem("Devolución");
      mItemDevolucion.addActionListener(new menuItemActionEvent());
   
      menuOperaciones.add(mItemVenta);
      menuOperaciones.add(mItemDevolucion);
   
      nav.add(menuOperaciones);
   
      // Menu CONSULTAS
      menuConsultas = new JMenu("Consultas");
      mItemConsultaVentas = new JMenuItem("Ventas");
      mItemConsultaVentas.addActionListener(new menuItemActionEvent());
      mItemConsultaProductos = new JMenuItem("Productos");
      mItemConsultaProductos.addActionListener(new menuItemActionEvent());
      mItemConsultaClientes = new JMenuItem("Clientes");
      mItemConsultaClientes.addActionListener(new menuItemActionEvent());
      mItemConsultaVendedores = new JMenuItem("Vendedores");
      mItemConsultaVendedores.addActionListener(new menuItemActionEvent());
   
      menuConsultas.add(mItemConsultaVentas);
      menuConsultas.add(mItemConsultaProductos);
      menuConsultas.add(mItemConsultaClientes);
      menuConsultas.add(mItemConsultaVendedores);
   
      nav.add(menuConsultas);
   
        // Menu REPORTES
      menuReportes = new JMenu("Reportes");
      mItemReporteVentas = new JMenuItem("Ventas");
      mItemReporteVentas.addActionListener(new menuItemActionEvent());
      mItemReporteProductos = new JMenuItem("Productos");
      mItemReporteProductos.addActionListener(new menuItemActionEvent());
      mItemReporteClientes = new JMenuItem("Clientes");
      mItemReporteClientes.addActionListener(new menuItemActionEvent());
      mItemReporteVendedores = new JMenuItem("Vendedores");
      mItemReporteVendedores.addActionListener(new menuItemActionEvent());
   
      menuReportes.add(mItemReporteVentas);
      menuReportes.add(mItemReporteProductos);
      menuReportes.add(mItemReporteClientes);
      menuReportes.add(mItemReporteVendedores);
   
      nav.add(menuReportes);
      
      setJMenuBar(nav);
      
   }
  
   // NAVEGADOR - INQUIERDO
   
   public void addLeftPanel(){
      leftPanel = new JPanel();
      leftPanel.setLayout(new BorderLayout());
      
      navLeft = new JPanel();
      navLeft.setLayout(new GridLayout(5, 1, 0, 0));
      navLeft.setPreferredSize(new Dimension(170, 300));
      
      cargarBotones();
      
      btn1 = btn1;
      btn2 = btn5;
         
      Dimension buttonSize = new Dimension(170, 35);
      btn1.setPreferredSize(buttonSize);
      btn2.setPreferredSize(buttonSize);
      //btn3.setPreferredSize(buttonSize);
      //btn4.setPreferredSize(buttonSize);
      //btn5.setPreferredSize(buttonSize);
      
      navLeft.add(btn1);
      navLeft.add(btn2);
      //navLeft.add(btn3);
      //navLeft.add(btn4);
      //navLeft.add(btn5);
      
      leftPanel.add(navLeft, BorderLayout.NORTH);
      add(leftPanel, BorderLayout.WEST);
      
   }
   
   public void cargarBotones(){
      btn1 = new JButton("Ventas");
      btn2 = new JButton("Productos");
      btn3 = new JButton("Clientes");
      btn4 = new JButton("Vendedores");
      btn5 = new JButton("Devoluciones");
   }
   
   public void setBotones(String BotonsId){
      navLeft.removeAll();
      switch(BotonsId){
         case "Maestros":navLeft.add(btn2); navLeft.add(btn3);navLeft.add(btn4);
            tituloLabel.setText("MAESTROS"); 
            break;
         case "Operaciones": navLeft.add(btn1); navLeft.add(btn5);
            tituloLabel.setText("OPERACIONES"); 
            break;
         case "Consultas": navLeft.add(btn1); navLeft.add(btn2);navLeft.add(btn3);navLeft.add(btn4); 
            tituloLabel.setText("CONSULTAS"); 
            break;
         case "Reportes":navLeft.add(btn1); navLeft.add(btn2);navLeft.add(btn3);navLeft.add(btn4);
            tituloLabel.setText("REPORTES"); 
            break;
      }
      navLeft.revalidate();
      navLeft.repaint(); 
   }
   
   //PANEL CENTRAL
   
   public void addCentroPanel(){
      centroPanel = new JPanel(new BorderLayout());
      centroPanel.setBackground(Color.white);
      centroPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
      addTituloPanel();// TITULO
     
      centroContentPanel = new JPanel(new BorderLayout());
      cargaPanels();
      contendPanel= panelVenta;
      centroContentPanel.add(contendPanel,BorderLayout.CENTER);
      centroPanel.add(centroContentPanel,BorderLayout.CENTER);
      add(centroPanel, BorderLayout.CENTER);
   }
   
   // TITULO
   public void addTituloPanel(){
      titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      tituloLabel = new JLabel("OPERACIONES");
      tituloLabel.setPreferredSize(new Dimension(150, 20));
      titlePanel.add(tituloLabel);
      centroPanel.add(titlePanel,BorderLayout.NORTH);
   }
   
   /// FIJAR PANEL CENTRAL
   
   private void setContendPanel(String panelName){
      
      centroContentPanel.remove(contendPanel);
      switch(panelName){
         case "MaestrosClientes": contendPanel= panelClientes; 
            break;
         case "MaestrosProductos":contendPanel= panelProductos; 
            break;
         case "MaestrosVendedores":contendPanel= panelVendedores; 
            break;
         case "OperacionesVentas":contendPanel= panelVenta; 
            break;
         case "OperacionesDevolución":contendPanel= panelDevolucion; 
            break;
         case "ConsultasVentas":contendPanel= panelConsultaVentas; 
            break;
         case "ConsultasProductos":contendPanel= panelConsultaProductos; 
            break;
         case "ConsultasClientes":contendPanel= panelConsultaClientes; 
            break;
         case "ConsultasVendedores":contendPanel= panelConsultaVendedores; 
            break;
         case "ReportesVentas":contendPanel= panelConsultaVentas; 
            break;
         case "ReportesProductos":contendPanel= panelConsultaProductos; 
            break;
         case "ReportesClientes":contendPanel= panelConsultaClientes; 
            break;
         case "ReportesVendedores":contendPanel=panelConsultaVendedores; 
            break;
         default: contendPanel= new JPanel();
      }
       
      centroContentPanel.setBackground(Color.white);
      //contendPanel.setPreferredSize(new Dimension(600,500));
      //contendPanel.setBackground(Color.green);
      //contendPanel.setOpaque(true);
      centroContentPanel.add(contendPanel);
      centroContentPanel.revalidate();
      centroContentPanel.repaint();
      
   }
   
   private void cargaPanels(){
      panelClientes = new ClientesPanel(registroClientes); 
      panelProductos = new ProductosPanel();
      panelVendedores = new VendedoresPanel();
      panelVenta = new VentasPanel(); 
      panelDevolucion = new DevolucionPanel(); 
      panelConsultaVentas = new ReporteVentasPanel();
      panelConsultaProductos = new ProductosPanel();
      panelConsultaClientes = new ReporteClientesPanel(); 
      panelConsultaVendedores = new VendedoresPanel();
   }
   
   class menuItemActionEvent implements ActionListener{
      public void actionPerformed(ActionEvent e){
         JMenuItem menuItem = (JMenuItem) e.getSource();
         String idItem = "";
         JPopupMenu popupMenu = (JPopupMenu) menuItem.getParent();
         JMenu menu = (JMenu) popupMenu.getInvoker();
         idItem = menu.getText() + menuItem.getText();
         setContendPanel(idItem);
         setBotones(menu.getText());
         //setTitleTxt(menu.getText());
         System.out.println(idItem);
      }   
   }
   
   
   
   
   public static void main(String args[]){
      Main ap = new Main();
   }
}

