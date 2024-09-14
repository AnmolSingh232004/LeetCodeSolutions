class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            //Here we take any word for example eat and sort it so basically all possible anagrams of 
            //eat shall be one key
            if (!map.containsKey(sortedWord))
            map.put(sortedWord, new ArrayList<String>());
            //Now here we check if it is the first anagram we create a new entry in map

            //Now this is smth new I learnt we get an already existing value from the map
            //Which is quite literally the value
            //And we update it by adding strs[i] which is our base word so for like 
            //eat, tea both get sorted to aet and then since aet already exist in our map
            //We update them in the List<String> which is the value of our map
            map.get(sortedWord).add(strs[i]);
        }

        List<List<String>> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        //Here we just simply put the values extracted into result required by question
        return list;
    }
}