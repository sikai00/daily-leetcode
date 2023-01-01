class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode tmp;
    ListNode prev = null;
    while (head != null) {
      tmp = head.next;
      head.next = prev;
      prev = head;
      head = tmp;
    }
    return prev;
  }

  public ListNode recursiveReverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode newHead = recursiveReverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}