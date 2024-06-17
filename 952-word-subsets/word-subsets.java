class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList();
        
        int[] target = new int[26];

        for(String word2: words2){
            int[] tmp = new int[26];
            char[] ch2 = word2.toCharArray();
            for(char c : ch2){
                tmp[c-'a']++;
                target[c-'a'] = Math.max(target[c-'a'], tmp[c-'a']);
            }
        }
        
        for(String word1: words1){
            int[] arr = new int[26];
            char[] ch1 = word1.toCharArray();
            for(char c : ch1){
                arr[c-'a']++;
            }
            if(subset(arr,target)){
                list.add(word1);
            }
        }
        
        return list;
    }
    private boolean subset(int[] arr, int[] tmp){
        for(int i=0;i<26;i++){
            if(tmp[i]>arr[i])
                return false;   
        }
        return true;
    }
}