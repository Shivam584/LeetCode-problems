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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
         ListNode prvNode=null;
        ListNode currNode=head;
        ListNode nextNode=head.next;
        while(nextNode!=null)
        {   if(currNode.val==nextNode.val)
            {
                while( nextNode!=null && currNode.val==nextNode.val)
                    nextNode=nextNode.next;
                if(prvNode!=null)
                    prvNode.next=nextNode;
                else
                    head=nextNode;
            }
            else{
                prvNode=currNode;
            }
                 currNode=nextNode;
                if(nextNode!=null)
                nextNode=nextNode.next;
              
        }
        return head;
    }
}