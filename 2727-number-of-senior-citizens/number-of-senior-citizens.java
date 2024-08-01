class Solution {
    public int countSeniors(String[] details) {
        int senior = 0;
        for (int i=0; i<details.length; i++) {
            String sub = details[i].substring(11,13);
            int val = Integer.parseInt(sub);
            if (val > 60)
            senior++;
        }
        return senior;
    }
}