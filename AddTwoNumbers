You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode sumList = new ListNode(0);
        ListNode sumCurr = sumList;
        int carry = 0;
        
        while(curr1 != null || curr2!= null)
        {
            int num1 = 0;
            int num2 = 0;
            if(curr1 != null)
                num1 = curr1.val;
            if(curr2 != null)
                num2 = curr2.val;

            int sum = num1 + num2 + carry;
            carry = 0;
            if(sum >= 10)
            {
                carry = 1;
                sum = sum %10;
            }
            sumCurr.next = new ListNode(sum); 
            sumCurr = sumCurr.next;
            if(curr1 != null)
                curr1 = curr1.next;
            if(curr2 != null)
                curr2 = curr2.next;
        }
        if(carry == 1)
            sumCurr.next = new ListNode(carry);
        return sumList.next;
    }
}
