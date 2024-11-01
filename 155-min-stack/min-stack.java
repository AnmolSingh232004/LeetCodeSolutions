class MinStack {

    List<Integer> list;
    int min;
    boolean init;

    public MinStack() {
        list = new ArrayList<>();
        init = true;
    }
    
    public void push(int val) {
        if (init) {
            min = val;
            init = false;
        }

        if (val < min)min = val;
        list.add(val);
        list.add(min);
    }
    
    public void pop() {
        list.remove(list.size()-1);
        list.remove(list.size()-1);
        if (list.size() > 0)
        min = list.get(list.size()-1);
        else 
        init = true;
    }
    
    public int top() {
        return list.get(list.size()-2);
    }
    
    public int getMin() {
        return list.get(list.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */