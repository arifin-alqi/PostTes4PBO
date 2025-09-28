package Model;

public class jualApartemen extends dataApartemen {
    private int hargaJual;

    // constructor dengan furniture
    public jualApartemen(int id, String tipe, int luas, String status, String furniture, int hargaJual) {
        super(id, tipe, luas, status, furniture);
        this.hargaJual = hargaJual;
    }

    // overloading constructor tanpa furniture
    public jualApartemen(int id, String tipe, int luas, String status, int hargaJual) {
        super(id, tipe, luas, status);
        this.hargaJual = hargaJual;
    }

    public int getHargaJual() { return hargaJual; }
    public void setHargaJual(int hargaJual) { this.hargaJual = hargaJual; }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println(" Harga Jual Unit: Rp " + hargaJual + " Juta");
        System.out.println("=====================================");
    }
}
