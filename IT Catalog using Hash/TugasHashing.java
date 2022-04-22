package TugasHashing;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class TugasHashing {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int panjang=0,j,n;
        String tmpKey,tmpValue,a;
        Data tmpData;
        boolean lanjut=true;
        File fileInput = new File("DataKamusIT.txt");
        Hash H=new Hash(234);
        try{
            Scanner scanfile = new Scanner(fileInput);
            while(scanfile.hasNextLine()){
                tmpKey = scanfile.nextLine();
                tmpValue = scanfile.nextLine();
                tmpData = new Data(tmpKey,tmpValue);
                H.insert(tmpData, panjang);
                panjang++;
            }
            scanfile.close();
        }
        catch(FileNotFoundException error){
            System.out.print("File tidak ditemukan");
        }
        System.out.println("==================================================");
        System.out.println("        Data Kamus IT dengan Hash Tabel         ");
        System.out.println("==================================================");
        while(lanjut){
            System.out.println("==================================================");
            System.out.println("       Istilah IT dalam hash tabel :              ");
            System.out.println("==================================================");
            H.hashing();
            System.out.println("====================================================");
            System.out.print("\nmasukkan data yg dicari : ");
            a = input.nextLine();
            H.find(a);
            System.out.println("====================================================");
            System.out.print("Apakah anda ingin lanjut : (y/n)");
            boolean next=false;
            while(next==false){
                String lanjutkan;
                lanjutkan = input.next();             
                if("y".equals(lanjutkan)){
                    lanjut=true;
                    break;
                }
                else if("n".equals(lanjutkan)){
                    lanjut=false;
                    break;
                }
                else {
                    System.out.println("Perintah error, ulangi");
                    next=false;

                }
            }      
        }
    }
}
