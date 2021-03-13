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

        // handling unknown amount of numbers
        if(num.length > 2) {
            int result = handleUnknownAmountOfNumbers(num);
            return result;
        } 

        // if string has two numbers
        return Integer.valueOf(num[0]) + Integer.valueOf(num[1]); 
    }

    private int handleUnknownAmountOfNumbers(String num[]) {
        int sum = 0;
        for(int i = 0 ; i < num.length ; i++) {
            int number = Integer.valueOf(num[i]);
            sum = sum + number;
        }
        return sum;
    }
}