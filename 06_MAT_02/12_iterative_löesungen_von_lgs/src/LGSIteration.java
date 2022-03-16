import java.util.Arrays;

public class LGSIteration {

    public static void main(String[] args) {
        double[][] a = {{5.0, 1.0, 1.0}, {1.0, 5.0, 0.0}, {1.0, 0.0, 5.0}};
        double[] b = {1.0, 2.0, 0.0};
        //jacobi(a, b, 2);
        gaussSeidel(a, b, 1);
    }

    public static double[] jacobi(double[][] a, double[] b, int step) {
        // catch exceptions
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != a.length) {
                throw new IllegalArgumentException("1. Parameter muss quadratische Matrix sein");
            }
        }

        if (a.length != b.length) {
            throw new IllegalArgumentException("1. & 3. Parameter müssen gleiche Dimension haben");
        }

        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i][i]) < 1e-8) {
                throw new IllegalArgumentException("Diagonalen dürfen nicht 0en vorkommen");
            }
        }
        
        // check if convergent
//        for (int i = 0; i < a.length; i++) {
//            double sum = 0;
//            for (int j = 0; j < a.length; j++) {
//                if (i != j) {
//                    sum += Math.abs(a[i][j]);
//                }
//            }
//            if (sum >= Math.abs(a[i][i])) {
//                throw new IllegalArgumentException("Bedingung für Konvergenz nicht erfüllt");
//            }
//        }

        try {
            int it = 0;
            double[] y = new double[a.length];
            double[] x = new double[a.length];
            
            // special case for steps
            if (step == 0) {
                return y;
            } else if (step < 0) {
                throw new IllegalArgumentException("3. Parameter muss >= 0 sein");
            }

            // first iteration find solution
            for (int i = 0; i < a.length; i++) {
                try {
                    y[i] = b[i] / a[i][i];
                } catch(IllegalArgumentException e) {
                    throw new IllegalArgumentException("nicht durch 0 teilen");
                }
            }

            System.out.println(Arrays.toString(y));

            // copy solution
            for (int i = 0; i < y.length; i++) {
                x[i] = y[i];
            }        

            while (it < step) {
                for (int i = 0; i < y.length; i++) {
                    x[i] = y[i];
                }

                for (int i = 0; i < a.length; i++) {
                    try {
                        double term = 0;
                        for (int j = 0; j < a.length; j++) {
                            if (i != j) {
                                double r = x[j];
                                double t = a[i][j];
                                term += x[j]*a[i][j];
                            }
                        }

                        y[i] = (b[i] - term)/ a[i][i];
                    } catch(IllegalArgumentException e) {
                        throw new IllegalArgumentException("nicht durch 0 teilen");
                    }
                }
                System.out.println(Arrays.toString(y));
                it++;
            } 
            return x;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("irgendetwas schief gelaufen");
        }
    }
    
    public static double[] gaussSeidel(double[][] a, double[] b, int step) {
     // catch exceptions
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != a.length) {
                throw new IllegalArgumentException("1. Parameter muss quadratische Matrix sein");
            }
        }

        if (a.length != b.length) {
            throw new IllegalArgumentException("1. & 3. Parameter müssen gleiche Dimension haben");
        }

        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i][i]) < 1e-8) {
                throw new IllegalArgumentException("Diagonalen dürfen nicht 0en vorkommen");
            }
        }
        
        // check if convergent
//        for (int i = 0; i < a.length; i++) {
//            double sum = 0;
//            for (int j = 0; j < a.length; j++) {
//                if (i != j) {
//                    sum += Math.abs(a[i][j]);
//                }
//            }
//            if (sum >= Math.abs(a[i][i])) {
//                throw new IllegalArgumentException("Bedingung für Konvergenz nicht erfüllt");
//            }
//        }

        try {
            int it = 1;
            double[] y = new double[a.length];
            
            // special case for steps
            if (step == 0) {
                return y;
            } else if (step < 0) {
                throw new IllegalArgumentException("3. Parameter muss >= 0 sein");
            }

            for (int i = 0; i < a.length; i++) {
                try {
                    double term = 0;
                    for (int j = 0; j < a.length; j++) {
                        if (i != j) {
                            double r = y[j];
                            double t = a[i][j];
                            term += y[j]*a[i][j];
                        }
                    }

                    y[i] = (b[i] - term)/ a[i][i];
                } catch(IllegalArgumentException e) {
                    throw new IllegalArgumentException("nicht durch 0 teilen");
                }
            }

            System.out.println(Arrays.toString(y));  
            double[] x = y;
            while (it < step) {
                x = y;
                for (int i = 0; i < a.length; i++) {
                    try {
                        double term = 0;
                        for (int j = 0; j < a.length; j++) {
                            if (i != j) {
                                double r = x[j];
                                double t = a[i][j];
                                term += x[j]*a[i][j];
                            }
                        }

                        y[i] = (b[i] - term)/ a[i][i];
                    } catch(IllegalArgumentException e) {
                        throw new IllegalArgumentException("nicht durch 0 teilen");
                    }
                }
                System.out.println(Arrays.toString(y));
                it++;
            } 
            return x;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("irgendetwas schief gelaufen");
        }
    }

}
