import java.util.Scanner;
public class Genap {
    public static void main(String[] args) {
        int n;
        Scanner input=new Scanner(System.in);
        System.out.print("Masukan nilai n : ");
        n= input.nextInt();
        int i=1;
        while(i<=2*n){
            if(i%2==0){
                System.out.print(i+" ");
            }
            i++;
        }
        System.out.println(" ");

    }
}
