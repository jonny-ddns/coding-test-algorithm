package programmers_coding_test.unsolved.lv02_����ä�ù�;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        //Map : <userid, nickname>
        Map<String, String> map = new HashMap<>();
        //List : ���Ӱ� ������ record
        List<String> list = null;
        //result : ���ϰ�
        String[] result;

        String command = "";
        String userid = "";
        String nickname = "";

        //nickname�� ����� ��� ��������� �г��� map ����
        for(int i=record.length; i>0; i--){
            command = record[i-1].split(" ")[0];
            userid = record[i-1].split(" ")[1];

            if(command.equals("Change") && !isMapContainUserid(map, userid) ){
                nickname = record[i-1].split(" ")[2];
                map.put(userid, nickname);
                break;
            }
        }

        //nickname�� ����������� ��� map�� �ֱ�
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

        String comment_enter = "���� ���Խ��ϴ�.";
        String comment_leave = "���� �������ϴ�.";
        String comment_final = "";
        
        //Enter Ȥ�� Leave�� ��츸 comment ����
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

    //Map�� key������ userid�� ���ԵǾ����� Ȯ��
    boolean isMapContainUserid(Map<String, String> map, String userid){
        boolean isContain = false;
        if(map.keySet().contains(userid)){
            isContain = true;
        }
        return isContain;
    }
}