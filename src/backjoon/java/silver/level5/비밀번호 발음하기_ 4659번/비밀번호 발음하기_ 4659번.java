import java.util.*;
import java.io.*;

public class Main {
    static Set<Character> gather = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static Set<Character> ggather = new HashSet<>(Arrays.asList('e', 'o'));

    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //gather 필수
        //모음 자음 연속 3번나오면 안됨
        //ggather이놈만 2번 연속 허용

        //end이면 탈출
        while(true){
            String input = br.readLine();
            boolean flag = true;
            boolean isGather =false;

            if("end".equals(input)){
                break;
            }

            char first=' ';
            char second=' ';

            for(int i=0;i<input.length();i++){
                char now = input.charAt(i);
                if(gather.contains(now)){
                    isGather=true;
                }

                if(second==now){
                    if(!ggather.contains(now)){
                        // System.out.println("2");
                        flag=false;
                        break;
                    }
                }
                // System.out.println(now+" "+second+" "+first);
                if(i>=2){
                    boolean nowGather = gather.contains(now);
                    boolean secondGather = gather.contains(second);
                    boolean firstGather = gather.contains(first);

                    if (nowGather == secondGather && secondGather == firstGather) {
                        flag = false;
                        break;
                    }
                }

                first = second;
                second = now;
            }

            if(flag && isGather){
                acceptable(input);
            }
            else{
                inAccept(input);
            }
        }

        System.out.println(sb.toString().trim());
    }

    static void acceptable(String input){
        sb.append('<').append(input).append('>').append(" is acceptable.").append('\n');
    }

    static void inAccept(String input){
        sb.append('<').append(input).append('>').append(" is not acceptable.").append('\n');
    }
}
