
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class venta {
    private String CodVenta, FechaEmicion,  Observaciones;
    private double total;
    public cliente c = new cliente();
    public vendedor v = new vendedor();
    private ArrayList<detalleVenta> Registventa = new ArrayList<>();
    public static ArrayList<String> numeroVentas = new ArrayList<>(Arrays.asList("001", "002", "003", "004"));

    
    public venta(){  
    }

    public ArrayList<String> getNumeroVentas() {
        return numeroVentas;
    }

    public String getCodVenta() {
        return CodVenta;
    }
    public String getFechaEmicion() {
        return FechaEmicion;
    }
    public String getObservaciones() {
        return Observaciones;
    }
    public ArrayList<detalleVenta> getRegistventa() {
        return Registventa;
    }
    public detalleVenta extrarDetalleVenta() {
        return null;//Registventa;
    }
    public void agragarRegistro(detalleVenta registro){
        this.Registventa.add(registro);
    }
    public double getTotal() {
        return total;
    }
    public cliente getCliente() {
        return c;
    }
    public vendedor getVendedor() {
        return v;
    }

    public void setCodVenta(String codVenta) {
        CodVenta = codVenta;
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
        this.v = vendedor;
    }
    public void setRegistventa(ArrayList<detalleVenta> registventa) {
        Registventa = registventa;
    }



    public void LlenarProductos(){
       
    }

    public static void CrearVenta(){  

    }

 


    public void verificarVenta(){

    }


    public void MostrarError(){

    }



    public static String agregarIdVenta(ArrayList<String> numeroVentas){
        String ultimoElemento;
        if (!numeroVentas.isEmpty()) {
            ultimoElemento = numeroVentas.get(numeroVentas.size() - 1);
            return ultimoElemento;
        } else {
            System.out.println("001");
            return null;
        }    
    }

    
    public static void main(String[] args) {
        //venta venta = new venta();venta.LlenarVenta();venta.MostrarVenta();
        //new ventanaVenta();
        new venta();
        
    }
}




class AdvancedTooltipExample {
    public static void main(String[] args) {
        // Configurar el ToolTipManager
        ToolTipManager.sharedInstance().setInitialDelay(500); // Tiempo de espera antes de mostrar el tooltip (ms)
        ToolTipManager.sharedInstance().setDismissDelay(5000); // Tiempo antes de que desaparezca el tooltip (ms)

        // Crear el marco (ventana)
        JFrame frame = new JFrame("Ejemplo Avanzado de Tooltip");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Crear el panel
        JPanel panel = new JPanel(new FlowLayout());
        
        // Crear un JLabel con tooltip
        JLabel label = new JLabel("Pasa el mouse por aquí");
        label.setToolTipText("Este es un JLabel con un tooltip avanzado");

        // Crear un JTextField con tooltip
        JTextField textField = new JTextField(15);
        textField.setToolTipText("Este es un JTextField con un tooltip avanzado");
        
        // Añadir los componentes al panel
        panel.add(label);
        panel.add(textField);
        
        // Añadir el panel al marco
        frame.add(panel);
        
        // Hacer visible el marco
        frame.setVisible(true);
    }
}











