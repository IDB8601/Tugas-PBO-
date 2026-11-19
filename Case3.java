class Cell<T> {
    private T data;

    public void setValue(T data) {
        this.data = data;
    }

    public T getValue() {
        return data;
    }

    
    public void displayType() {
        if (data == null) {
            System.out.println("Belum ada data (null)");
        } else {
            System.out.println("Tipe data: " + data.getClass().getSimpleName());
        }
    }
}

public class Case3 {
    public static void main(String[] args) {
        
        Cell<Integer> cellInt = new Cell<>();
        cellInt.setValue(100);
        System.out.println("cellInt   = " + cellInt.getValue());
        cellInt.displayType();

        Cell<String> cellStr = new Cell<>();
        cellStr.setValue("Halo Generic");
        System.out.println("cellStr   = " + cellStr.getValue());
        cellStr.displayType();

        
        int angka = cellInt.getValue() + 5;
        String teks = cellStr.getValue().toUpperCase();
        System.out.println("angka + 5 = " + angka);
        System.out.println("uppercase = " + teks);

        
        System.out.println();
        System.out.println("=== Keuntungan generic (type safety) ===");
        System.out.println("1. Kesalahan tipe ketahuan saat kompilasi, bukan saat program berjalan.");
        System.out.println("2. Tidak perlu casting manual, sehingga ClassCastException dapat dihindari.");
        System.out.println("3. Satu class dapat dipakai ulang untuk banyak tipe (Integer, String, dll).");
        System.out.println("4. Kode lebih mudah dibaca karena tipe data terlihat jelas.");
    }
}