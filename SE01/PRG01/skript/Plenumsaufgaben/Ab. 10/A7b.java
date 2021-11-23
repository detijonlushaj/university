import java.util.Arrays;
public class A7b {
    public static void main(String[] args) {
        int[] a = {2, 5, -1, 6, 14, -7, -9};
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                a[i] = 0;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}