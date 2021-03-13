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
        // remove checking length, because flow will reach here there are more than one number
        return handleUnknownAmountOfNumbers(num);
         
    }

    private int handleUnknownAmountOfNumbers(String num[]) {
        int sum = 0;
        for(int i = 0 ; i < num.length ; i++) 
            sum = sum + Integer.valueOf(num[i]);
        return sum;
    }
}