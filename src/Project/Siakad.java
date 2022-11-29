package Project;
import javax.xml.crypto.dsig.SignedInfo;
import java.util.Scanner;

public class Siakad {
    static Mahasiswa[]mahasiswa=new Mahasiswa[1000];
    static int jumlahData=0;
    static Scanner input=new Scanner(System.in);
    public  void tambahData(){
        Siakad siakad=new Siakad();
        String konfirmasi;
        do{
            System.out.println("Silahkan Tambah Data");
            System.out.print("NIM : ");
            int nim=input.nextInt();
            System.out.print("Nama : ");
            String nama=input.next();
            System.out.println("isi data lagi?");
            konfirmasi=input.next();
            mahasiswa[jumlahData]=new Mahasiswa();
            mahasiswa[jumlahData].setNama(nama);
            mahasiswa[jumlahData].setNIM(nim);
            jumlahData++;

        }while (!konfirmasi.equals("n"));


    }
    public static void lihatData(){
        System.out.println("Berikut data anda");
        for(int i=0;i<jumlahData;i++){
            System.out.println(mahasiswa[i].getNim()+" "+mahasiswa[i].getNama());
        }
        System.out.println("");
    }

    public void urutkanData(){
        Siakad siakad=new Siakad();
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.print("Pilih algoritma : ");
        int searchAlgo = input.nextInt();
        switch(searchAlgo){
            case 1:{
                siakad.ExchangeSort();
                break;

            }
            case 2:{
                siakad.SelectionSort();
                break;

            }

            case 3:{
                siakad.InsertionSort();
            }
        }

    }

    public void ExchangeSort(){
        Mahasiswa temp;
        for(int i=0;i<jumlahData-1;i++){
            for(int k=i+1;k<jumlahData;k++){
                if(mahasiswa[i].getNim()>mahasiswa[k].getNim()){
                    temp=mahasiswa[i];
                    mahasiswa[i]=mahasiswa[k];
                    mahasiswa[k]=temp;

                }
            }
        }

    }

    public void SelectionSort(){
        int minIndx;
        Mahasiswa temp;
        for(int i=0;i<jumlahData-1;i++){
            minIndx=i;
            for(int j=i+1;j<jumlahData;j++){
                if(mahasiswa[j].getNim()<mahasiswa[minIndx].getNim()){
                    minIndx=j;
                }
            }
            temp=mahasiswa[i];
            mahasiswa[i]=mahasiswa[minIndx];
            mahasiswa[minIndx]=temp;

        }
    }

    public void InsertionSort(){


        for(int m=1;m<jumlahData;++m){
            Mahasiswa key=mahasiswa[m];
           int l=m-1;
           while (mahasiswa[l].getNim()> key.getNim() && l>0){
               mahasiswa[l+1]=mahasiswa[l];
               l=l-1;

           }
           mahasiswa[l+1]=key;

        }
    }

    public static void main(String[] args) {
        Siakad siakad=new Siakad();

        /*System.out.println("Menu Siakad");
        System.out.println("1. Tambah Data ");
        System.out.println("2. Lihat Data ");
        System.out.println("3. Keluar \n Pilih Menu = ");
        int menu=input.nextInt();*/
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data ");
            System.out.println("2. Lihat Data ");
            System.out.println("3. Urutkan Data");
            System.out.println("3. Keluar \n Pilih Menu = ");
            int menu=input.nextInt();
            if(menu==1){
                siakad.tambahData();

            }
            else if(menu==2){
                lihatData();
            }
            else if(menu==3){
                siakad.urutkanData();

            }

            else if(menu==4){
                break;

            }


        }while (true);
        /*switch(menu){
            case 1:
                System.out.println("Silahkan tambah data");
                break;
            case 2:
                System.out.println("Berikut data anda ");
                break;
            case 3:
            break;
        }*/
    }
}
