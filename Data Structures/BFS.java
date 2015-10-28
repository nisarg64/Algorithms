public class BFS {

	public BFS(int s, Graph g) {

		boolean[] visited = new boolean[g.noOfVertices];

		Queue q = new Queue();

		visited[s] = true;
		q.enqueue(s);

		while (!q.isEmpty()) {
			s = (Integer)q.dequeue();
			System.out.print(s + " ");
			for (int i = 0; i < g.adjList.get(s).size(); i++) {
				if (!visited[g.adjList.get(s).get(i)]) {
					visited[g.adjList.get(s).get(i)] = true;
					q.enqueue(g.adjList.get(s).get(i));
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 4;
		int s = 2;

		Graph g = new Graph(v);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("BFS Traversal starting with node " + s);
		new BFS(s, g);
	}

}
