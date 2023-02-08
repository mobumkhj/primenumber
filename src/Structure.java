import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Structure {
    public List<Long> getPrimeList(String data, int order) {
        // data form: "1|2|3|4|5"
        List<String> elements = Arrays.asList(data.split("\\|"));
        List<Long> numbers = new ArrayList<Long>();
        for (String str : elements) numbers.add(Long.valueOf(str));
        // return: List<Long> type (ex. [1,2,3,4,5])

        if (order == 1) {
            Collections.reverse(numbers);
        }

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
