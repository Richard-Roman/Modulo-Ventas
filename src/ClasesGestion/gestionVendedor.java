package ClasesGestion;

import java.util.HashSet;
import java.util.Set;
import ClasesBase.vendedor;

public class gestionVendedor {
     private Set<vendedor> registroVendedores = new HashSet<>();
     vendedor auxi; // variable que hace referencia a la clase cliente 
    // Metodo para gestionar los clientes 
   public void gestionarVendedor(){
    int op = 0;
    do{
    System.out.println("\n---> GESTION DE VENDEDORES  <---");
    System.out.println("1. Registrar Vendedor\n2. Buscar Vendedor\n3. Modificar vendedor\n4. Eliminar vendedor\n5. Imprimir vendedores\n6. Regresar al menu principal");
    op = leer.Entero("Opcion"); // llamamos al metodo de la clase Leer y le damos parametros 
          switch(op){
             case 1: registrarVendedor(); break; // llamamos al metodo para registrar un nuevo cliente 
             case 2: buscarVendedor(); break; // llamamos al metodo buscar un cliente 
             case 3: menuModificarVendedor(); break;
             case 4: menuEliminarVendedor(); break;
             case 5: menuImprimirVendedor(); break;
             case 6: System.out.println("\n<----- Regresando"); break;
             default: System.out.println("la opcion " + op + " no es valida"); break;
          }
    } while(op!=6);
 }

    private void registrarVendedor(){
    int op = 0;
       do{
          System.out.println("\n----> REGISTRAR VENDEDOR <----");
          System.out.println("\n1. Iniciar registro \n2. Regresar al menu anterior");
          op = leer.Entero("Opcion"); // llamamos al metodo entero de la clase Leer 
          switch(op){
             case 1: System.out.println("\nRegistrando nuevo VENDEDOR");
                auxi = vendedor.crearVendedor(); // llamamos al metodo crear cliente de la clase cliente que devulve un objeto 

                // comparaos si el objeto del vendedor creado ya esta en la lista 
                if(!this.estaRegistradoVendedor(auxi)){ // llamamos al metodo estaregistrado y le pasamos el objeto del cliente creado
                   // si es diferente de verdadero se agrega a la lista de clientes 
                   auxi = vendedor.completarRegistrovVendedor(auxi); // enviamos el objeto para completar el registro de datos de la clase cliente 
                   registroVendedores.add(auxi);
                   System.out.println("\nRegistro exitoso");
                } else {
                   System.out.println("\nEl vendedor con DNI" + auxi.getId() + " ya esta registrado");
                }
                break;
             case 2: System.out.println("\n<----- Regresando"); break;
             default: System.out.println("la opcion " + op + " no es valida"); break;
          }
       }while(op!=2);
    }

    public boolean estaRegistradoVendedor(vendedor auxi){ // recibimos de parametros el objeto creado del cliente 
        for(vendedor i: registroVendedores){ // recorremos la lista de clientes que tiene objetos en si 
           if(i.esIgual(auxi)){ // llamamos al metodo esIgual de la clase cliente y le pasamos el objeto creado del nuevo cliente 
              return true;
           }
        }
        return false;
     }

     private void buscarVendedor(){
        int op = 0;
        do{
           System.out.println("\n------> BUSCAR CLIENTE <------");
           System.out.println("\n1. Iniciar Busqueda\n2. Regresar al menu anterior");
           op = leer.Entero("Opcion");
           switch(op){
              case 1:
                 System.out.println("\nSeleccione el Vendedor a buscar");
                 auxi = vendedor.crearVendedor();
                 if(this.estaRegistradoVendedor(auxi)){
                    System.out.println("\nEl Vendedor con DNI: "  +auxi.getId() + " ya esta registrado");
                 } else {
                    System.out.println("\nEl Vendedor con DNI: "  +auxi.getId() + " no esta registrado");
                 }
                 break;
              case 2: System.out.println("\n<----- Regresando"); break;
              default: System.out.println("la opcion " + op + " no es valida"); break;
           }
        }while(op!=2);
     }
  

     public void menuModificarVendedor(){
        int op = 0;
           do{
              System.out.println("\n----> MODIFICAR VENDEDOR <----");
              System.out.println("\n1. Seleccionar cliente a modificar\n2. Regresar al menu anterior");
              op = leer.Entero("Opcion");
              switch(op){
                 case 1: System.out.println("\nModificando Vendedor");
                    auxi = vendedor.crearVendedor();
                    auxi = this.getVendedor(auxi); 
                    if(auxi != null){
                       this.modificarVendedor(auxi);
                       break;
                    } else {
                       System.out.println("\nEl cliente con DNI"+auxi.getId()+ "  no esta registrado");
                    }
                 case 2:System.out.println("\n<----- Regresando"); break;
                 default: System.out.println("la opcion " + op + " no es valida"); break;          
              }
           }while(op!=2);
        }

        public vendedor getVendedor(vendedor auxi){
            for(vendedor i: registroVendedores){
               if(i.esIgual(auxi)){
                  return i;
               }
            }
            return null;
         }

         public void modificarVendedor(vendedor auxi){
            int op = 0; 
               do{System.out.println(" ");
                  auxi.imprimir();
                  System.out.println("\nModificar");
                  System.out.println("\n1. Numero de DNI" + auxi.getId()+ "\n2. Nombre : " + auxi.getNombre()+ "\n3. Telefono" +auxi.getTelefono()+ "\n4. Regresar al menu anterior");
                  op = leer.Entero("Opcion");
                  switch(op){
                     
                     case 1:
                        System.out.println("\nModificando numero de DNI del vendedor");
                        auxi.setId(leer.Entero("Nuevo DNI: "));
                        System.out.println("DNI modificado con exito: ");
                        break;
                     case 2: System.out.println("\nModificando Nombre");
                        auxi.setNombre(leer.Cadena("Nuevo nombre"));
                        System.out.println("DNI modificado con exito: ");
                        break;
                     case 3:
                        System.out.println("\nModificando Telefono");
                        auxi.setTelefono(leer.Entero("Nuevo telefono"));
                        System.out.println("DNI modificado con exito: ");
                        break;
                     case 4: System.out.println("\n<----- Regresando"); break;
                     default: System.out.println("la opcion " + op + " no es valida"); break; 
                  }
               }while(op!=5);   
            }

   public void menuEliminarVendedor(){
      int op = 0;
         do{
            System.out.println("\n----> ELIMINAR VENDEDOR <----");
            System.out.println("\n1. Seleccionar Vendedor a eliminar\n2. Regresar al menu anterior");
            op = leer.Entero("Opcion");
            switch(op){
               case 1: System.out.println("\nSeleccione el Vendedor a eliminar");
                  auxi = new vendedor(); 
                  auxi = this.getVendedor(auxi);
                  if(auxi != null){
                     this.eliminarVendedor(auxi);
                     System.out.println("\nEliminacion exitosa");
                  } else {
                     System.out.println("\nEl cliente con DNI "  +auxi.getId() + " no esta registrado");
                  }
                  break;
               case 2:System.out.println("\n<----- Regresando"); break;
               default: System.out.println("la opcion " + op + " no es valida"); break;          
            }
         }while(op!=2); 
      }

      public void eliminarVendedor(vendedor c){
         if(this.estaRegistradoVendedor(c)){
            registroVendedores.remove(c);
            System.out.println("\nEl cliente " + c.getNombre() + " se elimino con exito");
         } else {
            System.out.println("\nEl cliente con DNI" +c.getId() + " no esta registrado");
            System.out.println("No se realiza ningun cambio");
         }  
      }

      public void menuImprimirVendedor(){
         int op = 0;
            do{
               System.out.println("\n----> IMPRIMIR <----");
               System.out.println("\n1. Imprimir todo las lista de vendedores\n2. Imprimir un vendedor\n3. Regresar al menu anterior");
               op = leer.Entero("Opcion");
               switch(op){
                  case 1: System.out.println("\nImprimiendo Registro de Vendedores");
                     this.imprimir();
                     break;
                  case 2:
                     System.out.println("\nSeleccione el cliente a imprimir");
                     auxi = vendedor.crearVendedor();
                     auxi = this.getVendedor(auxi);
                     if(auxi != null){
                        auxi.imprimir(); break;
                     } else {
                        System.out.println("\nEl cliente con DNI: " +auxi.getId() + " no esta registrado");
                     } break;
                  case 3:System.out.println("\n<----- Regresando"); break;
                  default: System.out.println("la opcion " + op + " no es valida"); break;          
               }
            }while(op!=3);
         }

         public void imprimir(){
            for(vendedor i: registroVendedores){
               i.imprimir();
            }
         }

            public static void main(String args[]){
               gestionVendedor nuevo = new gestionVendedor();
               nuevo.gestionarVendedor();
            }
 
}
