class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<score.length; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        int[] res = new int[score.length];
        int it = 1;
        for (int i=score.length-1; i>=0; i--) {
            res[map.get(score[i])] = it;
            it++;
        }
        String[] finalRes = new String[score.length];
        for (int i=0; i<finalRes.length; i++) {
            if (res[i] == 1) {
                finalRes[i] = "Gold Medal";
            } else if (res[i] == 2) {
                finalRes[i] = "Silver Medal";
            } else if (res[i] == 3) {
                finalRes[i] = "Bronze Medal";
            } else {
                finalRes[i] = String.valueOf(res[i]);
            }
        }
        return finalRes;
    }
}