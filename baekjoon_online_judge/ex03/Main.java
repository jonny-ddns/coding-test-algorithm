package baekjoon_online_judge.ex03;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        new Nested().execute();
    }
    static class Nested {
        void execute(){
            try{
                InputStream inputStream = System.in;
                byte[] byteArr = new byte[4];
                int readByte = 0;

                while((readByte = inputStream.read(byteArr, 0, byteArr.length)) != -1){
                    for(byte b : byteArr){
                        System.out.println((char)b);
                    }

                    System.out.println("kkk");
                }
                System.out.println("mmm");


            } catch (IOException ie){
                ie.printStackTrace();
            }


        }


    }
}