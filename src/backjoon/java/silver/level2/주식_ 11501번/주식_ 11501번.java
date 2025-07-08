import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer  st = new StringTokenizer(br.readLine());
            int[] prices = new int[N];

            long total =0;

            for(int j=0;j<N;j++){
                int price = Integer.parseInt(st.nextToken());
                prices[j]= price;
            }

            long max=prices[prices.length-1];

            for(int j=prices.length-2;j>=0;j--){
                long price = prices[j];

                if(price<max){
                    total+= max-price;
                }
                else{
                    max= price;
                }
            }

            sb.append(total).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}
