package unsolved.lv02_����ä�ù�;
/*
 */


import java.util.*;

class Exam {
    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();


        String command = "";
        String userid = "";
        String nickname = "";


        //�̸��� ����Ǿ��ٸ� ��������� �г��� map ����
        for(int i=record.length; i>0; i--){
            command = record[i-1].split(" ")[0];
            userid = record[i-1].split(" ")[1];
//            if(isMapContainUserid(map), )

            if(command.equals("Change") && !isMapContainUserid(map, userid) ){
                nickname = record[i-1].split(" ")[2];
                map.put(userid, nickname);
            }
        }

        //������ ���� ���� ��� map�� �ֱ�
        for(int i=record.length; i>0; i--){
            command = record[i-1].split(" ")[0];
            userid = record[i-1].split(" ")[1];

            if(command.equals("Enter") && !isMapContainUserid(map, userid) ){
                nickname = record[i-1].split(" ")[2];
                map.put(userid, nickname);
            }
        }

        //�Ƹ��� map�ϼ� ... result �����ϱ�


        String answer = "";
        String comment_enter = "���� ���Խ��ϴ�.";
        String comment_leave = "���� �������ϴ�.";
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