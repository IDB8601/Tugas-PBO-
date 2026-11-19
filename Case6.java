import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Case6 {

    // Latihan 1 + 2: deteksi file tidak ditemukan, simpan hasil ke ArrayList<String>
    static ArrayList<String> bacaFile(String namaFile) {
        Path path = Paths.get(namaFile);

        if (Files.notExists(path)) {
            System.out.println("[ERROR] File tidak ditemukan: " + namaFile);
            return new ArrayList<>();
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return br.lines().collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println("[ERROR] Gagal membaca file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    
    static void tulisFile(String namaFile, ArrayList<String> baris) {
        try {
            Files.write(Paths.get(namaFile), baris, StandardCharsets.UTF_8);
            System.out.println("Berhasil menulis " + baris.size() + " baris ke " + namaFile);
        } catch (IOException e) {
            System.out.println("[ERROR] Gagal menulis file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- Uji file tidak ada ---");
        bacaFile("tidak_ada.txt");

        
        System.out.println("\n--- Isi employees.txt ---");
        ArrayList<String> daftar = bacaFile("employees.txt");
        daftar.forEach(System.out::println);
        System.out.println("Jumlah karyawan: " + daftar.size());

       
        System.out.println();
        tulisFile("copy_employees.txt", daftar);
    }
}