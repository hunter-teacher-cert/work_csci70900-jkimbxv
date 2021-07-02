import java.io.*;
import java.util.*;

public class Temp{
  public static void main(String[] args){
    //ch 3 exercise 2
    double cel;
    double faren;
    Scanner in = new Scanner (System.in);
    System.out.println("Temperature in Celcius: ");
    cel = in.nextFloat();
    faren = (cel * (9.0/5.0)) + 32.0;
    System.out.printf("%.1f C = %.1f F",cel,faren );
    System.out.println();

  }
}
