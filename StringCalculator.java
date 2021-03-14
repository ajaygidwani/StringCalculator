import java.util.ArrayList;
class StringCalculator {

    private int addInvokeCounter = 0;

    public int add(String numbers) throws Exception{

        // handling increment variable each time when add method called
        addInvokeCounter += 1;

        // handling empty string
        if(numbers.equals("")) {
            return 0;
        }

        // handling case when string size is one
        if(numbers.length() == 1){

            // handling negetive number
            int tempNum = Integer.valueOf(numbers);
            if(tempNum > 1000) return 0;
            if(tempNum < 0)
                throw new Exception("negatives not allowed " + tempNum);
            return tempNum;
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
        }
        return ',';
    }

    private int handleUnknownAmountOfNumbers(String num[]) throws Exception{
        int sum = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < num.length ; i++){
            int numTemp = Integer.valueOf(num[i]);
            // handling case 9, numbers bigger then 1000 should be ignored
            if(numTemp > 1000) {
                continue;
            }
            if(numTemp < 0) 
                list.add(numTemp+"");
            sum = sum + numTemp;
        } 
        // check if multiple negetive numbers present
        if(!list.isEmpty()){
            String allNegativeNumbers = String.join(", ", list);
            throw new Exception("negatives not allowed, all negative numbers are : " + allNegativeNumbers );
        }
        return sum;
    }

    public int getCalledCount() {
        return this.addInvokeCounter;
    }

}