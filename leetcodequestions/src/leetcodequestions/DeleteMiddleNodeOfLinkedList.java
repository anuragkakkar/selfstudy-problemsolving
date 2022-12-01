package leetcodequestions;

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode() {
//	}
//
//	ListNode(int val) {
//		this.val = val;
//	}
//
//	ListNode(int val, ListNode next) {
//		this.val = val;
//		this.next = next;
//	}
//}

public class DeleteMiddleNodeOfLinkedList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(2);
		ListNode n7 = new ListNode(6);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;

		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();

		head = deleteMiddle(head);

		cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	private static ListNode deleteMiddle(ListNode head) {

		ListNode cur = head;
		int length = 0;

		while (cur != null) {
			cur = cur.next;
			length++;
		}

		int nodeToBeDeleted = length / 2;

		if (nodeToBeDeleted == 0)
			return head = head.next;

		cur = head;
		int i = 0;
		while (i < nodeToBeDeleted - 1) {
			cur = cur.next;
			i++;
		}

		cur.next = cur.next.next == null ? null : cur.next.next;
		return head;

	}

}
