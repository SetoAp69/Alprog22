import java.util.Scanner;
public class bintang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Masukan n : ");
        n= input.nextInt();
        for(int i=0;i<n;i++){
            for(int j=i;j<n-1;j++){
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
