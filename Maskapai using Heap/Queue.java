package TugasHeap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        Heap x = new Heap();
        Heap[] y ;
        Maskapai tmp  ;
        int a=0,sum=0; 
        File fileInput = new File("Data.txt");
        Scanner scan = new Scanner(System.in);
        int tmpnomer,tmpprio;
        String tmpnama,tmpkota;
        try{
            Scanner scanfile = new Scanner(fileInput);
            while(scanfile.hasNextLine()){   
                tmpnama = scanfile.nextLine();
                tmpnomer = Integer.valueOf(scanfile.nextLine());
                tmpprio = Integer.valueOf(scanfile.nextLine());
                tmpkota = scanfile.nextLine();
                tmp = new Maskapai(tmpnama, tmpnomer, tmpprio, tmpkota);
                x.enqueue(tmp, a);
                a++;
            }

            scanfile.close();
        }
        catch(FileNotFoundException error){
            System.out.print(" File not Found");
        }

        System.out.println("\n Selamat Datang Bandara Kota Mondstadt");
        System.out.println("\n Berikut adalah Data seluruh penerbangan hari ini :");
        x.cetak(a);
        System.out.println(" Seluruh Pesawat akan segera diberangkatkan");
        System.out.println();
        System.out.println(" Urutan Seluruh Penerbangan Pesawat yang ada :");
        while(a>0){
            x.removeMax(a);
            a--;
        }
        
    }
    
}
