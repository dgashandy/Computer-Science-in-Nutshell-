package Modul76;
 
public class Hash {
    public static int[] arrayData;
    int arraySize;
    
    public Hash(int size) {
        arraySize = size;
        arrayData = new int[size];
        for(int i = 0; i < size; i++) {
        arrayData[i] = -1;
        }
    }
    public int modMethod(int hashvalue, int sizehash) {
        int index = hashvalue%sizehash;
        return index;
    }
 
    public boolean ifArrayFull(int[] array) {
        for(int i = 0; i < arraySize; i++) {
            if (array[i] == -1) {
                return false;
            }
        }
        return true;
    }
 
    public void insert1(int key) { //linear probing
        int indexArr = modMethod(key, arraySize);
        if (ifArrayFull(arrayData)) {
            System.out.println("Array Full!");
        }
        else {
            while(arrayData[indexArr] != -1){
                indexArr += 1;
                if(indexArr == arraySize){ 
                    indexArr = 0;
                }
            }
            arrayData[indexArr] = key;
        }
    }
 
    public void insert2(int key) { //quadratic probing
        int indexArr = modMethod(key, arraySize);
        int i = 1;
        if (ifArrayFull(arrayData)) {
            System.out.println("Array Full!");
        }
        else {
            while(arrayData[indexArr] != -1){
                indexArr += i*i;
                
                if(indexArr == arraySize){
                    indexArr = 0;
                }
                else if(indexArr >= arraySize){
                    indexArr = indexArr % arraySize;
                }
                i++;
            }
            arrayData[indexArr] = key;
        }
    }
 
    public void insert3(int key) { //double hashing
        int index1 = modMethod(key, arraySize);
        int index2 = (11-(key%11))%arraySize;
        if(ifArrayFull(arrayData)){
            System.out.println("Array Full!");
        }
        else {
            int indexNext = index1;
            while(arrayData[indexNext] != -1 ){
                int i = 1;
                indexNext = index1 + (i * index2);
                if(indexNext == arraySize){
                    indexNext=0;
                }
                else if(indexNext >= arraySize){
                    indexNext = indexNext % arraySize;
                }
                i++;
            }
            arrayData[indexNext]=key;
        }
    } 
    public static void main(String[] args) {
        Hash theFunc = new Hash(29);
        theFunc.insert3(10); 
        theFunc.insert3(20);
        theFunc.insert3(30); 
        theFunc.insert3(40);
        theFunc.insert3(50); 
        theFunc.insert3(8);
        theFunc.insert3(60); 
        theFunc.insert3(15);
        theFunc.insert3(30); 
        theFunc.insert3(45);
        theFunc.insert3(11); 
        theFunc.insert3(13);
        theFunc.insert3(17); 
        theFunc.insert3(19);
        theFunc.insert3(100);
        for (int data : arrayData) {
            System.out.print(data + " ");
        }
    }
}
