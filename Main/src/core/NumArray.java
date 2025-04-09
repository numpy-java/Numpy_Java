package core;

import java.util.Arrays;

public class NumArray extends Operations {

    public static Object array(String value) {
        return array(value, DType.INT); // Default to INT
    }

    public static Object array(String value, DType dtype) {
        value = value.trim();

        if (value.startsWith("[[") && value.endsWith("]]")) {
            value = value.substring(2, value.length() - 2);
            String[] rows = value.split("\\],\\s*\\[");
            int rowCount = rows.length;

            switch (dtype) {
                case FLOAT:
                    float[][] fData2D = new float[rowCount][];
                    for (int i = 0; i < rowCount; i++) {
                        String[] vals = rows[i].trim().split("[, ]+");
                        fData2D[i] = new float[vals.length];
                        for (int j = 0; j < vals.length; j++) {
                            fData2D[i][j] = Float.parseFloat(vals[j]);
                        }
                    }
                    return fData2D;
                case DOUBLE:
                    double[][] dData2D = new double[rowCount][];
                    for (int i = 0; i < rowCount; i++) {
                        String[] vals = rows[i].trim().split("[, ]+");
                        dData2D[i] = new double[vals.length];
                        for (int j = 0; j < vals.length; j++) {
                            dData2D[i][j] = Double.parseDouble(vals[j]);
                        }
                    }
                    return dData2D;
                case INT:
                default:
                    int[][] iData2D = new int[rowCount][];
                    for (int i = 0; i < rowCount; i++) {
                        String[] vals = rows[i].trim().split("[, ]+");
                        iData2D[i] = new int[vals.length];
                        for (int j = 0; j < vals.length; j++) {
                            iData2D[i][j] = Integer.parseInt(vals[j]);
                        }
                    }
                    return iData2D;
            }
        } else {
            String[] vals = value.replaceAll("[\\[\\]]", "").trim().split("[, ]+");

            switch (dtype) {
                case FLOAT:
                    float[] fData = new float[vals.length];
                    for (int i = 0; i < vals.length; i++) fData[i] = Float.parseFloat(vals[i]);
                    return fData;
                case DOUBLE:
                    double[] dData = new double[vals.length];
                    for (int i = 0; i < vals.length; i++) dData[i] = Double.parseDouble(vals[i]);
                    return dData;
                case INT:
                default:
                    int[] iData = new int[vals.length];
                    for (int i = 0; i < vals.length; i++) iData[i] = Integer.parseInt(vals[i]);
                    return iData;
            }
        }
    }

    public static void print(Object arr) {
        if (arr instanceof int[]) {
            System.out.println(Arrays.toString((int[]) arr));
        } else if (arr instanceof float[]) {
            System.out.println(Arrays.toString((float[]) arr));
        } else if (arr instanceof double[]) {
            System.out.println(Arrays.toString((double[]) arr));
        } else if (arr instanceof int[][]) {
            for (int[] row : (int[][]) arr) System.out.println(Arrays.toString(row));
        } else if (arr instanceof float[][]) {
            for (float[] row : (float[][]) arr) System.out.println(Arrays.toString(row));
        } else if (arr instanceof double[][]) {
            for (double[] row : (double[][]) arr) System.out.println(Arrays.toString(row));
        } else {
            System.out.println("Unknown array format");
        }
    }
}
