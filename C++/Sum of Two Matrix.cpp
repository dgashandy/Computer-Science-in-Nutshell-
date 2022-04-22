// Program Penjumlahan Matrix Ordo 2x2
#include <iostream>
using namespace std;
int main()
{

	int i, j;
	int A[2][2], B[2][2], O[2][2];
	cout << " Penjumlahan Matriks 2x2 " << endl;
	cout << " Input Elemen matriks: " << endl;

	cout << endl;

	for (i = 0; i < 2; i++)
	{
		for (j = 0; j < 2; j++)
		{
			cout << " A"
				 << "[" << (i + 1) << "]"
				 << "[" << (j + 1) << "] = ";
			cin >> A[i][j];
		}
	}

	cout << endl;

	for (i = 0; i < 2; i++)
	{
		for (j = 0; j < 2; j++)
		{
			cout << " B"
				 << "[" << (i + 1) << "]"
				 << "[" << (j + 1) << "] = ";
			cin >> B[i][j];
		}
	}

	for (i = 0; i < 2; i++)
	{
		for (j = 0; j < 2; j++)
			O[i][j] = A[i][j] + B[i][j];
	}

	cout << endl;

	cout << " Matriks A: " << endl;
	for (i = 0; i < 2; i++)
	{
		for (j = 0; j < 2; j++)
		{
			cout << A[i][j] << "\t";
		}
		cout << endl;
	}
	cout << endl;

	cout << " Matriks B: " << endl;
	for (i = 0; i < 2; i++)
	{
		for (j = 0; j < 2; j++)
		{
			cout << B[i][j] << "\t";
		}
		cout << endl;
	}
	cout << endl;

	cout << endl;

	cout << " Hasil Penjumlahan Matriks A dan B: " << endl;
	for (i = 0; i < 2; i++)
	{
		for (j = 0; j < 2; j++)
		{
			cout << O[i][j] << "\t";
		}
		cout << endl;
	}

	return 0;
}
