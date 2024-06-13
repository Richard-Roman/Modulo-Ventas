
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;

public class venta {
    private Scanner Sc = new Scanner(System.in);
    private String ID, FechaEmicion,  Observaciones;
    private double total;
    public cliente c = new cliente();
    private vendedor vendedor = new vendedor();
    private Set<detalleVenta> Registventa = new LinkedHashSet<>();
    public static ArrayList<String> numeroVentas = new ArrayList<>(Arrays.asList("001", "002", "003", "004"));
    

    public venta(){

    }

    public ArrayList<String> getNumeroVentas() {
        return numeroVentas;
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

    public static String agregarIdVenta(ArrayList<String> numeroVentas){
        String ultimoElemento;
        if (!numeroVentas.isEmpty()) {
            ultimoElemento = numeroVentas.get(numeroVentas.size() - 1);
            return ultimoElemento;
        } else {
            System.out.println("El ArrayList está vacío.");
            return null;
        }    
    }
    public static String agregarFecha(){
        LocalDate fechaActual = LocalDate.now();
        // Formatear la fecha actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formatter);
        // Mostrar la fecha formateada
        return fechaFormateada;
    }
    
    public static void main(String[] args) {
        //venta venta = new venta();venta.LlenarVenta();venta.MostrarVenta();
        //new ventanaVenta();
        new VentanaVenta();
    }
}


class VentanaVenta extends JFrame {
        private JPanel encabezado;
        private JLabel lblCodVenta, lblFecha, lblCliente, lblTipoDocumento,lblDocumento, lblVendedor, lblTotal;
        private JTextField txtCodVenta, txtFecha, txtCliente, txtTipoDocumento, txtDocumento, txtTotal;
        private JPanel registros;
        private JComboBox<String> vendedor;

        public VentanaVenta() {
            setTitle("Nueva Venta");
            setSize(500, 700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //setLayout();
    
            // Panel principal con BorderLayout
            encabezado = new JPanel(new BorderLayout(10,10));
            encabezado.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30)); 
            
            // Panel de encabezado
            JPanel headerPanel = new JPanel(new BorderLayout());
            // Panel para el título de la venta en el centro
            JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Borde de Panel
            lblCodVenta = new JLabel("Venta N°:");
            txtCodVenta = new JTextField(5); // Establecer el tamaño del campo de texto
            txtCodVenta.setText(venta.agregarIdVenta(venta.numeroVentas));
            txtCodVenta.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde de línea para el campo de texto
            txtCodVenta.setEditable(true);
            titlePanel.add(lblCodVenta);
            titlePanel.add(txtCodVenta);
            headerPanel.add(titlePanel, BorderLayout.NORTH);

    
            // Panel para la fecha a la derecha
            JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            datePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); 
            JPanel agruparDate = new JPanel(new FlowLayout(FlowLayout.CENTER));
            agruparDate.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Borde de Panel
            lblFecha = new JLabel("Fecha: ");
            txtFecha = new JTextField(10); // Establecer el tamaño del campo de texto
            txtFecha.setText(venta.agregarFecha());
            txtFecha.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde de línea para el campo de texto
            txtFecha.setEditable(true);
            agruparDate.add(lblFecha);agruparDate.add(txtFecha);
            datePanel.add(agruparDate);
            headerPanel.add(datePanel, BorderLayout.CENTER);
    
            JPanel InfoCliente = new JPanel(new FlowLayout(FlowLayout.LEFT));
            // Panel para la información del cliente en el sur
            JPanel clientePanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);
            //Creamos los elementos del panel cliente
            lblCliente = new JLabel("Señor(es): ");  
            txtCliente = new JTextField(25); 
            txtCliente.setEditable(true);
            lblTipoDocumento = new JLabel("Tipo Documento: ");
            txtTipoDocumento = new JTextField(25); // Establecer el tamaño del campo de texto
            txtTipoDocumento.setEditable(true); 
            lblDocumento = new JLabel("N° Documento: ");
            txtDocumento = new JTextField(25); // Establecer el tamaño del campo de texto
            txtDocumento.setEditable(true);
            //Creamos el Combox que contendra los vendedores
            lblVendedor = new JLabel("Vendedor:");
            vendedor = new JComboBox<>();
            vendedor.addItem("Juan Peres");
            vendedor.addItem("Pedro Vargas");
            //Agregamos los Elmentos del panel en su pocicion
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 0; gbc.gridy = 0; clientePanel.add(lblCliente,gbc); gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1; gbc.gridy = 0; clientePanel.add(txtCliente,gbc);
            gbc.gridx = 0; gbc.gridy = 1; clientePanel.add(lblTipoDocumento,gbc);
            gbc.gridx = 1; gbc.gridy = 1; clientePanel.add(txtTipoDocumento,gbc);
            gbc.gridx = 0; gbc.gridy = 2; clientePanel.add(lblDocumento,gbc);
            gbc.gridx = 1; gbc.gridy = 2; clientePanel.add(txtDocumento,gbc);
            gbc.gridx = 0; gbc.gridy = 3; clientePanel.add(lblVendedor,gbc);
            gbc.gridx = 1; gbc.gridy = 3; clientePanel.add(vendedor,gbc);
            //Agregamos los elementos al panel cliente
            InfoCliente.add(clientePanel,BorderLayout.WEST);
            headerPanel.add(InfoCliente, BorderLayout.SOUTH);
            encabezado.add(headerPanel, BorderLayout.NORTH);
            add(encabezado,BorderLayout.NORTH);

            //Creamos el panel para los registros
            registros = new JPanel(new BorderLayout());
            registros.setBorder(BorderFactory.createTitledBorder("Registros de Venta"));
            // Definir el modelo de la tabla con datos de ejemplo
            String[] columnNames = {"ID", "Nombre", "P.Unit", "Cantidad", "Subtotal"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 16); // 10 filas, 5 columnas
            JTable table = new JTable(model);
            // Personalizar la tabla
            table.setCellSelectionEnabled(true); // Habilitar la selección de celdas
            table.setShowGrid(true); // Mostrar las líneas de la cuadrícula
            table.setGridColor(Color.GRAY); // Color de la cuadrícula
            table.setRowHeight(20); // Altura de las filas

            //Agregamos un panel para le total
            JPanel totalPanel = new JPanel(new BorderLayout());
            totalPanel.setBorder(BorderFactory.createEmptyBorder(5, 16, 5, 0)); 
            lblTotal = new JLabel("TOTAL:"); 
            txtTotal = new JTextField(9);
            totalPanel.add(lblTotal, BorderLayout.WEST);
            totalPanel.add(txtTotal, BorderLayout.EAST);

    
            // Agregar la tabla a un JScrollPane para agregar capacidades de desplazamiento
            JScrollPane scrollPane = new JScrollPane(table);
            registros.add(scrollPane, BorderLayout.CENTER);
            registros.add(totalPanel, BorderLayout.SOUTH);


            //Creamos el panel que contendra a los botones de las funcionalidades
            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton verificar = new JButton("Verificar");
            JButton salvar = new JButton("Salvar");
            JButton guardar = new JButton("Guardar");
            panelBotones.add(verificar);
            panelBotones.add(salvar);
            panelBotones.add(guardar);
            add(panelBotones, BorderLayout.SOUTH);
    
            // Añadir el panel de registros a la ventana
            add(registros, BorderLayout.CENTER);
            setVisible(true);
        }

    }









