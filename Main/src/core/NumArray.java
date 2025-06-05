package core;

import java.util.Arrays;

public class NumArray extends Operations{

    public static Object array(String input) {
        return array(input, DType.INT);
    }

    public static Object array(String input, DType dtype) {
        input = input.trim();
        if (input.startsWith("[[")) {
            String[] rows = input.substring(2, input.length() - 2).split("\\],\\s*\\[");
            switch (dtype) {
                case INT:
                    int[][] int2D = new int[rows.length][];
                    for (int i = 0; i < rows.length; i++)
                        int2D[i] = Arrays.stream(rows[i].split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
                    return int2D;
                case FLOAT:
                    float[][] float2D = new float[rows.length][];
                    for (int i = 0; i < rows.length; i++)
                        float2D[i] = Arrays.stream(rows[i].split(",")).map(String::trim).mapToDouble(Double::parseDouble).mapToObj(d -> (float) d).collect(java.util.stream.Collectors.collectingAndThen(java.util.stream.Collectors.toList(), l -> {
                            float[] a = new float[l.size()];
                            for (int j = 0; j < l.size(); j++) a[j] = l.get(j);
                            return a;
                        }));
                    return float2D;
                case DOUBLE:
                    double[][] double2D = new double[rows.length][];
                    for (int i = 0; i < rows.length; i++)
                        double2D[i] = Arrays.stream(rows[i].split(",")).map(String::trim).mapToDouble(Double::parseDouble).toArray();
                    return double2D;
            }
        } else {
            String[] tokens = input.replaceAll("[\\[\\]]", "").split(",");
            switch (dtype) {
                case INT:
                    return Arrays.stream(tokens).map(String::trim).mapToInt(Integer::parseInt).toArray();
                case FLOAT:
                    float[] float1D = new float[tokens.length];
                    for (int i = 0; i < tokens.length; i++) float1D[i] = Float.parseFloat(tokens[i].trim());
                    return float1D;
                case DOUBLE:
                    return Arrays.stream(tokens).map(String::trim).mapToDouble(Double::parseDouble).toArray();
            }
        }
        throw new IllegalArgumentException("Unsupported dtype: " + dtype);
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(int[][] arr) {
        for (int[] row : arr) System.out.println(Arrays.toString(row));
    }

    public static void print(float[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(float[][] arr) {
        for (float[] row : arr) System.out.println(Arrays.toString(row));
    }

    public static void print(double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(double[][] arr) {
        for (double[] row : arr) System.out.println(Arrays.toString(row));
    }
}
