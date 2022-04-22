//Program Menghitung Fungsi Ackerman
#include<iostream>
using namespace std;

int ackerman(int m,int n){
	if(m==0)
  		return n+1;
	else if(m!=0 && n==0)
		return ackerman(m-1,1);
	else if(m!=0 && n!=0)
		return ackerman(m-1,ackerman(m,n-1));
  
}

int main(){
	int m, n, hasil;
 
	cout << " Input Nilai M : ";
	cin >> m;
	cout << " Input Nilai N : ";
	cin >> n;
 
	hasil = ackerman(m,n);
	
 	cout <<endl;
 	cout << " Fungsi Ackerman : "<<endl;
	cout << " m = "<<m<<endl;
	cout << " n = "<<n<<endl;
	cout << " Hasil = "<<hasil;
 
 return 0;
}
