package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요");
        String carName1 = Console.readLine();
        String[] carName2 = splitNames(carName1);
        nameError(carName2);

        System.out.println("시도할 횟수를 입력하세요");
        int number = Integer.parseInt(Console.readLine());

        System.out.println("실행결과");
        f5(carName2, number);
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
    static void f3(String[] cars,  String[] pos, int i) {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            pos[i] = pos [i] + "-";
        }
    }
    static void f4(String[] cars, String[] pos) {
        for (int i = 0; i < cars.length; i++) {
            f3(cars, pos, i);
            System.out.println(cars[i].trim() + " : " + pos[i]);
        }
        System.out.println(); //?빼도되는거아니냐
    }
    static void f5(String[] cars, int number) {
        String[] pos = new String[cars.length];
        Arrays.fill(pos, "");

        for (int r = 0; r < number; r++) {
            f4(cars, pos);
        }
    }

}
