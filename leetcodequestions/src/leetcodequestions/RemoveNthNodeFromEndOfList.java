package leetcodequestions;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode cur = head;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
		
		head = removeNthFromEnd(head, 2);
		
		cur = head;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {

		int length = 0;
		ListNode cur = head;
		while (cur != null) {
			length++;
			cur = cur.next;
		}

		if (length == 1) return null;

		int nodeFromStart = length - n + 1;
		if (nodeFromStart == 1) return head = head.next;

		cur = head;
		int i = 1;
		while (i < nodeFromStart - 1) {
			cur = cur.next;
			i++;
		}
		cur.next = cur.next.next == null ? null : cur.next.next;
		return head;
	}

}
