import java.util.*;
import java.io.*;

public class Main {
    static int N,K,max;
    static StringBuilder sb = new StringBuilder();
    static int[] totalValues;
    static List<int[]> products = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //물품 개수
        K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 물품 무게
            int V = Integer.parseInt(st.nextToken()); // 물품 가치
            products.add(new int[]{W,V});
        }

        //무게당 가치 배열 만들고 -1 넣음
        totalValues = new int[K+1];
        Arrays.fill(totalValues,-1);

        //시작지점인 0 0으로 시작
        totalValues[0]= 0;

        for(int i=0;i<products.size();i++){
            //물건 하나씩 빼고
            int[] nowProduct = products.get(i);
            int productWeight = nowProduct[0];
            int productValue =  nowProduct[1];
            //무게가 K인거부터 차례로 -1 아닌 것 즉 이미 누가 배낭에 넣은 곳만 색출
            for(int w=K;w>=0;w--){

                if(totalValues[w]!=-1){

                    int nw = w + productWeight;
                    // 해당 무게에 대해 더 큰 가치를 적용
                    if(nw<=K && (totalValues[nw]<totalValues[w]+productValue)){
                        totalValues[nw]= totalValues[w]+productValue;
                    }
                }
            }
        }
        //무게 전체 탐색하면서 최대값 가져옴
        for(int i = K;i>=0;i--){
            if(totalValues[i]!= -1){
                max= Math.max(max,totalValues[i]);
            }
        }
        System.out.println(max);

    }
}
