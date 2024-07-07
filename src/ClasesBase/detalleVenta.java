package ClasesBase;
public class detalleVenta{
    producto producto= new producto();
    double cantidad;
    double subTotal;
    int filaRegistro;

    public detalleVenta(){  
    }

    public detalleVenta(producto p, double cantidad){
        this.producto= p;
        this.cantidad= cantidad;
    }
    public double getCantidad() {
        return cantidad;
    }
    public producto getProducto() {
        return producto;
    }
    public int getFilaRegistro() {
        return filaRegistro;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setProducto(producto producto) {
        this.producto = producto;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public void setFilaRegistro(int filaRegistro) {
        this.filaRegistro = filaRegistro;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public detalleVenta creardetalle(producto p, double cantidad){
        return new detalleVenta(p,cantidad);
    }
    public void incertEnRegistro(producto p, String cantidad){
        
    }




    public void mostrarDetalle(){  
        int camp1 = 5, camp2 = 12 , camp3=7, camp4 = 7;
        System.out.println(" "+Imprimirdato(this.producto.getIdProducto(), camp1)+Imprimirdato(this.producto.getNombre(), camp2)+ Imprimirdato(this.producto.getPrecio(), camp3) + "  " +Imprimirdato(this.cantidad, camp4));
    }

    public  String generarEspacios(int numeroEspacios) {
        String espacios = new String();
        for (int i = 0; i < numeroEspacios; i++) {
            espacios += (" ");
        }
        return espacios.toString();
    }

    public  String Imprimirdato(int valor, int campo) {
        String cadenaNumero = String.valueOf(valor);
        int longitud = cadenaNumero.length();
        String espacios = generarEspacios(campo-longitud);
        return valor+espacios;
    }
    public  String Imprimirdato(String valor, int campo) {
        int longitud = valor.length();
        String espacios = generarEspacios(campo-longitud);
        return valor+espacios;
    }
    public  String Imprimirdato(Double valor, int campo) {
        String cadenaNumero = String.valueOf(valor);
        int longitud = cadenaNumero.length();
        String espacios = generarEspacios(campo-longitud);
        return valor+espacios;
    }


}