public class StackUsingLinkedList {

	public static class Stack {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		s.push(9);
		s.push(10);
		s.push(11);

		System.out.println(s.pop());
		s.push(12);
		s.pop();
		System.out.println(s.peek());
	}

}
