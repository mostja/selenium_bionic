/**
 * Created by Mostja on 16-Feb-15.
 */
public class RegExp {
    public static void main(String[] args) {
        String someString = "Ahalay mahalay 12.39";
        boolean patternMatch = assertMatch (someString);
        System.out.print(patternMatch);
    }
    private static boolean assertMatch(String s){
        return s.matches(".*\\d+(\\.\\d+).*");
    }
}
