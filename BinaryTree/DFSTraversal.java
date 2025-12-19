package BinaryTree;

import java.util.*;

public class DFSTraversal {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(0, 3, 4));
        graph.add(Arrays.asList(0, 4));
        graph.add(Arrays.asList(1, 4));
        graph.add(Arrays.asList(1, 2, 3));

        List<Integer> dfsTraversalResult = dfsTraversal(graph);
        System.out.println(dfsTraversalResult);
    }

    private static List<Integer> dfsTraversal(List<List<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) visit(graph, i, visited, result);
        }

        return result;
    }

    private static void visit(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : graph.get(node)) {
           if (!visited[neighbor]) visit(graph, neighbor, visited, result);
        }
    }
}
