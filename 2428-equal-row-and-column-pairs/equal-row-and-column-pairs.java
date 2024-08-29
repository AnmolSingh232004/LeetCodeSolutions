class Solution {
    public int equalPairs(int[][] grid) {

        Map<List<Integer>, Integer> map = new HashMap<>();
        int res = 0;

        for (int i=0; i<grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<grid[i].length; j++) {
                list.add(grid[i][j]);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }


        for (int i=0; i<grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<grid[i].length; j++) {
                list.add(grid[j][i]);
            }
            if (map.containsKey(list))
            res += map.get(list);
        }
        return res;
    }
}