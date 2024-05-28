public abstract class persona{
   private Integer id;
   private String nombre;
   private Integer telefono;
   // metodos set y get de la clase 
      public void setId(int id) {
         this.id = id;
      }
      
      public void setNombre(String nombre) {
         this.nombre = nombre;
      }
      
      public void setTelefono(int telefono) {
         this.telefono = telefono;
      }
      
      public int getId() {
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
      return id + " - Nombre" + nombre +  " - Telefono: " + telefono;
   }
   // compara dos objetos de la clase persona 
   public boolean esIgual(persona b){// recibe de parametro un objeto de tipo Persona 
      if(this.getId() == b.getId()){ // comparav el ID de la clase con el Id del objeto 
         return true;
      } else {
         return false;
      }
   }
   
   // evalua si un objeto tiene datos o esta vacio
   public int estaLleno(){
      if(getNombre() == null){
         return 1;
      } else if (getTelefono()== null){
         return 2;
      } else {
         return 0;
      }
   }
   // metodo abstracto para imprimir 
   public abstract void imprimir();
}