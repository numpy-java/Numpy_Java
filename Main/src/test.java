import core.NumJava;
//import core.Operations;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        //double[]arr =(double[]) NumJava.array("5,6,7,9");
       // double[][]arr2 =(double[][]) NumJava.array("[[1, 2, 3], [4, 5, 6], [7, 8, 9]]");
      //  NumJava.print(arr2);
        //System.out.println(Arrays.toString(arr));
        //arr[0]=9;
        //System.out.println(Arrays.toString(arr));
      //  System.out.println(Arrays.toString(NumJava.data));

        double a[]=(double[]) NumJava.array("5,6,4,6");

        System.out.println(Arrays.toString(a));

        //implementing zeros
        System.out.println("zeros");
        System.out.println(Arrays.deepToString(NumJava.zeros(2, 3)));
        System.out.println(Arrays.toString(NumJava.zeros(2)));

        //implementing ones
        System.out.println("ones");
        System.out.println(Arrays.deepToString(NumJava.ones(2, 3)));
        System.out.println(Arrays.toString(NumJava.ones(2)));

        //implementing full
        System.out.println("given value");
        System.out.println(Arrays.deepToString(NumJava.full(2, 3, 8)));
        System.out.println(Arrays.toString(NumJava.full(2, 8)));

        //implementing arange
        System.out.println("arange");
        System.out.println(Arrays.toString(NumJava.arange(1, 10, 2)));

        //implementing empty
        System.out.println("empty");
        System.out.println(Arrays.deepToString(NumJava.empty(2, 3)));
        System.out.println(Arrays.toString(NumJava.empty(2)));

        //implementing linspace
        System.out.println("linspace");
        System.out.println(Arrays.toString(NumJava.linspace(1, 10, 5)));

        //implementing logspace
        System.out.println("logspace");
        System.out.println(Arrays.toString(NumJava.logspace(1, 3, 5, 10)));

        //implementing eye
        System.out.println("eye");
        for (float[] i : NumJava.eye(4,5, -1)) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //implementing eye
        System.out.println("eye");
        for (float[] i : NumJava.eye(4, -1)) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //implementing identity
        System.out.println("identity");
        for (float[] i : NumJava.identity(4)) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //implementing random.randint
        System.out.println("random.randint(low,high,row,column)");
        for (int[] i : NumJava.random_randint(2, 9, 3, 3))
            System.out.print(Arrays.toString(i) +" ");
        System.out.println();

        //implementing ltri
        System.out.println("lower triangle");
        for (float[] i : NumJava.ltri(4,4, -2)) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

