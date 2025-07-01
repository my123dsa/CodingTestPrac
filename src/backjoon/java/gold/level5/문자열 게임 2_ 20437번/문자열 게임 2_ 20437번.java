import java.util.*;
import java.io.*;


public class Main {
    static char[] w;

    static Map<Integer,List<Integer>> map= new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int k=0;k<T;k++){
            w = br.readLine().toCharArray(); //<- w
            int K= Integer.parseInt(br.readLine()); //K
            int max=-1;
            int min =99999;
            int maxS=0;
            int maxE=0;
            int minS=0;
            int minE=0;
            boolean flag=false;
            for(int i=0;i<26;i++){
                // System.out.println(ch);
                map.put(i,new ArrayList<>());
            }

            for(int i=0;i<w.length;i++){
                map.get(w[i]-'a').add(i);
            }

            for(int i=0;i<26;i++){
                List<Integer> idxs = map.get(i);
                Collections.sort(idxs);
                // [1,2,3]
                for(int j=0;j<idxs.size()-K+1;j++){
                    int start= idxs.get(j);
                    int end = idxs.get(j+K-1);
                    int len = end-start;
                    // if(max<len){
                    // maxS= start;
                    // maxE=end;
                    // }
                    // if(min>len){
                    // minS=start;
                    // }
                    max= Math.max(max,len);
                    min = Math.min(min,len);
                }
            }
            if(max==-1 || min==99999){
                sb.append(-1).append("\n");
            }
            else{
                sb.append((min+1)+" ").append((max+1)+" ").append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
