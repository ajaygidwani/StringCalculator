public class Driver{
    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();

        // first point test case, empty string, one number and two numbers
        System.out.println(sc.add(""));
        System.out.println(sc.add("2"));
        System.out.println(sc.add("2,3"));

        // test cases for point 2, handling unknown amount of numbers
        System.out.println(sc.add("1,2,3,4,5"));
    }
}