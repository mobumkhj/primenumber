import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class Structure {
    public List<Long> getPrimeList(String data) {
        // data form: "1|2|3|4|5"
        List<String> elements = Arrays.asList(data.split("\\|"));
        List<Long> numbers = new ArrayList<Long>();
        for (String str : elements) numbers.add(Long.valueOf(str));
        // return: List<Long> type (ex. [1,2,3,4,5])
        return numbers;
    }
    public List<Long> getReversedPrimeList(String data) {
        // data form: "1|2|3|4|5"
        List<String> elements = Arrays.asList(data.split("\\|"));
        List<Long> numbers = new ArrayList<Long>();
        for (String str : elements) numbers.add(Long.valueOf(str));
        Collections.reverse(numbers);
        // return: List<Long> type (ex. [5,4,3,2,1])
        return numbers;
    }
    public String getPrimeString(List<Long> numbers){
        // numbers: [1, 2, 3, 4, 5]
        String result = numbers.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("|"));
        // return: String type (ex. "1|2|3|4|5")
        return result;
    }
}
