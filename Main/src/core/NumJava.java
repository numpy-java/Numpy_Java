package core;

import java.util.Arrays;

public class NumJava extends Operations {
    public static double[] data;
    private static double[][] data2D;

    // Parses a string input and converts it into either a 1D or 2D double array
    public static Object array(String value) {
        value = value.trim();

        // If input is like [[1, 2], [3, 4]], treat it as 2D array
        if (value.startsWith("[[") && value.endsWith("]]")) {
            value = value.substring(2, value.length() - 2);
            String[] rows = value.split("\\],\\s*\\[");
            data2D = new double[rows.length][];

            for (int i = 0; i < rows.length; i++) {
                String[] values = rows[i].trim().split("[, ]+");
                data2D[i] = new double[values.length];
                for (int j = 0; j < values.length; j++) {
                    data2D[i][j] = Double.parseDouble(values[j].trim());
                }
            }
            return deepCopy(data2D);
        }

        // If input is like [1, 2, 3], treat it as 1D array
        else if (value.startsWith("[") && value.endsWith("]")) {
            value = value.substring(1, value.length() - 1);
            String[] values = value.trim().split("[, ]+");
            data = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                data[i] = Double.parseDouble(values[i].trim());
            }
            return Arrays.copyOf(data, data.length);
        }

        // If input is like "1 2 3" or "1,2,3", also treat as 1D array
        else if (value.matches("[-+]?\\d+(\\.\\d+)?([,\\s]+[-+]?\\d+(\\.\\d+)?)*")) {
            String[] values = value.trim().split("[, ]+");
            data = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                data[i] = Double.parseDouble(values[i].trim());
            }
            return Arrays.copyOf(data, data.length);
        }

        // Input is invalid if it doesn't match any of the expected formats
        else {
            throw new IllegalArgumentException("Invalid array format! Use [1,2], '1 2', or [[1,2],[3,4]]");
        }
    }

    // Prints the contents of either a 1D or 2D double array to the console
    public static void print(Object arr) {
        if (arr instanceof double[]) {
            System.out.println(Arrays.toString((double[]) arr));
        } else if (arr instanceof double[][]) {
            for (double[] row : (double[][]) arr) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            throw new IllegalArgumentException("Only 1D/2D double arrays are supported.");
        }
    }
}
