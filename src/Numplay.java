import java.util.*;

public class Numplay extends GameRule {
    public static void main(String[] args) {
        //중복이 없는 숫자 랜덤 숫자 만들기
        Random random = new Random();
        HashSet<Integer> treeNum = new HashSet<>();
        while (treeNum.size() < 3) {
            treeNum.add(random.nextInt(9) + 1);
        }
        //set >> List
        List<Integer> shuffleNum = new ArrayList<>(treeNum);
        Collections.shuffle(shuffleNum);
        int correctNum = (shuffleNum.get(0) * 100) + (shuffleNum.get(1) * 10) + shuffleNum.get(2);
        System.out.println(correctNum + " " + shuffleNum);
        System.out.println("숫자를 입력해 주세요");


        //정답 입력
        int answerNum = 0;
        String strAnswerNum;
        char tmp;
        boolean input = true;
        int tryCount = 0;

        while (correctNum != answerNum) {
            Scanner sc = new Scanner(System.in);
            strAnswerNum = sc.nextLine();
            tryCount++;
            for (int i = 0; i < strAnswerNum.length(); i++) {
                tmp = strAnswerNum.charAt(i);
                if ('0' <= tmp && tmp <= '9') {
                    input = true;
                    answerNum = Integer.parseInt(strAnswerNum);
                } else {
                    input = false;
                    System.out.println("숫자를 입력해 주세요");
                }
            }
            int num1 = answerNum / 100;
            int num2 = (answerNum - num1 * 100) / 10;
            int num3 = answerNum % 10;

            List<Integer> answer = new ArrayList<>();
            answer.add(num1);
            answer.add(num2);
            answer.add(num3);


            int strike = 0;
            int ball = 0;

            for (int i = 0; i < shuffleNum.size(); i++) {
                for (int j = 0; j < answer.size(); j++) {
                    if (shuffleNum.get(i) == answer.get(j)) {
                        if (i == j) {
                            strike = strike + 1;
                        } else {
                            ball = ball + 1;
                        }
                    }
                }
            }
            System.out.println(tryCount +"차 시도 "+ answer);
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        }
        System.out.println("정답입니다.("+tryCount+"차)");


    }

}
