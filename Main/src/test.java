import core.NumArray;
import core.NumJava;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        NumJava nj = new NumJava();

        System.out.println("===== Constructor-Based Creation =====");
        NumJava arr1D = new NumJava("1, 2, 3");
        arr1D.print();  // Expected: [1.0, 2.0, 3.0]

        NumJava arr2D = new NumJava("[[1, 2], [3, 4]]");
        arr2D.print();  // Expected: [[1.0, 2.0], [3.0, 4.0]]

        System.out.println("\n===== Factory Method .from() =====");
        NumJava fromArr = nj.from("[[5, 6], [7, 8]]");
        fromArr.print();  // Expected: [[5.0, 6.0], [7.0, 8.0]]

        System.out.println("\n===== Chainable reshape() + T() =====");
        NumJava reshaped = nj.from("1, 2, 3, 4").reshape(2, 2);
        reshaped.print();  // Expected: [[1.0, 2.0], [3.0, 4.0]]

        NumJava transposed = reshaped.T();
        transposed.print();  // Expected: [[1.0, 3.0], [2.0, 4.0]]

        System.out.println("\n===== Inherited Operations: zeros() =====");
        NumJava zerosArr = new NumJava(nj.zeros(2,3));
        zerosArr.print();  // Expected: [[0.0, 0.0, 0.0], [0.0, 0.0, 0.0]]

        System.out.println("\n===== Inherited Operations: ones() =====");
        NumJava onesArr = new NumJava(nj.ones(3));
        onesArr.print();  // Expected: [1.0, 1.0, 1.0]

        System.out.println("\n===== Legacy-style Static API via NumArray =====");
        double[] oneD = (double[]) nj.array("4, 5, 6");
        NumArray.print(oneD);  // Expected: [4.0, 5.0, 6.0]

        double[][] twoD = (double[][]) nj.array("[[7, 8], [9, 10]]");
        NumArray.print(twoD);  // Expected: [[7.0, 8.0], [9.0, 10.0]]

        System.out.println("\n===== Test Completed Successfully =====");

        //implementing zeros
        System.out.println("zeros");
        System.out.println(Arrays.deepToString(nj.zeros(2, 3)));
        System.out.println(Arrays.toString(nj.zeros(2)));

        //implementing ones
        System.out.println("ones");
        System.out.println(Arrays.deepToString(nj.ones(2, 3)));
        System.out.println(Arrays.toString(nj.ones(2)));

        //implementing full
        System.out.println("given value");
        System.out.println(Arrays.deepToString(nj.full(2, 3, 8)));
        System.out.println(Arrays.toString(nj.full(2, 8)));

        //implementing arange
        System.out.println("arange");
        System.out.println(Arrays.toString(nj.arange(1, 10, 2)));

        //implementing empty
        System.out.println("empty");
        System.out.println(Arrays.deepToString(nj.empty(2, 3)));
        System.out.println(Arrays.toString(nj.empty(2)));

        //implementing linspace
        System.out.println("linspace");
        System.out.println(Arrays.toString(nj.linspace(1, 10, 5)));

        //implementing logspace
        System.out.println("logspace");
        System.out.println(Arrays.toString(nj.logspace(1, 3, 5, 10)));

        //implementing eye
        System.out.println("eye");
        for (float[] i : nj.eye(4,5, -1)) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //implementing eye
        System.out.println("eye");
        for (float[] i : nj.eye(4, -1)) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //implementing identity
        System.out.println("identity");
        for (float[] i : nj.identity(4)) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //implementing random.randint
        System.out.println("random.randint(low,high,row,column)");
        for (int[] i : nj.random_randint(2, 9, 3, 3))
            System.out.print(Arrays.toString(i) +" ");
        System.out.println();

        //implementing ltri
        System.out.println("lower triangle");
        for (float[] i : nj.ltri(4,4, -2)) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

