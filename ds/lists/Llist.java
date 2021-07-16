import java.io.*;
import java.util.*;


public class Llist{
    private Node front; // the front of the list

    public  Llist(){
	     front = null; //can't use getNext() without it already being a Node
    }

    // Add a new node containing data
    // at the front of the list
    public void addFront(String data){
	     // make the new node   //point it to what front points to
      Node newNode = new Node(data, front);
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

    private Node getNode(int index){ //i added this because I was tired of writing the loop out
      if (index > this.length()){
      return null;
      }
      int i = 0;
      Node currNode = front;
      while (i != index){
        i++;
        currNode = currNode.getNext();
      }
      return currNode;
    }

    // sets the item at location index (starting
    // with 0) to value.
    // only sets if the index is within range
    public void set(int index, String value){
      Node currNode = getNode(index);
      currNode.setData(value);
    }

    // insert an item before index.
    // only inserts if the index is within bounds
    // Hint: look at toString for hints on
    // traversal and draw out a diagram.
    // You will need a variable that refers to
    // the node BEFORE you want to do the insertion.
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
