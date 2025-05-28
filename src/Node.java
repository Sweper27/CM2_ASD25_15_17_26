public class Node {
    Pasien pasien;
    transaksiLayanan transaksi;
    Node next;

    public Node(Pasien pasien) {
        this.pasien = pasien;
        this.transaksi = null;
        this.next = null;
    }

    public Node(transaksiLayanan transaksi) {
        this.pasien = null;
        this.transaksi = transaksi;
        this.next = null;
    }
}