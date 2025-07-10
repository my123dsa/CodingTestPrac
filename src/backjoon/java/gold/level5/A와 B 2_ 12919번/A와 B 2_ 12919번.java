import java.util.*;
import java.io.*;

public class Main {
    static String S,T,RT;
    static boolean result =false;
    static int tl;
    static int sl;
    static Set<String> set= new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        RT= change(T);
        tl= T.length();
        sl= S.length();
        init();
        // 1. S에 A 추가 2. B 추가하고 문자열 reserve
        // 3.  S.length() == T.length()  if(S.equals.(T));
        dfs(S,S.length(),false);
        System.out.println(result?1 :0);
    }

    static void dfs(String str ,int length,boolean reverse){
        if(!result){
            if(length==T.length()){
                // System.out.println(str);
                if(!reverse){
                    if(str.equals(T)){
                        result =true;
                    }
                }
                else{
                    if(change(str).equals(T)){
                        result=true;
                    }
                }
                return;
            }
            if(!set.contains(str)){
                return;
            }
            if(reverse){
                dfs("A"+str,length+1,reverse);
                dfs("B"+str,length+1,!reverse);
            }
            else{
                dfs(str+"A",length+1,reverse);
                dfs(str+"B",length+1,!reverse);
            }


        }
    }
    static void init(){
        for(int i= sl;i<=tl;i++){
            // set.add(T.);
            // set.add(RT.su)
            for(int j =0;j+i<=tl;j++){
                set.add(T.substring(j,j+i));
                set.add(RT.substring(j,j+i));
                // System.out.println(T.substring(j,j+i));
            }

        }
    }

    static String change(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
