import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.IOException;

public class Case7 {

    static final Path LOG = Paths.get("log.txt");
    static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    
    static void log(String pesan) {
        String baris = "[" + LocalDateTime.now().format(FMT) + "] " + pesan;
        System.out.println(baris);
        try {
            Files.write(LOG, List.of(baris), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Gagal menulis log: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");

        try {
            Files.write(source, List.of("Report Generated", "Status: OK"));
            log("Laporan ditulis ke " + source);

           
            if (Files.exists(source)) {
                if (Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());
                    log("Folder backup dibuat: " + backup.getParent());
                }
                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
                log("Backup berhasil dibuat: " + backup);
            } else {
                log("GAGAL: file sumber tidak ditemukan: " + source);
            }
        } catch (IOException e) {
            log("ERROR: " + e.getMessage());
        }
    }
}