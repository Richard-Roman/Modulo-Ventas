import java.util.Set;
import java.util.HashSet;

public class gestionClientes{
   private Set<cliente> registroClientes = new HashSet<>();
   cliente cl;
   public void setCliente(cliente c){
      if(this.estaRegistrado(c)){
         registroClientes.add(c);
         System.out.println("El cliente " + c.getNombre() + " se registro con exito");
      } else {
         System.out.println("El cliente " + c.getNombre() + " ta esta registrado\nNo se realizara ningun cambio");
      }
   }
   
   public boolean estaRegistrado(cliente c){
      for(cliente i: registroClientes){
         if(i.esIgual(c)){
            return true;
         }
      }
      return false;
   }
   
   public cliente getCliente(cliente c){
      for(cliente i: registroClientes){
         if(i.esIgual(c)){
            return i;
         }
      }
      return null;
   }
   
   public void eliminarCliente(cliente c){
      if(this.estaRegistrado(c)){
         registroClientes.remove(c);
         System.out.println("\nEl cliente " + c.getNombre() + " se elimino con exito");
      } else {
         System.out.println("\nEl cliente con " + c.getTipoId()+ ": " +c.getId() + " no esta registrado");
         System.out.println("No se realiza ningun cambio");
      }  
   }
   
   public void imprimir(){
      for(cliente i: registroClientes){
         i.imprimir();
      }
   }
   
   public void gestionarRegistro(){
      int op = 0;
      do{
      System.out.println("\n---> GESTION DE CLIENTES <---");
      System.out.println("1. Registrar cliente\n2. Buscar cliente\n3. Modificar cliente\n4. Eliminar cliente\n5. Imprimir\n6. Regresar al menu principal");
      op = leer.Entero("Opcion");
            switch(op){
               case 1: registrarCliente(); break;
               case 2: buscarCliente(); break;
               case 3: menuModificar(); break;
               case 4: menuEliminarCliente(); break;
               case 5: menuImprimir(); break;
               case 6: System.out.println("\n<----- Regresando"); break;
               default: System.out.println("la opcion " + op + " no es valida"); break;
            }
      } while(op!=6);
   }
   
   private void registrarCliente(){
   int op = 0;
      do{
         System.out.println("\n----> REGISTRAR CLIENTE <----");
         System.out.println("\n1. Iniciar registro \n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nRegistrando nuevo cliente");
               cl = cliente.crearCliente();
               if(!this.estaRegistrado(cl)){
                  cl = cliente.completarRegistro(cl);
                  registroClientes.add(cl);
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
   int op = 0;
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
   int op = 0;
      do{
         System.out.println("\n----> MODIFICAR CLIENTE <----\n");
         System.out.println("\n1. Seleccionar cliente a modificar\n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nSeleccione el cliente a modficar");
               cl = cliente.crearCliente();
               cl = this.getCliente(cl);
               this.modificarCliente(cl);
               break;
            case 2:System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;          
         }
      }while(op!=2);
   }
     
   public void modificarCliente(cliente c){
   int op = 0, id=0; String tipoId;
      do{System.out.println(" ");
         c.imprimir();
         System.out.println("\nModificar");
         System.out.println("\n1. Tipo de Identificacion\n2. Numero de " + c.getTipoId()+ "\n3. Nombre / Razon Social" + "\n4. Telefono" + "\n5. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nModificando tipo de intificacion");
               tipoId = leer.Cadena("Tipo de identificacion");
               cl = new cliente(tipoId, c.getId());
               if(!this.estaRegistrado(cl)){
                  c.setTipoId(tipoId.toUpperCase());
                  System.out.println("\nModificacion exitosa");
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " ya esta registrado");
                  System.out.println("No se realiza ningun cambio");
               };
               break;
            case 2:
               System.out.println("\nModificando numero de identificacion");
               id = leer.Entero("Numero de " + c.getTipoId());
               cl  = new cliente(c.getTipoId(), id);
               if(!this.estaRegistrado(cl)){
                  c.setId(id);
                  System.out.println("\nModificacion exitosa");
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " ya esta registrado");
                  System.out.println("No se realiza ningun cambio");
               };
               break;
            case 3: System.out.println("\nModificando nombre/Razon Social");
               if(c.tieneRuc()){
                  c.setNombre(leer.Cadena("Razon Social"));
               } else {
                  c.setNombre(leer.Cadena("Nombre"));
               }
               break;
            case 4:
               System.out.println("\nModificando Telefono");
               c.setTelefono(leer.Entero("Telefono"));
               break;
            case 5: System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break; 
         }
      }while(op!=5);   
   }
   
   public void menuEliminarCliente(){
   int op = 0;
      do{
         System.out.println("\n----> ELIMINAR CLIENTE <----\n");
         System.out.println("\n1. Seleccionar cliente a eliminar\n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nSeleccione el cliente a eliminar");
               cl = cliente.crearCliente();
               cl = this.getCliente(cl);
               this.eliminarCliente(cl);
               break;
            case 2:System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;          
         }
      }while(op!=2); 
   }
   
   public void menuImprimir(){
   int op = 0;
      do{
         System.out.println("\n----> IMPRIMIR <----");
         System.out.println("\n1. Imprimir todo\n2. Imprimir un cliente\n3. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\n Imprimiendo Registro de Clientes");
               this.imprimir();
               break;
            case 2:
               System.out.println("\nSeleccione el cliente a eliminar");
               cl = cliente.crearCliente();
               cl = this.getCliente(cl);
               if(cl == null){
                  cl.imprimir(); break;
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " no esta registrado");
               }
            case 3:System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;          
         }
      }while(op!=3);
   }
   
   public static void main(String args[]){
      gestionClientes clientes = new gestionClientes();
      clientes.gestionarRegistro();
   }
}