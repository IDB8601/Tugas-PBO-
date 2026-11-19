class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() { return first; }
    public T2 getSecond() { return second; }

    public void showTypes() {
        System.out.println(first.getClass().getName() + " & " + second.getClass().getName());
    }

    
    public Pair<T2, T1> swap() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class Case4 {
    public static void main(String[] args) {
        
        Pair<Integer, String> p1 = new Pair<>(90, "Budi");
        Pair<Double, Boolean> p2 = new Pair<>(3.14, true);

        System.out.println("p1 = " + p1);
        p1.showTypes();
        System.out.println("p2 = " + p2);
        p2.showTypes();

        
        System.out.println("\n=== Setelah swap ===");
        Pair<String, Integer> s1 = p1.swap();
        Pair<Boolean, Double> s2 = p2.swap();
        System.out.println("p1.swap() = " + s1);
        s1.showTypes();
        System.out.println("p2.swap() = " + s2);
        s2.showTypes();
    }
}