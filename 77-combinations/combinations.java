class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        if(k==0){
            list.add(new LinkedList());
            return list;
        }
        
        backtrack(1,n,k,new LinkedList<>(),list);
        return list;
    }
    private void backtrack(int start, int n, int k, LinkedList<Integer> current, List<List<Integer>> list){
        if(current.size()==k){
            list.add(new LinkedList(current)); 
        }
        for(int i=start;i<=n;i++){
            current.add(i);
            backtrack(i+1,n,k,current,list);
            current.removeLast();
        }
    }
}