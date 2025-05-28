import java.util.Scanner;

public class KlinikMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Klinik klinik = new Klinik();
        Pasien data;
        int pilih;

        do {
            System.out.println("Sistem Antrian Klinik");
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
                    data = psn(sc);
                    klinik.tambahPasien(data);
                    System.out.println("Pasien masuk ke dalam antrian.");
                    break;
                case 2:
                    System.out.println("----- Antrian Pasien -----");
                    klinik.lihatAntrian();
                    break;
                case 3:
                    System.out.println("Pilih Dokter:");
                    System.out.print("Input kode dokter: ");
                    String idDokter = sc.nextLine();
                    System.out.print("Input durasi layanan (jam): ");
                    int durasi = sc.nextInt();
                    klinik.searchById();
                    break;
                case 4:
                    klinik.removeFirst();
                    break;
                case 5:
                    System.out.println("----- Riwayat Transaksi -----");
                    klinik.removeLast();
                    break;
                case 6:
                    System.out.println("Sisa antrian: " + klinik.getJumlahAntrian());
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);
    }

    public static Pasien psn(Scanner sc) {
        System.out.print("Nama      : ");
        String nama = sc.nextLine();
        System.out.print("NIK       : ");
        String nik = sc.nextLine();
        System.out.print("Keluhan   : ");
        String keluhan = sc.nextLine();
        return new Pasien(nama, nik, keluhan);
    }
}
