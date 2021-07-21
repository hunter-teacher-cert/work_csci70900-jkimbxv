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
    private int size;

    public  DLL(){
      last = null;
      front = null;
      size = 0;
    }

    // Add a new node containing data at the front of the list
    public void addFront(String data){
      Node newNode = new Node(data);
      size++;
      newNode.setNext(front); //make new node
      front=newNode;  // point front to the new node
      if (size == 1){
        last = newNode;
      }else{
        (newNode.getNext()).setPrev(newNode);//creates "backward" connection
      }
    }

    public void addLast(String data){
      Node newNode = new Node(data);
      size++;
      newNode.setPrev(last);
      last = newNode;
      if(size == 1)
        front = newNode;
      else
        newNode.getPrev().setNext(newNode);
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
    public int size(){
      return this.size;
    }
/*
    // returns the number of items in the list
    public int length(){
      int result = 0;
      Node currNode = front;
      while (currNode != null){
        result++;
        currNode = currNode.getNext();
      }
	    return result;
    }*/

    // returns the item at location index;
    // returns null if there aren't enough
    // items. Starts with index 0
    public String get(int index){
	     return (getNode(index)).getData();
    }

    //gets node at a certain index via closest path (front of back)
    public Node getNode(int index){
      if (index > this.size()){
      return null;
      }
      if (index<(this.size() - index)){
        System.out.println("I indexed from the front");
        int i = 0;
        Node currNode = front;
        while (i != index){
          i++;
          currNode = currNode.getNext();
        }
        return currNode;
      }else{
        System.out.println("I indexed from the back");
        int i = this.size-1;
        Node currNode=last;
        while ( i > index){
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
      if (index > this.size()){
       throw new ArithmeticException("index out of bounds");
      }

      Node newNode = new Node(value); //to be inserted
      Node prevNode = getNode(index-1); //previous node
      Node postNode = prevNode.getNext(); //node after

      newNode.setNext(postNode); //new Node --> post Node
      postNode.setPrev(newNode); // new Node <-- post Node
      prevNode.setNext(newNode); //prev Node --> new Node
      newNode.setPrev(prevNode); //prev Node <-- new Node
      size++;
    }

    // returns the index of the first item with
    // data value key. Returns -1 if not found
    public int search(String key){
      int i = 0;
      Node currNode = front;
      while (i < this.size()){
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
      size--;
      if (index < this.size()){
        if (index == 0){ //front edge case
            Node postNode = getNode(index+1);
            front = postNode;

        }else if (index == this.size()-1){ //end edge case
            Node preNode = getNode (index-1);
            preNode.setNext(null);
        }else{
          Node preNode = getNode(index-1);
          Node postNode = (preNode.getNext()).getNext();
          preNode.setNext(postNode); //preNode --> postNode
          postNode.setPrev(preNode);//preNode <-- postNode
        }
    }
    }


}
