package cn.belongtech.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @author sunliang
 * @version 1.0
 */
public class HasCycleSolution {

    /**
     * O(n)
     * hashSet
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> result = new HashSet<>();
        while (null != head) {
            if (result.contains(head)) {
                return true;
            }
            result.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢双指针
     * O(1)
     */
    public boolean hasCycleBy2(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (null == fast || null == fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}