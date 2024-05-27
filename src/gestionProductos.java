import java.util.Set;
import java.util.HashSet;

public class gestionProductos{
   private Set<stockProducto> registroProductos = new HashSet<>();
   private static stockProducto stockProd;
   private static producto p;
   
   public void setProducto(stockProducto sp){
      p = sp.getProducto();
      if(this.estaRegistrado(sp)){
         registroProductos.add(sp);
         System.out.println("El producto" + p.getNombre() + " se registro con exito");
      } else {
         System.out.println("El cliente " + p.getNombre() + " ta esta registrado\nNo se realizara ningun cambio");
      }
   }
   
   public boolean estaRegistrado(stockProducto sp){
      for(stockProducto i: registroProductos){
         if(i.esIgual(sp)){
            return true;
         }
      }
      return false;
   }
   
   public stockProducto getStockProducto(stockProducto sp){
      for(stockProducto i: registroProductos){
         if(i.esIgual(sp)){
            return i;
         }
      }
      return null;
   }
   
   public void eliminarStockProducto(stockProducto sp){
      p = sp.getProducto();
      if(this.estaRegistrado(sp)){
         registroProductos.remove(sp);
         System.out.println("\nEl producto " + p.getNombre() + " se elimino con exito");
      } else {
         System.out.println("\nEl producto con id: " + p.getIdProducto()+ " y nombre: " + p.getNombre() + " no esta registrado");
         System.out.println("No se realiza ningun cambio");
      }
   }
   
   public void imprimir(){
      for(stockProducto i: registroProductos){
         i.imprimir();
      }
   }
   
   /// Metodos que se encargan de presentar el menu y llamar a los demas metodos para realizar la manipulacion.
   
   public void gestionar(){
      int op = 0;
      do{
      System.out.println("\n---> GESTION DE PRODUCTOS <---");
      System.out.println("1. Registrar producto\n2. Buscar producto\n3. Modificar producto/Stock\n4. Eliminar producto\n5. Imprimir\n6. Consultas\n7. Reportes\n8. Regresar al menu principal");
      op = leer.Entero("Opcion");
            switch(op){
               case 1:registrarProducto(); break;
               case 2:menuBuscar(); break;
               case 3:menuModificar(); break;
               case 4:// menuEliminar(); break;
               case 5:// menuImprimir(); break;
               case 6:// menuConsultas(); break;
               case 7:// menuReportes(); break;
               case 8: System.out.println("\n<----- Regresando"); break;
               default: System.out.println("la opcion " + op + " no es valida"); break;
            }
      } while(op!=8);
   } 
   
   public void registrarProducto(){
      int op =0;
      do{
         System.out.println("\n----> REGISTRAR PRODUCTO <----");
         System.out.println("\n1. Iniciar registro \n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nRegistrando nuevo Producto");
               stockProd = stockProducto.crearProducto();
               if(!this.estaRegistrado(stockProd)){
                  stockProd = stockProducto.completarRegistro(stockProd);
                  registroProductos.add(stockProd);
                  p = stockProd.getProducto();
                  System.out.println("\nRegistro exitoso");
               } else {
                  System.out.println("\nProducto con codigo" + p.getIdProducto()+ " - " + p.getNombre() + " ya esta registrado");
               }
               break;
            case 2: System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;
         }
      } while(op!=2);
   }
   
   public void menuBuscar(){
      int op = 0;
      do{
         System.out.println("\n------> BUSCAR PRODUCTO <------");
         System.out.println("\n1. Iniciar Busqueda\n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1:
               System.out.println("\nSeleccione el producto a buscar");
               p = new producto(leer.Entero("Codigo del producto"));
               stockProd = new stockProducto(p);
               stockProd = this.getStockProducto(stockProd);
               if(stockProd != null){
                  p = stockProd.getProducto();
                  System.out.println("\nEl producto con codigo " +  p.getIdProducto()+ " - " + p.getNombre() + " si esta registrado");
               } else {
                  System.out.println("\nEl producto con codigo " +  p.getIdProducto()+ " no esta registrado");
               }
               break;
            case 2: System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;
         }
      }while(op!=2);
   }
   
   public void menuModificar(){
   int op = 0;
      do{
         System.out.println("\n----> MODIFICAR CLIENTE <----");
         System.out.println("\n1. Seleccionar producto a modificar\n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nSeleccione el producto a modificar");
               p = new producto(leer.Entero("Codigo del producto"));
               stockProd = new stockProducto(p);
               stockProd = this.getStockProducto(stockProd);
               if(stockProd != null){
                  this.modificarProducto(stockProd);
               } else {
                  System.out.println("\nEl producto con codigo " +  p.getIdProducto()+ " no esta registrado");
               }
               break;
            case 2:System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;          
         }
      }while(op!=2);
   }
   
   public void modificarProducto(stockProducto sp){
      stockProducto msp; producto mp;
      int op=0,id=0;
      do{System.out.println(" ");
         sp.encabezadaImprimir();
         sp.imprimir();
         System.out.println("\nModificar");
         System.out.println("\n1. Codigo del producto\n2. Nombre " + "\n3. Precio" + "\n4. Stock" + "\n5. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         mp = sp.getProducto();
         switch(op){
            case 1: System.out.println("\nModificando el codigo del producto");
               id = leer.Entero("Nuevo codigo");
               p = new producto(id);
               msp = new stockProducto(p);
               if(!this.estaRegistrado(msp)){
                  mp.setIdProducto(id);
                  System.out.println("\nModificacion exitosa");
               } else {
                  System.out.println("\nEl producto con codigo: " + msp.getProducto().getIdProducto() + " ya esta registrado");
                  System.out.println("No se realiza ningun cambio");
               };
               break;
            case 2:
               System.out.println("\nModificando el nombre del producto");
                  sp.getProducto().setNombre(leer.Cadena("Nuevo Nombre"));
               break;
            case 3: System.out.println("\nModificando el precio del producto");
                  sp.getProducto().setPrecio(leer.Decimal("Nuevo Precio"));
               break;
            case 4: modificarStock(sp);
               break;
            case 5: System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break; 
         }
      }while(op!=5);
   }
   
   public void modificarStock(stockProducto sp){
      int op=0;
      do{
         System.out.println(" ");
         sp.encabezadaImprimir();
         sp.imprimir();
         System.out.println("\nModificar Stock");
         System.out.println("\n1. Agregar existencias\n2. Disminuir Existencias " + "\n3 Establecer Stock" + "\n4. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nAgregando Existencias");
               sp.agregar(leer.Entero("Existencias"));
               break;
            case 2:
               System.out.println("\nDiminuyendo Existencias");
               sp.sustraer(leer.Entero("Existencias"));
               break;
            case 3:
               System.out.println("\nEstableciendo Stock");
               sp.setStock(leer.Entero("Existencias"));
               break;
            case 4: System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;
         }   
      }while(op!=4);
   }
   
   
   public static void main(String args[]){
      gestionProductos productos = new gestionProductos();
      productos.gestionar();
   }
   
}