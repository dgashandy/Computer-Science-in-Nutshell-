//Program Pembalik Angka dengan Rekursif
#include<iostream>
using namespace std;

void num2(int num1){
	
	int n2 = 0;
	
	if(num1!=0){
		n2 = (n2*10)+(num1%10);
		num1 = num1/10;
		cout << n2;
		num2(num1);
	}
}

int main(){
	
	int n1;
 
	cout << " Input Bilangan : ";
	cin >> n1;
	cout <<endl;
	cout << " Bilangan(Dibalik) : " ;
	
	num2(n1);
return 0; 
}
