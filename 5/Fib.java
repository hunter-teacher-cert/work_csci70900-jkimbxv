// Jiyoon Kim and Tiffany Wong

public class Fib {

  //your implementation of fib(n) here

  //method fib
  //conditionals to establish base cases- f(0) = 0, f(1) = 1
  //f(n) = f(n-1) + f(n-2)

  public static int fib(int n){

    //recursive definition
    /*if (n <= 1){ //for base cases f(0) = 0 and f(1) = 1
      return n;
    } else {
      return fib(n-1)+fib(n-2);
    }*/

    //alternate implementation with loop
    int i = 0; //index of current fib term
    int sum = 0;
    int sumPrev = 1;
    while(i<n){
      int temp = sum; // temp variable to store sum of n-2th term
      sum = sum + sumPrev; //adding n-1 and n-2th term
      sumPrev = temp;
      i++;
    }
    return sum;
  }


  public static void main( String[] args ) {


    System.out.println( fib(0) ); // -> 0
    System.out.println( fib(1) ); // -> 1
    System.out.println( fib(2) ); // -> 1
    System.out.println( fib(3) ); // -> 2
    System.out.println( fib(4) ); // -> 3
    System.out.println( fib(5) ); // -> 5

    //now go big:
    System.out.println( fib(10) ); // -> 55
    System.out.println( fib(20) ); // -> 6765
    System.out.println( fib(40) ); // -> 102334155
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main()


}//end class Fib
