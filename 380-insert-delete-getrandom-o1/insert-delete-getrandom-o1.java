class RandomizedSet {
    Map<Integer, Integer> set;
    List<Integer> list;

    public RandomizedSet() {
        set = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (set.containsKey(val))return false;
        list.add(val);
        set.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!set.containsKey(val))return false;
        int index = set.get(val);
        int lastVal = list.get(list.size() - 1);

        list.set(index, lastVal);
        set.put(lastVal, index);


        list.remove(list.size()-1);
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = (int) (Math.random() * list.size());

        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */