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

        // getting numbers
        String num[] = numbers.split(",");

        // if string has two numbers
        int sum = Integer.valueOf(num[0]) + Integer.valueOf(num[1]); 
        return sum;
    }
}