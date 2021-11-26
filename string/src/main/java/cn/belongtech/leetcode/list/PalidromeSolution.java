package cn.belongtech.leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author sunliang
 * @version 1.0
 */
public class PalidromeSolution {

    private ListNode frontPointer;

    /**
     * O(n)
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode currentNode = head;
        while(Objects.nonNull(currentNode)) {
            list.add(currentNode.getVal());
            currentNode = currentNode.getNext();
        }

        int front = 0;
        int end = list.size() - 1;
        while(front < end) {
            if(!list.get(front).equals(list.get(end))) {
                return false;
            }
            front++;
            end--;
        }
        return true;
    }

    /**
     * O(1)
     */
    public boolean isRecursionPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    /**
     * 双向指针
     */
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.getVal() != frontPointer.getVal()) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}