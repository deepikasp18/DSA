package BinaryTree;

import java.util.*;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] edges = {
            {1,2},
            {3},
            {3},
            {}
        };
        System.out.println("All paths from source to target: " + allPathsSourceTarget(edges, 0, edges.length - 1));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] edges, int source, int target) {
        List<List<Integer>> graph = new ArrayList<>();

        // Build the graph from edges
        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
            for (int node : edges[i]) {
                graph.get(i).add(node);
            }
        }  
        
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(graph, source, target, currentPath, allPaths);
        return allPaths;
    }

    private static void dfs(List<List<Integer>> graph, int source, int target, List<Integer> currentPath, List<List<Integer>> allPaths) {

        currentPath.add(source);

        if (source == target) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (int adjacent: graph.get(source)) {
                dfs(graph, adjacent, target, currentPath, allPaths);
            }
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    } 
}
