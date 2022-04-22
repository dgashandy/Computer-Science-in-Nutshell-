//Soal Nomor1
#include <iostream>
using namespace std;

int main()
{
    struct data{
       long long int NISN;
       string nama;
       int nilai;
       int jarak;
    };
  
    data Mahasiwa[] = {{60312, "Handi Ramadhan", 90, 1000}, {63959, "Rio Alfandra", 55, 6000},
                    {50310, "Ronaldo Valentino Uneputty", 80, 7500}, {70272, "Achmad Yaumil Fadjri R.", 60, 2500},
                    {70293, "Alivia Rahma Pramesti", 70, 10000}, {52382, "Ari Lutfianto", 65, 4000},
                    {65653, "Arief Budiman", 60, 2000}};
  
    cout<< "--Mengurutkan NISN dengan insertion sort--" << endl;
    int i, dataSize = sizeof(Mahasiwa)/sizeof(Mahasiwa[0]);
    long long int temp1, temp3, temp4;
    string temp2;

    for(int j=1; j<dataSize; j++){
       i = j-1;
       temp1=Mahasiwa[j].NISN;
       temp2=Mahasiwa[j].nama;
       temp3=Mahasiwa[j].nilai;
       temp4=Mahasiwa[j].jarak;
       while(Mahasiwa[i].NISN>temp1 && i>=0){
          Mahasiwa[i+1].NISN = Mahasiwa[i].NISN;
          Mahasiwa[i+1].nama = Mahasiwa[i].nama;
          Mahasiwa[i+1].nilai = Mahasiwa[i].nilai;
          Mahasiwa[i+1].jarak = Mahasiwa[i].jarak;
          i--;
       }
       Mahasiwa[i+1].NISN = temp1;
       Mahasiwa[i+1].nama = temp2;
       Mahasiwa[i+1].nilai = temp3;
       Mahasiwa[i+1].jarak = temp4;
    }
    cout<< "Urutan NISN dari yang terkeci: " << endl;
    for(int i=0; i<dataSize; i++){
       cout<< " Mahasiswa ke-" << i+1 << endl;
       cout<< " NISN  : " << Mahasiwa[i].NISN << endl;
       cout<< " Nama  : " << Mahasiwa[i].nama << endl;
       cout<< " Nilai : " << Mahasiwa[i].nilai << endl;
       cout<< " Jarak : " << Mahasiwa[i].jarak << " meter" << endl;
       cout<< endl;
    }

    return 0;
}
