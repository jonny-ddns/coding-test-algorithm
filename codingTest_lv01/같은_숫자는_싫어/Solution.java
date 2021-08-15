package codingTest_lv01.����_���ڴ�_�Ⱦ�;
//2021.08.15
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        boolean result;
        //�յ� ���� �ٸ��ٸ� ����Ʈ�� �� �߰��ϱ�
        for(int i=0; i<arr.length-1; i++){
            result = compareElement(arr, i);
            if(!result){
                list.add(arr[i]);
            }
        }
        //������ �� �߰�
        list.add(arr[arr.length-1]);

        //����Ʈ�� �迭�� ��ȯ�ϱ�
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    //n, n+1 ��° ���Ͽ��� �Ǵ�
    boolean compareElement(int[] arr, int n){
        return (arr[n] == arr[n+1]);
    }
}