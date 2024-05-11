import java.util.*;
public class MinimumCostHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        double[][] workers = new double[n][2];

        for(int i = 0; i < n; i++){
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, Comparator.comparingDouble( a -> a[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0;
        double maxRate = 0.0;

        for(int i = 0; i < k; i++){
            maxHeap.offer((int) workers[i][1]);
            qualitySum += workers[i][1];
            maxRate = Math.max(maxRate, workers[i][0]);
        }


        double minCost = maxRate * qualitySum;

        for(int i = k; i < n; i++){
            maxHeap.offer((int) workers[i][1]);
            qualitySum += workers[i][1] - maxHeap.poll();
            maxRate = Math.max(maxRate, workers[i][0]);
            minCost = Math.min(minCost, maxRate * qualitySum);
        }
        return minCost;
    }
}
