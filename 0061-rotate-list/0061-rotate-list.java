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
        if(head==null || head.next==null || k==0) {
            return head;
        }
        int size=0;
        ListNode temp = head;
        while(temp!=null) {
            size++;
            temp=temp.next;
        }
        k=k%size; //if k==size
        if(k==0) return head;
        int breakPoint = size-k;
        ListNode prev = null;
        ListNode curr = head;
        while(breakPoint-->0) {
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        ListNode tail=curr;
        while(tail.next!=null) {
            tail=tail.next;
        }
        tail.next=head;
        return curr;
    }
}