public class U03    {
    public static void main(String[] args)  {
        int x;
        double y;
        double z;
        
        x = (int)(5.4 * 4.3); 
        System.out.println(x);
        x = (int)(3.00001 - 1.00001); 
        System.out.println(x);
        x = 4 / 5; 
        System.out.println(x);
        y = 2 - 1; 
        System.out.println(y);
        y = 3.0 * 2.6; 
        System.out.println(y);
        z = (double)19/5; // ohne double würde 3.0 rauskommen
        System.out.println(z);
    }
}