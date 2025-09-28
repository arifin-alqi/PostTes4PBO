package Model;

public class sewaApartemen extends dataApartemen {
    private int hargaSewa;

    // constructor dengan furniture
    public sewaApartemen(int id, String tipe, int luas, String status, String furniture, int hargaSewa) {
        super(id, tipe, luas, status, furniture);
        this.hargaSewa = hargaSewa;
    }

    // overloading constructor tanpa furniture
    public sewaApartemen(int id, String tipe, int luas, String status, int hargaSewa) {
        super(id, tipe, luas, status);
        this.hargaSewa = hargaSewa;
    }

    public int getHargaSewa() { return hargaSewa; }
    public void setHargaSewa(int hargaSewa) { this.hargaSewa = hargaSewa; }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println(" Harga Sewa Unit: Rp " + hargaSewa + " Juta");
        System.out.println("=====================================");
    }
}
