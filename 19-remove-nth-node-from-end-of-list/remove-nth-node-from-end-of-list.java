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
    int i;
    int j;
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if(head==null)
        return head;
        j++;
        ListNode temp=removeNthFromEnd(head.next,n);
        if(i==n)
            {
                if(temp!=null)
                head.next=temp.next;
            }
        i++;
        return (j==n)?head.next : head;
    }
}