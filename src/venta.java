
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;

public class venta {
    private Scanner Sc = new Scanner(System.in);
    private String ID, FechaEmicion,  Observaciones;
    private double total;
    public cliente c = new cliente();
    private vendedor vendedor = new vendedor();
    private Set<detalleVenta> Registventa = new LinkedHashSet<>();

    public venta(){

    }

    public String getID() {
        return ID;
    }
    public String getFechaEmicion() {
        return FechaEmicion;
    }
    public String getObservaciones() {
        return Observaciones;
    }
    public Set<detalleVenta> getRegistventa() {
        return Registventa;
    }
    public double getTotal() {
        return total;
    }
    public cliente getCliente() {
        return c;
    }
    public vendedor getVendedor() {
        return vendedor;
    }

    public void setID(String iD) {
        ID = iD;
    }
    public void setFechaEmicion(String fechaEmicion) {
        FechaEmicion = fechaEmicion;
    }
    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setCliente(cliente cliente) {
        this.c = cliente;
    }
    public void setVendedor(vendedor vendedor) {
        this.vendedor = vendedor;
    }



    public void LlenarProductos(){
        boolean terminar = false;
        Sc.useDelimiter("\\s+");
       
        System.out.println("|id | Nombre  |P.Unit| Cantidad |");
        System.out.println("----------------------------------------------------------------------");
        do{
            System.out.print("  ");
            producto producto = new producto();
            detalleVenta dt = new detalleVenta();
            String control = Sc.next();
            if (!control.equals("terminar")){
                int id = Integer.parseInt(control);
                String nombre = Sc.next();
                double precio = Sc.nextDouble(); 
                double cantidad = Sc.nextDouble(); 
                producto.setIdProducto(id);producto.setNombre(nombre); producto.setPrecio(precio);
                dt.setProducto(producto);dt.setCantidad(cantidad);
                this.Registventa.add(dt);
            }else{
                terminar=true;
            }

        }while(!terminar);
     }
    public void LlenarVenta(){
        System.out.println("----------------------------------------------------------------------");
        setID(leer.Cadena("                      Venta N°"));
        System.out.println("----------------------------------------------------------------------");
        setFechaEmicion(leer.Cadena("                                          Fecha"));
        String nombre = leer.Cadena("Señor(es)      ");
        String Tipoid = leer.Cadena("Tipo Documento ");
        Integer id = leer.Entero("N° "+Tipoid+" ");
        System.out.println("----------------------------------------------------------------------");
        LlenarProductos();
        System.out.println("----------------------------------------------------------------------");

        this.c.setNombre(nombre);this.c.setTipoId(Tipoid); this.c.setId(id);
    }


    public void CompovarVenta(){

    }

    public void EditarVenta(){
        

    }


    public void MostrarError(){

    }

    public void MostrarVenta(){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                      Venta N° "+getID());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                                          Fecha: "+getFechaEmicion());
        System.out.println("Señor(es)      "+ this.c.getNombre());
        System.out.println("Tipo Documento "+ this.c.getTipoId());
        if(c.tieneRuc()){
            System.out.println("N° RUC: "+ this.c.getId());
        }else{
            System.out.println("N° DNI: "+ this.c.getId());
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|id  | Nombre   | P.Unit | Cantidad |");
        System.out.println("----------------------------------------------------------------------");
        
        for (detalleVenta dt: Registventa){
            dt.mostrarDetalle();
        }
        System.out.println("----------------------------------------------------------------------");
    }
    
    public static void main(String[] args) {
        //venta venta = new venta();venta.LlenarVenta();venta.MostrarVenta();
        //new ventanaVenta();
        new VentanaVenta();
    }
}


class VentanaVenta extends JFrame {
        private JPanel encabezado;
        private JLabel lblCodVenta, lblFecha, lblCliente, lblTipoDocumento,lblDocumento;
        private JTextField txtCodVenta, txtFecha, txtCliente, txtTipoDocumento, txtDocumento;
        private JPanel registros;
        private JComboBox<String> vendedor;

        public VentanaVenta() {
            setTitle("Nueva Venta");
            setSize(500, 800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //setLayout();
    
            // Panel principal con BorderLayout
            encabezado = new JPanel(new BorderLayout(10,10));
            encabezado.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30)); 
            
            // Panel de encabezado
            JPanel headerPanel = new JPanel(new BorderLayout());
            // Panel para el título de la venta en el centro
            JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Borde de Panel
            lblCodVenta = new JLabel("Venta N°:");
            txtCodVenta = new JTextField(5); // Establecer el tamaño del campo de texto
            txtCodVenta.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde de línea para el campo de texto
            txtCodVenta.setEditable(true);
            titlePanel.add(lblCodVenta);
            titlePanel.add(txtCodVenta);
            headerPanel.add(titlePanel, BorderLayout.NORTH);
    
            // Panel para la fecha a la derecha
            JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            datePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10)); 
            JPanel agruparDate = new JPanel(new FlowLayout(FlowLayout.CENTER));
            agruparDate.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Borde de Panel
            lblFecha = new JLabel("Fecha: ");
            txtFecha = new JTextField(10); // Establecer el tamaño del campo de texto
            txtFecha.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde de línea para el campo de texto
            txtFecha.setEditable(true);
            agruparDate.add(lblFecha);agruparDate.add(txtFecha);
            datePanel.add(agruparDate);
            headerPanel.add(datePanel, BorderLayout.CENTER);
    
            // Panel para la información del cliente en el sur
            JPanel clientePanel = new JPanel(new GridLayout(3, 2,  7, 7));
            lblCliente = new JLabel("Señor(es): ");
            clientePanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0)); 
            txtCliente = new JTextField(10); // Establecer el tamaño del campo de texto
            txtCliente.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde de línea para el campo de texto
            txtCliente.setEditable(true);
            lblTipoDocumento = new JLabel("Tipo Documento: ");
            lblTipoDocumento.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
            txtTipoDocumento = new JTextField(10); // Establecer el tamaño del campo de texto
            txtTipoDocumento.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde de línea para el campo de texto
            txtTipoDocumento.setEditable(true); 
            lblDocumento = new JLabel("N° Documento: ");
            lblDocumento.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0)); 
            txtDocumento = new JTextField(10); // Establecer el tamaño del campo de texto
            txtDocumento.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde de línea para el campo de texto
            txtDocumento.setFont(txtDocumento.getFont().deriveFont(Font.PLAIN, 12)); // Reducir el tamaño de la fuente
            txtDocumento.setEditable(true);

            clientePanel.add(lblCliente);
            clientePanel.add(txtCliente);
            clientePanel.add(lblTipoDocumento);
            clientePanel.add(txtTipoDocumento);
            clientePanel.add(lblDocumento);
            clientePanel.add(txtDocumento);
            headerPanel.add(clientePanel, BorderLayout.SOUTH);
            encabezado.add(headerPanel, BorderLayout.NORTH);
            add(encabezado,BorderLayout.NORTH);

            registros = new JPanel(new BorderLayout());
            registros.setBorder(BorderFactory.createTitledBorder("Registros de Venta"));
            // Definir el modelo de la tabla con datos de ejemplo
            String[] columnNames = {"ID", "Nombre", "P.Unit", "Cantidad", "Subtotal"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 15); // 10 filas, 5 columnas
            JTable table = new JTable(model);
    
            // Personalizar la tabla
            table.setCellSelectionEnabled(true); // Habilitar la selección de celdas
            table.setShowGrid(true); // Mostrar las líneas de la cuadrícula
            table.setGridColor(Color.GRAY); // Color de la cuadrícula
            table.setRowHeight(20); // Altura de las filas
    
            // Agregar la tabla a un JScrollPane para agregar capacidades de desplazamiento
            JScrollPane scrollPane = new JScrollPane(table);
            registros.add(scrollPane, BorderLayout.CENTER);
    
            // Añadir el panel de registros a la ventana
            add(registros, BorderLayout.CENTER);
            setVisible(true);
        }

    }

class ExcelLikeTableExample extends JFrame {

    public ExcelLikeTableExample() {
        setTitle("Tabla tipo Excel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        // Definir el modelo de la tabla con datos de ejemplo
        DefaultTableModel model = new DefaultTableModel(10, 5); // 10 filas, 5 columnas
        JTable table = new JTable(model);

        // Personalizar la tabla
        table.setCellSelectionEnabled(true); // Habilitar la selección de celdas
        table.setShowGrid(true); // Mostrar las líneas de la cuadrícula
        table.setGridColor(Color.GRAY); // Color de la cuadrícula
        table.setRowHeight(20); // Altura de las filas
    
        // Agregar la tabla a un JScrollPane para agregar capacidades de desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExcelLikeTableExample());
    }
}




