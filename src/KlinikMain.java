import java.util.Scanner;

public class KlinikMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Klinik klinik = new Klinik();
        Pasien data;
        int pilih;

        do {
            System.out.println("\nSistem Antrian Klinik");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("6. Sort Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Input Nama Pasien : ");
                    String nama = sc.nextLine();
                    System.out.print("NIK : ");
                    String nik = sc.nextLine();
                    System.out.print("Keluhan : ");
                    String keluhan = sc.nextLine();
                    klinik.tambahPasien(nama, nik, keluhan);
                    break;
                case 2:
                    klinik.lihatAntrian();
                    break;
                case 3:
                    klinik.layaniPasien(sc);
                    break;
                case 4:
                    System.out.println("Sisa antrian: ");
                    klinik.cekSisaAntrian();
                    break;
                case 5:
                    klinik.lihatRiwayat();
                    break;
                case 6:
                    klinik.sortRiwayatTransaksiDESC();
                    klinik.lihatRiwayat();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);
    }
}
