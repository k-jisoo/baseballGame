import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 변수 선언
        Random rand = new Random();
        int[] randomNumbers = new int[3];
        int[] userNumbers = new int[3];
        int strike = 0;
        int ball = 0;
        int cnt = 0;
        int randCnt = 0;

        // 컴퓨터가 숫자 3개를 랜덤으로 생성
        while (randCnt < 3) {
            int randomNumber = rand.nextInt(10);
            if (!contains(randomNumbers, randomNumber, randCnt)) {
                randomNumbers[randCnt] = randomNumber;
                randCnt++;
            }
        }


        // 사용자의 입력을 반복
        while(true){
            //strike, ball 초기화
            strike = 0;
            ball = 0;

            //사용자 입력 전 루프 카운트 증가.
            cnt++;
            
            // 사용자가 3자리 숫자를 입력
            Scanner sc = new Scanner(System.in);
            int str = sc.nextInt();

            int firstNum = str / 100;
            int secondNum = str % 100 / 10;
            int thirdNum = str % 10;

            userNumbers[0] = firstNum;
            userNumbers[1] = secondNum;
            userNumbers[2] = thirdNum;


            // strike 및 ball 처리
            for (int i = 0; i < 3; i++) {
                if(userNumbers[i] == randomNumbers[i]) {
                    strike++;
                }
                else if (contains(randomNumbers, userNumbers[i], 3)){
                    ball++;
                }
            }


            // 사용자 입력 처리 후 스트라이크 볼 표시
            String output = strike + "S" + ball + "B";
            System.out.println(output);


            // 3S0B일 경우 게임 종료.
            if(output.equals("3S0B")){
                System.out.println(cnt + "번만에 맞히셨습니다.\n게임을 종료합니다.");
                break;
            }
        }
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인하는 메서드
    public static boolean contains(int[] array, int target, int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }
}
