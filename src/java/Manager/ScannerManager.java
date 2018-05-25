/*
    Main Controller to call all the functions
*/

package Manager;

import Controller.FileUploadController;
import Controller.FileScanController;
import Controller.JSONController;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScannerManager {

    static boolean Completed;

    public static void retrieveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        try {
            String folderID = FileUploadController.uploadFile(request);
            Completed = FileScanController.callScanner(folderID);
            if (Completed) {
                JSONController JS = new JSONController(response);
                JSONController.convertObject(folderID);
            } else {
                response.getWriter().print("not completed");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("retrieveRequest Error Message: " + e);
        }
    }
}
