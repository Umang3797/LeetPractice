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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        // push digits onto stacks
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode head = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int x1 = !s1.isEmpty() ? s1.pop() : 0;
            int x2 = !s2.isEmpty() ? s2.pop() : 0;

            int sum = x1 + x2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            // prepend node
            ListNode node = new ListNode(digit);
            node.next = head;
            head = node;
        }
        return head;
    }
}