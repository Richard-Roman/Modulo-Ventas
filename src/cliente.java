public class cliente {
   private int id;
   private String tipoId;
   private String nombre;
   private String razonSocial;
   private int telefono = 0;

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
    
   public void setTelefono(int telefono) {
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
   
   public int getTelefono() {
       return telefono;
   }
   
   public String nombre(){
      if(this.tieneRuc()){
         return this.getRazonSocial();
      } else{
         return this.getNombre();
      }
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
   
   public void imprimir(){
      System.out.println(this.toString());
   }
   
   public static boolean esIgual(cliente a, cliente b){
      if(a.getId() == b.getId() && a.getTipoId().equalsIgnoreCase(b.getTipoId())){
         return true;
      } else {
         return false;
      }
   }
   
   private boolean tieneRuc(){
      if(this.getTipoId().equalsIgnoreCase("ruc")){
         return true;
      } else {
         return  false;
      }
   }
   
   public static cliente completarRegistro(cliente c){
         while(c.estaLleno()!=0){
            switch(c.estaLleno()){
               case 1: if(c.tieneRuc()){
                     c.setRazonSocial(leer.Cadena("Razon social")); 
                  } else{
                     c.setRazonSocial(leer.Cadena("Nombre"));
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
      cliente c = new cliente(id, tipoId);
      return c;
   }
   
   public int estaLleno(){
      if(razonSocial == null || razonSocial == null){
         return 1;
      } else if (telefono == 0){
         return 2;
      } else {
         return 0;
      }
   }
}
   