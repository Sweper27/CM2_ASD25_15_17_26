public class transaksiLayanan {
    Pasien pasien;
    Dokter dokter;
    int durasiLayanan;
    int biaya = 50000;

    public transaksiLayanan(Pasien pasien , Dokter dokter , int durasi){
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasi;
    }
    public int HitungBiaya(){
        return durasiLayanan * biaya;
    }
    public void tampilkanInformasi() {
        System.out.printf("%-10s %-10s %-10s\n", "Pasien", "Dokter", "Durasi");
        System.out.printf("%-10s %-10s %-10s\n", pasien, dokter, durasiLayanan);
    }
}
