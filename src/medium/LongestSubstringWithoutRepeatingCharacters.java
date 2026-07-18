package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class implements one or more solutions to the problem described below:
 * 
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 *  Input: s = "abcabcbb"
 *  Output: 3
 *  Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *  Input: s = "bbbbb"
 *  Output: 1
 *  Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *  Input: s = "pwwkew"
 *  Output: 3
 *  Explanation: The answer is "wke", with the length of 3.
 *
 * Constraints:
 *  0 <= s.length <= 5 * 10^4
 *  s consists of English letters, digits, symbols, and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static interface Solution {
        public int lengthOfLongestSubstring(String s);
    }

    public static class Solution1 implements Solution {

        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            int currLen = 0;
            int start = 0;
            Map<Integer, Integer> tracker = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // Check if 'duplicate' is in portion of string we already processed - should not count, remove it
                if (tracker.containsKey((int) c) && tracker.get((int) c) < start) {
                    tracker.remove((int) c);
                }

                // If we've ended unique consecutive run or the end of string, update values
                if (tracker.containsKey((int) c)) {
                    // update trackers for next iteration and next potential longest substring
                    start = tracker.get((int) c) + 1;
                    tracker.remove((int) c);

                    currLen = i - start + 1;
                } else {
                    currLen += 1;
                }

                tracker.put((int) c, i);
                if (result < currLen) result = currLen;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            final String s = scanner.nextLine();

            final Solution solution = new Solution1();
            final int result = solution.lengthOfLongestSubstring(s);

            System.out.println(String.format("Result - length of longest substring without repeating characters: %d", result));
        } catch (final Exception e) {
            throw e;
        } finally {
            scanner.close();
        }
    }
}
