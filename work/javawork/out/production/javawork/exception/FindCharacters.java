package exception;

public class FindCharacters {
    public static void main(String[] args) {
        String s = "Boys. be ambitious";
        FindCharacters obj = new FindCharacters();
        System.out.println(obj.countChar(s, 'B'));
    }
    int countChar(String str, char c) {
        char[] arrC = str.toCharArray();
        int result = 0;
        for (char cha : arrC) {
            if (cha == c) {
                result += 1;
            }
        } return result;
    }

}
