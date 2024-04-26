    import java.util.HashMap;
public class RomanToInteger {


        public int romanToInt(String s) {
            HashMap<String, Integer> romanNumbers = new HashMap<>();

            romanNumbers.put("I", 1);
            romanNumbers.put("V", 5);
            romanNumbers.put("X", 10);
            romanNumbers.put("L", 50);
            romanNumbers.put("C", 100);
            romanNumbers.put("D", 500);
            romanNumbers.put("M", 1000);
            int result = sumNumbers(s, romanNumbers);
            return result;


        }

        public int sumNumbers(String s, HashMap<String, Integer> romanNumbers){
            int sum = 0;
            for(int i = 0; i < s.length(); i++){
                String symbol = s.substring(i, i+1); // Get the current symbol as a string
                if(i+1 < s.length()){
                    String nextSymbol = s.substring(i+1, i+2);
                    if(romanNumbers.containsKey(symbol) && romanNumbers.containsKey(nextSymbol)){
                        int currentNumber = romanNumbers.get(symbol);
                        int nextNumber = romanNumbers.get(nextSymbol);
                        if(currentNumber< nextNumber){
                            // if the current number is less than the next number
                            sum -= currentNumber;
                        }else{
                            // Otherwise, add it
                            sum += currentNumber;
                        }
                    }
                }else{
                    sum += romanNumbers.get(symbol);
                }
            }
            return sum;



        }
        public static void main(String[] args){
            RomanToInteger roman = new RomanToInteger();
            String oneHundred = "C";

            System.out.println(roman.romanToInt(oneHundred));// Output: 100

            System.out.println(roman.romanToInt("XXII"));// Output: 100
            System.out.println(roman.romanToInt("D"));// Output: 100
            System.out.println(roman.romanToInt("MCMD"));// Output: 100
        }

    }
