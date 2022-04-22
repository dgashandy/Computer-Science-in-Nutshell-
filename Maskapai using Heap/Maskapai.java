package TugasHeap;

public class Maskapai{
    private int nomor, queue;
    private String name, city;
   
    public Maskapai(String Nama, int Nomer, int Priority, String Kota){
        this.city = Kota;
        this.name = Nama;
        this.nomor = Nomer;
        this.queue = Priority;
        
    }
    public String getNama(){
        return name;
    }
    public int getNomor(){
        return nomor;
    }
    public String getKota(){
        return city;
    }
    public int getQueue(){
        return queue;
    }
}
