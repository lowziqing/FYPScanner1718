/*
    Process String Builder
    Create multiple processes for different uploads
    Calls Dependency check CLI
*/

package Controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import model.MyFolder;

public class FileScanController {

    public static boolean callScanner(String folderID) throws InterruptedException {
        /*https://jeremylong.github.io/DependencyCheck/index.html
          Execution sourcecode for CLI  
          http://jagadesh4java.blogspot.sg/2011/03/running-process-from-java-application.html*/
        MyFolder folder = FolderController.getFolder(folderID);
        LocalDateTime dateTime1 = LocalDateTime.now();

        final String argument1 = "--project";
        final String variable1 = "Project_" + folder.getFolderName();
        final String argument2 = "--scan";
        final String variable2 = "\"" + folder.getFolderUploadDirectory() + "\"";
        final String argument3 = "--out";
        final String variable3 = "\"" + folder.getFolderJSONDirectory() + "\"";
        final String argument4 = "--format";
        final String variable4 = "ALL";

        final String path = "C://Users/Low Zi Qing/Desktop/FYP/dependency-check/bin/";

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "cmd", "/c", "dependency-check.bat",
                    argument1, variable1,
                    argument2, variable2,
                    argument3, variable3,
                    argument4, variable4
            );

            pb.directory(new File(path));
            System.out.println("2.  Scanning Commence");
            Process process = pb.start();
            System.out.println("3.  Process Waiting to finish");
            process.waitFor(); // Wait for the process to finish.
            System.out.println("4.  Process Destroyed");
            process.destroy();

            // Test the time taken for the process to complete
            LocalDateTime dateTime2 = LocalDateTime.now();
            long diffInSeconds = java.time.Duration.between(dateTime1, dateTime2).getSeconds();
            long diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();
            long diffInMinutes = java.time.Duration.between(dateTime1, dateTime2).toMinutes();
            System.out.println("5.  Total Time Taken: " + diffInMinutes + ":" + diffInSeconds + ":" + diffInMilli);

        } catch (IOException e) {
            System.out.println("Scanning Error" + e);
        }

        System.out.println("6.  Scanning Ended");
        return true;
    }
}// end of public class
