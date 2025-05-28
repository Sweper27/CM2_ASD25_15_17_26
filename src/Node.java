public class Node {
    Pasien pasien;
    transaksiLayanan transaksi;
    Node prev, next;

    public Node(Node prev, Pasien pasien, Node next) {
        this.pasien = pasien;
        this.transaksi = null;
        this.prev = prev;
        this.next = next;
    }

    public Node(Node prev, transaksiLayanan transaksi, Node next) {
        this.pasien = null;
        this.transaksi = transaksi;
        this.prev = prev;
        this.next = next;
    }
}