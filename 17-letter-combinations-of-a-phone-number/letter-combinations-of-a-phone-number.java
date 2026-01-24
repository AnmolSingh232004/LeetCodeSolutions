class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        map.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        map.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        map.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        map.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        map.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        map.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        map.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));


        backtrack(digits, 0, new StringBuilder());
        return res;

    }

    public void backtrack(String digits, int start, StringBuilder sb) {
          if (sb.length() == digits.length()) {
                    res.add(new String(sb));
                    return;
            }

            for (int i=0; i<map.get(digits.charAt(start)).size(); i++) {
                
                sb.append(map.get(digits.charAt(start)).get(i));
                backtrack(digits, start+1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

        
}
}

// first character will always be from the first digit
// every character in any combination will only be from its respective digit's position
// 