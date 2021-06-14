import com.sparta.jian.controller.csvToDatabaseWithThread;
import com.sparta.jian.controller.csvToDatabase;
import com.sparta.jian.model.EmployeesDAO;
import com.sparta.jian.util.Printer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PerformanceTest {


    @Test
    @DisplayName("Sequential time")
    public void performanceTestSequential(){
        String csvFile = "resources/employees.csv";
        long start = System.nanoTime();
        EmployeesDAO.createTable();
        csvToDatabase.csvReaderToDatabase(csvFile);
        long end = System.nanoTime();
        long totalTime = end - start;
        double timeInSeconds = (double) totalTime / 1_000_000_000;
        Printer.print("Time to write in the database sequentially:  " + timeInSeconds + "seconds");
    }

    @Test
    @DisplayName("Concurrent Time")
    public void performanceTestConcurrent(){
        String csvFile = "resources/employees.csv";
        long start = System.nanoTime();
        EmployeesDAO.createTable();
        csvToDatabaseWithThread.csvReaderToDatabaseThread(csvFile);
        long end = System.nanoTime();
        long totalTime = end - start;
        double timeInSeconds = (double) totalTime / 1_000_000_000;
        Printer.print("Time to write in the database concurrently: " + timeInSeconds + "seconds");
    }
}
