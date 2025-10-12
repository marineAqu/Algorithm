import java.util.*;

class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        //save
        for(int i=0; i<info.length; i++){
            dfs(info[i].split(" "), "", 0);
        }
        
        //sort
        for(ArrayList<Integer> arr : map.values()){
            Collections.sort(arr);
        }
        
        String makeQuery;
        int count;
        
        //find
        for(int i=0; i<query.length; i++){
            answer[i] = binarySearch(query[i]);
            /*
            makeQuery = query[i].split(" ")[0]
                + query[i].split(" ")[2]
                + query[i].split(" ")[4]
                + query[i].split(" ")[6];
            
            if(!map.containsKey(makeQuery)){
                answer[i] = 0;
                continue;
            }
            
            count = Collections.binarySearch(map.get(makeQuery), 
                                            Integer.parseInt(query[i].split(" ")[7]));
            if(count < 0) answer[i] = map.get(makeQuery).size() + count + 1;
            else answer[i] = map.get(makeQuery).size() - count;
            */
        }
        
        return answer;
    }
    
    private int binarySearch(String query) {
        String[] arr = query.split(" and ");
        int score = Integer.parseInt(arr[3].split(" ")[1]);

        query = arr[0] + arr[1] + arr[2] + arr[3].split(" ")[0];

        if(!map.containsKey(query)) return 0;

        ArrayList<Integer> list = map.get(query);
        int start = 0;
        int end = list.size();

        // score 이상인 값이 처음으로 나타나는 인덱스 찾기(하한선)
        while(start < end) { 
            int mid = (start + end) / 2;

            if(list.get(mid) >= score)
                end = mid;
            else // list.get(mid) > score
                start = mid + 1;
        }

        return list.size() - start;
    }
    
    private void dfs(String[] info, String st, int depth){
        if(depth == 4){
            if(map.containsKey(st)){
                map.get(st).add(Integer.parseInt(info[4]));
            }
            else {
                map.put(st, new ArrayList<>());
                map.get(st).add(Integer.parseInt(info[4]));
            }
            return;
        }
        
        dfs(info, st+info[depth], depth+1);
        dfs(info, st+"-", depth+1);
    }
}