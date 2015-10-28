public class DFS {
	public DFS(int s, Graph g) {
		boolean[] visited = new boolean[g.noOfVertices];
		DFSHelper(s, visited, g);
	}

	public void DFSHelper(int s, boolean[] visited, Graph g) {
		// TODO Auto-generated method stub
		visited[s] = true;
		System.out.print(s + " ");
		for (int i = 0; i < g.adjList.get(s).size(); i++) {
			if (!visited[g.adjList.get(s).get(i)]) {
				DFSHelper(g.adjList.get(s).get(i), visited, g);
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

		System.out.println("DFS Traversal starting with node " + s);
		new DFS(s, g);
	}

}
