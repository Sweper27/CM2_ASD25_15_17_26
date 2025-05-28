public class Pasien {
    String nama;
    String nik;
    String keluhan;

    public Pasien(String nama, String nik, String keluhan) {
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    public void tampilkanInformasi() {
        System.out.printf("%-10s %-10s %-10s\n", "Nama", "NIK", "Keluhan");
        System.out.printf("%-10s %-10s %-10s\n", nama, nik, keluhan);
    }
}