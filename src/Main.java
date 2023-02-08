import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요: ");
        long input = sc.nextInt();
        List<Long> output = null;

        DB l1 = new DB();
        String dbData = l1.getPrimeNumbers(input);

        Structure l2 = new Structure();

        if(dbData == null){
            PrimeNumber l3 = new PrimeNumber();
            output = l3.makePrimeNumber(input);
        }
        else{
            output = l2.getPrimeList(dbData);
        }

        System.out.println("소수: ");
        System.out.println(output);

        String dbSaveData = l2.getPrimeString(output);
        l1.savePrimeNumber(dbSaveData);
    }
}