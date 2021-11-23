public class A4_2m  {
    public static void main(String[] args)  {
        System.out.println("a)");
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("b)");
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("c)");
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("d)");
        for (int i = 1; i <= 2; i++)    {
            for (int j = 1; j <= 3; j++)    {
                System.out.println(j + ", " + i);
            }
        }
    }
}