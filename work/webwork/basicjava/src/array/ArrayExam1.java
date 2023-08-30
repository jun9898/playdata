package array;

public class ArrayExam1 {
	public static void main(String[] args) {
		int[] nums = new int[5];
		nums[0] = 100;
		nums[1] = 200;
		nums[2] = 300;
		nums[3] = 400;
		nums[4] = 500;
		
		for (int num : nums) {
			System.out.println(num);
		}

		int[] nums2 = new int[] {1,2,3,4,5};

		for (int num : nums2) {
			System.out.println(num);
		}
	}

}
