/*
    Creates folder to store all the uploaded file
    Unique Identifer is created for each upload.
*/

package Controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.MyFolder;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadController {

    // Limits the size of the upload
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 500;  // 500MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 500; // 500MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 500; // 500MB

    public static String uploadFile(HttpServletRequest request) throws IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        String timeStamp = new SimpleDateFormat("ddMMyy(hhmmss)").format(new Date());
        String id = new SimpleDateFormat("MM").format(new Date());
        String folderID = id + timeStamp;

        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);

        String uploadPath = "C:/Users/Low Zi Qing/Documents/NetBeansProjects/FYPScanner-1718/uploadedFiles/"
                + folderID;
        String reportPath = "C:/Users/Low Zi Qing/Documents/NetBeansProjects/FYPScanner-1718/web/generatedJSON/"
                + folderID;

        File uploadDir = new File(uploadPath);
        File reportDir = new File(reportPath);
        if (!uploadDir.exists() || !reportDir.exists()) {
            uploadDir.mkdir();
            reportDir.mkdir();
        }

        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                    }
                }
            }
        } catch (Exception ex) {

        }

        MyFolder folder = new MyFolder(folderID, timeStamp, uploadPath, reportPath);
        FolderController.addFolder(folderID, folder);
        System.out.println("1.  File Created");

        return folderID;

    } // end of method
} // end of class

