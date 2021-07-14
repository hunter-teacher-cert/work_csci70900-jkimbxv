import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
	Node n;
	n = new Node();
	n.setData("Eduardo");


	Node n2 = new Node("Brian");
	n.setNext(n2);

	System.out.println(n);

	System.out.println(n2);

	System.out.println(n.getNext());
	n.getNext().setNext(new Node("Steph"));
	System.out.println(n.getNext());
	System.out.println(n.getNext().getNext());


// 1.Create a new  list that looks like:
//   L->"a"->"b"->"c"->"d"
	Node L = new Node("a");
  Node L2 = new Node ("b");
  L.setNext(L2); //set L's next node as L2
  Node L3 = new Node ("c");
  L2.setNext(L3); //set L2's next node as L3
  Node L4 = new Node ("d");
  L3.setNext(L4); //set L3's next node as L4

	// 2. Write the code to insert an "x"
	//    betwjkimeen the b and the c

  Node lInsert = new Node("x"); //create new node
  lInsert.setNext(L3); //set lInsert next node. toL3
  L2.setNext(lInsert); //set L2 next node to lInsert
  //checking
  System.out.println(L2.getNext());
  System.out.println((L2.getNext()).getNext());


	// 3. Write the code to delete the c
  lInsert.setNext(L4); //jump over c and connect lInsert to L4
  System.out.println(lInsert.getNext());

  L.printWholeList();

  //linked list stuff
  System.out.println();
  System.out.println("-----------Llist testing-----------");

  Llist ll = new Llist();
  ll.addFront("x");
  System.out.println(ll);

    }
}
