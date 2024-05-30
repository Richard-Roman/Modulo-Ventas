import java.util.Scanner;
public class leer{
   private static Scanner Sc = new Scanner(System.in);
   
   public static int Entero(String txt){
      System.out.print(txt + ": ");
      int e = Sc.nextInt();
      Sc.nextLine();
      return e;
   }
   
   public static String Cadena (String txt){
      System.out.print(txt + ": ");
      String e = Sc.nextLine();
      return e;
   }
   
   public static double Decimal(String txt){
      System.out.print(txt + ": ");
      double e = Sc.nextDouble();
      return e;
   }
}