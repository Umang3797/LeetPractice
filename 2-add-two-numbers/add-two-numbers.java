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
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;

        int carry=0;
        int totalsum=0;

        while(l1!=null || l2!=null){
            if(l1!=null){
                totalsum = totalsum+l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                totalsum = totalsum+l2.val;
                l2=l2.next;
            }
            totalsum = totalsum+carry;
            temp.next = new ListNode(totalsum%10);
            temp=temp.next;

            carry=totalsum/10;
            if(carry>0){
                temp.next=new ListNode(carry);
            }
            totalsum=0;
        }

        return l3.next;
        
    }
}
