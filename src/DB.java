import java.io.*;

public class DB {

    public String getPrimeNumbers(Long number) {
        BufferedReader bufferedReader = null;
        try {

            bufferedReader = new BufferedReader(new FileReader("db.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                line = line.trim();
                String[] items = line.split("\\|");
                if (items[0].equals(number.toString())) {
                    return line;
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }


    public boolean savePrimeNumber(String line) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("db.txt", true));
            bw.newLine();
            bw.write(line);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}