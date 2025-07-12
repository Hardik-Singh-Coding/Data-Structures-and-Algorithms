public class Array_03_Check_sorted_list {
    static boolean sorted(int[] nums){
        for(int i=1; i<nums.length; i++){
            if(nums[i] >= nums[i-1]){
                continue;
            }
            else if(nums[i] < nums[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4};
        System.out.println(sorted(nums));
    }
}
