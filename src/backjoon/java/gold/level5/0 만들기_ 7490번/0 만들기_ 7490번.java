import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int k=0;k<T;k++){
            N = Integer.parseInt(br.readLine());
            char[] c= new char[N];
            dfs(2,0,c,1,'+');
            sb.append('\n');

        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int level,int num,char[] ch, int before,char nc){
        if(level==N+1){
            int aa=cal(num,before,nc);
            if(aa==0){
                String s ="";
                for(int i=0;i<N;i++){
                    s+= (i+1);
                    s+= ch[i];
                    // sb.append(i+1).append(ch[i]);
                }
                s= s.trim();
                sb.append(s);
                sb.append('\n');
            }
            return;
        }

        ch[level-2]=' ';
        dfs(level+1,num,ch,before*10+(level),nc);
        ch[level-2]='+';
        dfs(level+1,cal(num,before,nc),ch,level,'+');
        ch[level-2]='-';
        dfs(level+1,cal(num,before,nc),ch,level,'-');

    }

    static int cal(int num, int before, char c){
        if(c=='+'){
            return num+before;
        }
        return num-before;
    }
}
