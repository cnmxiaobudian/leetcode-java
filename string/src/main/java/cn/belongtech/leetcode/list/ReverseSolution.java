package cn.belongtech.leetcode.list;

/**
 * 反转链表
 * @author sunliang
 * @version 1.0
 */
public class ReverseSolution {

    /**
     * O(n)
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        while (null != current) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }


    /**
     * O(1)
     */
    public ListNode recursionReverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode newHead = recursionReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}