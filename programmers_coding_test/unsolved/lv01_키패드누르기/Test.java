package programmers_coding_test.unsolved.lv01_키패드누르기;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        String answer = s.solution(numbers, hand);
        System.out.println("answer : "+ answer);
    }
}
