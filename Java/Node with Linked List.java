package prakjava2;

import java.util.Scanner;

public class Main {
	
	public class Node {
		public int iData;
		public Node next;
	}
	
	public static void main(String[] args) {
		int nodeNum;
		int tempNum;
		
		LinkedList list = new LinkedList();
		Scanner in = new Scanner(System.in);
		System.out.print("Masukkan jumlah Nodes: ");
		nodeNum = in.nextInt();
		for (int i=0; i<nodeNum; i++) {
			System.out.print("Masukkan angka ke-" + (i+1) + " :");
			tempNum = in.nextInt();
			list.push(tempNum);
			}
		System.out.println("Jumlah elemen data : " + list.sum());
		}
	}




