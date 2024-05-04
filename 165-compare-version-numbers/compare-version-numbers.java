class Solution {
    public int compareVersion(String version1, String version2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        StringBuilder sb1 = new StringBuilder();
        
        for (int i=0; i<version1.length(); i++) {
            if (version1.charAt(i) != '.')sb1.append(version1.charAt(i));
            
            if (version1.charAt(i) == '.' || i == version1.length() - 1) {
                list1.add(Integer.parseInt(sb1.toString()));
                sb1 = new StringBuilder();
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i=0; i<version2.length(); i++) {
            if (version2.charAt(i) != '.')sb2.append(version2.charAt(i));

            if (version2.charAt(i) == '.' || i == version2.length() - 1) {
                list2.add(Integer.parseInt(sb2.toString()));
                sb2 = new StringBuilder();
            }
        }
        
        int p1 = 0;
        int p2 = 0;
        while (p1 < list1.size() && p2 < list2.size()) {
            if (list1.get(p1) > list2.get(p2))return 1;
            else if (list1.get(p1) < list2.get(p2))return -1;
            p1++;
            p2++;
        }

        while (p1 < list1.size()) {
            if (list1.get(p1) > 0)return 1;
            p1++;
        }
        while (p2 < list2.size()) {
            if (list2.get(p2) > 0)return -1;
            p2++;
        }
        return 0;
}
}

