/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode p, ListNode q) {
        ListNode runner1 = p, runner2 = q;
        
        while (runner1 != runner2) { // Guaranteed to complete since both nodes belong to same tree
            // We are simulating a cycle when any of the conditions below is satisfied 
            // by pointing runner to the head of the other "list"  to make sure 
            // intersection is found before either of the below conditions are satisfied again
            runner1 = (runner1 == null)?q:runner1.next;
            runner2 = (runner2 == null)?p:runner2.next;
        }
        
        return runner1;
    }
}