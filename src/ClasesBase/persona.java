package ClasesBase;

public abstract class persona{
   private String id;
   private String nombre;
   private Integer telefono;
   // metodos set y get de la clase 
   // Constructor
   public persona(String id, String nombre, Integer telefono) {
      this.id = id;
      this.nombre = nombre;
      this.telefono = telefono;
   }
    
   public void setId(String id) {
      this.id = id;
   }
      
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
      
   public void setTelefono(int telefono) {
      this.telefono = telefono;
   }
      
   public String getId() {
      return id;
   }

   public String getNombre() {
      return nombre;
   }
      
   public Integer getTelefono() {
      return telefono;
   }
   // metodo ToString que devuelve los datos almacenados 
   
   public String toString(){
      return id + " - Nombre: " + nombre +  " - Telefono: " + telefono;
   }

   
   // compara dos objetos de la clase persona 
   public boolean esIgual(persona b){// recibe de parametro un objeto de tipo Persona 
      return this.getId().equalsIgnoreCase(b.getId());
   }

   // metodo abstracto para imprimir 
   public abstract void imprimir();
}