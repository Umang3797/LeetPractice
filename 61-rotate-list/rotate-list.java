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
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // Step 1: Compute the length of the linked list
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        // Now, 'curr' is at the last node
        ListNode tail = curr;
        
        // Step 2: Compute the effective rotation
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }
         // Step 3: Find the new head and tail
        int stepsToNewHead = length - k;
        curr = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            curr = curr.next;
        }
        // 'curr' is now the new tail
        ListNode newHead = curr.next;
        curr.next = null; // Break the link
        
        // Step 4: Link the old tail to the original head
        tail.next = head;
        
        return newHead;
    }
}