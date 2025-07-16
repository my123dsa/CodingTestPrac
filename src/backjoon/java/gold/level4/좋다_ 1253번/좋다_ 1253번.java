import java.util.*;
import java.io.*;
public class Main {
    static int count =0;
    static int[] numbers;
    static int N;
    static boolean[] goods;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 어떤 수가 다른 수 두 개의 합
        numbers= new int[N];
        goods= new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            numbers[i]= Integer.parseInt(st.nextToken());
        }
        //오름차순
        Arrays.sort(numbers);

        for(int i=0;i<N;i++){

            int target = numbers[i];
            //혹시 자신과 같은게 사전에 이미 있으면 그거 따라감
            if(i!=0 && target==numbers[i-1]){
                if(goods[i-1]){
                    goods[i]=true;
                    count++;
                }
                continue;
            }
            //시작과 끝을 둠 -> 음수도 존재해서
            int left = 0;
            int right = N-1;

            //왼쪽 포인터가 오른쪽 보다 작을 때 반복
            while(left<right){
                //자기 사진일 때는 ++ or -- 처리
                if(left==i){
                    left++;
                    continue;
                }
                if(right==i){
                    right--;
                    continue;
                }

                int ln = numbers[left];
                int lr = numbers[right];
                int sum =ln+lr;

                //합이 되면 탈출
                if(sum==target){
                    count++;
                    goods[i]=true;
                    break;
                }
                //크면 오른쪽을 작게
                //작으면 왼쪽을 크게
                if(sum>target) right--;
                else left++;
            }
        }

        System.out.println(count);
    }
}
