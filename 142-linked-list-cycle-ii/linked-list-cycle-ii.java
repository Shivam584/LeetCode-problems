/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
        return head;
        ListNode slow=head;
        ListNode fast= head.next;
        boolean cycleExist= false;
        while(fast!=null && fast.next!=null)
        {
            if(slow==fast)
            {cycleExist=true;break;}
            slow=slow.next;
            fast=fast.next.next;
        }
        if(!cycleExist)
            return null;
        
        ListNode x=head,y=fast.next;
        fast=fast.next;
        slow.next=null;
        while(head!=fast)
        {
            head=head.next;
            fast=fast.next;
            if(head==null)
                head=y;
            if(fast==null)
                fast=x;
        }
        slow.next=y;
        return fast;
    }
}