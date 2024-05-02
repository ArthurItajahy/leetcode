public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int largerCount = 0;
        for(int i = 0; i < s.length(); i++){
            int veri = verify(s, i);
            if(veri > largerCount){
                largerCount = veri;
            }
        }
        return largerCount;
    }
    public int verify(String s, int position){
        String result = "";
        for(int i = position; i < s.length(); i++){
            char charc = s.charAt(i);
            if(result.contains(String.valueOf(charc))){
                return result.length();
            }else{
                result += String.valueOf(charc);
            }
        }
        return result.length();

    }
}
