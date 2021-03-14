public class Driver{
    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();
        try{
            // first point test case, empty string, one number and two numbers
            System.out.println("test case of  \"\" == 0  "  +  "Result =>"  + ( sc.add("") == 0 ));
            System.out.println("test case of  \"2\"  == 2 "  +  "Result =>" + (sc.add("2") == 2));
            System.out.println("test case of  \"2,3\"  == 5 "  +  "Result =>" + (sc.add("2,3") == 5));

            // test cases for point 2, handling unknown amount of numbers
            System.out.println("test case of  \"1,2,3,4,5\" == 15  "  +  "Result =>" + (sc.add("1,2,3,4,5") == 15));

            // test case for point 3, handling \n between numbers
            System.out.println("test case of  \"1\\n2,3\"  == 6 "  +  "Result =>" + (sc.add("1\n2,3") == 6));

            // test case for point 4, handling different delimeter
            System.out.println("test case of  \" //;\\n1;2 \" == 3 "  +  "Result =>" + (sc.add("//;\n1;2") == 3));

            // test case for point 7, count how many times add invoked
            System.out.println("Number of times add method invoked: " + sc.getCalledCount());

            // test case for point 8, number bigger than 1000 is ignored
            System.out.println("test case of  \"1,2,3,4000,5\" == 11  "  +  "Result =>" + (sc.add("1,2,3,4000,5") == 11));

            // test case for point 10, delimeter can be of any length
            System.out.println("test case of  \" //[***]\\n1***2***3 \" == 6  "  +  "Result =>" + (sc.add("//[***]\n1***2***3") == 6));

            // test case for point 11, multiple delimeters possible
            System.out.println("test case of  \" //[*][%]\\n1*2%3 \" == 6  "  +  "Result =>" + (sc.add("//[*][%]\n1*2%3") == 6));

            // test case for point 12, multiple delimeters with length longer then one possible
            System.out.println("test case of  \" //[**][%%]\\n1**2%%3 \" == 6  "  +  "Result =>" + (sc.add("//[**][%%]\n1**2%%3") == 6));

            // test case for point 5, handling case if number is negative
            System.out.println("test case of  \" 1,2,-3 \"  == should be exception "  +  "Result =>" + (sc.add("1,2,-3") == 3));

            // test case for point 6, handling multiple negative numbers
            // System.out.println("test case of  \" 1,2,-3,-4,-6 \"  == should be exception "  +  "Result =>" + (sc.add("1,2,-3,-4,-6") == 3));
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}