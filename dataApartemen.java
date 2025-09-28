package Model;

public class dataApartemen {
    private int id;
    private String tipe;
    private int luas;
    private String status;
    private String furniture;

    // Constructor lengkap (dengan furniture)
    public dataApartemen(int id, String tipe, int luas, String status, String furniture) {
        this.id = id;
        this.tipe = tipe;
        this.luas = luas;
        this.status = status;
        this.furniture = furniture;
    }

    // Overloading Constructor (tanpa furniture)
    public dataApartemen(int id, String tipe, int luas, String status) {
        this.id = id;
        this.tipe = tipe;
        this.luas = luas;
        this.status = status;
        this.furniture = ""; // default kosong
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipe() { return tipe; }
    public void setTipe(String tipe) { this.tipe = tipe; }

    public int getLuas() { return luas; }
    public void setLuas(int luas) { this.luas = luas; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFurniture() { return furniture; }
    public void setFurniture(String furniture) { this.furniture = furniture; }

    // method umum
    public void tampilkanInfo() {
        System.out.println("====================================");
        System.out.println(" ID Unit : " + id);
        System.out.println(" Tipe Unit : " + tipe);
        System.out.println(" Luas Unit : " + luas + " m2");
        System.out.println(" Status Unit : " + status);

        // furniture hanya tampil kalau tidak kosong
        if (furniture != null && !furniture.isEmpty()) {
            System.out.println(" Furniture Unit : " + furniture);
        }
    }
}
