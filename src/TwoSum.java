import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static void main(String[] args) {
        int [] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(new TwoSum().twoSum(arr, 12)));
    }

    public int[] twoSum(int[] nums, int target) {
//        value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer idxComplement = map.get(target - nums[i]);
            if (idxComplement != null) {
                return new int[]{idxComplement, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
