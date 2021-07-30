//shout out to peter tsun and liam baum for helping me struggle through this
import java.io.*;
import java.util.*;

public class PhoneBook{
  private Llist[] book;

  public PhoneBook(){ //default constructor
    int size = 16;
    book = new Llist[size];
    for (int i = 0; i<size; i++){
      book[i] = new Llist();
    }
  }//end default construct
  public PhoneBook(int size){ //parameter constructor
    book = new Llist[size];
    for (int i = 0; i<size; i++){
      book[i] = new Llist();
    }
  }//end param construct

//hasKey(key) - returns True if the hash table contains key
public boolean hasKey(String key){
  for (int i = 0; i<book.length; i++){
    if (book[i].search(key)!=-1){
      return true;
    }
  }return false;
}

//get(k) - returns value of the item with key k (if present).
public String get(String key){ //phone number returned
  int index = hashing(key);
  int result = book[index].search(key); //linear search
  if (result != -1){
    return book[index].getPerson(result).getNum();
  }else{
    return "not found";
  }
}

//isEmpty() - returns true if the hash table is empty.
public boolean isEmpty(){
  for (int i = 0; i<book.length; i++){
    if (!(book[i].isEmpty())){
      return false;
    }
  }return true;
}


//put(k,v) - adds an item with key k and value v to the hash table
  public void put(String last, String first, String num){ //first param is the lastname and key
    int index = hashing(last);
    book[index].addFront(last,first,num);
  }//end put method

  public int hashing(String lastName){
    int result = 0;
    for (int i = 0; i<lastName.length(); i++){
      result += lastName.charAt(i);
    }
    return result%book.length;
  }//end hashing method

  public String toString(){
  String result = "";
    for (int i = 0; i< book.length; i++){
      result+= "Node "+i+": "+(book[i])+"\r\n";
    }
    return result;
  }
}
