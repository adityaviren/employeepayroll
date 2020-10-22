import com.cg.employeepayroll.EmployeeData;
import com.cg.employeepayroll.EmployeePayrollMain;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.io.File;

public class fileTest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirmed() throws IOException {

        Path homePath = Paths.get(HOME);

        Assert.assertTrue(Files.exists(homePath));

        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
        Assert.assertTrue(Files.notExists(playPath));

        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

        IntStream.range(1,10).forEach(cntr-> {
            Path tempFile = Paths.get(playPath + "/temp" +cntr);
            Assert.assertTrue(Files.notExists(tempFile));
            try{Files.createFile(tempFile);}
            catch(IOException e) {}
            Assert.assertTrue(Files.exists(tempFile));
        });

        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);




    }

    @Test
    public void givenADirectory_whenWatched_listsAllTheActivities() throws IOException {
        Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new JavaWatch8Service(dir).processEvents();
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);

    }

    @Test
    public void given3Employees_whenWrittenToFile_shouldMatchEmployeeEntries() throws IOException {
        EmployeeData[] arrayOfEmps= {
                new EmployeeData("Jeff Bezos", "1","10000"),
                new EmployeeData("Bill Gates", "2","20000"),
                new EmployeeData("Mark Zuckerberg", "3","30000")
        };
        EmployeePayrollMain employeePayrollMain;
        employeePayrollMain = new EmployeePayrollMain(Arrays.asList(arrayOfEmps));
        employeePayrollMain.writeEmployeeData();
        employeePayrollMain.printData();
        long entries = employeePayrollMain.countEntries();
        Assert.assertEquals(3,entries);
    }
}
