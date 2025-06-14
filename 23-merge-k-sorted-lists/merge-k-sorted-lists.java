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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists==null || lists.length==0) return null;
        
        // PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> Integer.comapre(a.val,b.val));
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>((a,b)-> Integer.compare(a.val, b.val));

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}