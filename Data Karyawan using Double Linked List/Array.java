package PRG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Array {
	 private Karyawan[] isi;
	 private int length = 0;

	    public Array(Karyawan[] arr) {
	        isi = Arrays.copyOf(arr, 100);
	        length = arr.length;
	    }

	    public void setLength(int length) {
	        this.length = length;
	    }

	    public int getLength() {
	        return length;
	    }
	    
	    private int moveUp(int index) {
	        int i = getLength() - 1;
	        while (i >= index) {
	            isi[i + 1] = isi[i];
	            --i;
	        }
	        return i;
	    }
	    private int moveDown(int index) {
	        int i = index;
	        while (i <= getLength() - 1) {
	            isi[i] = isi[i + 1];
	            ++i;
	        }
	        return i;
	    }
	    public int find(int nomor) {
	        int first = 0;
	        int last = getLength() - 1;
	        int mid = (first + last) / 2;
	        while (first <= last) {
	            if (isi[mid].NIP < nomor) {
	                first = mid + 1;
	            } else if (isi[mid].NIP == nomor) {
	                break;
	            } else {
	                last = mid - 1;
	            }
	            mid = (first + last) / 2;
	        }
	        if (first > last) {
	            return -1;
	        }
	        return mid;
	    }
	    public void insert(Karyawan karyawan) {
	        int index = find(karyawan.NIP);
	        if (index != -1) {
	            int indexArray = moveUp(index);
	            isi[indexArray + 1] = karyawan;
	        } else {
	            if (isi[getLength() - 1].NIP < karyawan.NIP) {
	                isi[getLength()] = karyawan;
	            } else {
	                int moveIndex = 0;
	                for (int i = 0; i < getLength(); ++i) {
	                    if (isi[i].NIP > karyawan.NIP) {
	                        moveIndex = i;
	                        break;
	                    }
	                }
	                moveUp(moveIndex);
	                isi[moveIndex] = karyawan;
	            }
	        }
	        setLength(getLength() + 1);
	    }

	    public void delete(int nip) {
	        int indeks = find(nip);
	        if (indeks == -1) {
	            System.out.println("Tidak Ditemukan");
	        }
	        if (indeks != getLength() - 1) {
	            moveDown(indeks);
	        }
	        setLength(getLength() - 1);
	    }
	    public void display() {
	        for (int i = 0; i < getLength(); ++i) {
	            System.out.println(isi[i].nama + "\t" + isi[i].NIP + "\t" + isi[i].masaKerja + "\t" + isi[i].gaji);
	        }
	    }
	    public void UpdateGaji(int gajii, int nip) {
	        int indeks = find(nip);
	        if (indeks != -1) {
	            isi[indeks].gaji = gajii;
	        }
	    }
	    public void UpdateMasaKerja(int durasii, int nip) {
	        int indeks = find(nip);
	        if (indeks != -1) {
	            isi[indeks].masaKerja = durasii;
	        }
	    }
	    public int GetTotalGaji() {
	        int total = 0;
	        for (int i = 0; i < getLength(); ++i) {
	            total += isi[i].gaji;
	        }
	        return total;
	    }
	    public void writeFile() {
	        File databaru =  new File("list2.txt");
	        try
	        {
	            FileWriter filewrite = new FileWriter(databaru);
	            filewrite.write("Daftar Karyawan Baru: \n");
	            for(int x = 0; x < getLength(); x++){
	                String baruNama = isi[x].nama;
	                int baruNIP = isi[x].NIP;
	                int barumasaKerja = isi[x].masaKerja;
	                int barugaji = isi[x].gaji;
	                filewrite.write(baruNama+"\t"+baruNIP+"\t"+barumasaKerja+"\t"+barugaji +"\n");
	            }
	            filewrite.close();
	            System.out.println("Data Tersimpan.");
	        }
	        catch(IOException e) {
	            System.out.println("Error: "+ e.getMessage());
	        }
	    }
	}
