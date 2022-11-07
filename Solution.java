/**
 * Definition for singly-linked list.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 1, 2, 3, 4, 5 null 순서를 가지고 있기 때문에 가르키는 노드의 방향을 변경하고 테일을 리턴하면 될거 같다.
        ListNode before = null;
        ListNode now = head;
        ListNode after = null;

        while (now != null) {
            after = now.next;
            now.next = before;
            before = now;
            now = after;
        }

        return before;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
