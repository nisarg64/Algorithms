import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nisarg on 1/18/16.
 */
public class TopologicalSort {
    boolean[] visited  = null;
    boolean[] visiting  = null;
    HashMap<Integer, ArrayList<Integer>> courseMap = null;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        courseMap = new HashMap<Integer, ArrayList<Integer>>();
        visited  = new boolean[numCourses];
        visiting  = new boolean[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            if(!courseMap.containsKey(prerequisites[i][1])){
                courseMap.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            courseMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // for (Integer key: courseMap.keySet()){
        //     ArrayList<Integer> value = courseMap.get(key);
        //     System.out.print(key + " " );
        //     for(int i = 0; i < value.size(); i++) {
        //         System.out.print(value.get(i));
        //     }
        //     System.out.println();
        // }

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                boolean isloop = topologicalSort(i);
                if(isloop == false)
                    return false;
            }
        }
        return true;
    }

    public boolean topologicalSort(int vertex){
        //System.out.println(vertex);

        if(!visiting[vertex])
            visiting[vertex] = true;

        if(courseMap.containsKey(vertex)){
            ArrayList<Integer> edgeList = courseMap.get(vertex);
            for(int j = 0; j < edgeList.size(); j++) {
                //System.out.println(edgeList.get(j));
                if(visiting[edgeList.get(j)] && !visited[edgeList.get(j)])
                    return false;
                boolean res = topologicalSort(edgeList.get(j));
                if(!res)
                    return false;
            }
        }
        visited[vertex] = true;
        return true;

    }

}
