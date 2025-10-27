package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요");
        String carName1 = Console.readLine();
        String[] carName2 = splitNames(carName1);
        nameError(carName2);

        System.out.println("시도할 횟수를 입력하세요");
        int number = Integer.parseInt(Console.readLine());

        System.out.println("실행결과");
        loop3(carName2, number);
    }
    static String[] splitNames(String input) {
        return input.split(",");
    }
    static void nameError(String[] cars) {
        for (String name : cars) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
    static void loop1(String[] cars,  String[] pos, int i) {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            pos[i] = pos [i] + "-";
        }
    }
    static void loop2(String[] cars, String[] pos) {
        for (int i = 0; i < cars.length; i++) {
            loop1(cars, pos, i);
            System.out.println(cars[i].trim() + " : " + pos[i]);
        }
        System.out.println(); //?빼도되는거아니냐
    }
    static void loop3(String[] cars, int number) {
        String[] pos = new String[cars.length];
        Arrays.fill(pos, "");

        for (int r = 0; r < number; r++) {
            loop2(cars, pos);
        }
        printWinner(cars,pos);
    }
    static void printWinner(String[] cars, String[] pos) {
        int max = 0;
        String winners = "";

        for (int i = 0; i < cars.length; i++) {
            int len = pos[i].length();
            if (len > max) {
                max = len;
                winners = cars[i].trim();
            } else if (len == max) {
                winners += ", " + cars[i].trim();
            }
        }
        System.out.println("최종 우승자 : " + winners);
    }
}
