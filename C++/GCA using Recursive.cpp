//Nomor3, Program Mencari FPB 
#include<iostream>
using namespace std;

int FPB(int x, int y){
	if (y==0)
		return x;
	else return FPB(y,x%y);
 
}
int main(){
	int x, y, hasil;
 
	cout << " Input Bilangan Pertama : ";
	cin >> x;
	cout << " Input Bilangan Kedua : ";
	cin >> y;
	
	hasil = FPB(x,y);
	
	cout <<endl;
	cout << " Jadi, FPB dari "<<x<<" dan "<<y<<" = "<<hasil;

	return 0;
}
