import core.NumJava;
import core.Operations;

import java.util.Arrays;

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


        NumJava c = new NumJava(2);
        c.set(0,9);
        c.set(1,8);

        NumJava d = new NumJava(2);
        d.set(0,7);
        d.set(1,6);


        System.out.println("testing for 1D array sum");
        NumJava result1D=Operations.add(d,c);

        result1D.print();
        //System.out.println(result1D);
        //c.print();
        System.out.println("2D array sum");
        NumJava result = NumJava.add(a, b);
        result.print();
        NumJava e = new NumJava("1,2,3,5,7,4");
        e.print();
        //implementing zeros
        System.out.println(Arrays.deepToString(NumJava.ones(2,3)));
        System.out.println(Arrays.toString(NumJava.ones(2)));



    }
}
