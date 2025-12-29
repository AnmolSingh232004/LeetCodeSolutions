class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //sorting must be done to avoid duplicates and use two pointer approach after fixing i
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<nums.length; i++) { //itteration for the fixed i
            if (i > 0 && nums[i] == nums[i-1])continue; //if i has any repeated element until the only unique i is left, ex 1,1,1. Skip till we reach last 1
            int l = i+1; //l will be just after i
            int r = nums.length-1; //r will be last element

            while (l < r) { // while pointers dont cross each other
                int tSum = nums[i] + nums[l] + nums[r]; //this is what we going to find but i is constant
                if (tSum < 0) {  //since sum is smaller we need a bigger value so l++
                    l++;
                }
                else if(tSum > 0) { //we need a smaller number
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r])); // add the combo which matches
                    l++; //the current element is processed so move to next
                    r--; //processed so move

                    while (l < r && nums[l] == nums[l-1])l++; 
                    while (l < r && nums[r] == nums[r+1])r--;
                }
                }
            }
                    return res;
        }
    }



// sorted
// [-4,-1,-1,0,1,2]