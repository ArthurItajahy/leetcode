public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            // Update left and right maximum heights
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                // Water trapped at current position depends on leftMax
                water += leftMax - height[left];
                left++;
            } else {
                // Water trapped at current position depends on rightMax
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Example usage:
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height1)); // Output: 6

        int[] height2 = {4,2,0,3,2,5};
        System.out.println(solution.trap(height2)); // Output: 9
    }
}
