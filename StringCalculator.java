class StringCalculator {
    public int add(String numbers){
        // handling empty string
        if(numbers.equals("")) {
            return 0;
        }

        // handling case when string size is one
        if(numbers.length() == 1){
            return Integer.valueOf(numbers);
        }

        // handling different delimeters
        // first check if numbers string contains different delimeter or not
        char delimeter = checkForDiffDelimeter(numbers);
        if(delimeter == ',') {
            // no different delimeter
            numbers = numbers.replace('\n', ',');
        } else {
            numbers = numbers.split("\n")[1];
        }

        // getting numbers
        String num[] = numbers.split(delimeter+"");

        // handling unknown amount of numbers
        // remove checking length, because flow will reach here there are more than one number
        return handleUnknownAmountOfNumbers(num);
         
    }

    private char checkForDiffDelimeter(String num){
        if(num.charAt(0) == '/') {
            return num.charAt(2);
        } else {
            return ',';
        }
    }

    private int handleUnknownAmountOfNumbers(String num[]) {
        int sum = 0;
        for(int i = 0 ; i < num.length ; i++) 
            sum = sum + Integer.valueOf(num[i]);
        return sum;
    }
}