package cn.belongtech.leetcode.list;

/**
 * 合并K个升序链表
 *
 * @author sunliang
 * @version 1.0
 */
public class MergeKListsSolution {

    /**
     * 分治法
     */
    public ListNode mergeKListsBy2List(ListNode[] lists) {
        return this.merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }

        if (l > r) {
            return null;
        }

        // 右移 （获取两数中间值，中间下标）
        int middle = (l + r) >> 1;

        return mergeTwoLists(merge(lists, l, middle), merge(lists, middle + 1, r));
    }

    /**
     * O(n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 将长度n的list，转换为两两比对，分批进行
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = this.mergeTwoLists(lists[i], result);
        }
        return result;
    }

    /**
     * O(n)
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (null == a || null == b) {
            return null == a ? b : a;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (null != aPtr && null != bPtr) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = null != aPtr ? aPtr : bPtr;
        return head.next;
    }
}