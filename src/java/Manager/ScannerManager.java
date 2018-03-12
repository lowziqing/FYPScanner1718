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
                //JSONController.passObject();
            } else {
                response.getWriter().print("not completed");
            }
        } catch (Exception e) {

        }
    }
}

