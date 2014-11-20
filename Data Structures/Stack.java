public class Stack {
	LinkedListNode top;

	public void push(Object data) {
		LinkedListNode t = new LinkedListNode(data);
		t.next = top;
		top = t;
	}

	public Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	public Object peek() {
		if (top != null) {
			return top.data;
		}
		return null;
	}
}
