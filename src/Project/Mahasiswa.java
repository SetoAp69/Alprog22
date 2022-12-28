package Project;

public class Mahasiswa {
    private String nama;
    private int nim;
    public Mahasiswa(String nama,int Nim){
        this.nama=nama;
        this.nim=Nim;
    }
    public int getNim(){
        return this.nim;
    }
    public void setNIM(int nim){
        this.nim=nim;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public String getNama(){
        return this.nama;
    }

}
