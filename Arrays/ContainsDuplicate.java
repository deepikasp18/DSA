public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean hasDuplicate = containsDuplicate(nums);
        System.out.println("Contains Duplicate: " + hasDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        java.util.HashSet<Integer> numSet = new java.util.HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }
}
