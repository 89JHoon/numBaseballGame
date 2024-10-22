import java.util.*;

public class Numplay {
    public static void main(String[] args) {
        //문제
        Random random = new Random();
        HashSet<Integer> treeNum = new HashSet<>();
        while (treeNum.size() < 3) {
            treeNum.add(random.nextInt(9) + 1);
        }
        //set >> List
        List<Integer> shuffleNum = new ArrayList<>(treeNum);
        Collections.shuffle(shuffleNum);
        System.out.println(shuffleNum);
        System.out.println("숫자를 입력해 주세요");


        //정답 입력
        Scanner sc = new Scanner(System.in);
        int answerNum = sc.nextInt();
        System.out.println(answerNum);

        int num1 = answerNum / 100;
        int num2 = (answerNum -num1*100)/10;
        int num3 = answerNum % 10;

        List<Integer> answer = new ArrayList<>();
        answer.add(num1);
        answer.add(num2);
        answer.add(num3);



    }
}
