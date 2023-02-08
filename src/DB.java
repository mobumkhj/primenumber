import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    public List getPrimeNumbers(Long number) {
        BufferedReader bufferedReader = null;
        try {
            List<Long> list = new ArrayList<>();

            bufferedReader = new BufferedReader(new FileReader("db.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                line = line.trim();
                String[] items = line.split(" ");
                if (items[0].equals(number.toString())) {
                    for (String item : items) {
                        list.add(new Long(item));
                    }
                    list.remove(0);
                }
            }
            return list;

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }


    public boolean savePrimeNumber(Long number, List<Long> primeNumbers) {

        StringBuffer sb = new StringBuffer();
        sb.append(number + " ");

        primeNumbers.forEach(num -> {
            sb.append(num + " ");
        });

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("db.txt", true));
            bw.newLine();
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}