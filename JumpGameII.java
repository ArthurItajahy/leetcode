public class JumpGameII {
    public static int minJumps(int[] nums){
        int n = nums.length;
        if(n <= 1){
            return 0;
        }

        int maxReach = nums[0]; // Maximum index reachable
        int lastJump = nums[0]; // Index where the last occurred
        int steps = 1; // Number of Jumps taken so far

        for(int i = 1; i<n - 1; i++){
            maxReach = Math.max(maxReach, i+ nums[i]);
            if(i == lastJump){
                lastJump = maxReach;
                steps++;
            }
            if(maxReach >= n - 1) {
                return steps;
            }
        }
        return -1; // If unable to reach the last index
    }
    public static void main(String[] args){
        int[] nums1 = { 2, 3, 1, 1, 4};
        System.out.println(minJumps(nums1)); // Output: 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(minJumps(nums2)); // Output: 2
    }
}
