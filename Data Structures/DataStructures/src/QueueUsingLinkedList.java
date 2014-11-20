public class QueueUsingLinkedList {

	public static class Queue {
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

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.enqueue(9);
		q.enqueue(10);
		q.enqueue(11);

		System.out.println(q.dequeue());
		q.enqueue(12);
		System.out.println(q.dequeue());
	}

}
