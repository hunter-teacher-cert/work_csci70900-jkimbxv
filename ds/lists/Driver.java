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

	//    between the b and the c

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
  System.out.println("testing addFront()");
  ll.addFront("charlie");
  ll.addFront("bravo");
  ll.addFront("alpha");
  System.out.println(ll);
  System.out.println();

  System.out.println("testing isEmpty()");
  Llist listA = new Llist();
  System.out.println(listA.isEmpty());
  System.out.println();

  System.out.println("testing length()");
  System.out.println(ll.length()); //prints 3
  System.out.println();

  System.out.println("testing get()");
  System.out.println(ll.get(2)); //prints "charlie"
  System.out.println(ll.get(1)); //prints "bravo"
  System.out.println();

  System.out.println("testing set()");
  ll.set(1,"i'm new"); //prints "alpha i'm new charlie"
  System.out.println(ll);
  System.out.println();

  System.out.println("testing insert()");
  ll.insert(1, "I've been inserted"); //"alpha, i've been inserted, i'm new, charlie"
  System.out.println(ll);
  System.out.println();

  System.out.println("testing search()");
  System.out.println(ll.search("1")); //-1
  System.out.println(ll.search("charlie")); //3
  System.out.println();

  System.out.println("testing remove()");
  ll.remove(0); //removes alpha
  System.out.println(ll);
  ll.remove(2); //removes charlie
  System.out.println(ll);
  ll.remove(10); //does nothing
  System.out.println(ll);
  System.out.println();



    }
}
