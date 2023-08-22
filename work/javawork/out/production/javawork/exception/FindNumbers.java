package exception;

public class FindNumbers {
    public static void main(String[] args) {
        FindNumbers fn=new FindNumbers();

        long number = 228754462;
        System.out.println( "입력 숫자 = " + number );
        System.out.println( "2 횟수 => " + fn.countNumber(number, 2));
        System.out.println( "4 횟수 => " + fn.countNumber(number, 4));
    }

    public int countNumber(long number, int i) {
        char charI = Character.forDigit(i,10);
        int result = 0;
        String arr = Long.toString(number);
        char[] strArr = arr.toCharArray();

        for (char c : strArr) {
            if (c == charI) {
                result += 1;
            }
        }
        return result;
    }

}

