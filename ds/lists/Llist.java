import java.io.*;
import java.util.*;


public class Llist{
    private Node front; // the front of the list

    public  Llist(){
	     front = new Node(); //can't use getNext() without it already being a Node
    }

    // Add a new node containing data
    // at the front of the list
    public void addFront(String data){
	     // make the new node   //point it to what front points to
      Node newNode = new Node(data, front.getNext());
      front.setNext(newNode);  // point front to the new node
    }

    public String toString(){
	     Node currentNode = front;
	     String result = "";
	     while (currentNode != null){
	         result = result + currentNode+"-->";
	    // this is like i=i+1 is for arrays but for linked lists
	         currentNode = currentNode.getNext();
	      }
	     result = result+ "null";
	     return result;
    }

}
