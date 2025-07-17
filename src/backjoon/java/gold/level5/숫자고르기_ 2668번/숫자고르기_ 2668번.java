import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] array;
    static StringBuilder sb = new StringBuilder();
    static Map<Integer,Set<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 1={2,3},3={1},4={6},5={4,5},6={7}
        // -> 2제거,7제거,
        //  1={3},3={1},4={6},5={4,5}
        // 6제거,4제거
        // 1={3},3={1},5={5}

        for(int i=1;i<=N;i++){
            int num = Integer.parseInt(br.readLine());
            //map에서 num에 해당하는 idx를  set에 넣음
            // set을 쓴 이유는 이후 .remove를 하여 컬렉션에서 에러 안터지게 할 때 더 편하게 하려고
            if(map.containsKey(num)){
                map.get(num).add(i);
            }
            else{
                Set<Integer> list = new HashSet<>();
                list.add(i);
                map.put(num,list);
            }
        }

        boolean flag = true;
        // map에서 특정 key가 삭제 안될 때 까지 반복
        while(flag){
            flag=false;
            //N은 100이라고 했으니 1~100
            for(int i=1;i<=100;i++){
                if(map.containsKey(i)){
                    Iterator<Integer> it = map.get(i).iterator();

                    while(it.hasNext()){
                        int id =it.next();
                        //해당 키에 대한 인덱스가 map에 존재하지 않으면 삭제
                        if(!map.containsKey(id)){
                            it.remove();
                        }
                    }
                    if(map.get(i).size()==0){
                        map.remove(i);
                        flag =true;
                    }
                }
            }
        }
        //이거 그냥 빼도 괜찮아보이긴한데 각 키에 대한 최소 인덱스 가져오고
        int[] answer= new int[map.size()];
        int idx=0;
        for(int i=1;i<=100;i++){
            if(map.containsKey(i)){
                Iterator<Integer> it = map.get(i).iterator();
                answer[idx]=1000;
                while(it.hasNext()){
                    int id =it.next();
                    answer[idx] = Math.min(answer[idx],id);
                }
                idx++;
            }
        }
        //정렬
        Arrays.sort(answer);
        sb.append(map.size()).append('\n');
        for(int i=0;i<answer.length;i++){
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}
