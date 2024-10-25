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
        int a = (shuffleNum.get(0) * 100) + (shuffleNum.get(1) * 10) + shuffleNum.get(2);
        System.out.println(a + " " + shuffleNum);
        System.out.println("숫자를 입력해 주세요");


        //정답 입력
        int answerNum = 0;
        String strAnswerNum;
        char tmp;
        boolean input = true;

        while (a != answerNum) {
            Scanner sc = new Scanner(System.in);
            strAnswerNum = sc.nextLine();

            System.out.println(strAnswerNum);
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



            System.out.println("문제");
            System.out.println(shuffleNum);

            System.out.println("답변");
            System.out.println(answer);

            List<Integer> scount = new ArrayList<>();
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

            System.out.println(strike + " 스트라이크 " + ball + " 볼");


        }

        System.out.println("정답입니다.");


    }

}
