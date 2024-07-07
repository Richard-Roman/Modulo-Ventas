import java.util.Set;

import javax.swing.JOptionPane;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import com.itextpdf.text.Chunk;
// libreria PDF
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

// OHHHH

public class gestionClientes{
   // crea una lista Set con paremetros de la clase cliente 
   private Set<cliente> registroClientes = new HashSet<>();
   cliente cl; // variable que hace referencia a la clase cliente 

   // Metodo para gestionar los clientes 
   public void gestionar(){
      int op = 0;
      do{
      System.out.println("\n---> GESTION DE CLIENTES <---");
      System.out.println("1. Registrar cliente\n2. Buscar cliente\n3. Modificar cliente\n4. Eliminar cliente\n5. Imprimir Reporte\n6. Regresar al menu principal");
      op = leer.Entero("Opcion"); // llamamos al metodo de la clase Leer y le damos parametros 
            switch(op){
               case 1: registrarCliente(); break; // llamamos al metodo para registrar un nuevo cliente 
               case 2: buscarCliente(); break; // llamamos al metodo buscar un cliente 
               case 3: menuModificar(); break;
               case 4: menuEliminarCliente(); break;
               case 5: imprimirRegistroCliente(); break;
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
            op = leer.Entero("Opcion"); // llamamos al metodo entero de la clase Leer 
            switch(op){
               case 1: System.out.println("\nRegistrando nuevo cliente");
                  cl = cliente.crearCliente(); // llamamos al metodo crear cliente de la clase cliente que devulve un objeto 

                  // comparaos si el objeto del cliente creado ya esta en la lista 
                  if(!this.estaRegistrado(cl)){ // llamamos al metodo estaregistrado y le pasamos el objeto del cliente creado
                     // si es diferente de verdadero se agrega a la lista de clientes 
                     cl = cliente.completarRegistro(cl); // enviamos el objeto para completar el registro de datos de la clase cliente 
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
   

   // metodo para ver si un objeto ya existe en la lista 
   public boolean estaRegistrado(cliente c){ // recibimos de parametros el objeto creado del cliente 
      for(cliente i: registroClientes){ // recorremos la lista de clientes que tiene objetos en si 
         if(i.esIgual(c)){ // llamamos al metodo esIgual de la clase cliente y le pasamos el objeto creado del nuevo cliente 
            return true;
         }
      }
      return false;
   }
    
   // metodo para buscar un cliente en la lista
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


   public void setCliente(cliente c){
      if(!this.estaRegistrado(c)){
         registroClientes.add(c);
         System.out.println("El cliente " + c.getNombre() + " se registro con exito");
      } else {
         System.out.println("El cliente " + c.getNombre() + " ya esta registrado\nNo se realizara ningun cambio");
      }
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
   
   // modificar un cliente 
   public void menuModificar(){
   int op = 0;
      do{
         System.out.println("\n----> MODIFICAR CLIENTE <----");
         System.out.println("\n1. Seleccionar cliente a modificar\n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nSeleccione el cliente a modificar");
               cl = cliente.crearCliente(); 
               cl = this.getCliente(cl);
               if(cl != null){
                  this.modificarCliente(cl);
                  break;
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " no esta registrado");
               }
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
         System.out.println("\n----> ELIMINAR CLIENTE <----");
         System.out.println("\n1. Seleccionar cliente a eliminar\n2. Regresar al menu anterior");
         op = leer.Entero("Opcion");
         switch(op){
            case 1: System.out.println("\nSeleccione el cliente a eliminar");
               cl = cliente.crearCliente();
               cl = this.getCliente(cl);
               if(cl != null){
                  this.eliminarCliente(cl);
                  System.out.println("\nEliminacion exitosa");
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " no esta registrado");
               }
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
            case 1: System.out.println("\nImprimiendo Registro de Clientes");
               this.imprimir();
               break;
            case 2:
               System.out.println("\nSeleccione el cliente a imprimir");
               cl = cliente.crearCliente();
               cl = this.getCliente(cl);
               if(cl != null){
                  cl.imprimir(); break;
               } else {
                  System.out.println("\nEl cliente con " + cl.getTipoId()+ ": " +cl.getId() + " no esta registrado");
               } break;
            case 3:System.out.println("\n<----- Regresando"); break;
            default: System.out.println("la opcion " + op + " no es valida"); break;          
         }
      }while(op!=3);
   }

   public void imprimirRegistroCliente() {
        String rutaArchivo = "C:\\Users\\USUARIO\\Documents\\reportes\\reporteClientes.pdf"; // Cambia esto a tu ruta deseada

        try {
            // Crear el documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));

            // Abrir el documento para escribir
            document.open();

            // Agregar cabecera con título y fecha en la misma línea
            Paragraph header = new Paragraph("Reporte de Clientes", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            header.setAlignment(Element.ALIGN_LEFT);

            Paragraph date = new Paragraph(new SimpleDateFormat("dd/MM/yyyy").format(new Date()), FontFactory.getFont(FontFactory.HELVETICA, 12));
            date.setAlignment(Element.ALIGN_RIGHT);

            // Crear una tabla para cabecera y fecha
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.addCell(createCell(header, Element.ALIGN_LEFT));
            headerTable.addCell(createCell(date, Element.ALIGN_RIGHT));
            document.add(headerTable);

            // Espacio después de la cabecera
            document.add(Chunk.NEWLINE);

            // Crear la tabla con 4 columnas
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Encabezados de la tabla
            String[] columnHeaders = {"Tipo ID", "ID", "Nombre", "Teléfono"};
            for (String headerTitle : columnHeaders) {
                PdfPCell headerCell = new PdfPCell(new Phrase(headerTitle, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(headerCell);
            }

            // Datos de la tabla
            for (cliente cliente : registroClientes) {
                table.addCell(cliente.getTipoId());
                table.addCell(String.valueOf(cliente.getId())); // Transformar a String
                table.addCell(cliente.getNombre());
                table.addCell(cliente.getTelefono().toString()); // Transformar a String
            }

            // Agregar la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();

            System.out.println("PDF creado en: " + rutaArchivo);
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para crear celdas con alineación específica
    private PdfPCell createCell(Paragraph content, int alignment) {
        PdfPCell cell = new PdfPCell(content);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(alignment);
        return cell;
    }
   

   
   public static void main(String args[]){
      gestionClientes clientes = new gestionClientes();
      clientes.gestionar();
   }
}

