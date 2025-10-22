import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SubsetSum {

		public static boolean findSubsetSum(ArrayList<Integer> nums, int target, List<Integer> subset) {

		//Base case, target is 0, empty set will do
		if (target == 0) {
			System.out.println(subset);
			return true;
		}
       
		//no more number of the target become negative, no subset found	 
		if (nums.size()==0 || target < 0) {
			return false;
		}

		//add the current number to the subset
		int n = nums.get(0);
		subset.add(n);
		nums.remove(0);
        
		//update the target, then recursilvey search
		if (findSubsetSum(nums, target - n, subset)) {
			return true;//found one
		}
        
		//backtrack and remove the last added number
		subset.remove(subset.size() - 1);
        
		//search without the current number
		return findSubsetSum(nums, target, subset);
	}

	public static void main(String[] args) {

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 34, 4, 12, 5, 2));
		int target = 9;
		List<Integer> subset = new ArrayList<>();
        
		if (!findSubsetSum(nums, target, subset)) {
			System.out.println("No subset found");
		}
	}
}

