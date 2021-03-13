public class Driver{
    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();
        System.out.println(sc.add(""));
        System.out.println(sc.add("2"));
        System.out.println(sc.add("2,3"));
    }
}