import java.util.Set;
import java.util.HashSet;
public class registroClientes{
   private Set<cliente> clientes = new HashSet<>();
   private static int id;
   private static String tipoId;
   private static int op;
   private static cliente cl;
   
   public void setCliente(cliente c){
      if(this.estaRegistrado(c)){
         clientes.add(c);
         System.out.println("El cliente " + c.nombre() + " se registro con exito");
      } else {
         System.out.println("El cliente " + c.nombre() + " ta esta registrado\nNo se realizara ningun cambio");
      }
   }
   
   public boolean estaRegistrado(cliente c){
      for(cliente i: clientes){
         if(cliente.esIgual(i,c)){
            return true;
         }
      }
      return false;
   }
   
   public cliente getCliente(cliente c){
      for(cliente i: clientes){
         if(cliente.esIgual(i,c)){
            return i;
         }
      }
      return null;
   }
   
   
   public void eliminarCliente(){}
   
   public void imprimir(){}
   
   public void gestionarRegistro(){
      
      do{
      System.out.println("\n---> GESTION DE CLIENTES <---");
      System.out.println("1. Registrar cliente\n2. Buscar cliente\n3. Modificar cliente\n4. Eliminar cliente\n5. Imprimir\n6. Regresar al menu principal");
      op = leer.Entero("Opcion");
            switch(op){
               case 1: registrarCliente(); break;
               case 2: buscarCliente(); break;
               case 3: break;
               case 4: break;
               case 5: break;
               case 6: break;
               default: break;
            }
      } while(op!=6);
   }
   
   private void registrarCliente(){
      do{
         System.out.println("\n----> REGISTRAR CLIENTE <----");
         System.out.println("\n1. Iniciar registro \n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nRegistrando nuevo cliente");
               cl = cliente.crearCliente();
               if(!this.estaRegistrado(cl)){
                  cl = cliente.completarRegistro(cl);
                  clientes.add(cl);
                  System.out.println("\nRegistro exitoso");
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " ya esta registrado");
               }
               break;
            case 2: System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;
         }
      }while(op!=2);
   }
   
   private void buscarCliente(){
      do{
         System.out.println("\n------> BUSCAR CLIENTE <------");
         System.out.println("\n1. Iniciar Busqueda\n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1:
               System.out.println("\nSeleccione el cliente a buscar");
               cl = cliente.crearCliente();
               if(this.estaRegistrado(cl)){
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " si esta registrado");
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " no esta registrado");
               }
               break;
            case 2: System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;
         }
      }while(op!=2);
   }
   
   public void menuModificar(){
      do{
         System.out.println("\n----> MODIFICAR CLIENTE <----\n");
         System.out.println("\n1. Seleccionar cliente a modificar\n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nSeleccione el cliente a modficar");
               cl = cliente.crearCliente();
               cl = this.getCliente(cl);
               cl.imprimir();
               this.modificarCliente(cl);
               break;
            case 2:System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;          
         }
      }while(op!=2);
   }
   
   public static void main(String args[]){
      registroClientes clientes = new registroClientes();
      clientes.gestionarRegistro();
   }
   
   public void modificarCliente(cliente c){
      do{
         c.imprimir();
         System.out.println("\nModificar");
         System.out.println("\n1. Tipo de Identificacion\n2. Numero de " + c.getTipoId()+ "\n3. Nombre / Razon Social" + "\n4. Telefono" + "\n5. salir");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nModificando tipo de intificacion");
               tipoId = leer.Cadena("Tipo de identificacion");
               cl = new cliente(c.getId(),tipoId);
               if(!this.estaRegistrado(cl)){
                  c.setTipoId(tipoId);
                  System.out.println("\nModificacion exitosa");
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " ya esta registrado");
                  System.out.println("No se realiza ningun cambio");
               };
               break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            default: break;
         }
      }while(op!=5);   
   }
   
}