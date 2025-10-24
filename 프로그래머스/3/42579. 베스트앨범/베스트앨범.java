import java.util.*;

//인덱스 저장
//정렬: 장르, 재생count, 고유번호
//그러면 장르 count를 별도로 저장하고 그 순서대로 int로 순위로 값 주기
class Node{
    int genre;
    int count;
    int index;
    
    Node(int genre, int count, int index){
        this.count = count;
        this.genre = genre;
        this.index = index;
    }
}

class Rank{
    String g;
    int sum;
    Rank(String g, int sum){
        this.g = g;
        this.sum = sum;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        
        PriorityQueue<Rank> rank = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);
        
        for(int i=0; i<genres.length; i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i], plays[i]);
            }
            else map.put(genres[i], map.get(genres[i]) + plays[i]);
        }
        
        map.forEach((k, v) -> {
                rank.add(new Rank(k, v));
        });
        
        map.clear();
        int r = 1;
        int genreCount = rank.size();
        
        Rank nowRank;
        while(!rank.isEmpty()){
            nowRank = rank.poll();
            map.put(nowRank.g, r++);
        }
        
        //각 원소 정렬
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.genre != o2.genre) return o1.genre - o2.genre;
            else if(o2.count != o1.count) return o2.count - o1.count;
            return o1.index - o2.index;
        });
    
        for(int i=0; i<genres.length; i++){
            queue.add(new Node(map.get(genres[i]), plays[i], i));
        }
        
        int isFullOf2[] = new int[genreCount];
        Queue<Integer> stack = new LinkedList<>();
        
        Node now;
        
        while(!queue.isEmpty()){ 
            now = queue.poll();
            
            if(isFullOf2[now.genre-1] == 2) continue;
            
            isFullOf2[now.genre-1]++;
            stack.add(now.index);
            
        }
        
        r = 0;
        int real[] = new int[stack.size()];
        while(!stack.isEmpty()){
            real[r++] = stack.poll();
        }
        
        return real;
    }
}