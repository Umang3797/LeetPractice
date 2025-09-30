class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num); // autobox int → Integer
        }

        if(nums.length==1) return nums[0];
        // while(list.size()>1){
        //     int i=0;
        //     List<Integer> newList= new ArrayList(list.size()-1);
        //     while(i<list.size()-1){
        //         newList.add((list.get(i)+list.get(i+1))%10);
        //         i++;
        //     }
        //     list=newList;
        // }

        while (list.size() > 1) {
            List<Integer> next = new ArrayList<>(list.size() - 1);
            for (int i = 0; i < list.size() - 1; i++) {
                next.add((list.get(i) + list.get(i + 1)) % 10);
            }
            list = next;
        }
    
        

        return list.get(0);
    }
}