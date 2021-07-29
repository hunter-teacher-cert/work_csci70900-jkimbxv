import java.io.*;
import java.util.*;

public class Person{
  private String lastName;
  private String firstName;
  private String phoneNumber;
  private Person next;

  public Person(){
    lastName = "";
    firstName = "";
    phoneNumber = "";
    next = null;
  }
  public Person(String lN, String fN, String pN){
    lastName = lN;
    firstName = fN;
    phoneNumber = pN;
    next = null;
  }

  public String getLast(){ return lastName;}

  public String getfirst(){ return firstName;}

  public String getNum(){ return phoneNumber;}

  public Person getNext(){return next;}

  public void setLast(String lN){lastName = lN;}

  public void setFirst(String fN){firstName = fN;}

  public void setNum(String pN){phoneNumber = pN;}

  public void setNext(Person n){next = n};

  public String toString() {return lastName + ", "+firstName+": "+phoneNumber;}//toString


}
