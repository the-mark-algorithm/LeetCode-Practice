package hard;

import java.util.Scanner;

/**
 * This class implements one or more solutions to the problem described below:
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median
 * of the two sorted arrays. The overall run time complexity should be O(log (m + n)).
 *
 * Example 1:
 *  Input: nums1 = [1,3], nums2 = [2]
 *  Output: 2.00000
 *
 * Example 2:
 *  Input: nums1 = [1,2], nums2 = [3,4]
 *  Output: 2.50000
 *
 * Constraints:
 *  0 <= m, n <= 1000
 *  1 <= m + n <= 2000
 *  nums1 and nums2 are sorted in non-decreasing order
 */
public class MedianOfTwoSortedArrays {

    public static interface Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2);
    }

    public static class Solution1 implements Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // TODO: implement solution
            return 0.0;
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the first sorted array as a comma-separated list (e.g. 1,3,...):");
            final String firstInput = scanner.nextLine().trim();
            final int[] nums1 = parseInputArray(firstInput);

            System.out.println("Enter the second sorted array as a comma-separated list (e.g. 2,7,...):");
            final String secondInput = scanner.nextLine().trim();
            final int[] nums2 = parseInputArray(secondInput);

            final Solution solution = new Solution1();
            final double result = solution.findMedianSortedArrays(nums1, nums2);

            System.out.println(String.format("Result - median of the two sorted arrays: %.5f", result));
        } catch (final Exception e) {
            throw e;
        } finally {
            scanner.close();
        }
    }

    private static int[] parseInputArray(String input) {
        if (input == null || input.isBlank()) {
            return new int[0];
        }

        final String[] parts = input.split(",");
        final int[] result = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }

        return result;
    }
}
