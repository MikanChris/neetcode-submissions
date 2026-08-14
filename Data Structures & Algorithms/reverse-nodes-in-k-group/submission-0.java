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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while(true){
            ListNode kth = getKth(groupPrev, k);
            
            if(kth == null){
                break;
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;

            while(cur != groupNext){
                ListNode next = cur.next;

                cur.next = prev;

                prev = cur;
                cur = next;
            }

            ListNode oldGroupStart = groupPrev.next;

            groupPrev.next = kth;

            groupPrev = oldGroupStart;
        }
        return dummy.next;

    }

    private ListNode getKth(ListNode cur, int k){
        while(cur != null && k > 0){
            cur = cur.next;
            k--;
        }

        return cur;
    }
}
