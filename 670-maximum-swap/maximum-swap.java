class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int[] maxIndex = new int[n];
        int maxPos = n-1;
        maxIndex[n-1] = maxPos;
        
        // right to left
        for(int i = n-2; i>=0; i--){
            if(digits[i]>digits[maxIndex[i+1]]){
                maxPos = i;
                maxIndex[i] = maxPos;
            }
            maxIndex[i] = maxPos;
        }
        // left to right
        for(int i = 0; i < n ; i++){
            if(i!=maxIndex[i] && digits[maxIndex[i]]!=digits[i]){
                char tmp=digits[maxIndex[i]];
                digits[maxIndex[i]]=digits[i];
                digits[i]=tmp;
                break;
            }
            // if(digits[i]!=digits[maxIndex[i]]){ 
            //     char tmp = digits[maxIndex[i]] ;
            //     digits[maxIndex[i]] = digits[i];
            //     digits[i] = tmp;
            //     break;
            // }
        }
        
        System.out.println(Arrays.toString(maxIndex));
        System.out.println(String.valueOf(digits));
        return Integer.parseInt(String.valueOf(digits));
    }
}