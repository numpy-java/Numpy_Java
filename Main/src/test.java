import core.NumJava;
import core.Operations;

public class test {
    public static void main(String[] args) {
        NumJava a = new NumJava(2, 2);
        a.set(0, 0, 1);
        a.set(0, 1, 2);
        a.set(1, 0, 3);
        a.set(1, 1, 4);

        NumJava b = new NumJava(2, 2);
        b.set(0, 0, 5);
        b.set(0, 1, 6);
        b.set(1, 0, 7);
        b.set(1, 1, 8);

        NumJava result = Operations.add(a, b);
        result.print();
    }
}
