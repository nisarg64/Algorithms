import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	int noOfVertices;
	HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();

	public Graph(int V) {
		this.noOfVertices = V;
	}

	public void addEdge(int V, int w) {
		if (!adjList.containsKey(V)) {
			adjList.put(V, new ArrayList<Integer>());
		}
		adjList.get(V).add(w);
	}
}
