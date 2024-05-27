public class vendedor {
    private int idVendedor;
    private String nombre;
    private String telefono;
    private sexo; 

    
    public vendedor(int idVendedor) { // Constructor
        setIdVendedor(idVendedor);
    }
    
    // Setters

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getters
    
    public int getIdVendedor() {
        return idVendedor;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public String toString() {
        return idVendedor + " " + nombre + " " + telefono;
    }
}
