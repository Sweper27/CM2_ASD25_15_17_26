public class Klinik {
    Node headPasien, headDokter, headLayanan;
    int size;

    public Klinik() {
        headPasien = headDokter = headLayanan = null;
        size = 0;
    }

    public boolean isEmpty15() {
        return headPasien == headDokter == headLayanan  == null;
    }

    public void addLast(String nama, String nik, String keluhan) {
        Pasien data = new Pasien(nama, nik, keluhan);
        NodePasien ndInput = new NodePasien(null, data, null);
            headPasien = ndInput;
        } else {
            NodePasien temp = headPasien;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = ndInput;
            ndInput.prev = temp;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty15()) {
            System.out.println("Antrian masih kosong, tidak ada yang bisa dihapus.");
        } else {
            System.out.println("Pasien" + headPasien.data.nama + " dipanggil");
            headPasien = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        }
    }

    public void print15() {
        if (isEmpty15()) {
            System.out.println("Antrian kosong");
            return;
        } else {
            NodeVaksinasi15 temp = head;
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("Daftar Pengantri Vaksin");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.printf("| %-8s | %-10s |\n", "No.", "Nama");
            while (temp != null) {
                System.out.printf("| %-8d | %-10s |\n", temp.data.no, temp.data.nama);
                temp = temp.next;
            }
            System.out.println("Sisa Antrian: " + size);
        }
    }

    public void searchById15(String idFilm) {
        if (isEmpty15()) {
            System.out.println("Data Film Kosong!");
            return;
        }
        NodeFilm15 temp = head;
        int posisi = 0;
        boolean ditemukan = false;
        while (temp != null) {
            if (temp.data.idFilm.equals(idFilm)) {
                System.out.println("Data ID Film " + temp.data.idFilm + " ditemukan di node ke-" + posisi);
                System.out.println("IDENTITAS:");
                temp.data.tampilInformasi15();
                ditemukan = true;
                break;
            }
            temp = temp.next;
            posisi++;
        }
        if (!ditemukan) {
            System.out.println("Data Film dengan ID " + idFilm + " tidak ditemukan.");
        }
    }

    public void sortRatingDesc15() {
        if (isEmpty15()) {
            System.out.println("Data Film Kosong!");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            NodeFilm15 curr = head;
            while (curr != null && curr.next != null) {
                if (curr.data.rating < curr.next.data.rating) {
                    Film15 temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
        print15();
        System.out.println("Data berhasil diurutkan berdasarkan rating (desc).");
    }
}
