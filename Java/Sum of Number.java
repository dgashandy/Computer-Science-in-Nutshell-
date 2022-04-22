package prakjava2;

import java.util.Scanner;

public class SumOfNumber {

	public static void main(String[] args) {
		int size;
		int sum = 0;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Masukkan Panjang Array: ");
		size = in.nextInt(); //Masukkan panjang array
		
		int[] arr = new int[size];
		for (int j=0; j<size; j++) {
			System.out.print("Masukkan Angka ke-" + (j+1) +" :" );
			arr[j] = in.nextInt(); //Masukkan elemen array
		}
		for (int i=0; i<size; i++)
			sum += arr[i]; //Menjumlahkan array
		
		System.out.println("Jumlah elemen array : " + sum); //Output jumlah seluruh elemen array
		}
	}


