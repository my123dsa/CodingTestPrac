import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        //채팅방은 중복 닉네임을 허용
        //A가 나간후 B로 다시 들어올 때  모두 B로 변경
        //A가 방에서 B로 변경시 모두 B로 변경

        //이거 순서 보장 필수

        int count=0;
        Map<String,List<Recode>> enterMap = new HashMap<>();

        Map<String,String> nameMap = new HashMap<>();

        for(int i=0;i<record.length;i++){
            String[] recordArray = record[i].split(" ");

            String id = recordArray[1];
            String type= recordArray[0];


            Recode newRecode = new Recode(i-count,type);

            if(type.equals("Change")){
                String name = recordArray[2];
                count++;
                nameMap.put(id,name);
                continue;
            }

            if(!nameMap.containsKey(id)){

                List<Recode> recodeList =new ArrayList<>();

                enterMap.put(id, recodeList);
            }

            if(!type.equals("Leave")){
                nameMap.put(id,recordArray[2]);
            }

            enterMap.get(id).add(newRecode);
        }

        String[] answer= new String[record.length-count];

        Iterator<Map.Entry<String,String>> iterator = nameMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            String nowId = entry.getKey();
            String newName = entry.getValue();

            List<Recode> recodeList=  enterMap.get(nowId);

            for(int i=0;i<recodeList.size();i++){
                Recode nowRecode= recodeList.get(i);
                System.out.println();
                answer[nowRecode.index] = createString(nowRecode.type,newName);

            }
        }

        return answer;
    }

    public String createString(String type, String name){
        if(type.equals("Enter")){
            return name+"님이 들어왔습니다.";
        }
        return name+"님이 나갔습니다.";

    }

    class Recode{
        int index;
        String type;

        public Recode(int index, String type){
            this.index= index;
            this.type= type;
        }
    }
}