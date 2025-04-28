import java.util.*;
class Solution {
    public class Robot{
        int r;
        int c;
        int nextIndex;
        public Robot(int r,int c, int nextIndex){
            this.r = r;
            this.c=c;
            this.nextIndex=nextIndex;
        }

        public void moveToTarget(int targetR,int targetC){
            if(r<targetR){
                r++;
                return;
            }else if( r>targetR){
                r--;
                return;
            }
            if(c<targetC){
                c++;
            }else if(c>targetC){
                c--;
            }
        }

        public boolean hasArrived(int targetR,int targetC){
            return r==targetR && c== targetC;
        }

        public void updateIndex(){
            this.nextIndex++;
        }
    }
    public int solution(int[][] points, int[][] routes) {
        int routeStep= routes[0].length;
        List<Robot> robots = new ArrayList<>();
        Map<Integer, Integer> startMap = new HashMap<>();

        for(int i=0;i<routes.length;i++){
            int[] xy =points[routes[i][0]-1];
            Robot robot = new Robot(xy[0],xy[1],1);
            robots.add(robot);
            if(startMap.containsKey(routes[i][0])){
                startMap.put(routes[i][0],startMap.get(routes[i][0])+1);
            }
            else{
                startMap.put(routes[i][0],1);
            }
        }
        int result = 0;

        for (Integer value : startMap.values()) {
            if (value > 1) {
                result++;
            }
        }

        while(!robots.isEmpty()){
            Map<String, Integer> collisionMap = new HashMap<>();
            boolean[] arrived = new boolean[robots.size()];

            for(int i=0;i<robots.size();i++){
                Robot robot=robots.get(i);
                int nextIndex= robot.nextIndex;
                if(nextIndex>=routeStep){
                    arrived[i]= true;
                    continue;
                }
                int pointIndex = routes[i][nextIndex] - 1;
                int targetR = points[pointIndex][0];
                int targetC = points[pointIndex][1];

                robot.moveToTarget(targetR,targetC);

                String posKey= robot.r+" "+robot.c;
                if(collisionMap.containsKey(posKey)){
                    collisionMap.put(posKey,collisionMap.get(posKey)+1);
                }
                else{
                    collisionMap.put(posKey,1);
                }

                if(robot.hasArrived(targetR,targetC)){
                    robot.updateIndex();
                }
            }

            for(Integer value : collisionMap.values()){
                if(value>1){
                    result++;
                }
            }
            boolean allArrived = true;
            for (boolean arrivedStatus : arrived) {
                if (!arrivedStatus) {
                    allArrived = false;
                    break;
                }
            }
            if (allArrived) {
                break;
            }

        }
        return result;
    }
}