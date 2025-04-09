import core.NumJava;
import core.DType;
import core.Operations;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        NumJava nj = new NumJava();

        float[] arr = (float[]) nj.ones(5,DType.FLOAT);
        System.out.println(Arrays.toString(arr));

        int[] oneArr=(int[]) nj.ones(3,DType.INT);
        System.out.println(Arrays.toString(oneArr));

        // int[] staticArr= new NumJava("8,6");

        System.out.println("===== Constructor-Based Creation =====");
        NumJava arr1D = new NumJava("1, 2, 3");
        arr1D.print();  // Expected: [1, 2, 3]

        NumJava arr2D = new NumJava("[[1, 2], [3, 4]]");
        arr2D.print();  // Expected: [[1, 2], [3, 4]]

        System.out.println("\n===== Constructor with Float DType =====");
        NumJava floatArr = new NumJava("1.1, 2.2, 3.3", DType.FLOAT);
        floatArr.print();  // Expected: [1.1, 2.2, 3.3]

        System.out.println("\n===== Constructor with double DType =====");
        NumJava doubleArr = new NumJava("1.1, 2.2, 3.00000000300000", DType.DOUBLE);
        doubleArr.print();  // Expected: [1.1, 2.2, 3.3]

        System.out.println("\n===== Reshape + T() Chaining =====");
        NumJava reshaped = new NumJava("1, 2, 3, 4").reshape(2, 2).T();
        reshaped.print();  // Expected: [[1, 3], [2, 4]]

        System.out.println("\n===== Flatten 2D to 1D =====");
        NumJava flat = new NumJava("[[10, 20], [30, 40]]").flatten();
        flat.print();  // Expected: [10, 20, 30, 40]

        System.out.println("\n===== Reshape then Flatten (Int) =====");
        NumJava combo = new NumJava("1, 2, 3, 4").reshape(2, 2).flatten();
        combo.print();  // Expected: [1, 2, 3, 4]

        System.out.println("\n===== Reshape then Flatten (float) =====");
        NumJava comboFloat = new NumJava("1, 2, 3, 4",DType.FLOAT).reshape(2, 2).flatten();
        comboFloat.print();  // Expected: [1, 2, 3, 4]

        System.out.println("\n===== DType Verification =====");
        System.out.println("DType of floatArr: " + floatArr.getDType()); // Expected: FLOAT
        System.out.println("DType of arr1D: " + arr1D.getDType());       // Expected: INT

        System.out.println("\n===== Print Raw Array (getArray) =====");
        Object raw = arr2D.getArray();
        System.out.println(raw instanceof int[][]);  // Should be true

        System.out.println("\n===== All Tests Completed Successfully =====");
    }
}
