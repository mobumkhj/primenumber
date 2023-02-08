import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Structure {
    public List<Long> getPrimeList(String data) {
        // data form: "1.2.3.4.5"
        List<String> elements = Arrays.asList(data.split("\\."));
        List<Long> numbers = new ArrayList<Long>();
        for (String str : elements) numbers.add(Long.valueOf(str));
        // return: List<Long> type (ex. [1,2,3,4,5])
        return numbers;
    }
}
