import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요: ");
        long input = sc.nextInt();
        List<Integer> output = null;

        DB l1 = new DB();
        output = l1.getPrimeNumbers(input);

        if(output == null){
            PrimeNumber l3 = new PrimeNumber();
            output = l3.makePrimeNumber(input);
        }

        System.out.println("소수: ");
        System.out.println(output);
        l1.savePrimeNumber(input, output);
    }
}