public abstract class persona{
   private Integer id;
   private String nombre;
   private Integer telefono;
   
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
   
   public String toString(){
      return id + " - Nombre" + nombre +  " - Telefono: " + telefono;
   }
   
   public boolean esIgual(persona b){
      if(this.getId() == b.getId()){
         return true;
      } else {
         return false;
      }
   }
   
   public int estaLleno(){
      if(getNombre() == null){
         return 1;
      } else if (getTelefono()== null){
         return 2;
      } else {
         return 0;
      }
   }
   
   public abstract void imprimir();
}