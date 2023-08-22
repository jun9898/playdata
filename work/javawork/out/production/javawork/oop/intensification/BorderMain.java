
public class BorderMain {
    public static void main(String[] args) {
    	
        Display display1 = new StringDisplay("Hello, world.");
        Display display2 = new SideBorder(display1, '#');
        Display display3 = new SideBorder(new SideBorder( new StringDisplay("Hello Gurum"), '#'), '&');
        Display display4 = new FullBorder( display3 );

        System.out.println("1. 문자열을 출력합니다.");
        display1.show();
        System.out.println();

        System.out.println("2. '#'으로 Side를 장식합니다.");
        display2.show();
        System.out.println(); 
        
        System.out.println("3. '&'으로 Side를 장식합니다.");
        display3.show();
        System.out.println(); 
        
        System.out.println("4. 모든 테두리를 장식합니다."); 
        display4.show();
    }
}
