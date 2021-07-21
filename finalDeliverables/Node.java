import java.io.*;
import java.util.*;

//Implement a doubly linked list.
//A doubly linked list is similar to a linked list but has both next and previous references.
//Your doubly linked list should have private instance variables for prev and next
//(and anything else you need). If you'd like you can also have one for current (the currentNode).
//Implement all methods that we implemented for the singly linked list.

public class Node{
        private String data;
        private Node next;
        private Node prev;

        public Node() {
    	     data = "";
    	     next = null;
           prev = null;
        }//default constructor

        public Node(String value) {
    	     data = value;
    	     next = null;
           prev = null;
        }//constructor(value)

        public void setData(String value) {
    	     data = value;
        }//setData

        public void setNext(Node n) {
    	     next = n;
        }//setNext

        public void setPrev(Node n){
          prev = n;
        }//setPrev

        public String getData() {
    	     return data;
        }//end getValue

        public Node getNext() {
    	     return next;
        }//getNext

        public Node getPrev(){
          return prev;
        }//getPrev

        public String toString() {
    	     return data;
        }//toString
        public void printList(){
         Node temp = this;
          while (temp!=null){
            System.out.print(temp+"->");
            temp = temp.getNext();
          }
          System.out.println("Null");
        }
    }//class Node
