
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
       
    }

    public static void CrearVenta(){  
        VentanaVenta ventana = new VentanaVenta();    
        ventana.agregarCodVenta(agregarIdVenta(numeroVentas));
        ventana.agregarFecha(agregarFecha());
    }


    public void CompovarVenta(){

    }

    public void EditarVenta(){
        

    }


    public void MostrarError(){

    }

    public void MostrarVenta(){
 
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
        venta vn = new venta();
        venta.CrearVenta();
    }
}











