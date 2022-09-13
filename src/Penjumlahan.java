

import java.util.Scanner;
public class Penjumlahan {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int x,y,hasil;
        System.out.println("Masukkan X : ");
        x= input.nextInt();
        System.out.println("Masukkan Y : ");
        y=input.nextInt();
        hasil=x+y;
        System.out.println("-----Hasil-----");
        System.out.println("X+Y= "+hasil);
    }
}
