public class Seq    {
    public static void main(String[] args)  {
        System.out.print("a) ");
        for (int count = 1; count <= 8; count++)    {
            System.out.print(count * 2 + ", ");
        }
        System.out.println();
        
        System.out.print("b) ");
        for (int count = 1; count <= 8; count++)    {
            System.out.print(count * 8 + 6 + ", ");
        }
        System.out.println();
        
        System.out.print("c) ");
        for (int count = 1; count <= 8; count++)    {
            System.out.print(count * -5 + 134 + ", ");
        }
        System.out.println();
        
        System.out.print("d) ");
        for (int count = 1; count <= 8; count++)    {
            System.out.print((int) Math.pow(count, 2) + ", ");
        }
        System.out.println();
        
        System.out.print("e) ");
        for (int count = 1; count <= 8; count++)    {
            System.out.print(count * count + count + 2 + ", ");
        }
    }
}