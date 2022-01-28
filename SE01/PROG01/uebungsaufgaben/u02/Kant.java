/** Abgabeteam 3
    Detijon Lushaj und Schehat Abdel Kader
    U03 Eine Nachricht 1000 Mal ausgeben
    */ 
public class Kant   {
    public static void main(String[] args) {
        zitat1000();
    }
    
    /** Zitat 1000 Durchläufe */
    public static void zitat1000(){
        zitat100();
        zitat100();
        zitat100();
        zitat100();
        zitat100();
        zitat100();
        zitat100();
        zitat100();
        zitat100();
        zitat100();
    }
    
    /** Zitat 100 Durchläufe */
    public static void zitat100(){
        zitat10();
        zitat10();
        zitat10();
        zitat10();
        zitat10();
        zitat10();
        zitat10();
        zitat10();
        zitat10();
        zitat10();
    }
    
    
    /** Zitat 10 Durchläufe */
    public static void zitat10(){
        zitat();
        zitat();
        zitat();
        zitat();
        zitat();
        zitat();
        zitat();
        zitat();
        zitat();
        zitat();
    }
    
    /** Zitat von Kant */
    public static void zitat()   {
        System.out.println("Habe Mut dich deines eigenen Verstandes zu bedienen!");
    }
    
}