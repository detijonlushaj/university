public class A7fii {
    public static void main(String[] args) {
        System.out.println(wordCount("the quick brown fox"));
    }
    
    public static int wordCount(String s) {
        return s.split(" ").length;
    }
}