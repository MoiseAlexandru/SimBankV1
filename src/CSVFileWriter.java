import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class CSVFileWriter {
    private String csvFilePath;

    public CSVFileWriter(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public void writeHeaders(String[] headers) {
        try (FileWriter fileWriter = new FileWriter(csvFilePath); CSVWriter csvWriter = new CSVWriter(fileWriter)) {
            csvWriter.writeNext(headers);
            csvWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(DbRequest req) {
        String[] data = {req.actionName, req.timestamp.toString()};
        try (FileWriter fileWriter = new FileWriter(csvFilePath, true); CSVWriter csvWriter = new CSVWriter(fileWriter)) {
            csvWriter.writeNext(data);
            csvWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
