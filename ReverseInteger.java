public class ReverseInteger {
    public int reverse(int x) {
        String s = String.valueOf(x);
        if(x < 0){
            s = s.replace("-", "");
        }
        s = reverse(s);
        long  n = Long.parseLong(s);
        if( n < -2147483647  ||  n > 2147483647 ){
            return 0;
        }

        if(x < 0){
            return(int) n * -1;
        }

        return (int) n;

    }

    public String reverse(String str){

        char[] charArray = str.toCharArray();

        int left = 0;
        int right = charArray.length -1;
        while(left  < right){
            char temp = charArray[left];

            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        String result = new String(charArray);
        return result;


    }
}
