class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        List<String> ans = new ArrayList(map.keySet());

        Collections.sort(ans,(w1,w2)->map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2)-map.get(w1));
        /*
        if both the frequency are same -> map.get(w1).equals(map.get(w2))
        then sort lexicographically -> w1.compareTo(w2)
        else sort  descending, more frequency to less frequency -> map.get(w2)-map.get(w1))
        */

        List<String> list = new ArrayList();
        for(int i=0;i<k;i++){
            list.add(ans.get(i));
        }
        return list;
    }
}