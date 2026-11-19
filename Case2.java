enum AccountType {
    SAVINGS("SA", 0.035),
    CREDIT("CR", 0.18),
    DEPOSIT("DP", 0.05);

    private String code;
    private double interestRate; 

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() {
        return code;
    }

    public double getInterestRate() {
        return interestRate;
    }

    
    public void tampilkan() {
        System.out.printf("Nama: %-8s | Kode: %-3s | Suku bunga: %.2f%%%n",
                name(), code, interestRate * 100);
    }
}

public class Case2 {
    public static void main(String[] args) {
        System.out.println("=== Satu tipe ===");
        AccountType.SAVINGS.tampilkan();

        
        System.out.println("\n=== Loop semua tipe ===");
        for (AccountType t : AccountType.values()) {
            System.out.println(t + " -> kode " + t.getCode());
        }

        System.out.println("\n=== Detail lengkap ===");
        for (AccountType t : AccountType.values()) {
            t.tampilkan();
        }
    }
}