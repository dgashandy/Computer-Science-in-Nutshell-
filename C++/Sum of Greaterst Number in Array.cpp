#include<iostream>
using namespace std;

int main(){
	
	int a[100];
	int n;
	
	cout << " Input Jumlah Angka :";
	cin >>n;
	
	for(int i=1;i<=n;i++){
		cin >>a[i];
	}
	int max1=a[1];
	for (int j=2;j<=n;j++){
		if(a[j]>max1)
		max1=a[j];
	}
	int max2=a[1];
	for (int k=2;k<n;k++){
		if(a[k]!=max1){
			if(a[k]>max2)
			max2=a[k];
		}
	}
	int sum = max1+max2;
	
	cout << " Hasil = "<<sum;
	return 0;
}
