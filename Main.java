package Main;

import Model.*;
import Service.sistemApartemen;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Data awal (contoh campuran jual & sewa)
        sistemApartemen.daftarUnit.add(new sewaApartemen(1, "Single", 30, "Tersedia", 2));
        sistemApartemen.daftarUnit.add(new jualApartemen(2, "Twin", 45, "Tersedia", 370));
        sistemApartemen.daftarUnit.add(new sewaApartemen(3, "Double", 70, "Disewa", 4));
        sistemApartemen.daftarUnit.add(new jualApartemen(4, "Twin", 50, "Tersedia", 390));

        Scanner input = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("==SELAMAT DATANG DI APARTEMEN KOBA==");
            System.out.println("\n====== Sistem Apartemen ======");
            System.out.println("1. Tambah Unit");
            System.out.println("2. Lihat Daftar Unit");
            System.out.println("3. Ubah Status Unit");
            System.out.println("4. Hapus Unit");
            System.out.println("5. Cari Tipe Unit");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            String pilihStr = input.nextLine();

            try {
                pilihan = Integer.parseInt(pilihStr);
            } catch (NumberFormatException e) {
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    sistemApartemen.tambahUnit();
                    sistemApartemen.tekanEnter(input);
                    break;

                case 2:
                    sistemApartemen.tampilkanDaftarUnit();
                    sistemApartemen.tekanEnter(input);
                    break;

                case 3:
                    sistemApartemen.tampilkanDaftarUnit();
                    sistemApartemen.sistemUpdate();
                    sistemApartemen.tekanEnter(input);
                    break;

                case 4:
                    sistemApartemen.tampilkanDaftarUnit();
                    sistemApartemen.hapusUnit();
                    sistemApartemen.tekanEnter(input);
                    break;

                case 5:
                    sistemApartemen.cariUnitBerdasarkanTipe();
                    sistemApartemen.tekanEnter(input);
                    break;

                case 6:
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi!");
            }
        } while (pilihan != 6);

        input.close();
    }
}
