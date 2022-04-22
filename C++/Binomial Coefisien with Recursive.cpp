//Program Koefisen Binomial
#include<iostream>
using namespace std;

int binomial(int n,int k){
 
	if(n>=k){
		if(n==k||k==0){
			return 1;
	}
	else
		return binomial(n-1,k) + binomial(n-1,k-1);
	}
	else{
		cout <<endl;
		cout << " Nilai yang Anda Masukkan Salah ! Ulangi !! "<<endl;
  return 0;
	}
}
int main(){
	
	int n, k, hasil;

	cout << " Input Nilai N : ";
	cin >> n;
	cout << " Input Nilai k : ";
	cin >> k;
	
	hasil = binomial(n,k);
	cout <<endl;
	cout << " Nilai Binomial dari C("<<n<<","<<k<<") : "<<hasil;
	
return 0;
}
