package PRG;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TugasArray {

	public static void main(String[] args) {
		File fileinput = new File("list1.txt");
        try
        {
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.head = null;
            Dll.tail = null;
            
            Karyawan[] x = new Karyawan[10];
            Scanner scanfile = new Scanner(fileinput);
            while (scanfile.hasNextLine())
            {
                Node dDaftar = new Node();
                dDaftar.nama = scanfile.nextLine();
                dDaftar.NIP = Integer.valueOf(scanfile.nextLine());
                dDaftar.masaKerja = Integer.valueOf(scanfile.nextLine());
                dDaftar.gaji = Integer.valueOf(scanfile.nextLine());

                dDaftar.prev = null;
                dDaftar.next = null;
                Dll.insertSorted(dDaftar);

            }

            Dll.pindahToArray(x);

            Array hasil = new Array(x);


            System.out.println("\nData setelah diurutkan:");
            hasil.display();

            Karyawan baru = new Karyawan("Pudi", 202242, 10, 16500 );
            hasil.insert(baru);
            System.out.println("\nMemasukan data karyawan baru. Data urutan baru: ");
            hasil.display();

            System.out.println("\nInput NIP yang akan dihapus: ");
            Scanner myScanner = new Scanner(System.in);
            int d = myScanner.nextInt();
            hasil.delete(d);
            System.out.println("\nData setelah dihapus: ");
            hasil.display();
 
            System.out.println("\nMasukan NIP yang akan diubah gajinya: ");
            int NIP = myScanner.nextInt();
            System.out.println("Input Gaji baru: ");
            int gaji = myScanner.nextInt();
            System.out.println("\nData setelah diganti: ");
            hasil.UpdateGaji(gaji, NIP);
            hasil.display();

            System.out.println("\nInput NIP yang akan diubah masa kerjanya:");
            NIP= myScanner.nextInt();
            System.out.println("Input Masa kerja baru:");
            int masaKerja = myScanner.nextInt();
            System.out.println("\nData Setelah diubah: ");
            hasil.UpdateMasaKerja(masaKerja, NIP);
            hasil.display();

            System.out.println("\nTotal gaji karyawan sekarang :");
            System.out.println(hasil.GetTotalGaji());

            System.out.println("\nTunggu Data akan tersimpan.");
            hasil.writeFile();
        }
        catch (FileNotFoundException error) {
            System.out.println("File tidak ditemukan");
        }
    }
}

	


