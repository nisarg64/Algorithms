public class reverseLinkedList {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		LinkedListNode head, temp;
		head = new LinkedListNode(arr[0]);
		temp = head;
		for (int i = 1; i < arr.length; i++) {
			temp.next = new LinkedListNode(arr[i]);
			temp = temp.next;
		}
		LinkedListNode revHead = revLinkedList(head);
		printLinkedList(revHead);
	}

	public static LinkedListNode revLinkedList(LinkedListNode ptr) {
		LinkedListNode previous = null;
		LinkedListNode tmp;
		while (ptr != null) {
			tmp = ptr.next;
			ptr.next = previous;
			previous = ptr;
			ptr = tmp;
		}
		return previous;
	}

	public static void printLinkedList(LinkedListNode ptr) {
		while (ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
	}

}
