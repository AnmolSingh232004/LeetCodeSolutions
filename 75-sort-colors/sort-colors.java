class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i=0; i<nums.length; i++) {
            count[nums[i]]++;
            //freq count {2,2,2}
        }
        
        int i = count[0];
        int j = 0;

        while (j < i) { // 0 < 2 -> 1 < 2 
            nums[j] = 0;
            j++;
        }

        i += count[1];
        while (j < i) { // 1 < 2
            nums[j] = 1;
            j++;
        }

        i += count[2];
    
        while (j < i) {
            nums[j] = 2;
            j++;
        }
    }
}