package ClasesBase;
public class cliente extends persona {
   private String tipoId;

    // Constructor que inicializa todos los atributos, incluidos los de la clase base
   public cliente(String id, String nombre, Integer telefono, String tipoId) {
      super(id, nombre, telefono);
      this.tipoId = tipoId;
   }
   

    // Getters and Setters
   public String getTipoId() {
      return tipoId;
   }

   public void setTipoId(String tipoId) {
      this.tipoId = tipoId;
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
   
   @Override
   public String toString(){
      return tipoId + " - " + super.toString();
   }
   
   public String[] toArray(){
      String cliente[] = {getTipoId(), getId(), getNombre(), getTelefono().toString()};
      return cliente;
   }
   
   // metodo para completar el registro del cliente 
    /*public static cliente completarRegistro(cliente c){
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
   }*/
}