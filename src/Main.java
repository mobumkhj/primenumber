import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요: ");
        long input = sc.nextInt();

        PrimeNumber l3 = new PrimeNumber();
        List<Long> output = l3.getPrimeNumbers(input);

        System.out.println("소수: ");
        System.out.println(output);
    }
}