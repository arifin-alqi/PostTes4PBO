package Service;

import Model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class sistemApartemen {
    public static ArrayList<dataApartemen> daftarUnit = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    // Tambah unit baru
// Tambah unit baru
public static void tambahUnit() {
    int id = inputAngka(input, "Masukkan ID Unit: ");
    String tipe = inputTeks(input, "Masukkan Tipe Unit: ");
    int luas = inputAngka(input, "Masukkan Luas Unit (m2): ");

    // input furniture bisa kosong
    System.out.print("Masukkan Furniture Unit (kosongkan jika tidak ada): ");
    String furniture = input.nextLine().trim();

    int pilihan = 0;
    do {
        System.out.print("Unit ini untuk (1. Sewa / 2. Jual) ? ");
        String pilihStr = input.nextLine();
        try {
            pilihan = Integer.parseInt(pilihStr);
        } catch (NumberFormatException e) {
            pilihan = -1;
        }

        switch (pilihan) {
            case 1:
                int hargaSewa = inputAngka(input, "Masukkan Harga Sewa Unit: ");
                if (furniture.isEmpty()) {
                    daftarUnit.add(new sewaApartemen(id, tipe, luas, "Tersedia", hargaSewa));
                } else {
                    daftarUnit.add(new sewaApartemen(id, tipe, luas, "Tersedia", furniture, hargaSewa));
                }
                sewa sewa = new sewa();
                sewa.info();
                sewa.tampilJenis();
                System.out.println("Unit berhasil ditambahkan!");
                return;

            case 2:
                int hargaJual = inputAngka(input, "Masukkan Harga Jual Unit: ");
                if (furniture.isEmpty()) {
                    daftarUnit.add(new jualApartemen(id, tipe, luas, "Tersedia", hargaJual));
                } else {
                    daftarUnit.add(new jualApartemen(id, tipe, luas, "Tersedia", furniture, hargaJual));
                }
                beli beli = new beli();
                beli.info();
                beli.tampilJenis();
                System.out.println("Unit berhasil ditambahkan!");
                return;

            default:
                System.out.println("Pilihan tidak valid, coba lagi!");
        }
    } while (pilihan != 2);
}


    // Menampilkan semua unit
    public static void tampilkanDaftarUnit() {
        if (daftarUnit.isEmpty()) {
            System.out.println("Belum ada unit apartemen.");
        } else {
            System.out.println("\nDaftar Unit Apartemen:");
            for (dataApartemen unit : daftarUnit) {
                unit.tampilkanInfo();
            }
        }
    }

    // Update status unit
    public static void updateStatusUnit(int id, String statusBaru) {
        for (dataApartemen unit : daftarUnit) {
            if (unit.getId() == id) {
                unit.setStatus(statusBaru);
                System.out.println("\nStatus unit dengan ID " + id + " berhasil diupdate.");
                return;
            }
        }
        System.out.println("\nUnit dengan ID " + id + " tidak ditemukan.");
    }

    // Menu update status
    public static void sistemUpdate() {
        int idUpdate = inputAngka(input, "Masukkan ID Unit yang Ingin Di Update: ");
        String statusBaru = inputTeks(input, "Masukkan status baru (Tersedia/Disewa/Terjual): ");
        updateStatusUnit(idUpdate, statusBaru);
    }

    // Hapus unit
    public static void hapusUnit() {
        int idDelete = inputAngka(input, "Masukkan ID Unit yang ingin dihapus: ");

        dataApartemen unitHapus = null;
        for (dataApartemen unit : daftarUnit) {
            if (unit.getId() == idDelete) {
                unitHapus = unit;
                break;
            }
        }

        if (unitHapus != null) {
            daftarUnit.remove(unitHapus);
            System.out.println("Unit berhasil dihapus!");
        } else {
            System.out.println("Unit dengan ID tersebut tidak ditemukan.");
        }
    }

    // fitur search unit berdasarkan tipe
    public static void cariUnitBerdasarkanTipe() {
        String tipeCari = inputTeks(input, "\nMasukkan Tipe Unit yang ingin dicari: ");
        boolean ketemu = false;
        for (dataApartemen unit : daftarUnit) {
            if (unit.getTipe().equalsIgnoreCase(tipeCari)) {
                unit.tampilkanInfo();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Unit dengan tipe \"" + tipeCari + "\" tidak ditemukan.");
        }
    }

    // validasi input angka
    public static int inputAngka(Scanner input, String pesan) {
        int angka;
        while (true) {
            System.out.print(pesan);
            String str = input.nextLine();
            try {
                angka = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Coba lagi!");
            }
        }
        return angka;
    }

    // validasi input teks
    public static String inputTeks(Scanner input, String pesan) {
        String teks;
        while (true) {
            System.out.print(pesan);
            teks = input.nextLine().trim();
            if (!teks.isEmpty()) {
                break;
            }
            System.out.println("Input tidak boleh kosong. Coba lagi!");
        }
        return teks;
    }

    public static void tekanEnter(Scanner input) {
        System.out.println("\nTekan ENTER untuk lanjut...");
        input.nextLine();
    }
}
