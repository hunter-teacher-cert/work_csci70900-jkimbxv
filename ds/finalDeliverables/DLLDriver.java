import java.io.*;
import java.util.*;

public class DLLDriver {
    public static void main(String[] args) {
//checking new nodes for doubly linked lists
      Node zero = new Node("0");
      Node one = new Node("1");
      zero.setNext(one);
      one.setPrev(zero);
      Node two = new Node("2");
      one.setNext(two);
      two.setPrev(one);
      System.out.println(two.getPrev());

      DLL newDLL = new DLL();
      newDLL.addFront("node 4");
      newDLL.addFront("node 3");
      newDLL.addFront("node 2");
      newDLL.addFront("node 1");
      newDLL.addFront("node 0");
      newDLL.addLast("node 5");
      System.out.println((newDLL));



    }
  }
