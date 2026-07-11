import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This class implements one or more solutions to the problem described below:
 * 
 * Given an array of integers - nums and an integer - target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Example 1:
 *  Input: nums = [2,7,11,15], target = 9
 *  Output: [0,1]
 *  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 *  Input: nums = [3,2,4], target = 6
 *  Output: [1,2]
 * 
 * Example 3:
 *  Input: nums = [3,3], target = 6
 *  Output: [0,1]
 * 
 * Constraints:
 *  2 <= nums.length <= 10^4
 *  -10^9 <= nums[i] <= 10^9
 *  -10^9 <= target <= 10^9
 *  Only one valid answer exists.
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
public class TwoSum {

    public static interface Solution {
        public int[] twoSum(int[] nums, int target);
    }

    public static class Solution1 implements Solution {

        public int[] twoSum(int[] nums, int target) {
            final List<Integer> result = new ArrayList<>();
            final Map<Integer, Integer> inverse = new HashMap<>();

            for (int num : nums) {
                inverse.put(target - num, 1);
            }

            for (int i = 0; i < nums.length;  i++) {
                if (inverse.get(nums[i]) != null) {
                    result.add(i);
                }
            }
            // Edge Case: target is even, if (target/2) is in nums -> same element is used twice, remove it from result
            if (result.size() > 2) {
                for (int i = 0; i < result.size(); i++) {
                    if (nums[result.get(i)] == target / 2) {
                        result.remove(i);
                    }
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a comma-separate list of integers like so: 1, 2, 3, 4, ...");
            final String numString = scanner.nextLine();
            
            System.out.println("Enter the target number (single integer): ");
            final int target = Integer.parseInt(scanner.nextLine().trim());

            // process integer list to array for input
            final int[] nums = List.of(numString.trim().split(",")).stream().map(String::trim).mapToInt(Integer::parseInt).toArray();

            // calculate result
            final TwoSum.Solution solution = new TwoSum.Solution1();
            final int[] result = solution.twoSum(nums, target);

            System.out.println(String.format("Result - Indices of elements in list that add up to the target: %d, %d", result[0], result[1]));
        } catch (final Exception e) {
            throw e;
        } finally {
            scanner.close();
        }
    }
    
}
