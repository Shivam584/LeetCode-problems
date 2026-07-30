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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode x=headA, y=headB;
        while(x!=null && y!=null)
        {
            if(x==y)
                return x;
            x=x.next;
            y=y.next;
            
            if(x==null)
                x=headB;
            else if(y==null)
                y=headA;
        }
        return null;
    }
}