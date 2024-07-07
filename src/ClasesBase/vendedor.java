package ClasesBase;
public class vendedor extends persona{
   
   public vendedor(){
      
   }
   public vendedor(int id){
      super.setId(id);
   }
   public String toString(){
      return "DNI: " + super.toString();
   }
   public void imprimir(){
      System.out.println(this.toString());
   }

   public boolean esIgualVendedor(vendedor b){
      persona c = b;  
      if(this.getId() == (b.getId())){
         return super.esIgual(c);
      } else {
         return false;
      }
   }


   /*public static vendedor crearVendedor(){
      System.out.println("Ingrese los siguientes datos:");
      int id = leer.Entero("DNI ");
      vendedor nuevo = new vendedor(id); 
      return nuevo;
   }

   public static vendedor completarRegistrovVendedor(vendedor auxi){
      auxi.setNombre(leer.Cadena("Nombre"));
      auxi.setTelefono(leer.Entero("Telefono"));

   return auxi;
}*/


   
}