
//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode result = null;
        ListNode cur = result;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode nextNode = new ListNode(sum % 10);
            sum /= 10;
            if (result == null) {
                result = nextNode;
            } else {
                cur.next = nextNode;
            }
            cur = nextNode;

        }
        if (sum > 0) {
            cur.next = new ListNode(sum);
        }
        return result;
    }
}
