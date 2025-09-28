package Model;

public class beli implements jenisBeli{
    
    @Override
    public void info(){
        System.out.println("Jenis transaksi: Beli Apartemen");
    }

    @Override
    public void tampilJenis() {
        System.out.println("Selamat telah menambah unit baru untuk di beli");
    }
}
