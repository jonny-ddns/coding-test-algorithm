package programmers_coding_test.unsolved.lv02_오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        //Map : <userid, nickname>
        Map<String, String> map = new HashMap<>();
        //List : 새롭게 구성한 record
        List<String> list = null;
        //result : 리턴값
        String[] result;

        String command = "";
        String userid = "";
        String nickname = "";

        //nickname이 변경된 경우 최종변경된 닉네임 map 형성
        for(int i=record.length; i>0; i--){
            command = record[i-1].split(" ")[0];
            userid = record[i-1].split(" ")[1];

            if(command.equals("Change") && !isMapContainUserid(map, userid) ){
                nickname = record[i-1].split(" ")[2];
                map.put(userid, nickname);
                break;
            }
        }

        //nickname이 변경되지않은 경우 map에 넣기
        for(int i=record.length; i>0; i--){
            command = record[i-1].split(" ")[0];
            userid = record[i-1].split(" ")[1];

            if(command.equals("Enter") && !isMapContainUserid(map, userid) ){
                nickname = record[i-1].split(" ")[2];
                map.put(userid, nickname);
                break;
            }
        }

        list = new ArrayList<>();

        String comment_enter = "님이 들어왔습니다.";
        String comment_leave = "님이 나갔습니다.";
        String comment_final = "";
        
        //Enter 혹은 Leave인 경우만 comment 생성
        for(int i=0; i<record.length; i++){
            command = record[i].split(" ")[0];
            userid = record[i].split(" ")[1];
            nickname = map.get(userid);

            if(!command.equals("Change")){
                if(command.equals("Enter")){
                    comment_final = nickname+comment_enter;
                }
                if(command.equals("Leave")){
                    comment_final = nickname+comment_leave;
                }
                list.add(comment_final);
            }
        }

        result = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    //Map에 key값으로 userid가 포함되었는지 확인
    boolean isMapContainUserid(Map<String, String> map, String userid){
        boolean isContain = false;
        if(map.keySet().contains(userid)){
            isContain = true;
        }
        return isContain;
    }
}