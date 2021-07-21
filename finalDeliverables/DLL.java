import java.io.*;
import java.util.*;

//Implement a doubly linked list.
//A doubly linked list is similar to a linked list but has both next and previous references.
//Your doubly linked list should have private instance variables for prev and next
//(and anything else you need). If you'd like you can also have one for current (the current node).
//Implement all methods that we implemented for the singly linked list.

public class DLL{
    private Node front; // the front of the list
    private Node last; //end of list

    public  DLL(){
	     front = null;
       last = null;
    }

    // Add a new node containing data at the front of the list
    public void addFront(String data){
      Node newNode = new Node(data);
      newNode.setNext(front); //make new node
      front=newNode;  // point front to the new node
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

    // returns True if there is nothing in the list False otherwise
    public boolean isEmpty(){
	     return (front==null);
    }

    // returns the number of items in the list
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

    //gets node at a certain index via closest path (front of back)
    public Node getNode(int index){
      if (index > this.length()){
      return null;
      }
      if (index<(this.length() - index)){
        System.out.println("I indexed from the front");
        int i = 0;
        Node currNode = front;
        while (i != index){
          System.out.println(i);
          i++;
          currNode = currNode.getNext();
        }
        return currNode;
      }else{
        System.out.println("I indexed from the back");
        int i = this.length() -1;
        Node currNode=last;
        while ( i != index){
          System.out.println(i);
          i--;
          currNode = currNode.getPrev();
        }
        return currNode;
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
      Node newNode = new Node(value);
      newNode.setNext(prevNode.getNext());
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
