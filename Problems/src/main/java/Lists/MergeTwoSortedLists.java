package Lists;

/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list.
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
list1: 1->2->4
list2: 1->3->4
merged list: 1->1->2->3->4->4

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
*/

import java.util.LinkedList;


public class MergeTwoSortedLists {
    public static LinkedList<Integer> mergeTwoSortedLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();

        int val1, val2;
        while (!l1.isEmpty() && !l2.isEmpty()) {
            val1 = l1.getFirst();
            val2 = l2.getFirst();
            if (val1 < val2) {
                result.add(val1);
                l1.removeFirst();
            } else {
                result.add(val2);
                l2.removeFirst();
            }
        }
        if (!l1.isEmpty()) {
            result.addAll(l1);
        }
        if (!l2.isEmpty()) {
            result.addAll(l2);

        }
        return result;
    }
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        l2.add(1);
        l2.add(3);
        l2.add(4);
        LinkedList<Integer> result = mergeTwoSortedLists(l1, l2);
        System.out.println(result);
    }
}
