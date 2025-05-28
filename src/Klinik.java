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
        Node baru = new Node(baru, pasien, baru);
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
        Node current = headAntrian;
        while (current != null) {
            Pasien p = current.pasien;
            if (p != null) {
                System.out.println(p.nama + "\t" + p.nik + "\t" + p.keluhan);
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
    for (int i = 0; i < dokterList.length; i++) {
        System.out.println(dokterList[i].idDokter + "\t" + dokterList[i].nama);
    }

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
        Node baru = new Node(baru, t, baru);
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
        Node ulang = new Node(ulang, pasien, ulang);
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
        System.out.println("-- Riwayat Transaksi --");
        Node current = headTransaksi;
        while (current != null) {
            transaksiLayanan t = current.transaksi;
            if (t != null) {
                System.out.println(t.pasien.nama + "\t" + t.dokter.nama + "\t" + t.durasiLayanan + "\t" + t.biaya);
            }
            current = current.next;
        }
    }
}
