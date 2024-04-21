public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        return Math.max(
                maxLength(s, '('),  // Check from left to right
                maxLength(reverse(s), ')')  // Check from right to left
        );
    }

    private int maxLength(String s, char c) {
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }

        return maxLength;
    }

    private String reverse(String s) {
        StringBuilder reversed = new StringBuilder(s);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();

        // Example usage:
        System.out.println(solution.longestValidParentheses("(()"));  // Output: 2
        System.out.println(solution.longestValidParentheses(")()())"));  // Output: 4
        System.out.println(solution.longestValidParentheses(""));  // Output: 0
    }
}
