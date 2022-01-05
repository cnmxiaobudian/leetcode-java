package cn.belongtech.leetcode.list;

/**
 * K个一组翻转链表
 * @author sunliang
 * @version 1.0
 */
public class ReverseKGroupSolution {

    /**
     * 分组 && 翻转
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;

        ListNode pre = hair;
        ListNode end = hair;

        while (null != end.next) {
            // 找到第K个节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            // 节点数不足K的时候，无需翻转
            if (null == end) {
                break;
            }
            
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = this.recursionReverseList(start);
            start.next = next;
            pre = start;
            end = pre;
        }

        return hair.next;
    }

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