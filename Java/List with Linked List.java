package prakjava;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LindkeListClass {

	public static void main(String[] args) {
		LinkedList theList1 = new LinkedList();
		LinkedList theList2 = new LinkedList();
		
		Scanner in = new Scanner(System.in);
		int nodeNum1;
		int nodeNum2;
		int tempNum;
		
		System.out.print("First List Size : ");
		nodeNum1 = in.nextInt();
		
		for(int i=0; i<nodeNum1; i++){
			System.out.print("Insert number " + (i+1) + " :");
			tempNum = in.nextInt();
			theList1.addLast(tempNum);
		}
		System.out.println(theList1);
		
		System.out.print("Second list size : ");
		nodeNum2 = in.nextInt();
		
		for(int i=0; i<nodeNum2; i++){
			System.out.print("Insert number " + (i+1) + " :");
			tempNum = in.nextInt();
			theList2.addFirst(tempNum);
		}
		
		System.out.println(theList2);
		
		System.out.println("\nDeleting first node of first list");
		theList1.removeFirst();
		System.out.println(theList1);
		
		System.out.println("\nDeleting last node of second list");
		theList2.removeLast();
		System.out.println(theList2);
		}
		

	}


