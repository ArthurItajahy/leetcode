public class LargestPosistiveInteger {
    public int findMaxK(int[] nums) {
        // I'll gonna need to declare one variable.
        int largerNumber = 0;
        for(int i = 0; i< nums.length; i++){
            // A loop to pass by the array
            if(nums[i] > 0){
                boolean result = verify(nums, nums[i]);
                if(largerNumber < nums[i] && result == true){
                    largerNumber = nums[i];
                }
            }
        }
        return largerNumber;

    }
    public boolean verify(int[] nums, int x){
        for(int i = 0; i< nums.length; i++){
            if(x*-1 == nums[i]){
                return true;
            }
        }
        return false;
    }
    public static void  main(String[] args){
        LargestPosistiveInteger s = new LargestPosistiveInteger();
        int[] nums = {-1,2,-3,3};
        System.out.println(s.findMaxK(nums));// 3
    }
}
