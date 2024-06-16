import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;


public class VentanaVenta extends JFrame{
        private JPanel encabezado;
        private JLabel lblCodVenta, lblFecha, lblCliente, lblTipoDocumento,lblDocumento, lblVendedor, lblTotal;
        private JTextField txtCodVenta, txtFecha, txtCliente, txtTipoDocumento, txtDocumento, txtTotal;
        private JPanel registros;
        private JComboBox<String> vendedor;
        private JTable table;
        private DefaultTableModel model;

        private venta vn = new venta();
        private boolean isSave=false;

        public static ArrayList<String> numeroVentas = new ArrayList<>(Arrays.asList("001", "002", "003", "004"));

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


        //Panel para el centro, contendra los registros y los botones verificar y salvar
            JPanel registrosPanel =new JPanel(new BorderLayout());
            //Creamos el panel que contendra a los botones de las funcionalidades
            JPanel panelBotones2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton verificar2 = new JButton("Verificar");
            JButton salvar2 = new JButton("Salvar");
            panelBotones2.add(verificar2);
            panelBotones2.add(salvar2);
            registrosPanel.add(panelBotones2, BorderLayout.NORTH);

            //Creamos el panel para los registros
            registros = new JPanel(new BorderLayout());
            registros.setBorder(BorderFactory.createTitledBorder("Registros de Venta"));
            // Definir el modelo de la tabla con datos de ejemplo
            String[] columnNames = {"ID", "Nombre", "P.Unit", "Cantidad", "Subtotal"};
            model = new DefaultTableModel(columnNames, 16); // 10 filas, 5 columnas
            table = new JTable(model);
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
            registrosPanel.add(registros,BorderLayout.CENTER);

            add(registrosPanel,BorderLayout.CENTER);


            //Creamos el panel que contendra a los botones de las funcionalidades
            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton guardar = new JButton("Guardar");
            JButton cancelar = new JButton("Cancelar");
            panelBotones.add(guardar);
            panelBotones.add(cancelar);

            add(panelBotones, BorderLayout.SOUTH);
    
            // Añadir el panel de registros a la ventana
            setVisible(true);
        }
        public VentanaVenta(venta vtn){
            VentanaVenta ventana = new VentanaVenta();
            this.vn = vtn;
            //Agregar los datos de la venta en los campos de la ventana
        }


    public String getTxtFecha() {
        return this.txtFecha.getText();
    }
    public String gettxtCodVenta() {
        return this.txtCodVenta.getText();
    }

    public String gettxtCliente() {
        return this.txtCliente.getText();
    }
    public String gettxtTipoDocumento() {
        return this.txtTipoDocumento.getText();
    }
    public String gettxtDocumento() {
        return this.txtDocumento.getText();
    }
    public String gettxtVendedor() {
        return (String) vendedor.getSelectedItem();
    }
    public String getTxtTotal() {
        return this.txtTotal.getText();
    }

    public void agregarCodVenta(String codigo){
        this.txtCodVenta.setText(codigo);
    }
    public void agregarCodUltimaVenta(ArrayList<String> numeroVentas){
        String ultimoElemento;
        if (!numeroVentas.isEmpty()) {
            ultimoElemento = numeroVentas.get(numeroVentas.size() - 1);
            this.txtCodVenta.setText(ultimoElemento);
        } else {
            this.txtCodVenta.setText("001");
        }  
    }

    public void agregarFecha(String fecha){
        this.txtFecha.setText(fecha);
    }
    public void agregarFechaActual(){
        LocalDate fechaactual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaactual.format(formatter);
        this.txtFecha.setText(fechaFormateada);
    }

    public void setTxtCliente(String NomCliente) {
        this.txtCliente.setText(NomCliente);
    }
    public JTable getTable() {
        return table;
    }
    public int getTableRows(){
        return model.getRowCount();
    }
    public int getTableColums(){
        return model.getColumnCount();
    }



    public  void salvar(){
        isSave = true;
        ExtraerEncabezado();
        ExtraerRegistros();
    }

    private void ExtraerEncabezado(){
        this.vn.setCodVenta(gettxtCodVenta());;
        this.vn.setFechaEmicion(getTxtFecha());
        this.vn.c.setNombre(gettxtCliente());
        this.vn.c.setTipoId(gettxtTipoDocumento());
        this.vn.c.setId(Integer.parseInt( gettxtCliente()));
        this.vn.v.setNombre(gettxtVendedor()); 
        this.vn.setTotal(Double.parseDouble(getTxtTotal()));
    }
    private void ExtraerRegistros(){
        
        for (int rowIndex = 0; rowIndex < getTableRows(); rowIndex++) {
            detalleVenta dtv = new detalleVenta();
            // Verificar si la fila tiene datos
            for (int colIndex = 0; colIndex < getTableColums(); colIndex++) {
                Object cellData = getTable().getValueAt(rowIndex, colIndex);
                if (cellData != null && !cellData.toString().trim().isEmpty()) {
                    dtv.incertEnRegistro(colIndex, cellData.toString());
                    //rowHasData = true;
                    break;
                }
            }
            if (dtv!=null){
                dtv.setFilaRegistro(rowIndex);
                this.vn.agragarRegistro(dtv);
            }
        }
    }

    public void  verificarCamposVacios(){

    }

    public static void main(String[] args) {
        //venta venta = new venta();venta.LlenarVenta();venta.MostrarVenta();
        //new ventanaVenta();
        new VentanaVenta();
        }
    
}
