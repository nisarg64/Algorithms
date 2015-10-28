public class Queue {
	LinkedListNode first, last;

	public void enqueue(Object data) {
		if (first == null) {
			last = new LinkedListNode(data);
			first = last;
		} else {
			last.next = new LinkedListNode(data);
			last = last.next;
		}
	}

	public Object dequeue() {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			if (first == null)
				last = null;
			return item;
		}
		return null;
	}

	public boolean isEmpty() {
		if (first == null && last == null)
			return true;
		else
			return false;
	}
}
