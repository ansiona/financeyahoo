package finance.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvUtil {

    public static List<CSVRecord> getCSVRecords(final String fileName) {
        List<CSVRecord> list = null;
        try {
            CSVParser parser = CSVFormat.DEFAULT.parse(new FileReader(
                    new File(System.getProperty("user.dir") + "/src/test/resources/" + fileName)));
            list = parser.getRecords();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
