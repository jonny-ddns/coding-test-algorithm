package programmers_coding_test.unsolved.lv02_���ڿ�����;

//https://programmers.co.kr/learn/courses/30/lessons/60057?language=java

/*
���ڿ��� ���� �պ��� ������ ���̸�ŭ �߶�� �Ѵ�
-�߰����� �ڸ��� �� �����
���ڿ� Ư�� ���ڱ������θ� �����ϱ�
���ϰ�; ����� �ּұ���
 */
/*
�ݺ��� ���鼭 ���� �� �ִ��� ã��
�ݺ����� �ݺ��ڴ� 2���� �־��� ���ڿ��� 1/2����

���ڿ��� ���ڰ� �־�����
���ڿ��� ó������ ���ڸ�ŭ ���̸� �߶󺻴� ->
�ڸ� ���ڿ���ŭ ���� ��ġ�ϴ� ���� Ȯ���ϱ�
���ڿ� �ٲٱ� -> ����+���ڿ�+������

�� ���ڿ����� ���� ����
�ּڰ��� �����ϱ�
 */
class Solution {
    public int solution(String body) {
        int answer = 0;
        String piece;
        int i;
        int count;
        int min;

        for(i=2; i<body.length()/2+1; i++){
            piece = getPiece(body, i);
            count = test2(body, piece);
            System.out.println("piece : "+ piece);



//            count = test2(body, piece);
            System.out.println("count : "+ count);

        }
        return answer;
    }

    //���ڿ� ã��
    //Ư�� ���� -> ���ڿ� �ش��ϴ� ���� �丷 ã��
    //when 2 -->
//    String test(String body, int num){
//        String compare = getPiece(body, num);
//        String part;
//
//        int count = 0;
//        boolean isEqual = true;
//        part = body.substring(i*num, num);
//        while(isEqual){
//            for(int i=0; i<body.length(); i++){
//
//                if(!compare.equals(part)){
//                    break;
//                }
//                count++;
//            }
//        }
//        body.replace()
//                //+count;
//        return body;
//    }

    //��ġ�ϴ� �ͱ��� ���ڿ� ��ȯ�ϱ�
    String test3(String body, String part){
        int num = part.length();

        //���ǹ�

        for(int i=0; num*i<body.length(); i++){
//            if(){
//
//
//                continue;
//            }
            break;
        }

        return null;
    }


    void test2(String body, int num){
        String compare = getPiece(body, num);   //���� ���ڿ�
//        String part;


        
    }




    //������ ���� ���ڿ� �丷 �����
    String getPiece(String body, int num){
        return body.substring(0, num);
    }
    
    //���ڿ� �ٲٱ�
    int test2(String body, String part){
        return (body.replace(part, "")+ part).length();
    }
}