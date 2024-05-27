public class stockProducto{
   producto prod;
   int stock = 0;
   String unidadMedida;
   
   public stockProducto(producto prod, int stock){
      setProducto(prod);
      setStock(stock);
   }
   
   public stockProducto(producto prod){
      setProducto(prod);
   }
   
   public void setProducto(producto prod){
      this.prod = prod;
   }
   
   public producto getProducto(){
      return prod;
   }
   
   public void setStock(int stock){
      this.stock = stock;
   }
   
   public int getStock(){
      return stock;
   }
   
   public String toString(){
      return prod.toString() + stock;
   }
   
   public void encabezadaImprimir(){
      System.out.println("Id - Producto - Precio - Stock");
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
   
   /// Metodo para comparar objetos
   
   public boolean esIgual(stockProducto sp){
      if(this.getProducto().esIgual(sp.getProducto())){  
         return true;
      } else {
         return false;
      }
   }
   
   
   // Metodo staticos para crear nueovs objetos a partid de la clase
   
   public static stockProducto crearProducto(){
      producto p = producto.crearProducto();
      stockProducto sp =  new stockProducto(p);
      return sp;
   }
   
   
   public static stockProducto completarRegistro(stockProducto sp){
      producto p = sp.getProducto();
      p.setPrecio(leer.Decimal("Precio"));
      sp.setStock(leer.Entero("Stock"));
      return sp;
   }
   
}