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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size=0;
        ListNode temp=head;
        while(temp!=null) {
            temp=temp.next;
            size++;
        }
        ListNode[] ans = new ListNode[k];

        int extra = size%k;
        int base = size/k;

        ListNode curr=head;

        for(int i=0; i<k; i++) {
            if(curr==null) {
                ans[i]=curr;
                continue;
            }
            
            ans[i]=curr;

            int partSize = base+(extra>0 ? 1 : 0);
            if(extra>0) extra--;

            for(int j=1; j<partSize; j++) {
                curr=curr.next;
            }

            ListNode nextNode = curr.next;
            curr.next=null;
            curr = nextNode; 

        }
        return ans;  
    }
}