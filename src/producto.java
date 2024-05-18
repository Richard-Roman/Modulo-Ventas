public class producto {
    private int idProducto;
    private String nombre;
    private double precio;

    public producto(int idProducto, String nombre) { // Constructor
        this.idProducto = idProducto;
        this.nombre = nombre;
    }
    
    // Setters

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    // Getters

    public String getNombre() {
        return nombre;
    }
    
    public int getIdProducto() {
        return idProducto;
    }
    
     public double getPrecio() {
        return precio;
    }

    public String toString() {
        return idProducto + " " + nombre + " " + precio;
    }
}
