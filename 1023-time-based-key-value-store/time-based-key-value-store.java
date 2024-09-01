class TimeMap {
    Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map=new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap());
        }
        TreeMap<Integer,String> timemap = map.get(key);
        timemap.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        TreeMap<Integer,String> timemap = map.get(key);
        Integer prevTime=timemap.floorKey(timestamp);
        if(prevTime==null)
            return "";
        else
            return timemap.get(prevTime);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */