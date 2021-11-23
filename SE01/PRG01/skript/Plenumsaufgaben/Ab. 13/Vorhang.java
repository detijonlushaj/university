public class Vorhang {
    public static void main(String[] args) {
        vorhang(3, "|---");
    }
    
    public static void vorhang(int tiefe, String prefix) {
        if (tiefe == 1) {
            System.out.println(prefix + "O");
        } else {
            vorhang(tiefe - 1, prefix + "---");
            System.out.println(prefix + "O");
            vorhang(tiefe - 1, prefix + "---");
        }
    }
}