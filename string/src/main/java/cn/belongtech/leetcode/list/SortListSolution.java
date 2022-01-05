package cn.belongtech.leetcode.list;

/**
 * 排序链表
 *
 * @author sunliang
 * @version 1.0
 */
public class SortListSolution {

    /**
     * 二分法排序
     * 分割 - 排序 - 合并
     * 快慢双指针
     * mergeTwoLists
     *
     * 核心：转换为，合并N个有序链表
     */
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = this.sortList(head);
        ListNode right = this.sortList(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;
        while (null != left && null != right) {
            if (left.val < right.val) {
                res.next = left;
                left = left.next;
            } else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = null != left ? left : right;
        return h.next;
    }
}