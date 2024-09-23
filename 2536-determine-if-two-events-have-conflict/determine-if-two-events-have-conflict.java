class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        for(int i=0;i<event1.length;i++){
            String str[] = event1[i].split(":");
            int hours = Integer.parseInt(str[0]);
            int minutes = Integer.parseInt(str[1]);
            event1[i] = String.valueOf(hours * 60 + minutes); 
        }
        for(int i=0;i<event2.length;i++){
            String str[] = event2[i].split(":");
            int hours = Integer.parseInt(str[0]);
            int minutes = Integer.parseInt(str[1]);
            event2[i] = String.valueOf(hours * 60 + minutes); 
        }
        
        // Check for overlap
        return Integer.parseInt(event1[1]) >= Integer.parseInt(event2[0]) &&
               Integer.parseInt(event1[0]) <= Integer.parseInt(event2[1]);
    }
}