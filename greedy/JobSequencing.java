package greedy;

import java.util.*;

/*
Given two arrays, deadline[] and profit[], where deadline[i] is the last time unit
by which the i-th job must be completed,
and profit[i] is the profit earned from completing it.
Each job takes 1 unit time, and only one job can be scheduled at a time.
 A job earns profit only if finished within its deadline. Find the number of jobs
  completed and maximum profit.
 */
public class JobSequencing {

    private static int PROFIT = 1;
    private static int DEADLINE = 0;
    public static void main(String[] args) {
        int[] profits = { 100, 20, 30, 20, 40 };
        int[] deadlines = {3,5,2,3,1};

        List<Integer> completedJobsAndProfits = jobSequencing(profits, deadlines);

        System.out.printf("%d jobs completed with maximum profit earned %d%n", completedJobsAndProfits.getFirst(), completedJobsAndProfits.getLast());
    }

    private static List<Integer> jobSequencing(int[] profits, int[] deadlines) {
        List<Integer> ans = new ArrayList<>(Arrays.asList(0,0));

        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            jobs.add(new int[]{deadlines[i], profits[i]});
        }

        jobs.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> scheduledJobs = new PriorityQueue<>();

        for (int i = 0; i < jobs.size(); i++) {
            int[] currentJob = jobs.get(i);
            if (currentJob[DEADLINE] > scheduledJobs.size()) { // If there is still time to finish the job, schedule it
                scheduledJobs.add(currentJob[PROFIT]);
            } else if (!scheduledJobs.isEmpty() && scheduledJobs.peek() < currentJob[PROFIT]) { // else check if the least profitable job scheduled is less profitable than the current job
                scheduledJobs.poll();                     // replace the old job with the current job
                scheduledJobs.add(currentJob[PROFIT]);
            }
        }

        while (!scheduledJobs.isEmpty()) {
            ans.set(1, ans.get(1) + scheduledJobs.poll());  // add profits of the completed jobs
            ans.set(0, ans.get(0) + 1);  // add number of jobs completed
        }

        return ans;
    }
}
