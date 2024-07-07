package Frame;
import Panels.*;
import javax.swing.*;
import java.awt.*;
public class prueba{
   public static void main(String args[]){
      VentasPanel p = new VentasPanel();
      
            
      ModuloVentasNuevo ap = new ModuloVentasNuevo();
      ap.add(p,BorderLayout.CENTER);
      ap.setVisible(true);
      
   }
}