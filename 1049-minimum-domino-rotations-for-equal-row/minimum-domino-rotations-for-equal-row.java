class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int topsmaxandcount[] = findMaxAndCount(tops);
        int bottomsmaxandcount[] = findMaxAndCount(bottoms);
        int count=0;
        int n=tops.length;
        boolean topshasmoremax = topsmaxandcount[1]>bottomsmaxandcount[1] ? true : false; 
        for(int i=0;i<n;i++){
            if(topshasmoremax){
                if(tops[i]!=topsmaxandcount[0] && bottoms[i]==topsmaxandcount[0]){
                    count++;
                }
            }else{
                if(bottoms[i]!=bottomsmaxandcount[0] && tops[i]==bottomsmaxandcount[0]){
                    count++;
                }
            }
        }

        if (topshasmoremax && count==n-topsmaxandcount[1]){
            return count;
        }
        else if(count==n-bottomsmaxandcount[1]){
            return count;
        }
        return -1;
        /** 
        1.count max number repeating in both the array
        example-2 me 
        tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
        tops me 3 is max repeating 2 times
        bottoms me 3 is max repeating 3 times
        so we will try to have same for bottom (less replacement)
        Now
        bottoms = [3,6,3,3,4]
        index=     0,1,2,3,4

        index 1 and 4 needs to be swapped with tops element(5,3)
        swaaping 5,6 and 3,4
        bottoms = [3,5,3,3,3]

        cant replace all hence -1 else 2(number of replaced element)



        tops =    [2,2,2,1,1,1]
        bottoms = [1,1,1,1,2,2]
        */
    }
    public static int[] findMaxAndCount(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxCount = 0;
        int mostFrequentNumber = arr[0];

        for (int num : arr) {
            int count = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, count);

            if (count > maxCount || (count == maxCount && num < mostFrequentNumber)) {
                maxCount = count;
                mostFrequentNumber = num;
            }
        }

        return new int[]{mostFrequentNumber, maxCount};
    }
}