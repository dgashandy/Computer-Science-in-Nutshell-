//Program untuk menghitung IPK/GPA berdasarkan inputan Banyak Mata Kuliah, Bobot dan SKS 
#include<iostream>
using namespace std;

struct ipk 
{
    char bobot;
    int sks;
};

float count_ipk(ipk a[], int n);

int main()
{
    int n; 
    cout << " Input Banyak (N) Mata Kuliah Yang di Ambil : ";
	cin >> n;
	cout <<endl;
    ipk bobots[n];
    
    for(int i=0;i<n;i++){
        cout << " Input Bobot dari Mata Kuliah Ke-"<<i+1<<" : ";
		cin >> bobots[i].bobot;
        cout << " Input SKS dari Mata Kuliah Ke-"<<i+1<<" : ";
		cin >> bobots[i].sks;
        bobots[i].bobot = toupper(bobots[i].bobot);
    }
    
	cout <<endl;
    cout << " IPK = " << count_ipk(bobots, n) << endl;
}

float count_ipk(ipk a[], int n){

    float total = 0;
    float totalSKS = 0;
    
    for(int i=0;i<n;i++)
    {
        switch(a[i].bobot){
            case 'A':
                total += 4*a[i].sks;
                break;
            case 'B':
                total += 3*a[i].sks;
                break;
            case 'C':
                total += 2*a[i].sks;
                break;
            case 'D':
                total += a[i].sks;
        }
        totalSKS += a[i].sks; 
    }
    float ipk = total/totalSKS;
    
    return ipk;
}
