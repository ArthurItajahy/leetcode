public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // Empty pattern matches empty string

        // Fill the first row of dp array
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // '*' can match zero characters
            }
        }

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, move diagonally
                } else if (p.charAt(j - 1) == '*') {
                    // '*' can match zero or more occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2]; // Zero occurrence
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j]; // One or more occurrences
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching matcher = new RegularExpressionMatching();

        // Example usage
        String s1 = "aa";
        String p1 = "a";
        System.out.println(matcher.isMatch(s1, p1)); // Output: false

        String s2 = "aa";
        String p2 = "a*";
        System.out.println(matcher.isMatch(s2, p2)); // Output: true
    }
}
