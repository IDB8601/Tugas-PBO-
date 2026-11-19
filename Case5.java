public class Case5 {

    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }

    public static void main(String[] args) {
        System.out.println("isEqual(5, 5)          = " + isEqual(5, 5));
        System.out.println("isEqual(\"Hello\",\"World\") = " + isEqual("Hello", "World"));
        System.out.println("isEqual(3.14, 3.14)    = " + isEqual(3.14, 3.14));

        
        System.out.println("\n=== Test case tambahan ===");
        System.out.println("isEqual(2.5, 2.5)      = " + isEqual(2.5, 2.5));
        System.out.println("isEqual(2.5, 2.6)      = " + isEqual(2.5, 2.6));
        System.out.println("isEqual(0.1+0.2, 0.3)  = " + isEqual(0.1 + 0.2, 0.3)); // false (presisi floating point)
        System.out.println("isEqual('A', 'A')      = " + isEqual('A', 'A'));
        System.out.println("isEqual('A', 'a')      = " + isEqual('A', 'a'));
        System.out.println("isEqual('x', 'y')      = " + isEqual('x', 'y'));

        
        System.out.println("\n=== Generic class vs generic method ===");
        System.out.println("Generic class : parameter tipe dideklarasikan di class, mis. Cell<T>.");
        System.out.println("                Berlaku untuk seluruh isi class; tipe ditentukan saat objek dibuat (new Cell<Integer>()).");
        System.out.println("Generic method: parameter tipe dideklarasikan di method, mis. <T> boolean isEqual(T a, T b).");
        System.out.println("                Berlaku hanya untuk method itu; tipe disimpulkan otomatis dari argumen saat dipanggil.");
        System.out.println("                Bisa ada di class biasa (non-generic) dan bisa static.");
    }
}