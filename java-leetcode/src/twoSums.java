public class twoSums {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        twoSums solver = new twoSums(); // Create an instance of twoSums
        int[] nums = {2, 7, 11, 15}; // Example array
        int target = 9; // Example target value that matches 2 + 7

        // Call the twoSum method with your example array and target
        int[] result = solver.twoSum(nums, target);

        // Print the result using Arrays.toString() for simplicity
        System.out.println(java.util.Arrays.toString(result));
    }
}
