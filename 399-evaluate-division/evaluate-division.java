class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //generating adj map 
        HashMap<String,HashMap<String,Double>> map = new HashMap<>();
        for (int i=0;i<equations.size();i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double res= values[i];

            map.putIfAbsent(dividend, new HashMap<>());
            map.putIfAbsent(divisor,  new HashMap<>());

            map.get(dividend).put(divisor, res);
            map.get(divisor).put(dividend, 1.0 / res);

            //can also use in Java 8+
            //map.computeIfAbsent(dividend, k -> new HashMap<>()).put(divisor, res);
            //map.computeIfAbsent(divisor,  k -> new HashMap<>()).put(dividend, 1.0 / res);


        }

        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            //basic checks
            if(!map.containsKey(dividend) || (!map.containsKey(divisor)))
                res[i]= -1.0;
            else if(dividend.equals(divisor))
                res[i] = 1.0;
            else{
                HashSet<String> visited = new HashSet<>();
                res[i] = dfs(dividend,divisor,map,values, visited, 1.0);
            }
        }

        return res;
    }

    public double dfs(
        String src, 
        String target, 
        HashMap<String,HashMap<String,Double>> map,
        double[] values,
        HashSet<String> visited,
        Double product
        ){

            double ret=-1;
            visited.add(src);

            if(map.get(src).containsKey(target)){
                ret = product * map.get(src).get(target);
            }else{
                //dfs to be applied, we did not get direct answer
                // case of a,c = a->b->c
                for(String neighbor: map.get(src).keySet()){
                    if(!visited.contains(neighbor)){
                        ret = dfs(neighbor,target,map,values, visited, product*map.get(src).get(neighbor));
                        if(ret!=-1){
                            break;
                        }
                    }
                }
            }

            visited.remove(src);
            return ret;

    }
}