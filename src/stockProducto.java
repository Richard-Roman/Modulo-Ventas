public class stockProducto{
   producto prod;
   int stock = 0;
   
   public stockProducto(producto prod, int stock){
      setProducto(prod);
      setStock(stock);
   }
   
   public void setProducto(producto prod){
      this.prod = prod;
   }
   
   public producto getProducto(producto prod){
      return prod;
   }
   
   public void setStock(int stock){
      this.stock = stock;
   }
   
   public int getStock(){
      return stock;
   }
   
   public String toString(){
      return prod.toString() + " Stock: " + stock;
   }
   
   public void imprimir(){
      System.out.println(this.toString());
   }
   
   /// Metodo de manejo de stock
   
   public void agregar(int cantidad){
      this.stock+=cantidad;
   }
   
   public void sustraer(int cantidad){
      this.stock-=cantidad;
   }
   
}