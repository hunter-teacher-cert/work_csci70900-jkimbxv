import java.io.*;
import java.util.*;

public class DLLDriver {
    public static void main(String[] args) {

      DLL newDLL = new DLL();
      newDLL.addFront("node 4");
      newDLL.addFront("node 3");
      newDLL.addFront("node 2");
      newDLL.addFront("node 1");
      newDLL.addFront("node 0");
      System.out.println(newDLL.getNode(1));
      System.out.println(newDLL);
    }
  }
