package programmers_coding_test.solved.lv01_최대공약수와최소공배수;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int n, int m) {
        int max = max(n, m);
        int min = min(n, m, max);
        return new int[]{max, min};
    }

    int max(int x, int y){
        Map<Integer, Integer> mapX = factor(x);
        Map<Integer, Integer> mapY = factor(y);

        int multi = 1;

        for(int i : mapX.keySet()){
            if (mapY.containsKey(i)) {
                multi *= (int) Math.pow(i, Math.min(mapX.get(i), mapY.get(i)));
            }
        }
        return multi;
    }

    int min(int x, int y, int max){
        return x * y / max;
    }

    //최대공약수
    Map<Integer, Integer> factor(int n){
        Map<Integer, Integer> map = new HashMap<>();
        int limit = n / 2;
        int tmp = n;
        for (int i = 2; i <= limit; i++) {
            tmp = addElement(map, tmp, i);
            if (tmp == 1) {
                break;
            }
        }
        if(map.isEmpty()){
            map.put(n, 1);
        }
        return map;
    }

    int addElement(Map<Integer, Integer> map, int goal, int x){
        int square = 0;
        while(goal % ((int) Math.pow(x, square)) == 0){
            square++;
        }
        square--;
        if(square != 0){
            map.put(x, square);
        }
        return goal / (int) Math.pow(x, square);
    }
}