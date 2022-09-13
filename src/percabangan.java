import java.util.Scanner;
public class percabangan {
    public static void main(String[] args) {
        String nama, keterangan;
        int nilai;
        Scanner input=new Scanner(System.in);
        System.out.println("Masukan Nama : ");
        nama= input.next();
        System.out.println("Masukan Nilai : ");
        nilai= input.nextInt();
        if (nilai>=60){
            keterangan="Lulus";
            System.out.println(nama+" "+keterangan);

        }
        else{
            keterangan="Tidak Lulus";
            System.out.println(nama+" "+keterangan);
            //x
        }


    }
}
