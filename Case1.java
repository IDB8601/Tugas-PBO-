enum AccountType {
    
    SAVINGS("Akun Tabungan"),
    CREDIT("Akun Kredit"),
    DEPOSIT("Akun Deposito");

    private final String deskripsi;

    AccountType(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    
    @Override
    public String toString() {
        return deskripsi;
    }
}

class Account {
    private AccountType type;

    public Account(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }
}

public class Case1 {
    public static void main(String[] args) {
        
        System.out.println("=== Semua tipe akun ===");
        for (AccountType t : AccountType.values()) {
            System.out.println(t.name() + " -> " + t);
        }

        System.out.println();
        Account a = new Account(AccountType.DEPOSIT);
        System.out.println("Tipe akun a: " + a.getType());
    }
}