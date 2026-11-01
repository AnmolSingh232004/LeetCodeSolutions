class Solution {
    public int longestOnes(int[] nums, int k) {
        int lo = 0;
        int hi = 0;

        int zeroCount = 0;
        int res = 0;

        while (hi < nums.length) {
            //nums = [1,1,0,1], k = 1
            if (nums[hi] == 1 && zeroCount <= k) {
                hi++;
                res = Math.max(hi-lo, res);
            } else {
                if (zeroCount < k) {
                    hi++;
                    zeroCount++;
                    res = Math.max(hi-lo, res);
                } else if (zeroCount >= k) {
                    if (nums[lo] == 0) {
                        lo++;
                        zeroCount--;
                    } else lo++;
                }

            }

            
        }
        return res;
    }
}

// Basically 2 main scenarios, one where we encounter 1 and one in which we enocunter 0
// If its one we just expand our window and note its size hi-lo
// If it is zero, we increase zero count and when zero count reaches k we shrink until zero count is valid again