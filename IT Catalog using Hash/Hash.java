package TugasHashing;

class Node{
    int data;
    String Data1,Data2;
    Node next;
}
class Data {
    String Key;
    String Value;
    Data(String key, String Value){
        this.Key = key;
        this.Value = Value;
    }
}

class Hash {
    int maksD;
    Node[] array;
    Data [] word;
    public Hash (int n){
        word = new Data[n];
        maksD = n;
    }
    
    public void insert(Data x,int i){  
        word[i] = x;
        
    }
    int hashfunction(String Key){
        int sum = 0;
        for(int i=0;i<Key.length();i++){
            sum+=Key.codePointAt(i);
        }
        return sum%prime();
       
    }
    
    void hashing(){ 
        int Index,s=0,t;
        Node b,q;
        array=new Node[prime()];
        for(int i=0;i<prime();i++) {
            array[i] = new Node();
            array[i].data = 0;
            array[i].next=null;
        }
        for(int i=0;i<maksD;i++) {
            Index = hashfunction(word[i].Key);
            if (array[Index].data==0){
                array[Index].Data2=word[i].Value;
                array[Index].Data1=word[i].Key;
                array[Index].data = 1;
            }
            else {
                b=new Node();
                b.Data1 = word[i].Key;
                b.Data2 = word[i].Value;
                b.next=null;
                if (array[Index].next == null) {
                    array[Index].next=b;
                } 
                else {
                    q=new Node();
                    q=array[Index].next;
                    while (q.next!=null) 
                        q=q.next;
                    q.next=b;
                }          
            }
        }
        
        System.out.println();
        for (int I=0;I<prime();I++) {
            System.out.print(I+"  "+array[I].Data1+", ");
            if (array[I].Data1!=null) s++;
            if(array[I].next!=null) {
                q=array[I].next;t=2;
                while(q!=null) {s+=t;t++;
                  System.out.print(q.Data1+", "); 
                  q=q.next; 
                }   
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("rata-rata ="+(float)s/maksD);
    }
    int prime(){
      int p,N=maksD+1;
      boolean prima;
      do {
         if ((N==2)||(N==3)) prima=true;
          else if ((N%2==0)||(N<2)) prima=false;
            else{ 
              p=3;prima=true;
	      do {
	         if ((N%p)==0)  prima=false; else p=p+2;
	        }
	      while ( prima && p<=(Math.sqrt(N)+1));
            }
            if (!prima) N++;    
      }while (!prima);
     return N;
    }
    void find(String x){
        int lokasi=0,i,p,k=1;
        Node q;
        boolean ada=false;
        p=prime();
        i=hashfunction(x);
        if ((array[i].Data1 == null ? (x) == null : array[i].Data1.equals(x) )) {ada=true;lokasi=i;}
        else
        if (array[i].next!=null) {
            q=array[i].next;ada=false;
            while (q!=null &&  !ada) {
                if (q.Data1 == null ? x == null : q.Data1.equals(x)) {
                    ada=true;
                    lokasi=i;
                    k++;
                } 
                else {
                    q=q.next;
                    k++;
                }
            }
        } else ada=false;
        if (ada){ 
            System.out.println("====================================================");
            System.out.println("data ada di "+lokasi+" ke "+k);
            if(k>1){
                while(k>1){
                    array[lokasi]=array[lokasi].next;
                    k--;
                }
            }
            System.out.println(array[lokasi].Data2);
        }
        else System.out.println("data tidak ada");
    }
    
}
