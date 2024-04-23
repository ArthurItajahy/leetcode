public class JumpGameII {
    public static int minJumps(int[] nums) {

            int n = nums.length;
            if (n <= 1) {
                return 0; // No jumps needed if there's only one element or none
            }

            int jumps = 0; // Number of jumps taken so far
            int maxReach = 0; // Farthest index reachable in a single jump
            int currentMaxReach = 0; // Farthest index reachable with the current number of jumps

            // Iterate through the array
            for (int i = 0; i < n - 1; i++) {
                maxReach = Math.max(maxReach, i + nums[i]); // Update maxReach

                // If we've reached the end of the current reachable indices
                if (i == currentMaxReach) {
                    jumps++; // Increment the number of jumps
                    currentMaxReach = maxReach; // Update currentMaxReach
                }
            }

            return jumps;

    }
    public static void main(String[] args){

        int[] nums1 = {3,2,1};
        System.out.println(minJumps(nums1)); // Output: 1

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(minJumps(nums2)); // Output: 2
        int[] nums3 = {2,3,1,1,4};
        System.out.println(minJumps(nums3)); // Output: 2

        int[] nums4 = {1,2,3};
        System.out.println(minJumps(nums4)); // Output: 2
    }

}
