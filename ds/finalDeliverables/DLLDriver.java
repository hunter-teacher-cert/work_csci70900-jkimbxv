import java.io.*;
import java.util.*;

public class DLLDriver {
    public static void main(String[] args) {
      System.out.print("Testing addFront() and addLast(): ");
      DLL newDLL = new DLL();
      /*newDLL.addFront("node 4");
      newDLL.addFront("node 3");
      newDLL.addFront("node 2");
      newDLL.addFront("node 1");
      newDLL.addFront("node 0");
      newDLL.addLast("node 5");*/

      System.out.println((newDLL)); //toString method automatically called
/*
      System.out.print("Testing isEmpty(): ");
      System.out.println((newDLL.isEmpty()));//return False

      System.out.print("Testing size(): ");
      System.out.println(newDLL.size()); //returns 5

      System.out.print("Testing get(): ");
      System.out.print(newDLL.get(0)+ " "); //node 0 front edge case
      System.out.print(newDLL.get(5)+ " ");//node 5 last edge case
      System.out.println(newDLL.get(3)+ " ");//node 3 middle case

      System.out.print("Testing set(): ");
      newDLL.set(5,"caboose");
      System.out.println(newDLL);

      System.out.print("Testing search(): ");
      System.out.println(newDLL.search("caboose")); //6


      System.out.print("Testing insert(): ");
      newDLL.insert(2,"inserted"); //middle case
      //newDLL.insert(7,"inserted"); //edge case, should throw exception
      System.out.println((newDLL));



      System.out.print("Testing remove(): ");
      newDLL.remove(2); //removes inserted
      System.out.println(newDLL);
      newDLL.remove(0); //front edge case
      System.out.println(newDLL);
      newDLL.remove(4); //back edge case
      System.out.println(newDLL);



*/




    }
  }
