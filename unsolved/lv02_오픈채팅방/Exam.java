package unsolved.lv02_오픈채팅방;
/*
 */


import java.util.*;

class Exam {
    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();


        String command = "";
        String userid = "";
        String nickname = "";


        //이름이 변경되었다면 최종변경된 닉네임 map 형성
        for(int i=record.length; i>0; i--){
            command = record[i-1].split(" ")[0];
            userid = record[i-1].split(" ")[1];
//            if(isMapContainUserid(map), )

            if(command.equals("Change") && !isMapContainUserid(map, userid) ){
                nickname = record[i-1].split(" ")[2];
                map.put(userid, nickname);
            }
        }

        //변경이 되지 않은 경우 map에 넣기
        for(int i=record.length; i>0; i--){
            command = record[i-1].split(" ")[0];
            userid = record[i-1].split(" ")[1];

            if(command.equals("Enter") && !isMapContainUserid(map, userid) ){
                nickname = record[i-1].split(" ")[2];
                map.put(userid, nickname);
            }
        }

        //아마도 map완성 ... result 생성하기


        String answer = "";
        String comment_enter = "님이 들어왔습니다.";
        String comment_leave = "님이 나갔습니다.";
        String comment_final = "";



        List<String> list = new ArrayList<>();

    for(int i=0; i<record.length; i++){

            command = record[i].split(" ")[0];
            userid = record[i].split(" ")[1];

            nickname = map.get(userid);

            if(command.equals("Enter")){
                comment_final = nickname+comment_enter;
            } if(command.equals("Leave")){
                comment_final = nickname+comment_leave;
            } if(command.equals("Change")){
                break;
            }
//            result[i] = comment_final;
        list.add(comment_final);


        }

        String[] result = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }


        return result;
    }


    boolean isMapContainUserid(Map map, String userid){
        boolean isContain = false;
        if(map.keySet().contains(userid)){
            isContain = true;
        }
        return isContain;
    }
}