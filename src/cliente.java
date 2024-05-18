public class cliente {
   private int id;
    private String tipoId;
    private String nombre;
    private String razonSocial;
    private String telefono;

    public cliente(int id, String tipoId) { // Constructor
        setId(id);
        setTipoId(tipoId);
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Getters
    public int getId() {
        return id;
    }
    
    public String getTipoId() {
        return tipoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public String toString() {
      String nom;
      if(nombre != null) {
         nom = getNombre();
      } else{
         nom = getRazonSocial();
      }
      return nom + " " + tipoId + ": " + id + " telefono: " + telefono;
   }
}
   