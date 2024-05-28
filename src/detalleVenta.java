public class detalleVenta{
   int id;
   private stockProducto p;
   private int cantidad;
   private double subtotal;
   
   public detalleVenta(stockProducto p, int cantidad){
      setProducto(p);
      setCantidad(cantidad);
   }
   
   public void setId(int id){
      this.id = id;
   }
   
   public void setProducto(stockProducto p){
      this.p = p;
   }
   
   public void setCantidad(int cantidad){
      this.cantidad = cantidad;
   }
   
   public void calcularSubtotal(){
      subtotal = p.getProducto().getPrecio()*cantidad;
   }
   
   public int getId(){
      return id;
   }
   
   public stockProducto getStockProducto(){
      return p;
   }
   
   public int getCantidad(){
      return cantidad;
   }
   
   public double getSubtotal(){
      return subtotal;
   }
   
   
   ///
   public String toString(){
      return p.toString() + " - " + getCantidad() + " - " + getSubtotal(); 
   }
   
   public void imprimir(){
      System.out.println(this.toString());
   }
   
   public boolean esIgual(detalleVenta dVenta){
      if(this.getId() == dVenta.getId()){
         return this.getStockProducto().esIgual(dVenta.getStockProducto());
      } else {
         return false;
      }
   }   
}