import java.util.Scanner;

public class KlinikMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLLFilm15 film = new DLLFilm15();
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
                    film.addLast15(data);
                    System.out.println("Pasien masuk ke dalam antrian.");
                    break;
                case 2:
                    System.out.println("----- Antrian Pasien -----");
                    film.print15();
                    break;
                case 3:
                    System.out.println("Pilih Dokter:");
                    System.out.print("Input kode dokter: ");
                    String idDokter = sc.nextLine();
                    System.out.print("Input durasi layanan (jam): ");
                    int durasi = sc.nextInt();
                    film.searchById15();
                    break;
                case 4:
                    film.removeFirst15();
                    break;
                case 5:
                    System.out.println("----- Riwayat Transaksi -----");
                    film.removeLast15();
                    break;
                case 6:
                    System.out.println("Sisa antrian: " + film.getJumlahAntrian());
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
