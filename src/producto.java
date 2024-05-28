public class producto {
    private int idProducto;
    private String nombre;
    private double precio;
    
    public producto() { // Constructor
        

    }
    public producto(int idProducto, String nombre) { // Constructor
        this.idProducto = idProducto;
        this.nombre = nombre;
    }
    
    public producto (int idProducto){
      this.idProducto = idProducto;
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
        return idProducto + " - " + nombre + " - " + precio;
    }
    
    
    
    // metodo para comparar objetos
    
    public boolean esIgual(producto p){
      if(this.getIdProducto() == p.getIdProducto()){
         return true;
      } else  {
         return false;
      }
    }
   
   // Metodo staticos para crear nueovs objetos a partid de la clase
    
    public static producto crearProducto(){
      System.out.println("Ingrese los siguientes datos:");
      int idProducto = leer.Entero("Codigo del producto");
      String nombre = leer.Cadena("Nombre");
      producto p = new producto(idProducto,nombre);
      return p;
    }
    
    public static producto completarRegistro(producto p){
      p.setNombre(leer.Cadena("Nombre"));
      return p;
    }
    
    
}
