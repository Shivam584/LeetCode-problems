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
    ListNode revHead;
    boolean check( ListNode head)
    {
        if(head==null)
            return true;
        boolean ans=check(head.next) && revHead.val==head.val;
        revHead=revHead.next;
        return ans;
    }
    public boolean isPalindrome(ListNode head) {
         revHead=head;
        return check(head);
    }
}