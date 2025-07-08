import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> registered = new HashSet<>();

        for (int now = 0; now < N; now++) {
            String[] inputArr = br.readLine().split(" ");
            boolean marked = false;

            // 1. 각 단어의 첫 글자 우선 탐색
            for (int i = 0; i < inputArr.length; i++) {
                char ch = inputArr[i].charAt(0);
                if (!registered.contains(Character.toLowerCase(ch)) && !registered.contains(Character.toUpperCase(ch))) {
                    registered.add(Character.toLowerCase(ch));
                    registered.add(Character.toUpperCase(ch));

                    StringBuilder sb = new StringBuilder(inputArr[i]);
                    sb.insert(0, '[');
                    sb.insert(2, ']');
                    inputArr[i] = sb.toString();

                    marked = true;
                    break;
                }
            }

            // 2. 첫 글자에서 못 찾았을 경우, 전체 문자 순회
            if (!marked) {
                outer:
                for (int i = 0; i < inputArr.length; i++) {
                    for (int j = 0; j < inputArr[i].length(); j++) {
                        char ch = inputArr[i].charAt(j);
                        if (!registered.contains(Character.toLowerCase(ch)) && !registered.contains(Character.toUpperCase(ch))) {
                            registered.add(Character.toLowerCase(ch));
                            registered.add(Character.toUpperCase(ch));

                            StringBuilder sb = new StringBuilder(inputArr[i]);
                            sb.insert(j, '[');
                            sb.insert(j + 2, ']');
                            inputArr[i] = sb.toString();
                            break outer;
                        }
                    }
                }
            }

            printAnswer(inputArr);
        }
    }

    public static void printAnswer(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) sb.append(arr[i]);
            else sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
