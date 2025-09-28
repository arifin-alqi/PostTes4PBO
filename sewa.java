package Model;

public class sewa implements jenisBeli {
    
    @Override
    public void info(){
        System.out.println("Jenis transaksi: Sewa Apartemen");
    }

    @Override
    public void tampilJenis() {
        System.out.println("Selamat telah menambah unit baru untuk di sewa");
    }
}
