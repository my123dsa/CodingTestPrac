import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> tops = new ArrayList<>();

        if(N>0){
            st= new StringTokenizer(br.readLine());
        }

        for(int i=0;i<N;i++){
            int topRecord = Integer.parseInt(st.nextToken());
            tops.add(topRecord);
        }

        int index=-1;
        boolean flag = false;
        int count=0;

        for(int i=0;i<tops.size();i++){
            int record= tops.get(i);
            if(record<newScore){
                index = i-count;
                flag= true;
                break;
            }
            if(record==newScore){
                count++;
            }
        }
        if(!flag){
            index= tops.size()-count;
        }

        index++;
        System.out.println(index+count<=P? index: -1);
        // System.out.println(tops);
        // if p보다 크면 -1

    }
}
