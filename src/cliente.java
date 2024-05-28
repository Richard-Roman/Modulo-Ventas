public class cliente extends persona {
   private String tipoId;
   public cliente(){
      
   }
   // metodo construtor de la clase persona 
   public cliente(String tipoId, int id){
      super.setId(id);
      setTipoId(tipoId);
   }
   // metodos set y get de la clase 
         public void setTipoId(String tipoId){
            this.tipoId = tipoId;
         }
         
         public String getTipoId(){
            return tipoId;
         }

   // metodo toString para devolver datos de la clase 
   public String toString() {
      return tipoId + ": " + getId() + " - "+ getNombre()  + " - Telefono: " + getTelefono();
   }
   
   // metodo heredado de la clase Persona que se esta sobreescribiendo
   public void imprimir(){
      System.out.println(this.toString());
   }

   // metodo para comparar dos objetos de la clase cliente 
   public boolean esIgual(cliente b){ // recibe un objeto de parametro 
      persona c = b;  // castea el objeto a su clase padre en este caso Presona
      // si el tipo ID del cliente es igual al Tipo ID del objeto que recibe  
      if(this.getTipoId().equalsIgnoreCase(b.getTipoId())){ 
         // llamamos al metodo de la clase padre para comparar dos objetos 
         return super.esIgual(c); // retorna True o False 
      } else {
         return false;
      }
   }
   
   // metodo para verificar si el objeto tiene RUC 
   public boolean tieneRuc(){
      if(this.getTipoId().equalsIgnoreCase("ruc")){
         return true;
      } else {
         return  false;
      }
   }
   
   // metodo para completar el registro del cliente 
   public static cliente completarRegistro(cliente c){
         while(c.estaLleno()!=0){
            switch(c.estaLleno()){
               case 1: if(c.tieneRuc()){
                     c.setNombre(leer.Cadena("Razon social")); 
                  } else{
                     c.setNombre(leer.Cadena("Nombre"));
                  } break;
               case 2: c.setTelefono(leer.Entero("Telefono")); break;
            }
         }
      return c;
   }
   

   // Metodo crear Nuevo Cliente 
   public static cliente crearCliente(){
      String tipoId;
      int id;
      System.out.println("Ingrese los siguientes datos:");
      tipoId = leer.Cadena("Tipo de documento de identidad").toUpperCase(); // lamamos al metodo Leer cadena de la clas Leer 
      id = leer.Entero("Numero de " + tipoId); // lamamos al metodo leer entero de la clase Leer 
      cliente c = new cliente(tipoId,id); // Creamos un objeto de la clase cliente y le damos los parametros ingresados 
      return c; // retornamos el onjeto 
   }
}