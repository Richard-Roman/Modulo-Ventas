public class cliente extends persona {
   private String tipoId;

   public cliente(){
   }
   
   public cliente(String tipoId, int id){
      super.setId(id);
      setTipoId(tipoId);
   }
   
   public void setTipoId(String tipoId){
      this.tipoId = tipoId;
   }
   
   public String getTipoId(){
      return tipoId;
   }
     
   public String toString() {
      return tipoId + ": " + getId() + " - "+ getNombre()  + " - Telefono: " + getTelefono();
   }
   
   
   public void imprimir(){
      System.out.println(this.toString());
   }
   
   public boolean esIgual(cliente b){
      persona c = b;  
      if(this.getTipoId().equalsIgnoreCase(b.getTipoId())){
         return super.esIgual(c);
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
   
   public static cliente crearCliente(){
      String tipoId;
      int id;
      System.out.println("Ingrese los siguientes datos:");
      tipoId = leer.Cadena("Tipo de documento de identidad").toUpperCase();
      id = leer.Entero("Numero de " + tipoId);
      cliente c = new cliente(tipoId,id);
      return c;
   }
}