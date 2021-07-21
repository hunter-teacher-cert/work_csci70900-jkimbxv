import java.io.*;
import java.util.*;

//Implement a doubly linked list.
//A doubly linked list is similar to a linked list but has both next and previous references.
//Your doubly linked list should have private instance variables for prev and next
//(and anything else you need). If you'd like you can also have one for current (the current node).
//Implement all methods that we implemented for the singly linked list.

public class DoubleLlist{
    private Node front; // the front of the list
    private Node last; //end of list

    class Node {
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

    public  DoubleLlist(){
	     front = null;
       last = null;
    }

    // Add a new node containing data at the front of the list
    public void addFront(String data){
      Node newNode = new Node(data)
      newNode.setNext(front); //make new node
      front=newNode;  // point front to the new node
    }

    public void addLast(String data){
      Node newNode = new Node(data);
      newNode.setPrev(last);
      last = newNode;
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

    // returns True if there is nothing in the list
    // False otherwise
    public boolean isEmpty(){
	     return (front==null);
    }

    // returns the number of items in the list
    // Hint: look at the toString
    // to remind you how to traverse down the list
    public int length(){
      int result = 0;
      Node currNode = front;
      while (currNode != null){
        result++;
        currNode = currNode.getNext();
      }
	    return result;
    }

    // returns the item at location index;
    // returns null if there aren't enough
    // items. Starts with index 0
    public String get(int index){
	     return (getNode(index)).getData();
    }

    private Node getNode(int index){ //i added this because I was tired
      //of writing the loop out

      if (index > this.length()){
      return null;
      }
      if (index<(this.length() - index)){
        int i = 0;
        Node currNode = front;
        while (i != index){
          i++;
          currNode = currNode.getNext();
        }
        return currNode;
      }else{
        int i = this.length() -1;
        Node currNode;
        while ( i != index){
          i--;
          currNode = currNode.getPrev();
        }
      }

    }

    // sets the item at location index (starting with 0) to value.
    // only sets if the index is within range
    public void set(int index, String value){
      Node currNode = getNode(index);
      currNode.setData(value);
    }

    // insert an item before index.
    // only inserts if the index is within bounds
    public void insert(int index, String value){
      if (index > this.length()){
       throw new ArithmeticException("index out of bounds");
      }
      Node prevNode = getNode(index-1);
      Node newNode = new Node(value,prevNode.getNext());
      prevNode.setNext(newNode);
    }

    // returns the index of the first item with
    // data value key. Returns -1 if not found
    public int search(String key){
      int i = 0;
      Node currNode = front;
      while (i < this.length()){
        if (currNode.getData() == key){
          return i;
        }
        i++;
        currNode = currNode.getNext();
      }
	     return -1;
    }

    // removes the node at index.
    // does nothing if index out of bounds
    public void remove(int index){
      if (index < this.length()){
        if (index == 0){ //front edge case
            Node postNode = getNode(index+1);
            front = postNode;
        }else if (index == this.length()-1){ //end edge case
            Node preNode = getNode (index-1);
            preNode.setNext(null);
        }else{
          Node preNode = getNode(index-1);
          Node postNode = (preNode.getNext()).getNext();
          preNode.setNext(postNode);
        }
    }
    }


}
