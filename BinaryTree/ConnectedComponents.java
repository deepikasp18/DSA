package BinaryTree;

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(0, 3, 4));
        graph.add(Arrays.asList(0, 4));
        graph.add(Arrays.asList(1, 4));
        graph.add(Arrays.asList(1, 2, 3));
        graph.add(Arrays.asList(6));
        graph.add(Arrays.asList(5));

        System.out.println("Connected Components: " + findConnectedComponents(graph));
    }

    public static List<List<Integer>> findConnectedComponents(List<List<Integer>> graph) {
        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(graph, i, visited, component);
                components.add(component);
            }
        }

        return components;
    }

    public static void dfs(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, component);
            }
        }
    }
}
