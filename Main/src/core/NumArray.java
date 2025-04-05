    package core;

    import java.util.Arrays;

    public class NumArray extends Operations{

        public static Object array(String value) {
            value = value.trim();

            if (value.startsWith("[[") && value.endsWith("]]")) {
                value = value.substring(2, value.length() - 2);
                String[] rows = value.split("\\],\\s*\\[");
                double[][] data2D = new double[rows.length][];

                for (int i = 0; i < rows.length; i++) {
                    String[] values = rows[i].trim().split("[, ]+");
                    data2D[i] = new double[values.length];
                    for (int j = 0; j < values.length; j++) {
                        data2D[i][j] = Double.parseDouble(values[j].trim());
                    }
                }
                return deepCopy(data2D);
            } else if (value.startsWith("[") && value.endsWith("]")) {
                value = value.substring(1, value.length() - 1);
                String[] values = value.trim().split("[, ]+");
                double[] data = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    data[i] = Double.parseDouble(values[i].trim());
                }
                return Arrays.copyOf(data, data.length);
            } else if (value.matches("[-+]?\\d+(\\.\\d+)?([,\\s]+[-+]?\\d+(\\.\\d+)?)*")) {
                String[] values = value.trim().split("[, ]+");
                double[] data = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    data[i] = Double.parseDouble(values[i].trim());
                }
                return Arrays.copyOf(data, data.length);
            } else {
                throw new IllegalArgumentException("Invalid array format! Provide input like '[1,2]', '1,2', or '[[1,2],[3,4]]'.");
            }
        }

        public static void print(Object arr) {
            if (arr instanceof double[]) {
                System.out.println(Arrays.toString((double[]) arr));
            } else if (arr instanceof double[][]) {
                for (double[] row : (double[][]) arr) {
                    System.out.println(Arrays.toString(row));
                }
            } else {
                throw new IllegalArgumentException("Invalid array format! Must be 1D or 2D double array.");
            }
        }

        private static double[][] deepCopy(double[][] source) {
            double[][] copy = new double[source.length][];
            for (int i = 0; i < source.length; i++) {
                copy[i] = Arrays.copyOf(source[i], source[i].length);
            }
            return copy;
        }
    }