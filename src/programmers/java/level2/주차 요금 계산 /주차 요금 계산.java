import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {

        //기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
        // 0            1               2               3
        //조건1 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주
        //조건2 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림
        //조건3 차량 번호 오름차순
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee =fees[3];
        Map<String,int[]> carMap= new HashMap<>();
        for(int i=0;i<records.length;i++){
            String[] record= records[i].split(" ");
            int recordTime = timeToInt(record[0]);
            String recordNum= record[1];
            String recordType = record[2];
            if(carMap.containsKey(recordNum)){
                int[] inTimeArray=carMap.get(recordNum);
                if(recordType.equals("IN")){
                    inTimeArray[0]= recordTime;
                    inTimeArray[2]= 1;
                }
                else{
                    inTimeArray[1] += recordTime-inTimeArray[0];
                    inTimeArray[0]=0;
                    inTimeArray[2]= 0;
                }
                carMap.put(recordNum,inTimeArray);
            }
            else{
                int[] timeArray= new int[3];
                timeArray[0]=recordTime;
                timeArray[2]= 1;
                carMap.put(recordNum,timeArray);
            }
        }

        int[] answer = new int[carMap.size()];
        PriorityQueue<Map.Entry<String,int[]>> queue = new PriorityQueue<>((a,b)->a.getKey().compareTo(b.getKey()));
        Iterator<Map.Entry<String,int[]>> iterator= carMap.entrySet().iterator();
        int last = timeToInt("23:59");
        while(iterator.hasNext()){
            Map.Entry<String,int[]> entry= iterator.next();

            int[] timeArray= entry.getValue();
            // System.out.println(entry.getKey()+" "+Arrays.toString(timeArray));
            //490/10  49
            if(timeArray[2] ==1){
                timeArray[1]+=last-timeArray[0];
            }
            int remainTime = timeArray[1]-basicTime;
            if(remainTime<=0){
                timeArray[0]=basicFee;
            }
            else{
                timeArray[0]=basicFee;
                timeArray[0]+=(int)Math.ceil((double)remainTime/unitTime) * unitFee;
                // System.out.println((int)Math.ceil((double)remainTime/unitTime)+"여기오");
            }
            // System.out.println(entry.getKey()+" "+Arrays.toString(timeArray));
            queue.add(entry);
        }

        int index=0;
        while(!queue.isEmpty()){
            answer[index++]= queue.poll().getValue()[0];
        }
        return answer;
    }

    public int timeToInt(String time){
        String[] hourAndMin = time.split(":");
        int hour= Integer.parseInt(hourAndMin[0])*60;
        int min = Integer.parseInt(hourAndMin[1]);
        return hour+min;
    }
}