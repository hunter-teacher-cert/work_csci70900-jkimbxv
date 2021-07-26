import java.io.*;
import java.util.*;


public class Driver {
	public static void main(String[] args) {
		BSTree t = new BSTree();
/*
		t.seed();
		int value;

		value = t.search(10);
		System.out.println(value);

		value = t.search(15);
		System.out.println(value);

		try {
			value = t.search(17);
			System.out.println(value);
		} catch (NullPointerException e) {
			System.out.println("17 not in tree");
		}*/
		t.insert(10);
		t.insert(20);
		t.insert(5);
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.insert(2);
		//t.insert(4);
		t.insert(25);
		/*
		System.out.println("top down print");
		t.traverse(); //top down print
		System.out.println();
		System.out.println("bottom up print");
		t.traverse2(); //bottom up print
		System.out.println();*/

		System.out.println("middle print");
		t.traverse3(); //middle  print, in numeric order
		System.out.println();

		t.delete(10);
		t.traverse3();
		System.out.println();
		System.out.println(t.getRoot());


	}
}
