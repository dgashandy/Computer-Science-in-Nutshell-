package PRG;

public class Karyawan {
	String nama;
    int NIP;
    int masaKerja;
    int gaji;
    
    public Karyawan(String nama, int NIP, int masaKerja, int gaji) {
        this.nama = nama;
        this.NIP = NIP;
        this.masaKerja = masaKerja;
        this.gaji = gaji;
    }
    public Karyawan() {
        this.nama = "0";
        this.NIP = 0;
        this.masaKerja = 0;
        this.gaji = 0;
    }

}
