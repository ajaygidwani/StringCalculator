import java.util.ArrayList;
import  java.util.*;
class StringCalculator {

    private int addInvokeCounter = 0;
    private ArrayList<String> listOfDelimeters = new ArrayList<>();
    private Stack<Character> stack = new Stack<>();

    public int add(String numbers) throws Exception{

        // handling increment variable each time when add method called
        addInvokeCounter += 1;

        // handling empty string
        if(numbers.equals("")) {
            return 0;
        }

        // handling case when string size is one
        if(numbers.length() == 1){
            return handleCaseNumEqualsOne(numbers);
        }

        // handling test case 4, different delimeter
        if(numbers.charAt(2) != '[' && numbers.charAt(0) == '/') {
            char delimeter = numbers.charAt(2);
            numbers = numbers.split('\n'+"")[1];
            String num[] = numbers.split(delimeter+"");
            return handleUnknownAmountOfNumbers(num);
        }

        // handling different delimeters
        // first check if numbers string contains different delimeter or not
        boolean isDelimeterComma = checkForDiffDelimeter(numbers);
        if(isDelimeterComma == true) {
            // no different delimeter
            numbers = numbers.replace('\n', ',');
            String num[] = numbers.split(','+"");
            return handleUnknownAmountOfNumbers(num);
        } else {
            if(numbers.indexOf('\n') != -1) {
                // means numbers contains \n
                numbers = numbers.split("\n")[1];
                String splitPattern = getSplitPattern();
                String num[] = numbers.split(splitPattern);
                return handleUnknownAmountOfNumbers(num);
            } else {
                String num[] = numbers.split(",");
                return handleUnknownAmountOfNumbers(num);
            }
        }     
    }

    private String getSplitPattern() {
        String splitPattern = "";
        for(String str : listOfDelimeters) {
            for(int i = 0 ; i < str.length() ; i++) {
                if(str.charAt(i) == '*'){
                    splitPattern += "\\*";
                } else {
                    splitPattern += str.charAt(i);
                }
            }
            splitPattern+= "|";
        }
        splitPattern = splitPattern.substring(0, splitPattern.length()-1);
        return splitPattern;
    }

    private int handleCaseNumEqualsOne(String numbers) throws Exception{
        // handling negetive number
        int tempNum = Integer.valueOf(numbers);
        if(tempNum > 1000) return 0;
        if(tempNum < 0)
            throw new Exception("negatives not allowed " + tempNum);
        return tempNum;
    }

    private boolean checkForDiffDelimeter(String num){

        // using stack for fetching the delimeters of different type and having length more than one
        if(num.charAt(0) == '/') {
            listOfDelimeters.clear();
            for(int i = 2; num.charAt(i)!= '\n' ; i++ ) {
                char ch = num.charAt(i);
                if(ch == '[') {
                    stack.push(ch);
                } else if(ch == ']'){
                    String delim = "";
                    while(!stack.empty()){
                        char poppedElement = stack.pop();
                        if(poppedElement != '[') {
                            delim += poppedElement;
                        }
                    }
                    listOfDelimeters.add(delim);
                } else {
                    stack.push(ch);
                }
            }
        }
        if(listOfDelimeters.size() > 0){
            return false;
        } else {
            return true;
        }
    }

    private int handleUnknownAmountOfNumbers(String num[]) throws Exception{
        int sum = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < num.length ; i++){
            int numTemp = Integer.valueOf(num[i]);
            // handling case 9, numbers bigger then 1000 should be ignored
            if(numTemp > 1000) continue;
            if(numTemp < 0) list.add(numTemp+"");
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