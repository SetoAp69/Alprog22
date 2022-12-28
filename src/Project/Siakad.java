package Project;
import java.util.Scanner;

public class Siakad {
    //static Mahasiswa[]mahasiswa=new Mahasiswa[1000];
    static Mahasiswa x=new Mahasiswa("a",2);
    static Mahasiswa y=new Mahasiswa("b",4);
    static Mahasiswa s=new Mahasiswa("e",15);
    static Mahasiswa c=new Mahasiswa("n",16);
    static Mahasiswa z=new Mahasiswa("k",11);
    static Mahasiswa v=new Mahasiswa("v",3);
    static Mahasiswa[]mahasiswa={x,y,s,c,z,v};
    static int jumlahData=6;
    static boolean sorted=false;
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
            //mahasiswa[jumlahData]=new Mahasiswa();
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

    public void  cariData(){
        Siakad siakad=new Siakad();
        System.out.println("-----Cari Data------");
        System.out.println("1. Cari berdasarkan Nama (linear search)");
        System.out.println("2. Cari berdasarkan Nim (Binary Search)");
        int pil= input.nextInt();
        switch (pil){
            case 1:{
                linearSearch();
                break;
            }
            case 2:{
                System.out.println("Masukan Nim :");
                String filterValue=input.next();
                Integer indexFound=siakad.binarySearch(mahasiswa,filterValue,0,jumlahData-1);
                if(indexFound!=null){
                    System.out.println("Data yang anda cari :");
                    System.out.println("Nim : "+mahasiswa[indexFound].getNim());
                    System.out.println("Nama : "+mahasiswa[indexFound].getNama()+"\n");
                }
                else{
                    System.out.println("Data tidak ditemukan");
                }

                break;
            }
        }
    }

    public void urutkanData(){
        Siakad siakad=new Siakad();
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Bubble Sort");
        System.out.println("5. Shell Sort");
        System.out.println("6. Quick Sort");
        System.out.print ("Pilih algoritma : ");
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

            case 4:{

                siakad.bubbleSort();
                break;
            }
            case 5:{
                siakad.shellSort();
                break;
            }
            case 6:{
                quickSort(mahasiswa,0,jumlahData-1);
            }
        }

    }
    static void quickSort(Mahasiswa arr[],int low, int high){

        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
        sorted=true;
    }
    static int partition(Mahasiswa arr[],int low,int high){
        int pivot=arr[high].getNim();
        int i=(low-1);
        Mahasiswa temp;
        for(int j=low;j<=high-1;j++){
            if(mahasiswa[j].getNim()<pivot){
                i++;
                temp=mahasiswa[j];
                mahasiswa[j]=mahasiswa[i];
                mahasiswa[i]=temp;

            }
        }
        temp=mahasiswa[i+1];
        mahasiswa[i+1]=mahasiswa[high];
        mahasiswa[high]=temp;
        return (i+1);
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
        sorted=true;


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
        sorted=true;

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
        sorted=true;

    }
    public void bubbleSort(){
        boolean noSwap;
        Mahasiswa temp;
        for(int i=jumlahData;i>0;i--){
            noSwap=true;
            for(int j=0;j<i-1;j++){
                if(mahasiswa[j].getNim()>mahasiswa[j+1].getNim()){
                    temp=mahasiswa[j];
                    mahasiswa[j]=mahasiswa[j+1];
                    mahasiswa[j+1]=temp;
                    noSwap=false;
                }

            }
            if(noSwap) break;
        }
        sorted=true;

    }

    public void shellSort(){
        int juml=jumlahData-1;
        int gap=juml/2;
        boolean swap =true;
        Mahasiswa temp;
        while(gap>0){
            swap=true;
            while(swap==true){
                swap=false;
                for(int i=0;i<=(juml-gap);i++){
                    if(mahasiswa[i].getNim()>mahasiswa[i+gap].getNim()){
                        temp=mahasiswa[i];
                        mahasiswa[i]=mahasiswa[i+gap];
                        mahasiswa[i+gap]=temp;
                        swap=true;
                    }
                }
            }
            gap=gap/2;

        }
        sorted=true;


    }

    static void binaryInsertionSort(){

    }
    public static void linearSearch(){
        System.out.println("Masukkan Nama/NIM : ");
        String filterValue=input.next();
        boolean found=false;
        for(int i=0; i<jumlahData; i++){
            String temp=mahasiswa[i].getNama();
            int temp1=mahasiswa[i].getNim();
            if(filterValue.equals(temp)){
                System.out.println("Data yang anda cari :");
                System.out.println("Nim : "+temp1);
                System.out.println("Nama : "+temp+"\n");
                found=true;
            }



        }
        if(!found){
            System.out.println("Data tidak ditemukan! Masukan kata kunci lain");
        }

    }

    public static Integer binarySearch(Mahasiswa []arr,String filterValue, int low, int high){
        if(!sorted){
            quickSort(mahasiswa,0,jumlahData-1);
        }
        if (low>high){

            return null;
        }

        else {
            int mid=(low+high)/2;
            if(Integer.valueOf(filterValue)==arr[mid].getNim()){

                return mid;
            }
            else if(Integer.valueOf(filterValue)>arr[mid].getNim()){
                return binarySearch(mahasiswa,filterValue,mid+1,high);

            }
            else{
               return binarySearch(mahasiswa,filterValue,low,mid-1);
            }
        }





    }
    static void editNama(Mahasiswa mahasiswa){
        System.out.println("---Edit Nama---");
        System.out.println("Nim : "+mahasiswa.getNim());
        System.out.println("Nama : "+ mahasiswa.getNama());
    }
    static void editNim(Mahasiswa mahasiswa){
        System.out.println("---Edit Nim---");
        System.out.println("Nim : "+mahasiswa.getNim());
        System.out.println("Nama : "+ mahasiswa.getNama());
    }
    public static void editData(){
        System.out.println("-----Edit Data-----");
        System.out.println("Cari Data yang akan diubah ");
        System.out.println("Masukan Nim :");
        String filter= input.next();
        Integer toBeEdited=binarySearch(mahasiswa,filter,0,jumlahData-1);

        if(toBeEdited!=null){
            System.out.println("-----Pilihan Edit-----");
            System.out.println("1. Edit nama");
            System.out.println("2. Edit Nim");
            System.out.println("3. Hapus Data");

            int pilEdit= input.nextInt();
            switch (pilEdit){
                case 1:{
                    editNama(mahasiswa[toBeEdited]);
                    break;
                }
                case 2:{
                    editNim(mahasiswa[toBeEdited]);
                    break;
                }
                case 3:{
                    hapusData(mahasiswa[toBeEdited]);
                }
            }
        }
        else{
            System.out.println("Data tidak ditemukan");
        }



    }
    public static void hapusData(Mahasiswa mahasiswa){
        System.out.println("Nama : "+mahasiswa.getNama());
        System.out.println("Nim : "+mahasiswa.getNim());
        System.out.println("Hapus Data ini? y/n");
        String pil= input.next();
        if(pil.equalsIgnoreCase("y")){
            System.out.println("Data Terhapus!");
        }
        else{

        }
    }


    public static void menu(){
        do {
            Siakad siakad=new Siakad();
            System.out.println("\n "+mahasiswa[3].getNim()+" "+ mahasiswa[3].getNama());
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data ");
            System.out.println("2. Lihat Data ");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit atau Hapus Data");
            int menu=input.nextInt();
            switch (menu){
                case 1: {
                    siakad.tambahData();
                    break;
                }
                case 2:{
                    lihatData();
                    break;
                }
                case 3:{
                    siakad.urutkanData();
                    break;
                }
                case 4:{
                    siakad.cariData();
                    break;
                }
                case 5:{
                    editData();
                    break;
                }
                case 6:{

                }

            }



        }while (true);
    }

    public static void main(String[] args) {
        menu();

        /*System.out.println("Menu Siakad");
        System.out.println("1. Tambah Data ");
        System.out.println("2. Lihat Data ");
        System.out.println("3. Keluar \n Pilih Menu = ");
        int menu=input.nextInt();*/

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
