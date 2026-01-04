class Solution {
    public int sumFourDivisors(int[] nums) {
        int fourDivisorCount = 0;

        for (int i=0; i<nums.length; i++) {
            int divisorSum = 0;
            int divisorCount = 0;
            for (int j=1; j<=nums[i]; j++) {

                if (nums[i] % j == 0) {
                    if (divisorCount > 4)break;
                    divisorCount++;
                    divisorSum += j;
                }
            }
            if (divisorCount == 4) {
                fourDivisorCount += divisorSum;
            }
        }

        return fourDivisorCount;
    }
}