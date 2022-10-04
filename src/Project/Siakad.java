package Project;
import java.util.Scanner;

public class Siakad {
    public static void tambahData(){
        System.out.println("Silahkan Tambah Data");
    }
    public static void lihatData(){
        System.out.println("Berikut data anda");
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        /*System.out.println("Menu Siakad");
        System.out.println("1. Tambah Data ");
        System.out.println("2. Lihat Data ");
        System.out.println("3. Keluar \n Pilih Menu = ");
        int menu=input.nextInt();*/
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data ");
            System.out.println("2. Lihat Data ");
            System.out.println("3. Keluar \n Pilih Menu = ");
            int menu=input.nextInt();
            if(menu==1){
                tambahData();

            }
            else if(menu==2){
                lihatData();
            }
            else if(menu==3){
                break;
            }
            else{

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
