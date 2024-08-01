class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<String, Boolean> memo = new HashMap<>();
        return recursive(s1,s2,s3,0,0,memo);
    }

    private boolean recursive(String s1, String s2, String s3, int i, int j, Map<String, Boolean> memo){

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if(i+j>s3.length()){
            return false;
        }
        if(i+j==s3.length()){
            boolean result = i == s1.length() && j == s2.length();
            memo.put(key, result);
            return result;
        }
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            if(recursive(s1,s2,s3,i+1,j,memo)){
                memo.put(key, true);
                return true;
            }
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            if(recursive(s1,s2,s3,i,j+1,memo)){
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
}