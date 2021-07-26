import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
	     root = null;
    }

    public int search(int key){
      //how efficient is this? log n if tree is full & balanced
	      TreeNode current = root;
        boolean isFound = false;
      	while (!isFound){
      	    int currentValue = current.getData();
      	    if (currentValue == key){
              isFound = true;
              return currentValue;
      	    } else if (key < currentValue){
              current = current.getLeft();
      	    } else {
              current = current.getRight();
      		  }
      	}
      	// do we really want to return -1? not really. probably give a null pointer exception
        throw new NullPointerException("key not found");
    }

    public void insert(int key){ // O(lg n)
        TreeNode newNode = new TreeNode(key); //to be inserted

        if (root == null){ //empty tree
          root = newNode; //just insert new node
          return;
        }

	      TreeNode front = root;
        TreeNode trailer= null; //piggy back

        boolean isFound = false;
      	while (front != null){
      	    int frontVal = front.getData();
      	    if (frontVal == key){
              //key already in TreeNode
              //update some node
              return;
      	    } else if (key < frontVal){
              trailer = front; //trailer points to what front used to point to
              front = front.getLeft();
      	    } else {
              trailer = front;
              front = front.getRight();
      		  }
      	}
      	//front points to Null
        //trailer points to node that goes before new newNode

        if (trailer.getData() < key){
          trailer.setRight(newNode);
        }else{
          trailer.setLeft(newNode);
        }
    }//end insert()
////////////////////////////////////////////////////////////////
    //preorder traversal
    private void traverse(TreeNode current){ //O(n)
      if (current == null){ //empty node
        return;
      }
      //do something to current node
      System.out.print(current.getData()+", ");
      //recursively print left
      traverse(current.getLeft());
      //recursively print right
      traverse(current.getRight());
    }
    public void traverse(){ //preorder traversal
      traverse(root);
      //need to be able to go in one direction and come back
      //recursion!
    }//end traverse

    //postorder traversal
    private void traverse2(TreeNode current){
      if (current == null){ //empty node
        return;
      }
      //recursively print left
      traverse2(current.getLeft());
      //recursively print right
      traverse2(current.getRight());
      //do something to current node
      System.out.print(current.getData()+", ");
    }
    public void traverse2(){
      traverse2(root);
    }//end traverse

////////////////////////////////////////////////////////////////
    //in order traversal
    private void traverse3(TreeNode current){
      if (current == null){ //empty node
        return;
      }

      //recursively print left
      traverse3(current.getLeft());

      //do something to current node
      System.out.print(current.getData()+", ");

      //recursively print right
      traverse3(current.getRight());
    }
    public void traverse3(){
      traverse3(root);
      //need to be able to go in one direction and come back
      //recursion!
    }//end traverse

    public void delete(int key){ //O(lg n)
      //need a piggy back
      //if u delete a leaf
      //u need to point the prev node to null
      //what if the node has children?? hard to delete

      //find node we want to delete
      //and node above it piggy back

      //if tree is empty
      if (root == null)
        return;

      TreeNode front = root;
      TreeNode trailer = root;

      while (front!= null && front.getData()!= key){
        if (front.getData()<key){
          trailer = front;
          front = front.getRight();
        }else{
          trailer = front;
          front = front.getLeft();
        }
      }
      //key wasn't in the tree
      if (front == null){
        return;
      }

      //front is node to be deleted
      //trailer one above

      //case 1: front is leaf repoint front's parent to null
      if (front.getLeft() == null && front.getRight()==null){
        if (front.getData() < trailer.getData()){ //node to be deleted is on left
          trailer.setLeft(null);
        }else{
          trailer.setRight(null);
        }
      }else if (front.getLeft() == null || front.getRight()==null){//check if front has 1 child
        //front is right of trailer
        if (trailer.getData()<front.getData()){ //front is right of trailer
          if(front.getLeft()==null){ //front's right child exists
            trailer.setRight(front.getRight());
          }else{
            trailer.setRight(front.getLeft());
          }
        }else{ //front is to the left of trailer
          if(front.getLeft()==null){ //front's right child exists
            trailer.setLeft(front.getRight());
          }else{
            trailer.setLeft(front.getLeft());
          }
        }
      }else{ //2 children
          TreeNode max = findMax(front.getLeft());
          //replace front with it
          this.delete(max.getData()); //this works but WHY
          front.setData(max.getData());//premax's child's data!
          if (root.getData() == key){
            root = max;
          }

      }
    }
    public int getRoot(){ return root.getData();}
    
    private TreeNode findMax(TreeNode start){
      if (start.getRight()==null){ //base case
        return start;
      }
      return findMax(start.getRight());
    }

    public void seed(){
    	TreeNode t;

    	t = new TreeNode(10);
    	root = t;
    	t = new TreeNode(5);
    	root.setLeft(t);
    	t = new TreeNode(20);
    	root.setRight(t);

    	root.getLeft().setRight( new TreeNode(8));

    	t = new TreeNode(15);
    	root.getRight().setLeft(t);

    	t = new TreeNode(22);
    	root.getRight().setRight(t);
	}
}
