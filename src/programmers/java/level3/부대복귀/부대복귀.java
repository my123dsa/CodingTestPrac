import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> route = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            route.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            route.get(road[0]).add(road[1]);
            route.get(road[1]).add(road[0]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        for(int i=0;i<distance.length;i++){
            distance[i]=-1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(destination);
        visited[destination] = true;
        distance[destination] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : route.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
        // System.out.println(Arrays.toString(distance));

        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = distance[sources[i]];
        }

        return result;
    }
}
