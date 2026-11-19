import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;

    Employee(String n, int a) {
        name = n;
        age = a;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}

public class Case9 {

    static void serialize(Employee e, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(e);
            System.out.println("Serialized successfully -> " + file);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    
    static Employee deserialize(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Employee) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
       
        Employee[] daftar = {
            new Employee("John", 30),
            new Employee("Siti", 27),
            new Employee("Andi", 41)
        };

        for (int i = 0; i < daftar.length; i++) {
            serialize(daftar[i], "emp" + (i + 1) + ".ser");
        }

        System.out.println();
        for (int i = 0; i < daftar.length; i++) {
            Employee restored = deserialize("emp" + (i + 1) + ".ser");
            if (restored != null) {
                System.out.println("Deserialized: " + restored.name + ", " + restored.age);
            }
        }

       
        System.out.println();
        System.out.println("Hasil file tidak ada: " + deserialize("tidak_ada.ser"));
    }
}