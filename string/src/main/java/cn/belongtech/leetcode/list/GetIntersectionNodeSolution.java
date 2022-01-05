package cn.belongtech.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 *
 * @author sunliang
 * @version 1.0
 */
public class GetIntersectionNodeSolution {

    /**
     * hashSet
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hash = new HashSet<>();
        ListNode tmp = headA;
        while (null != tmp) {
            hash.add(tmp);
            tmp = tmp.next;
        }

        tmp = headB;
        while (null != tmp) {
            if (hash.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }

        return null;
    }

    /**
     * 双指针
     *
     * 核心：计算两个链表的步长
     */
    public ListNode getIntersectionNodeBy2(ListNode headA, ListNode headB) {
        if (null ==  headA || null == headB) {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            pa = null == pa ? headB : pa.next;
            pb = null == pb ? headA : pb.next;
        }

        return pa;
    }
}
