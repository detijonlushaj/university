import java.util.Scanner;
public class Geheim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user1 = "doors", user2 = "gates", user3 = "dent";
        String pass1 = "lightmyfire", pass2 = "dos", pass3 = "42";
        
        String tmpuser = ask(scanner, "Benutzername");
        String tmppass = ask(scanner, "Geheimwort");
        
        String evalR = "richtig", evalW = "falsch", evalC = "Benutzername richtig, Geheimwort falsch";
        
        if (tmpuser.equals(user1) && tmppass.equals(pass1) || tmpuser.equals(user2) && tmppass.equals(pass2) || tmpuser.equals(user3) && tmppass.equals(pass3)) {
            eval(evalR);    
        }
        else if (tmpuser.equals(user1) || tmpuser.equals(user2) || tmpuser.equals(user3)) {
            eval(evalC);
        }
        else {
            eval(evalW);
        }
    }
    
    public static String ask(Scanner scanner, String para) {
        print(para);
        return assign(scanner);
    }
    
    public static void print(String para) {
        System.out.print(para + " bitte: ");
    }
    
    public static String assign(Scanner scanner) {
        return scanner.next();
    }
    
    public static void eval(String para) {
        System.out.println(para);
    }
}