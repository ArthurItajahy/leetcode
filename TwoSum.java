import java.util.Arrays;
import java.util.HashMap;
public class TwoSum {
        public int[] twoSum(int[] nums, int target) {

            // Create a HashMap to store elements and their indices
            HashMap<Integer, Integer> map = new HashMap<>();

            // Iterate through the array
            for(int i = 0; i < nums.length; i++){
                int complement = target - nums[i];

                // Check if the complement exists in the map
                if(map.containsKey(complement)){
                    // if yes, return the indices of the current element
                    return new int[] {map.get(complement), i};
                }
                // Otherwise, put the current element and its index into the map
                map.put(nums[i], i);
            }
            return null;
        }

        public static void main(String[] args){
            TwoSum sum = new TwoSum();
            int[] arr = {2,7,6,7,8};
            int target = 9;

            System.out.println(Arrays.toString(sum.twoSum(arr, target)));

    }


}
