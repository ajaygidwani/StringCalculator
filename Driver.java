public class Driver{
    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();

        // first point test case, empty string, one number and two numbers
        System.out.println("test case of  \"\"  "  +  "Result =>"  + ( sc.add("") == 0 ));
        System.out.println("test case of  \"2\"  "  +  "Result =>" + (sc.add("2") == 2));
        System.out.println("test case of  \"\"  "  +  "Result =>" + (sc.add("2,3") == 5));

        // test cases for point 2, handling unknown amount of numbers
        System.out.println("test case of  \"1,2,3,4,5\"  "  +  "Result =>" + (sc.add("1,2,3,4,5") == 15));

        // test case for point 3, handling \n between numbers
        System.out.println("test case of  \"1\\n2,3\"  "  +  "Result =>" + (sc.add("1\n2,3") == 6));
    }
}