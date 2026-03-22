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
    public ListNode swapPairs(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        if(head==null || head.next==null) return curr;
        while(curr!=null && curr.next!=null){
          if(curr==head){
            head=curr.next;
          }
          ListNode next=curr.next;
          if(prev!=null) prev.next=next;
          curr.next=next.next;
          next.next=curr;
          prev=curr;
          curr=curr.next;
        }
        return head;
    }
}