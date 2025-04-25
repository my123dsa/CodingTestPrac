import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int length = target.length();
        boolean[] visited = new boolean[words.length];
        Deque<String[]> deque = new ArrayDeque<>();
        deque.add(new String[]{begin, "0"});  // [현재 단어, 현재 레벨]

        while (!deque.isEmpty()) {
            String[] current = deque.pop();
            String currentWord = current[0];
            int level = Integer.parseInt(current[1]);

            if (currentWord.equals(target)) {
                return level;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i] || words[i].equals(currentWord)) {
                    continue;
                }

                int count = 0;
                for (int j = 0; j < length; j++) {
                    if (words[i].charAt(j) == currentWord.charAt(j)) {
                        count++;
                    }
                }

                if (count >= length - 1) {  // 한 글자만 다른 경우
                    visited[i] = true;
                    deque.add(new String[]{words[i], String.valueOf(level + 1)});
                }
            }
        }

        return 0;  // 변환할 수 없는 경우
    }
//     static class Item{
//         String word;
//         int level;
//         boolean[] visited;

//         public Item(String word, int level,boolean[] visited) {
//             this.word = word;
//             this.level = level;
//             this.visited = visited;
//         }
//     }
}