import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Case8 {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = Files.newBufferedWriter(Paths.get("user_input.txt"))) {

            System.out.println("Ketik teks (ketik 'exit' untuk berhenti):");
            int jumlah = 0;

          
            while (true) {
                System.out.print("Enter text: ");
                if (!sc.hasNextLine()) break;          
                String text = sc.nextLine();
                if (text.equalsIgnoreCase("exit")) break;

               
                String baris = "[" + LocalDateTime.now().format(fmt) + "] " + text;
                bw.write(baris);
                bw.newLine();
                jumlah++;
            }
            System.out.println("\nSaved! " + jumlah + " baris disimpan ke user_input.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
       
    }
}