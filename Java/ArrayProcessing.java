package prakjava2;

import java.io.IOException;
import java.util.Scanner;

public class ArrayProcessing {

	public static void main(String[] args) {
		int size;
		Scanner in = new Scanner(System.in);
		System.out.print("Masukkan jumlah dari Array : ");
		size = in.nextInt();
		
		int[] arr;
		arr = new int[size];
		for(int j=0; j<size; j++){	
			System.out.print("Input Angka Ke-" + (j+1) + " :");
			arr[j] = in.nextInt();
		}
		System.out.print("List dari Array:");
		
		for(int j=0 ; j<size; j++){
			System.out.print(arr[j]+ "," );
			System.out.print("");
		}
		int numSearch;
		System.out.print("\nInput Angka yang ingin dicari :");
		numSearch = in.nextInt();
		boolean found = false;
			for(int j=0; j<size; j++){
				if(numSearch == arr[j]){
					found = true;
					break;
				}
		}
			
		if(found)
		System.out.println(numSearch + " ditemukan");
		else
		System.out.println(numSearch + " tidak ditemukan ");
		int numToReplace;
		int numReplacing;
		
		System.out.print("Input Angka yang ingin ditukar :");
		numToReplace = in.nextInt();
		
		System.out.print("Input Angka Baru :");
		numReplacing = in.nextInt();
		for(int j=0; j<size ; j++){
			if(arr[j] == numToReplace)
				arr[j]=numReplacing;
		}
		System.out.print("List dari Array :");
		for(int j=0; j<size; j++){
			System.out.print(arr[j]+ "," );
			System.out.print("");
			}
		}
	}

	
