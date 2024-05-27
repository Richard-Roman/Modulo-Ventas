public class vendedor extends persona{
   
   public vendedor(int id){
      super.setId(id);
   }
   public String toString(){
      return "DNI: " + super.toString();
   }
   public void imprimir(){
      System.out.println(this.toString());
   }
}