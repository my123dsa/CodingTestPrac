import java.util.*;
class Solution {
    int numberIndex=0;
    int tailIndex= 0;

    List<File> fileList;
    public String[] solution(String[] files) {

        //HEAD, NUMBER, TAIL
        //조건 1 head기준 사전 정렬 대소문자 무시
        //조건 2  숫자 정렬
        //조건 3 1,2 동일시 들어온 순서 그대로

        fileList = new ArrayList<>();

        for(int i=0;i<files.length;i++){
            String file = files[i];
            numberIndex=0;
            tailIndex=0;
            checkIndex(file);
            String head= file.substring(0,numberIndex);
            String number= file.substring(numberIndex,tailIndex);
            String tail= file.substring(tailIndex);
            File newFile =new File(head,number,tail);
            numberCompare(newFile);
        }
        String[] answer = new String[files.length];
        for(int i=0;i<fileList.size();i++){
            answer[i]= fileList.get(i).getAll();
            // System.out.println(fileList.get(i).getAll());
        }

        return answer;
    }

    public void numberCompare(File newFile){
        for(int i=fileList.size()-1;i>=0;i--){
            File before = fileList.get(i);
            if(compare(before,newFile)<=0){
                fileList.add(i+1,newFile);
                return;
            }
        }
        fileList.add(0,newFile);
        return;
    }

    public int compare(File f1, File f2){
        int result= f1.head.toUpperCase().compareTo(f2.head.toUpperCase());
        if(result == 0){
            return f1.intNumber-f2.intNumber;
        }
        return result;
    }

    public void checkIndex(String file){
        for(int j=0;j<file.length();j++){
            char c =file.charAt(j);
            if(c>='0' && c<='9'){
                numberIndex=j;
                break;
            }
        }
        for(int j=numberIndex;j<file.length();j++){
            char c =file.charAt(j);
            if(c>='0' && c<='9'){
                continue;
            }
            tailIndex=j;
            break;
        }
        if(tailIndex==0){
            tailIndex=file.length();
        }
    }

    class File{
        String head;
        String number;
        int intNumber;
        String tail;
        File(String head,String number,String tail){
            this.head= head;
            this.number= number;
            this.tail= tail;
            this.intNumber = Integer.parseInt(number);
        }
        public String getAll(){
            return head+number+tail;
        }
    }
}