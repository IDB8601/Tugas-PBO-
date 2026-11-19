// Hands-on 10: Generic Class + Java NIO.2

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

// Latihan 1: atribut stok bertipe Integer
class Produk<T, U> {
    private T nama;
    private U harga;
    private Integer stok;

    public Produk(T nama, U harga, Integer stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return nama + "," + harga + "," + stok;
    }
}

// Latihan 3: jenis data lain
class Pelanggan {
    private String nama;
    private String kota;

    Pelanggan(String nama, String kota) {
        this.nama = nama;
        this.kota = kota;
    }

    @Override
    public String toString() {
        return nama + "," + kota;
    }
}

class Transaksi {
    private String id;
    private double total;

    Transaksi(String id, double total) {
        this.id = id;
        this.total = total;
    }

    @Override
    public String toString() {
        return id + "," + total;
    }
}

// Latihan 3: penyimpan generik, bisa dipakai untuk tipe data apa pun
class DataStore<T> {
    private final Path path;

    DataStore(String namaFile) {
        this.path = Paths.get(namaFile);
    }

    void simpan(List<T> data) throws IOException {
        List<String> lines = new ArrayList<>();
        for (T item : data) {
            lines.add(item.toString());
        }
        Files.write(path, lines);
    }

    // Latihan 2: baca kembali dengan Files.readAllLines()
    List<String> baca() throws IOException {
        return Files.readAllLines(path);
    }

    void tampilkan() throws IOException {
        System.out.println("Isi " + path + ":");
        for (String line : baca()) {
            System.out.println("  " + line);
        }
    }
}

public class Case10{
    public static void main(String[] args) {
        List<Produk<String, Double>> produkList = new ArrayList<>();
        produkList.add(new Produk<>("Laptop", 15000000.0, 10));
        produkList.add(new Produk<>("Mouse", 150000.0, 50));
        produkList.add(new Produk<>("Keyboard", 350000.0, 25));

        List<Pelanggan> pelangganList = List.of(
                new Pelanggan("Budi", "Makassar"),
                new Pelanggan("Siti", "Gowa"));

        List<Transaksi> transaksiList = List.of(
                new Transaksi("TRX001", 15150000.0),
                new Transaksi("TRX002", 350000.0));

        try {
            DataStore<Produk<String, Double>> storeProduk = new DataStore<>("produk_output.txt");
            storeProduk.simpan(produkList);
            System.out.println("Data produk berhasil disimpan menggunakan NIO.2");
            storeProduk.tampilkan();

            System.out.println();
            DataStore<Pelanggan> storePelanggan = new DataStore<>("pelanggan_output.txt");
            storePelanggan.simpan(pelangganList);
            storePelanggan.tampilkan();

            System.out.println();
            DataStore<Transaksi> storeTransaksi = new DataStore<>("transaksi_output.txt");
            storeTransaksi.simpan(transaksiList);
            storeTransaksi.tampilkan();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }
}