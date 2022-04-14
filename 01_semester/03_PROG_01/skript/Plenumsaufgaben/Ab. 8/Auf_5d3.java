public class Auf_5d3 {
    public static void main(String[] args) {
        System.out.println("Ist es ein Vokal: " + istVokal('e'));
    }
    
    public static boolean istVokal(char ch) {
        String vocals = "aeiou";
        for (int i = 0; i < vocals.length(); i++) {
            if (vocals.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }
}