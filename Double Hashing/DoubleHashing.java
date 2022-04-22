package Tugas9;
 
public class DoubleHashing {
    public static int[] arrayData;
    int arraySize; 
    
    public DoubleHashing(int size) {
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
 
    public void insert(int key) {
        int index1 = modMethod((10*key+5), 23);
        int index2 = (int) 
        Math.max(Math.pow(key,455449)%23,1);
        if(ifArrayFull(arrayData)){
            System.out.println("Array Full!");
        }
        else {
            int indexNext = index1;
            int i = 1;
            while(arrayData[indexNext] != -1){
                indexNext = index2 + (i * index1)%arraySize;
                if(indexNext == arraySize){
                    indexNext=0;
                }
                else if(indexNext > arraySize){
                    indexNext = indexNext % arraySize;
                }
                i++;
            }
            arrayData[indexNext]=key;
        }
    }
 
    public static void main(String[] args) {
        DoubleHashing theFunc = new DoubleHashing(23); 
        theFunc.insert(10); 
        theFunc.insert(20);
        theFunc.insert(30); 
        theFunc.insert(40);
        theFunc.insert(50); 
        theFunc.insert(8);
        theFunc.insert(60); 
        theFunc.insert(15);
        theFunc.insert(30); 
        theFunc.insert(45);
        theFunc.insert(11); 
        theFunc.insert(13);
        theFunc.insert(17); 
        theFunc.insert(19);
        theFunc.insert(100);
        for (int data : arrayData) {
            System.out.print(data + " ");
        }
    }
}
