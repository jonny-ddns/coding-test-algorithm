package unsolved.lv01_���￡��_�輭��_ã��;

import java.util.ArrayList;
import java.util.List;

class CompareTest {
    public void solution() {

        int index = 1000000;
        String[] strArr = new String[index];

        for(int i=0; i<index-1; i++){
            strArr[i] = Integer.toString((int)(Math.random() * 10));
        }
        strArr[index-1] = "Kim";


        List<String> list = new ArrayList<>();
        for(int i=0; i<index-1; i++){
           list.add( Integer.toString((int)(Math.random() * 10)) );
        }
        list.add("Kim");


        //ã��1
        int num;
        long time1;
        long time2;
        time1 = System.nanoTime();
        num = 0;
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].equals("Kim")){
                num = i;
                break;
            }
        }
        time2 = System.nanoTime();
        System.out.println("try1 : "+ num);
        System.out.println("�ð� : "+ (time2-time1));

        time1 = System.nanoTime();
        num = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals("Kim")){
                num = i;
                break;
            }
        }
        time2 = System.nanoTime();
        System.out.println("try2 : "+ num);
        System.out.println("�ð� : "+ (time2-time1));


    }


    public static void main(String[] args) {
        new CompareTest().solution();
    }
}