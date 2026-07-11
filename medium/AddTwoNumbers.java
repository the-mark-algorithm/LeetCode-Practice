package medium;

import java.util.Scanner;
import medium.datatypes.ListNode;

/**
 * This class implements one or more solutions to the problem described below:
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example 1:
 *  Input: l1 = [2,4,3], l2 = [5,6,4]
 *  Output: [7,0,8]
 *  Explanation: 342 + 465 = 807.
 * 
 * Example 2:
 *  Input: l1 = [0], l2 = [0]
 *  Output: [0]
 * 
 * Example 3:
 *  Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *  Output: [8,9,9,9,0,0,0,1]
 * 
 * Constraints:
 *  The number of nodes in each linked list is in the range [1, 100].
 *  0 <= Node.val <= 9
 *  It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {


    public static interface Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2);
    }

    public static class Solution1 implements Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            int carryOver = 0;
            int currVal = 0;
            while (l1.getNext() != null || l2.getNext() != null) {
                int val1 = l1 == null ? 0 : l1.getVal();
                int val2 = l2 == null ? 0 : l2.getVal();

                currVal = val1 + val2 + carryOver;
                carryOver = 0;

                if (currVal > 9) {
                    carryOver = 1;
                    currVal = currVal % 10;
                }

                result = new ListNode(currVal);
                result = result.getNext();
            }

            return result;
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Enter the first integer (>= 0): ");
            final String firstNum = scanner.nextLine().trim();
            final ListNode num1 = parseStringNumToListNode(firstNum);

            System.out.println("Enter the second integer (>= 0): ");
            final String secondNum = scanner.nextLine().trim();
            final ListNode num2 = parseStringNumToListNode(secondNum);

            final Solution solution = new Solution1();
            final ListNode result = solution.addTwoNumbers(num1, num2);


            System.out.println(String.format("Result - sum of both numbers: %d", parseListNodeToInteger(result)));
        } catch (final Exception e) {
            throw e;
        } finally {
            scanner.close();
        }
    }

    public static ListNode parseStringNumToListNode(String num) {
        ListNode result = new ListNode();
        for (int i = 0; i < num.length(); i++) {
            int digit = Integer.valueOf(num.charAt(i));
            
            if (i == 0) {
                result = new ListNode(digit);
            } else {
                result = new ListNode(digit, result);
            }
        }
        
        return result;
    }

    public static Integer parseListNodeToInteger(ListNode num) {
        Integer result = 0;
        int multiplier = 1;
        while (num.getNext() != null) {
            result += (num.getVal() * multiplier);
            multiplier *= 10;
        }

        return result;
    }
}

