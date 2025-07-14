import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb =new StringBuilder();
    static Stack<int[]>frontStack= new Stack<>();
    static Stack<int[]>backStack= new Stack<>();
    static Map<Integer,int[]> map = new HashMap<>();
    static int[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        array = new int [N+1];
        st= new StringTokenizer(br.readLine());


        for(int i=1;i<=N;i++){
            array[i]= Integer.parseInt(st.nextToken());
            //특정 위치에서 최대 위치가 100_000이기 때문에 +1 한다.
            // 볼수 있는 탑개수 =0, 상대 위치 =1000001로 초기화
            map.put(i,new int[]{0, 1000001});
        }


        for(int i=1;i<=N;i++){
            //앞을 기준으로 그리디 처리
            func(i,array[i],frontStack);
            //뒤를 기준으로 그리디 처리
            func(N-i+1,array[N-i+1],backStack);
        }

        for(int i=1;i<=N;i++){
            int[] ans =map.get(i);
            if(ans[0]==0){
                sb.append(0).append('\n');
                continue;
            }
            sb.append(ans[0]).append(' ').append(ans[1]).append('\n');
        }
        System.out.println(sb.toString().trim());
    }

    static void func(int index,int t,Stack<int[]> stack){
        //스택에 자기보다 작거나 같은 놈들 모두 제거
        while(!stack.isEmpty() && stack.peek()[1]<=t){
            int[] now =stack.pop();
        }
        //제거 후 스택이 비어있으면 내 옆에 나보다 큰게 없다는 것 = return
        if(stack.isEmpty()){
            stack.add(new int[]{index,t});
            return;
        }

        int[] nowAns =map.get(index);
        //나보다 큰놈들 즉 스택 크기 + 해줌
        nowAns[0]+=stack.size();

        int p =stack.peek()[0];
        int oldVal =Math.abs(index-nowAns[1]);
        int newVal=  Math.abs(p-index);
        //stack의 바로 앞에 있는 건물과 거리 비교
        // 거리가 작을 경우 와 거리가 같으면서 위치가 더 작을 경우 업데이트
        if(newVal<oldVal || (oldVal==newVal && p<nowAns[1])){
            nowAns[1]=p;
        }
        stack.add(new int[]{index,t});
    }
}
