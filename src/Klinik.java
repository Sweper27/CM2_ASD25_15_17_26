import java.util.Scanner;

public class Klinik {
    Node headAntrian = null;
    Node headTransaksi = null;
    Dokter[] dokterList = {
        new Dokter("dr01", "Wike Ratanca"),
        new Dokter("dr02", "Santi Runica"),
        new Dokter("dr03", "Aam Antanica"),
        new Dokter("dr04", "Slamet Sugito")
    };

    public void tambahPasien(String nama, String nik, String keluhan) {
        Pasien pasien = new Pasien(nama, nik, keluhan);
        Node baru = new Node(null, pasien, null);;
        if (headAntrian == null) {
            headAntrian = baru;
        } else {
            Node current = headAntrian;
            while (current.next != null) {
            current = current.next;
            }
            current.next = baru;
            baru.prev = current; 
        }
        System.out.println(">> Pasien masuk ke dalam antrian");
    }

    public void lihatAntrian() {
        System.out.println("-- Antrian Pasien --");
        System.out.printf("%-10s %-15s %-10s\n", "Nama", "NIK", "Keluhan");
        Node current = headAntrian;
        while (current != null) {
            Pasien p = current.pasien;
            if (p != null) {
                System.out.printf("%-10s %-15s %-10s\n", p.nama, p.nik, p.keluhan);
            }
            current = current.next;
        }
    }

   public void layaniPasien(Scanner scanner) {
    if (headAntrian == null) {
        System.out.println(">> Tidak ada pasien dalam antrian");
        return;
    }

    Pasien pasien = headAntrian.pasien;
    headAntrian = headAntrian.next;

    System.out.println("Pasien " + pasien.nama + " dipanggil");
    System.out.println("Daftar dokter jaga:");
    System.out.printf("%-10s %-10s\n", "Kode", "Nama");
    for (int i = 0; i < dokterList.length; i++) {
        System.out.printf("%-10s %-10s\n", dokterList[i].idDokter, dokterList[i].nama);
    }

    System.out.println("Pilih Dokter:");
    System.out.print("Input kode dokter: ");
    String kode = scanner.nextLine();
    System.out.print("Input durasi layanan (jam): ");
    int durasi = Integer.parseInt(scanner.nextLine());

    Dokter dokter = null;
    for (int i = 0; i < dokterList.length; i++) {
        if (dokterList[i].idDokter.equals(kode)) {
            dokter = dokterList[i];
            break;
        }
    }

    if (dokter != null) {
        transaksiLayanan t = new transaksiLayanan(pasien, dokter, durasi);
        Node baru = new Node(null, t, null);
        if (headTransaksi == null) {
            headTransaksi = baru;
        } else {
            Node current = headTransaksi;
            while (current.next != null) {
                current = current.next;
            }
            current.next = baru;
        }
        System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat");
    } else {
        System.out.println(">> Dokter tidak ditemukan");
        Node ulang = new Node(null, pasien, null);
        ulang.next = headAntrian;
        headAntrian =ulang;
    }
}

    public void cekSisaAntrian() {
        int count = 0;
        Node current = headAntrian;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println(">> Sisa antrian: " + count);
    }

    public void lihatRiwayat() {
    System.out.printf("%-10s %-15s %-10s %-10s\n", "Nama", "Nama Dokter", "Durasi", "Total");

    Node current = headTransaksi;
    while (current != null) {
        if (current.transaksi != null) {
            transaksiLayanan t = current.transaksi;
            System.out.printf("%-10s %-15s %-10d %-10d\n", t.pasien.nama, t.dokter.nama, t.durasiLayanan, t.HitungBiaya());
        }
        current = current.next;
    }
}
    
    public void sortRiwayatTransaksiDESC() {
    if (headTransaksi == null || headTransaksi.next == null) {
        System.out.println(">> Tidak ada transaksi yang perlu diurutkan");
        return;
    }

    boolean swapped;
    do {
        swapped = false;
        Node current = headTransaksi;

        while (current.next != null) {
            transaksiLayanan t1 = current.transaksi;
            transaksiLayanan t2 = current.next.transaksi;

            if (t1 != null && t2 != null && t1.pasien.nama.compareToIgnoreCase(t2.pasien.nama) < 0) {
                current.transaksi = t2;
                current.next.transaksi = t1;
                swapped = true;
            }

            current = current.next;
        }
    } while (swapped);
}
}
