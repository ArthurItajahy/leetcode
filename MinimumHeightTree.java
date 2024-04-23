import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        // Initialize arrays to store counts and links
        int[] counts = new int[n];
        int[] links = new int[n];

        // Calculate counts and Links
        for (int[] edge : edges){
            links[edge[0]] ^= edge[1];
            counts[edge[0]]++;
            links[edge[1]] ^= edge[0];
            counts[edge[1]]++;

        }

        // Initialize a list to store the roots of minimum height trees
        List<Integer> minHeightTrees = new ArrayList<>();

        // Initialize a queue to store leaf nodes
        Queue<Integer> queue = new LinkedList<>();

        // Initialize an array to store distances
        int[] dists = new int[n];

        // Find leaf node and add them to the queue
        for(int i = 0; i < n; i++){
            if(counts[i] == 1){
                queue.add(i);
            }
        }

        // Initialize a variable to track the curent step
        int step = 1;

        // Perform BFS traversal
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int tmp = queue.poll();
                // Update links and counts
                links[links[tmp]] ^= tmp;

                // If the new node becomes a leaf node, add it to the queue
                if(counts[links[tmp]] == 1){
                    dists[links[tmp]] = Math.max(step, dists[links[tmp]]);
                    queue.add(links[tmp]);
                }
            }
            step++;
        }
        // Find the maximum distance
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(dists[i], max);
        }
        // Add nodes with maximum distance to the result list
        for(int i = 0; i < n; i++){
            if(dists[i] == max){
                minHeightTrees.add(i);
            }
        }

        return minHeightTrees;
        }
        public static void main(String[] args){
            MinimumHeightTree solution = new MinimumHeightTree();
            int n = 4;
            int[][] edges = {{1,0}, {1,2},{1,3}};

            System.out.println(solution.findMinHeightTrees(n, edges));

        }

}

