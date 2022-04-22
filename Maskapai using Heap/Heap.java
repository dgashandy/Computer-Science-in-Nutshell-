package TugasHeap;

public class Heap {
    int nMax = 100000;
    Maskapai[] flight;
    public Heap(){
        flight = new Maskapai[nMax];
    }
    public void enqueue(Maskapai input,int i){
        if(i==0) {flight[0]=input;}
        else {
            flight[i]=input;   
            while (i>0 && flight[(i-1)/2].getQueue() < flight[i].getQueue()){
              tukar(i, (i-1)/2);
              i = (i-1)/2;
              for(int j=0;j<=i;j++){
                  if(flight[i].getQueue()==flight[j].getQueue()){
                      tukar(i,j);
                      break;
                  }
              }
            }
            
        }
    }
    public void tukar(int i, int j){
        Maskapai temp;
        temp = flight[i];
        flight[i] = flight[j];
        flight[j] = temp; 
    }
    public void maxheap(int i,int n){
     int left,right,largest;      
        left = 2*i+1;
        right = 2*i+2;
        if(left <n && flight[left].getQueue() > flight[i].getQueue())
        	largest=left; 
        else
        	largest=i;
        if(right <n && flight[right].getQueue() > flight[largest].getQueue())
        	largest=right;
        
        if(largest!=i){
            tukar(i,largest);
            maxheap(largest,n);
        }
    }
    public void removeMax(int n){
        int a;
        cetak2(0);
        flight[0] = flight[n-1];
        flight[n-1] = null;
        a=0;
        n--;
        for(int i=0;i<n;i++){
            maxheap(i,n);
        }
    
    }
    public void cetak(int n){
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.println("------------");
            System.out.println("Nama Maskapai    : "+flight[i].getNama());
            System.out.println("Kode Penerbangan : "+flight[i].getNomor());
            System.out.println("Kota Tujuan      : "+flight[i].getKota());
        }   
        System.out.println();
    }
    public void cetak2(int n){
    	System.out.println("------------");
        System.out.println("Nama Maskapai    : "+flight[n].getNama());
        System.out.println("Kode Penerbangan : "+flight[n].getNomor());
        System.out.println("Kota Tujuan      : "+flight[n].getKota());
    }

}

